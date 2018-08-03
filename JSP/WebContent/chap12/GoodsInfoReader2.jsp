<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.ArrayList"%>
<%@page import="chap12.GoodsInfo"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="DBError.jsp"%>
<% 
	Connection conn = null;
	Statement stmt = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "12345");
		if(conn == null)
			throw new Exception("데이터베이스에 연결할 수 없습니다.<br/>");
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from goodsinfo;");
		
		ArrayList<GoodsInfo> goods = new ArrayList<GoodsInfo>();
		
		while(rs.next()){
			String code = rs.getString("code");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			int price = rs.getInt("price");
			GoodsInfo good = new GoodsInfo(code, title, writer, price);
			goods.add(good);
		}
		
		request.setAttribute("GOODS", goods);
		//ArrayList<GoodsInfo> goods2 = (ArrayList<GoodsInfo>)request.getAttribute("GOODS");
		//out.println("<html><head></head><body>" + goods2.get(0).getCode()+ "<br/>" + goods2.get(1).getCode() + "</body></html>");
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
	RequestDispatcher dispatcher = request.getRequestDispatcher("GoodsInfoViewer2.jsp");
	dispatcher.forward(request, response);
%>