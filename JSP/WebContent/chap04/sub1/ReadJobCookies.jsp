<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Cookie[] cookies = request.getCookies(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>쿠키 데이터 읽기</title>
</head>
<body>
JOB: <%= getCookieValue(cookies, "JOB") %> <br/>
</body>
</html>

<%!
private String getCookieValue(Cookie[] cookies, String name){
	if(cookies == null)
		return null;
	for(Cookie cookie : cookies){
		if(cookie.getName().equals(name))
			return cookie.getValue();
	}
	return null;
}
%>