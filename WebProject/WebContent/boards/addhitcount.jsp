<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*,oracle.dbpool.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="org.apache.log4j.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Logger log = Logger.getLogger(this.getClass());
%>
<%
	String b_id = request.getParameter("b_id");
	String bbs_id = request.getParameter("bbs_id");
	log.info("addhitcount.jsp: " + b_id + " " + bbs_id);
	
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	Statement stmt = con.createStatement();
	String query = String.format("update sc_bbs_post set b_hit = b_hit+1 where b_id='%s' and bbs_id='%s'", b_id, bbs_id);
	log.info("조회수증가쿼리: " + query);
	stmt.executeUpdate(query);
	stmt.close();
	pool.freeConnection("ora8", con);
	String url = String.format("/WebProject/main/index.jsp?BODY_PATH=/boards/boardlist.jsp?POST=/boards/boardpost.jsp&bbs_id=%s&b_id=%s", bbs_id, b_id);
	log.info("url: " + url);
	response.sendRedirect(url);
%>