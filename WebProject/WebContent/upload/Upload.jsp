<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.ArrayList"%>
<%@page import="myutil.MultiPart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="org.apache.log4j.*"%>
<%
	Logger log = Logger.getLogger(this.getClass());
%>
<%
	MultiPart multipart = new MultiPart(request);
	String uploadPath = application.getRealPath("/images/");
	ArrayList<String> images = multipart.getFileNames("uploads");
	multipart.saveFiles("uploads", uploadPath);	
	for(int cnt=0; cnt<images.size();cnt++)
		log.info("image names: " + images.get(cnt));
	request.setAttribute("images", images);	
%>
<jsp:forward page="UploadResult.jsp"/>