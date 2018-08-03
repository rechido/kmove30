<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("ID");
	String password = request.getParameter("PASSWORD");
	String name = request.getParameter("NAME"); // request.getParameter 는 3페이지 이상 보존되지 않으므로 세션 내장함수를 사용한다.
	session.setAttribute("ID", id); // 
	session.setAttribute("PASSWORD", password);
	session.setAttribute("NAME", name);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원 가입</title>
</head>
<body>
	<h3>약관</h3>
	-------------------------------------------------------------<br/>
	1. 회원 정보는 웹 사이트의 운영을 위해서만 사용됩니다. <br/>
	2. 웹 사이트의 정상 운영을 방해하는 회원은 탈퇴 처리합니다. <br/>
	-------------------------------------------------------------<br/>
	<form action="Subscribe.jsp" method="post">
		위의 약관에 동의하십니까?
		<input type="radio" name="AGREE" value="yes"/>동의함
		<input type="radio" name="AGREE" value="no"/>동의하지 않음<br/><br/>
		<input type="submit" value="확인"/>	
	</form>
</body>
</html>