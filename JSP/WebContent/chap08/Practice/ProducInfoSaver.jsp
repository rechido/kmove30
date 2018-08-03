<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="chap08.ProductInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ProductInfo product = new ProductInfo();
	product.setName("초코케이크 3호");
	product.setPrice(20000);
	request.setAttribute("PRODUCT", product);
%>
<jsp:forward page="ProductInfoView.jsp" />