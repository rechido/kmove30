<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>상품 정보</title>
</head>
<body>
	<h3>상품 정보</h3>
	상품명: ${PRODUCT.name } <br/>
	<fmt:setLocale value="en-us"/>
	가격: <fmt:formatNumber value="${PRODUCT.price}" groupingUsed="true" type="currency"/> <br/>
</body>
</html>