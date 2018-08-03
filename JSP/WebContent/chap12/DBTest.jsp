<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>데이터베이스로 연결하기</title>
</head>
<body>
	<h3>데이터베이스 연결 테스트</h3>
	<% 
		String url = "jdbc:mysql://localhost:3306/kmove30";
		Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection(url, "root", "12345");
	if(conn != null){
		out.println("kmove30 데이터베이스로 연결했습니다.<br/>");
		conn.close();
		out.println("kmove30 데이터베이스로의 연결을 끊었습니다.<br/>");
	}
	else{
		out.println("kmove30 데이터베이스로 연결할 수 없습니다.<br/>");
	}
	%>
</body>
</html>