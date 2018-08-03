<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String result = request.getParameter("RESULT"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원 가입</title>
</head>
<body>
	<h3>회원 가입 결과</h3>
	<%
		if(result.equals("SUCCESS"))
			out.println("가입되었습니다.");
		else
			out.println("가입되지 않았습니다.");
	%>
</body>
</html>