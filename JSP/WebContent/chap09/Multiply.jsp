<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:set var="num1" value="7" scope="request"></c:set>
<c:set var="num2" value="9" scope="request"></c:set>
<c:set var="result" value="${num1*num2 }" scope="request"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>곱셈 프로그램</title>
</head>
<body>
	${num1 }과 ${num2 }의 곱은? ${result }
</body>
</html>
<jsp:forward page="ProductInfo.jsp" />