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
<title>현재의 시각</title>
</head>
<body>

	[d]	<fmt:formatDate value="${date}" type="both" dateStyle="short" timeStyle="short" />	<br /> 
	[M]	<fmt:formatDate value="${date}" type="both" dateStyle="medium" timeStyle="medium" />	<br /> 
	[L]	<fmt:formatDate value="${date}" type="both" dateStyle="long" timeStyle="long" />	<br /> 
	[F]	<fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full" />	<br />
</body>
</html>