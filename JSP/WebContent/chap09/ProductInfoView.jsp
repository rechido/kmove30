<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>상품 정보</title>
</head>
<body>
<c:remove var="CODE" scope="request"/>
	<h3>상품 정보</h3>
	상품코드: ${CODE }<br/>
	상품명: ${NAME }<br/>
	단가:${PRICE }<br/>
	
	${num1 }과 ${num2 }의 곱은? ${result }
</body>
</html>