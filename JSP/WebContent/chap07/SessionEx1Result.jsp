<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>세션 데이터를 읽는 JSP 페이지</title>
</head>
<body>
	이름: ${sessionScope.NAME }<br/>
	나이: ${sessionScope.AGE }<br/>
	성별: ${sessionScope.GENDER }
</body>
</html>