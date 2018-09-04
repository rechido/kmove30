<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.io.IOException"%>
<%@page import="jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode"%>
<%@page import="oracle.sql.CLOB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,oracle.dbpool.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="org.apache.log4j.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Logger log = Logger.getLogger(this.getClass());
%>
<%
	String b_id = session.getAttribute("b_id").toString();
	String bbs_id = session.getAttribute("bbs_id").toString();
	String c_id = request.getParameter("c_id");
	String new_comment = request.getParameter("new_comment");
	String pwd = request.getParameter("pwd");
	String c_pwd = "", c_email = "";
	log.info("-댓글 업데이트 정보- ");
	log.info("c_id: " + c_id);
	log.info("new_comment: " + new_comment);
	
	//쿼리에 '가 들어가면 에러가 발생하므로 replace 처리해준다.
 	new_comment = Replace(new_comment,"'","''");
 	// 게행처리
 	new_comment = Replace(new_comment,"\r\n","<br/>");
	
	// 회원댓글/ 비회원댓글 판별
		try {		
			DBConnectionManager pool = DBConnectionManager.getInstance();
			Connection con = pool.getConnection("ora8");
			
			String query = String.format("select c_pwd, c_email from sc_bbs_post_comments where b_id='%s' and bbs_id='%s' and c_id='%s'", b_id, bbs_id, c_id);
			log.info("댓글수정회원판별쿼리: " + query);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				c_pwd = rs.getString(1);
				c_email = rs.getString(2);
				log.info("c_pwd: " + c_pwd);
				log.info("c_email: " + c_email);
			} 
			stmt.close();
			pool.freeConnection("ora8", con);
			
		}catch (Exception e) {			
			out.println(e);
			%>
			<script language="JavaScript">
				alert("댓글을 삭제하지 못했습니다.");
				history.back(); // 1단계 이전 페이지로 이동
			</script>
			<%
			
		}
	
		// 비회원 댓글 수정
		if(c_email==null){
			log.info("비회원 댓글이다.");
			log.info("패스워드 일치? " + pwd + " " + c_pwd);
			if(pwd.equals(c_pwd)){
				updatebbs(b_id, bbs_id, c_id, new_comment, out, log);
				%>
				<script src="/WebProject/common/js/commonFunctions.js"></script>
				<script language="javascript">
					location.href = getCookie("currentURL");
				</script>
				<%
			} else{
				%>
				<script language="JavaScript">
					alert("패스워드가 일치하지 않습니다!");
					history.back(); // 1단계 이전 페이지로 이동
				</script>
				<%
			}
			
		// 회원 댓글 수정
		} else if(c_email!=null){
			log.info("회원 댓글이다.");
			updatebbs(b_id, bbs_id, c_id, new_comment, out, log);
			%>
			<script src="/WebProject/common/js/commonFunctions.js"></script>
			<script language="javascript">
				location.href = getCookie("currentURL");
			</script>
			<%
		}	
%>

<%! 
public void updatebbs(String b_id, String bbs_id, String c_id, String new_comment, JspWriter out, Logger log) throws Exception{
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	Statement stmt = con.createStatement();
	
	try {									
		String query = String.format("update sc_bbs_post_comments set c_comments = '%s', c_date = (select sysdate from dual) where b_id='%s' and bbs_id='%s' and c_id='%s'", new_comment, b_id, bbs_id, c_id);
		log.info("댓글수정쿼리: " + query);
		stmt.executeUpdate(query);	
	} catch (Exception e) {
		out.println(e);
	}finally{
		stmt.close();
		pool.freeConnection("ora8", con);
	}
}

//개행 처리를 위한 메소드 

public static String Replace(String original, String oldString, String newString) {
	for(int index = 0; (index = original.indexOf(oldString, index)) >= 0; index += newString.length())
	original = original.substring(0, index) + newString + original.substring(index + oldString.length());
return original;
}
%>