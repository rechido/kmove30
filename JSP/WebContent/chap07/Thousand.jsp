<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int sum = 0;
	for(int cnt = 1; cnt<=1000; cnt++)
		sum += cnt;
	pageContext.setAttribute("RESULT", new Integer(sum));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>1부터 1000까지의 합</title>
</head>
<body>
1부터 1000까지 더한 결과는? ${RESULT}
</body>
</html>