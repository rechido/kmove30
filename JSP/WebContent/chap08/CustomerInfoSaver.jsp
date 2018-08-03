<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="pinfo" class="chap08.PersonalInfo" scope="request"/>
<jsp:setProperty property="name" name="pinfo" value="김연희"/>
<jsp:setProperty property="gender" name="pinfo" value="여"/>
<jsp:setProperty property="age" name="pinfo" value="29"/>
<jsp:forward page="CustomerInfoViewer.jsp" />