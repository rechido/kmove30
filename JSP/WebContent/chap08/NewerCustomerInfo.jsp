<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>회원 정보</title>
</head>
<body>
	<jsp:useBean id="pinfo" class="chap08.PersonalInfo" />
	<jsp:setProperty property="*" name="pinfo" />
	이름: <jsp:getProperty property="name" name="pinfo" /><br /> 
	성별: <jsp:getProperty property="gender" name="pinfo" /><br /> 
	나이: <jsp:getProperty property="age" name="pinfo" /><br />
</body>
</html>