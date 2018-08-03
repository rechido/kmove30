<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>인사하기</title>
</head>
<body>

	<%
		String name = request.getParameter("NAME") == null ? "Unknown": request.getParameter("NAME");
			application.log(name + " - [인사하기] JSP 페이지가 호출되었습니다.");
	%>
	안녕하세요,	<%=name%>님
</body>
</html>

