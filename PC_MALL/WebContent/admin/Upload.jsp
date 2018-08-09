<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.net.URLEncoder"%>
<%@page import="mytuil.MultiPart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	MultiPart multipart = new MultiPart(request);
	String title = multipart.getParameter("title");
	String description = multipart.getParameter("description");
	String fileName = multipart.getFileName("upload_file");
	String newPath = application.getRealPath("/files/" + fileName);
	multipart.saveFile("upload_file", newPath);
	String url = String.format("UploadResult.jsp?title=%s&description=%s&file_name=%s",
			URLEncoder.encode(title, "UTF-8"), URLEncoder.encode(description, "UTF-8"),	URLEncoder.encode(fileName, "UTF-8"));
	response.sendRedirect(url);
%>