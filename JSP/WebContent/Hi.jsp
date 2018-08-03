<?xml version="1.0" encoding="UTF-8" ?>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page buffer="4kb" autoFlush="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>인사하기</title>
</head>
<body>
	안녕하세요, <%= request.getParameter("yourname") %>님 <br/><br/>
	
	Buffer Size : <%= out.getBufferSize() %> 바이트
	
	<%
		response.sendRedirect("http://www.hanbit.co.kr");
	%>
</body>
</html>

