<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="DBError.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
	Connection conn = null;
	Statement stmt = null;
	ArrayList goods = new ArrayList();
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "12345");
		if(conn == null)
			throw new Exception("데이터베이스에 연결할 수 없습니다.<br/>");
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from goodsinfo;");
		
		while(rs.next()){
			Map good = new HashMap();
			good.put("code", rs.getString("code"));
			good.put("title", rs.getString("title"));
			good.put("writer", rs.getString("writer"));
			good.put("price", new Integer(rs.getInt("price")));
			goods.add(good);
		}
		
		request.setAttribute("GOODS", goods);
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
%>

<jsp:forward page="GoodsInfoViewer3.jsp"/>
