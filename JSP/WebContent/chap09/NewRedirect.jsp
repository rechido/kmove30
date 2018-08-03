<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="next" value="Divide.jsp">
	<c:param name="NUM1" value="100"></c:param>
	<c:param name="NUM2" value="25"></c:param>
</c:url>
<c:redirect url="${next}"/>