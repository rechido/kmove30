<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" session="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>쿠키 보여주기</title>
</head>
<body>
	쿠키 이름: 쿠키 값<br/>
	==================<br/>
	<%
		Cookie cookies[] = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				String name = URLDecoder.decode(cookie.getName(), "UTF-8");
				String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
				out.println(name + ": " + value + "<br/>");
			}
		}
	%>
	<br/>
	<a href="InputCookie.html">쿠키 입력 화면으로</a>
</body>
</html>