<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% 
	request.setAttribute("ID", "Spiderman");
	request.setAttribute("VNUM", new Integer(3));
%>
<jsp:forward page="WelcomeView.jsp"/>