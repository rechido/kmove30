<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="chap08.ProductInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="PRODUCT" class="chap08.ProductInfo" scope="request"/>
<jsp:setProperty property="name" name="PRODUCT" value="초코케이크 3호"/>
<jsp:setProperty property="price" name="PRODUCT" value="20000"/>
<jsp:forward page="ProductInfoView.jsp" />