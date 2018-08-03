<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="date" value="<%=new Date()%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>나라마다 다른 포맷</title>
</head>
<body>
<h3>우리나라의 포맷</h3>
<fmt:setLocale value="ko_kr" />
금액: <fmt:formatNumber value="1000000" type="currency"/><br/>
일시: <fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full" /> <br/>
<h3>미국의 포맷</h3>
<fmt:setLocale value="en_us" />
금액: <fmt:formatNumber value="1000000" type="currency"/><br/>
일시: <fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full" /> <br/>
<h3>일본의 포맷</h3>
<fmt:setLocale value="ja_jp" />
금액: <fmt:formatNumber value="1000000" type="currency"/><br/>
일시: <fmt:formatDate value="${date}" type="both" dateStyle="full" timeStyle="full" /> <br/>
</body>
</html>