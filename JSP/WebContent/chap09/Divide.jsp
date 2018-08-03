<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String str1 = request.getParameter("NUM1")==null? "":request.getParameter("NUM1");
	String str2 = request.getParameter("NUM2")==null? "":request.getParameter("NUM2");
	int num1 = Integer.parseInt(str1.equals("")? "0":str1);
	int num2 = Integer.parseInt(str2.equals("")? "1":str2);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>나눗셈 프로그램</title>
</head>
<body>
Divide.jsp <br/>
	<c:catch var="e">
		<%
			int result = num1 / num2;
		%>
		나눗셈의 결과는? <%= result %> <br/>
	</c:catch>
	<c:if test="${e != null }">
		에러 메시지: ${e.message }
	</c:if>
	
	<c:import url="Echo.jsp"></c:import>
</body>
</html>