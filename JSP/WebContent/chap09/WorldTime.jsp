<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="date" value="<%=new Date()%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>세계시 프로그램</title>
</head>
<body>
서울: <fmt:formatDate value="${date}" type="both"/><br/>
<fmt:timeZone value="Asia/Hong_Kong">
홍콩: <fmt:formatDate value="${date}" type="both"/><br/>
</fmt:timeZone>
<fmt:timeZone value="Europe/London">
런던: <fmt:formatDate value="${date}" type="both"/><br/>
</fmt:timeZone>
<fmt:timeZone value="America/New_York">
뉴욕: <fmt:formatDate value="${date}" type="both"/><br/>
</fmt:timeZone>
</body>
</html>