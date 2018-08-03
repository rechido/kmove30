<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="DBError.jsp"%>
<% 
	String code = request.getParameter("code");
	Connection conn = null;
	Statement stmt = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "12345");
		if(conn == null)
			throw new Exception("데이터베이스에 연결할 수 없습니다.<br/>");
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from goodsinfo where code = '" + code + "';");
		
		if(rs.next()){
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			int price = rs.getInt("price");
			request.setAttribute("CODE", code);
			request.setAttribute("TITLE", title);
			request.setAttribute("WRITER", writer);
			request.setAttribute("PRICE", price);
		}
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
	RequestDispatcher dispatcher = request.getRequestDispatcher("GoodsInfoViewer.jsp");
	dispatcher.forward(request, response);
%>