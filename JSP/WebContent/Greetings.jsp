<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>점점 더 크게 인사하기</title>
</head>
<body>
<% 	
	for(int cnt=1; cnt<=6; cnt++) {
		out.print("<font size=" + cnt + ">안녕하세요, 여러분! <br/></font>");
	}
%>

</body>
</html>