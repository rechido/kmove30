<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.io.IOException"%>
<%@page import="jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode"%>
<%@page import="oracle.sql.CLOB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,oracle.dbpool.*,java.util.*"%>
<%@ page import="org.apache.log4j.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	request.setCharacterEncoding("utf-8");
	Logger log = Logger.getLogger(this.getClass());
%>
<%
	String b_id = session.getAttribute("b_id").toString();
	String bbs_id=session.getAttribute("bbs_id").toString();
	String pwd = request.getParameter("pwd");
	String b_pwd = "", b_email = "";

	log.info("지우려는 글: " + b_id);
	
	// 회원글/ 비회원글 판별
	try {		
		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");
		
		String query = String.format("select b_pwd, b_email from sc_bbs_post where b_id='%s' and bbs_id='%s'", b_id, bbs_id);
		log.info("글삭제회원판별쿼리: " + query);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			b_pwd = rs.getString(1);
			b_email = rs.getString(2);
			log.info("b_pwd: " + b_pwd);
			log.info("b_email: " + b_email);
		} 
		stmt.close();
		pool.freeConnection("ora8", con);
		
	}catch (Exception e) {			
		out.println(e);
		%>
		<script language="JavaScript">
			alert("글을 삭제하지 못했습니다.");
			history.back(); // 1단계 이전 페이지로 이동
		</script>
		<%
		
	}
	
	
	// 비회원 글 삭제
	if(b_email==null){
		log.info("비회원 글이다.");
		log.info("패스워드 일치? " + pwd + " " + b_pwd);
		if(pwd.equals(b_pwd)){
			deletebbs(b_id, bbs_id, out, log);
			%>
			<script language="javascript">
				alert("글을 삭제했습니다.");				
			</script>
			<%
			String url = String.format("/WebProject/main/index.jsp?BODY_PATH=/boards/boardlist.jsp?bbs_id=%s", bbs_id);
			log.info("url: " + url);
			response.sendRedirect(url);
		} else{
			%>
			<script language="JavaScript">
				alert("패스워드가 일치하지 않습니다!");
				history.back(); // 1단계 이전 페이지로 이동
			</script>
			<%
		}
		
		// 회원 글 삭제
	} else if(b_email!=null){
		log.info("회원 글이다.");
		deletebbs(b_id, bbs_id, out, log);
		%>
		<script language="javascript">
			alert("글을 삭제했습니다.");			
		</script>
		<%
		String url = String.format("/WebProject/main/index.jsp?BODY_PATH=/boards/boardlist.jsp?bbs_id=%s", bbs_id);
		log.info("url: " + url);
		response.sendRedirect(url);
	}
	
	
%>
<%! 
public void deletebbs(String b_id, String bbs_id, JspWriter out, Logger log) throws Exception{
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	// 글 삭제
	try {									
		Statement stmt = con.createStatement();
		String query = String.format("delete from sc_bbs_post where b_id='%s' and bbs_id='%s'", b_id, bbs_id);
		log.info("글삭제쿼리: " + query);
		stmt.executeUpdate(query);	
		stmt.close();
	} catch (Exception e) {
		out.println(e);
	}
	// 댓글/추천자/이미지 시퀀스 삭제
	try {									
		Statement stmt = con.createStatement();
		String query = String.format("select sequence_name from USER_SEQUENCES where sequence_name like 'SEQ_%s_%s%%'", bbs_id, b_id);
		log.info("게시글삭제_관련시퀀스모두조회: " + query);
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			String sequence_name = rs.getString(1);
			Statement stmt2 = con.createStatement();		
			String query2 = String.format("DROP SEQUENCE %s", sequence_name);
			log.info("게시글관련시퀀스모두삭제쿼리: " + query2);
			stmt2.executeUpdate(query2);
			stmt2.close();	
		}
	} catch (Exception e) {
		out.println(e);
	}
	
	pool.freeConnection("ora8", con);
}
%>
