<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Application 내장 변수의 사용 예</title>
</head>
<body>
	<%
		String appPath = application.getContextPath();
		String filePath = application.getRealPath("Hi.jsp");
	%>
	웹 애플리케이션의 URL 경로명: <%= appPath %><br/>
	Hi.jsp의 파일 경로명: <%= filePath %> <br/>
</body>
</html>