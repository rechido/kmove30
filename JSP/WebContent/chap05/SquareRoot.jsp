<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error/InputDataError.jsp"%>
<% 
	String str = request.getParameter("NUM");
	if(str == null)
		throw new Exception("데이터가 입력되지 않았습니다.");
	double num = Double.parseDouble(str);
	if(num<0)
		throw new Exception("0보다 작은 값이 입력되었습니다.");
		
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>제곱근 프로그램</title>
</head>
<body>
<%= num %>의 제곱근은? <%= Math.sqrt(num) %>
</body>
</html>