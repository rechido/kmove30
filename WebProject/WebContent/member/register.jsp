<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.sql.*"%>
<%@page import="oracle.dbpool.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="org.apache.log4j.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Logger log = Logger.getLogger(this.getClass());
%>
	<%
		String mem_email = request.getParameter("email");
		String mem_pwd = request.getParameter("pwd");
		String mem_nickname = request.getParameter("nickname");
		


		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");

		try {
			Statement stmt = con.createStatement();
			String query = String.format("select m_email from sc_member where m_email='%s'", mem_email);
			ResultSet rs = stmt.executeQuery(query);			

			if (rs.next()) {
				rs.close();
	%>
	<script language=javascript>
		alert("이미 사용중인 이메일입니다.");
		history.back();
	</script>
	<%
			} else {
				GregorianCalendar now = new GregorianCalendar();
				Statement stmt2 = con.createStatement();
				String query2 = String.format("insert into sc_member values('%s','%s','%s', '%TF')", 
						mem_email, mem_pwd, mem_nickname, now);
				log.info("회원가입쿼리: " + query2);
				stmt2.executeUpdate(query2);
				session.setAttribute("mem_email", mem_email);
				session.setAttribute("nickname", mem_nickname);
				rs.close();
				stmt.close();
				stmt2.close();
				pool.freeConnection("ora8", con);
	%>
	<script src="/WebProject/common/js/commonFunctions.js"></script>
	<script language=javascript>
		alert("회원가입을 축하합니다.");
		location.href = getCookie("currentURL");
	</script>
	<%
			}
			 
		} catch (SQLException e) {
			pool.freeConnection("ora8", con);
	%>
	<script language=javascript>
		alert("회원가입이 실패하였습니다. 다시 시도해 보시기 바랍니다.");
		location.href = getCookie("currentURL");
	</script>
	<%
		}
	%>