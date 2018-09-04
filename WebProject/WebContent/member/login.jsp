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
	try {
		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");

		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String rememberMe = request.getParameter("rememberMe");
		log.info("로그인: " + email + " " + pwd + " " + rememberMe);
		
		if(rememberMe == null){
			Cookie userEmail = new Cookie("userEmail", "");
			userEmail.setMaxAge(0);
			response.addCookie(userEmail);
			Cookie userPwd = new Cookie("userPwd", "");
			userPwd.setMaxAge(0);
			response.addCookie(userPwd);
			log.info("쿠키정보를 삭제했습니다.");
			
		} else if(rememberMe.equals("on"))	{
		    Cookie userEmail = new Cookie("userEmail", email.toString());		    
		    userEmail.setMaxAge(60 * 24 * 3600);
		    response.addCookie(userEmail);
		    
		    Cookie userPwd = new Cookie("userPwd", pwd.toString());
		    userPwd.setMaxAge(60 * 24 * 3600);
		    response.addCookie(userPwd);
		    
		    log.info("회원정보가 쿠키에 저장되었습니다.");
		} 

		String mem_email = "", mem_pwd = "", nickname = "";
		String query = String.format("select m_email, m_pwd, m_nickname from sc_member where m_email='%s'",
				email);
		log.info("로그인회원정보조회쿼리: " + query);

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		if (rs.next()) {
			mem_email = rs.getString(1);
			mem_pwd = rs.getString(2);
			nickname = rs.getString(3);
			log.info(mem_email + " " + mem_pwd + " " + nickname);
			
			if (pwd.equals(mem_pwd)) {
				// 세션 영역에 세션 키와 값을 저장
				session.setAttribute("mem_email", mem_email); // 회원 이메일 아이디
				session.setAttribute("nickname", nickname); // 회원 닉네임
%>
<script src="/WebProject/common/js/commonFunctions.js"></script>
<script language="javascript">
	alert("로그인 되었습니다.");
	location.href = getCookie("currentURL");
</script>
<%
			} else {
%>
<script language="JavaScript">
	alert("패스워드가 일치하지 않습니다.");
	history.back();
</script>
<%	
			}
		} else {
%>
<script language="JavaScript">
	alert("등록되어 있지 않은 아이디입니다.");
	history.back(); // 1단계 이전 페이지로 이동
</script>
<%
		}

		
		stmt.close();
		rs.close();
		pool.freeConnection("ora8", con); 

	} catch (Exception e) {
		out.println(e);
	}
%>