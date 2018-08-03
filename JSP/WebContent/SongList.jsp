<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>노래 파일 목록</title>
</head>
<body>
	<h3>노래 파일 목록</h3>
	<%
		File a = new File(application.getRealPath("/WEB-INF/songs/"));
		String filePath = application.getRealPath("/WEB-INF/songs/");
		String[] list = a.list();
		for (int cnt = 0; cnt < 3; cnt++){
			out.println("<a href='/JSP/SongReader.jsp?SONG=" + list[cnt] + "'>" + list[cnt] + "</a><br/>");
		}
			
	%>
</body>
</html>