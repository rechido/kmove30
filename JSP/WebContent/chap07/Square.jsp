<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int arr[] = new int[5];
	for(int cnt=1; cnt<=5; cnt++)
		arr[cnt-1] += cnt*cnt;
	request.setAttribute("RESULT", arr);
	RequestDispatcher dispatcher = request.getRequestDispatcher("SquareResult.jsp");
	dispatcher.forward(request, response);
	
%>