<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String arr[] = { "불고기 백반", "오므라이스", "콩국수"};
	request.setAttribute("MENU", arr);
%>
<jsp:forward page="LunchMenuView.jsp"/>