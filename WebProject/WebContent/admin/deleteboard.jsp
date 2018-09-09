<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.io.IOException"%>
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
	String admin_pwd = request.getParameter("admin_pwd");
	String category = request.getParameter("category");
	String boardName = request.getParameter("boardName");
	String m_pwd = "";
	String bbs_id = "";
	
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	
	// 관리자 비번 체크
	try {
		Statement stmt = con.createStatement();		
		String query = "select m_pwd from sc_member where m_email='admin@admin.admin'";
		log.info("게시판삭제_관리자암호조회: " + query);
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next())
			m_pwd = rs.getString(1);
		
		rs.close();
		stmt.close();
		
		if(admin_pwd.equals(m_pwd)){
			// 관리자 패스워드 일치 시 게시판 글 삭제
			
			// 게시판 존재 여부 조회
			Statement stmt2 = con.createStatement();		
			String query2 = String.format("select bbs_id from sc_bbs where bbs_name ='%s' and bbs_category = '%s'", boardName, category);
			log.info("게시판삭제_게시판존재여부조회: " + query2);
			ResultSet rs2 = stmt2.executeQuery(query2);
			if(rs2.next())
				bbs_id = rs2.getString(1);
			rs2.close();
			stmt2.close();
			
			if(bbs_id==""){
				%>
				<script language="JavaScript">
					alert("게시판이 존재하지 않습니다!");
					history.back(); // 1단계 이전 페이지로 이동
				</script>
				<%
			}else{
				Statement stmt3 = con.createStatement();		
				String query3 = String.format("delete sc_bbs where bbs_id='%s'", bbs_id);
				log.info("게시판삭제쿼리: " + query3);
				stmt3.executeUpdate(query3);
				stmt3.close();
				
				// 시퀀스 삭제 쿼리
				// 해당 게시판 관련 시퀀스 모두 조회
				Statement stmt4 = con.createStatement();		
				String query4 = String.format("select sequence_name from USER_SEQUENCES where sequence_name like 'SEQ_%s%%'", bbs_id);
				log.info("게시판삭제_관련시퀀스모두조회: " + query4);
				ResultSet rs4 = stmt4.executeQuery(query4);
				while(rs4.next()){
					String sequence_name = rs4.getString(1);
					Statement stmt5 = con.createStatement();		
					String query5 = String.format("DROP SEQUENCE %s", sequence_name);
					log.info("게시판시퀀스삭제쿼리: " + query5);
					stmt5.executeUpdate(query5);
					stmt5.close();	
				}
				
				
				pool.freeConnection("ora8", con);
				
				%>
				
				<script language="javascript">
					alert("게시판을 삭제했습니다.");
					location.href = "/WebProject/main/index.jsp";
				</script>		
				<%
			}
			
		}else{
			%>
			<script language="JavaScript">
				alert("패스워드가 일치하지 않습니다!");
				history.back(); // 1단계 이전 페이지로 이동
			</script>
			<%
		}
		
		
	} catch (Exception e) {
		out.println(e);
	}
	
	
%>
