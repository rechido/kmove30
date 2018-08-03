<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.setAttribute("NAME", "김지영");
	session.setAttribute("AGE", new Integer(21));
	session.setAttribute("GENDER", "여");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>세션 데이터를 저장하는 JSP 페이지</title>
</head>
<body>
세션 데이터가 저장되었습니다.
</body>
</html>