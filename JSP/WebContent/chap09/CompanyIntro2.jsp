<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="Intro" />
<fmt:message key="TITLE" var="title" />
<fmt:message key="GREETING" var="greeting" />
<fmt:message key="BODY" var="body" />
<fmt:message key="COMPANY_NAME" var="companyName" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${title }</title>
</head>
<body>
	<h3>${title }</h3>
	${greeting }
	<br />
	<br /> ${body }
	<br />
	<br />
	<font size=2>${companyName }</font>
</body>
</html>
