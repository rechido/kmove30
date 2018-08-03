<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>인사하기</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.NUM == 0 }">
			처음 뵙겠습니다. <br/>
		</c:when>
		<c:when test="${param.NUM == 1 }">
			반갑습니다. <br/>
		</c:when>
		<c:otherwise>
			안녕하세요. <br/>
		</c:otherwise>
	</c:choose>
</body>
</html>