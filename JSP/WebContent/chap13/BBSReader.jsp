<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="chap13.BBSItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% 
	int seqNo = Integer.parseInt(request.getParameter("SEQ_NO"));
	BBSItem bbsItem = new BBSItem();
	bbsItem.setSeqNo(seqNo);
	bbsItem.readDB();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>게시글 읽기</title>
</head>
<body>
	<h4>게시글 읽기</h4>
	[제목] <%= bbsItem.getTitle() %><br/>
	[작성자] <%= bbsItem.getWriter() %>
	[작성일시] <%= bbsItem.getDate() %> <%= bbsItem.getTime() %><br/>
	---------------------------------------------------------------------------------------<br/>
	<%= bbsItem.getContent() %>
</body>
</html>