<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*,oracle.dbpool.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="org.apache.log4j.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Logger log = Logger.getLogger(this.getClass());
%>
<%

	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	
	try {
		

		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String mem_email = "", mem_pwd = "";
		
		String query = String.format("select m_email, m_pwd from sc_member where m_email='%s'",	email);
		log.info("회원탈퇴회원정보조회쿼리: " + query);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		if (rs.next()) {
			
			mem_email = rs.getString(1);
			mem_pwd = rs.getString(2);
			if (pwd.equals(mem_pwd)) {
				
				query = String.format("delete from sc_member where m_email = '%s'", email);
				log.info("회원탈퇴쿼리: " + query);
				
				Statement stmt2 = con.createStatement();
				stmt2.executeUpdate(query);
				session.invalidate();
				stmt2.close();
				stmt.close();
				rs.close();
				pool.freeConnection("ora8", con); 
				
%>
<script language=javascript>
	alert("회원탈퇴 되었습니다.");
	document.location.href = '../main/index.jsp';
</script>
<%

			} else{
%>
<script language="JavaScript">
	alert("패스워드가 일치하지 않습니다.");
	history.back();
</script>
<%	
			}
		} else{
%>
<script language="JavaScript">
	alert("등록되어 있지 않은 아이디입니다.");
	history.back();
</script>
<%	
			
		}

		stmt.close();
		rs.close();
		pool.freeConnection("ora8", con); 

	} catch (Exception e) {
		out.println(e);
		pool.freeConnection("ora8", con);
%>
<script language=javascript>
	alert("회원탈퇴에 실패하였습니다. 다시 시도해 보시기 바랍니다.");
	document.location.href = '../main/index.jsp';
</script>
<%
	}
%>