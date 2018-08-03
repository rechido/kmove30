<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="DBError.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="java.sql.*"%>
<%
	String code = request.getParameter("code");
	if (code == null)
		throw new Exception("상품 코드를 입력하세요.");
	Connection conn = null;
	PreparedStatement pstmt = null;
	//Statement stmt = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb?useUnicode=true&characterEncoding=utf8", "root", "12345");
		if (conn == null)
			throw new Exception("데이터베이스에 연결할 수 없습니다.<br/>");

		// SQL 실행

		//stmt = conn.createStatement();
		// ResultSet rs = stmt.executeQuery("select * from goodsinfo;");
		//String command = String.format("select * from goodsinfo where code = '%s';", code);
		//ResultSet rs = stmt.executeQuery(command);
		
		// PreparedStatement를 이용한 방법. 개인적으론 위와 같이 String.format이 더 편한듯.
		String sql = "select * from goodsinfo where code = ?;";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, code);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			int price = rs.getInt("price");
			request.setAttribute("CODE", code);
			request.setAttribute("TITLE", title);
			request.setAttribute("WRITER", writer);
			request.setAttribute("PRICE", price);
		}
	} finally {
		try {
			pstmt.close();
		} catch (Exception ignored) {

		}
		try {
			conn.close();
		} catch (Exception ignored) {

		}
	}
	RequestDispatcher dispatcher = request.getRequestDispatcher("EditForm.jsp");
	dispatcher.forward(request, response);
%>