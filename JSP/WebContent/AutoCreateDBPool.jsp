<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="org.apache.commons.pool.impl.*"%>
<%@page import="org.apache.commons.dbcp.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%!public void jspInit() {
		GenericObjectPool objectPool = new GenericObjectPool();
		DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
				"jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8", "root", "12345");
		new PoolableConnectionFactory(connectionFactory, objectPool, null, null, false, true);
		PoolingDriver driver = new PoolingDriver();
		driver.registerPool("/webdb_pool", objectPool);
	}%>