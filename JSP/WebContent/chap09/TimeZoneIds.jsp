<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.TimeZone"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>시간대 ID 목록</title>
</head>
<body>
<% 
	String arr[] = TimeZone.getAvailableIDs();
	for(int cnt=0; cnt<arr.length; cnt++)
		out.println(arr[cnt]+"<br/>");
%>
</body>
</html>