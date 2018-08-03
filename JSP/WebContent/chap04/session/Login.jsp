<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("ID");
	String password = request.getParameter("PASSWORD");
	if(loginCheck(id,password))
		session.setAttribute("LOGIN_ID", id);
	response.sendRedirect("LoginResult.jsp");
%>
<%! 
	private boolean loginCheck(String id, String password){
	if(id.equals("minerva") && password.equals("1234"))
		return true;
	else if(id.equals("ironman") && password.equals("4567"))
		return true;
	else if(id.equals("snowwhite") && password.equals("7890"))
		return true;
	else
		return false;
	}
%>