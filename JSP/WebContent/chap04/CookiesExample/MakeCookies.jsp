<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" session="false" 
    pageEncoding="UTF-8"%>
<% 
	String cookieName = request.getParameter("COOKIE_NAME");
	String cookieValue = request.getParameter("COOKIE_VALUE");
	cookieName = URLEncoder.encode(cookieName, "UTF-8");
	response.addCookie(new Cookie(cookieName, cookieValue));
	response.sendRedirect("DisplayCookies.jsp");
%>