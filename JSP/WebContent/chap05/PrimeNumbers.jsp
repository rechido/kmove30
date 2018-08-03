<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String str = request.getParameter("NUM");
	int num = Integer.parseInt(str);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>소수</title>
</head>
<body>
<% 
	int arr[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
	for(int cnt=0; cnt<num; cnt++)
		out.println(arr[cnt]);
%>
</body>
</html>