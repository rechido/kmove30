<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="chap12.UserInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.sql.*"%>
<% 
	Connection conn = null;
	Statement stmt = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8", "root", "12345");
		if(conn == null)
			throw new Exception("데이터베이스에 연결할 수 없습니다.<br/>");
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from userinfo;");
		
		ArrayList<UserInfo> users = new ArrayList<UserInfo>();
		
		while(rs.next()){
			UserInfo user = new UserInfo();
			user.setName(rs.getString("name"));
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("password"));			
			users.add(user);
		}
		
		request.setAttribute("USERS", users);
	}finally{
		try{
			stmt.close();
		}catch(Exception ignored){
			
		}
		try{
			conn.close();
		}catch(Exception ignored){
			
		}
	}
	RequestDispatcher dispatcher = request.getRequestDispatcher("UserDisplay.jsp");
	dispatcher.forward(request, response);
%>