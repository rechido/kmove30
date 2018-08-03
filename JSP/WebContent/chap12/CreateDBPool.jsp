<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="org.apache.commons.pool.impl.*"%>
<%@page import="org.apache.commons.dbcp.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	GenericObjectPool objectPool = new GenericObjectPool();
	DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory("jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8", "root", "12345");
	new PoolableConnectionFactory(connectionFactory, objectPool, null, null, false, true);
	PoolingDriver driver = new PoolingDriver();
	driver.registerPool("/webdb_pool", objectPool);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>데이터베이스 커넥션 풀 생성하기</title>
</head>
<body>
	<h3>데이터베이스 커넥션 풀 생성하기</h3>
	데이터베이스 커넥션 풀을 생성하고 등록했습니다.
	<br />
	<br /> 풀 이름: /webdb_pool
</body>
</html>