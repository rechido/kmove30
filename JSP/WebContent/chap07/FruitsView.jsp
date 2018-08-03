<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>인기 상품 목록</title>
</head>
<body>
	<h3>이달에 가장 많이 팔린 과일입니다.</h3>
<%--	
	1위. ${FRUITS[0] }<br/>
	2위. ${FRUITS[1] }<br/>
	3위. ${FRUITS[2] }<br/>
 --%>
	<c:forEach var="str" items="${FRUITS }" varStatus="status">
	${status.count}위 ${str }<br/>
	</c:forEach>
</body>
</html>