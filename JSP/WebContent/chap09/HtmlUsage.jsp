<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>HTML 문법 설명</title>
</head>
<body>
	<h3>FONT 태그에 관하여</h3>
	<c:out value="<font size=7>커다란 글씨</font>는 다음과 같은 출력을 합니다."></c:out><br/><br/>
	<c:out value="<font size=7>커다란 글씨</font>는 다음과 같은 출력을 합니다." escapeXml="false"></c:out><br/><br/>
</body>
</html>