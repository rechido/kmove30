<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.net.URLEncoder"%>
<%@page import="mytuil.MultiPart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	MultiPart multipart = new MultiPart(request);
	String url = "UploadResult.jsp?"; int i=1;
	while(true){
		if(multipart.getFileName("upload_file" + i)==null)
			break;
		String fileName = multipart.getFileName("upload_file" + i);
		String newPath = application.getRealPath("/files/" + fileName);
		multipart.saveFile("upload_file", newPath);
		url += String.format("file_name%d=%s",	i, URLEncoder.encode(fileName, "UTF-8"));
	}
	response.sendRedirect(url);
%>