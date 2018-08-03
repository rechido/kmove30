<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="pinfo" class="chap08.ClothingInfo" scope="request"/>
<jsp:setProperty property="code" name="pinfo" value="70002"/>
<jsp:setProperty property="name" name="pinfo" value="반팔 티셔츠"/>     
<jsp:setProperty property="price" name="pinfo" value="15000"/>     
<jsp:setProperty property="size" name="pinfo" value="M"/>     
<jsp:setProperty property="color" name="pinfo" value="베이지"/>          
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>의류 정보 관리</title>
</head>
<body>
	의류 정보가 저장되었습니다. <br/>
	-------------------------------<br/>
	<h3>제품 개략 정보</h3>
	<jsp:include page="ProductInfo.jsp" />
</body>
</html>