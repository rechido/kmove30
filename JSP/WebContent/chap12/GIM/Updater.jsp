<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="DBError.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:requestEncoding value="UTF-8"/>
<%
	String code = request.getParameter("code");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String price = request.getParameter("price");
	if (code == null || title == null || writer == null || price == null)
		throw new Exception("누락된 데이터가 있습니다.");
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8", "root", "12345");
		if(conn == null)
			throw new Exception("데이터베이스에 연결할 수 없습니다.<br/>");
		stmt = conn.createStatement();
		String sql = String.format("update goodsinfo set title = '%s', writer = '%s', price = %s where code = '%s';", title, writer, price, code);
		int rowNum = stmt.executeUpdate(sql);
		
		// PreparedStatement를 이용한 방법. 개인적으론 위와 같이 String.format이 더 편한듯.
		//String sql = "update goodsinfo set title = ?, writer = ?, price = ? where code = ?;";
		//pstmt = conn.prepareStatement(sql);
		//pstmt.setString(1, title);
		//pstmt.setString(2, writer);
		//pstmt.setString(3, price);
		//pstmt.setString(4, code);	
		//int rowNum = pstmt.executeUpdate(sql);
		if(rowNum<1)
			throw new Exception("데이터를 DB에 입력할 수 없습니다.<br/>");
	}finally{
		try{
			pstmt.close();
		}catch(Exception ignored){
			
		}
		try{
			conn.close();
		}catch(Exception ignored){
			
		}
	}
	response.sendRedirect("UpdateResult.jsp?code="+code);
	
%>
