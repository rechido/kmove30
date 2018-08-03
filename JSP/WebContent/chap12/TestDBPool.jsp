<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="DBError.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>데이터베이스 커넥션 풀 테스트</title>
</head>
<body>
	<h3>데이터베이스 커넥션 풀 테스트</h3>
	<%
		Class.forName("org.apache.commons.dbcp.PoolingDriver");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:/wpool");
		if (conn != null) {
			out.println("연결 취득 완료<br/>");
			conn.close();
			out.println("연결 반환 완료<br/>");
		} else {
			out.println("연결 취득 실패<br/>");
		}
	%>
</body>
</html>