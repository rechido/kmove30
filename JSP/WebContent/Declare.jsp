<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String dept_name = "컴퓨터정보계열";
	String grade[] = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"};
	int cLass = 3;
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>변수선언</title>
</head>
<body>
dept_name = <%= dept_name %><br/>
grade = <%= grade[8] %><br/>
class = <%= cLass %><br/>

</body>
</html>