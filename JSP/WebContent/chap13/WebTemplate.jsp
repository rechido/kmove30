<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="org.apache.log4j.*" %>
<%
	Logger logger = Logger.getLogger(this.getClass());
	//logger.info("로그 시작.");
%>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>한빛미디어</title>
</head>
<body>
	<h1>한빛미디어</h1>
	<table border="1" cellpadding="10">
		<tr>
			<td width="190" valign="top">
			<!-- 구 로그인/아웃 화면 (로그인 화면 및 로그인 결과 보여줌) -->
			<%-- <c:choose>				
				<c:when test="${sessionScope.LOGIN_ID == null }">
					<a href="WebTemplate.jsp?BODY_PATH=LoginForm.html">로그인</a><br /> 
				</c:when>
				<c:otherwise>
					<a href="logout">로그아웃</a><br /> 
				</c:otherwise> 				
			</c:choose> --%>
			<!-- 신 로그인 화면 (웹 탬플릿 내부에 로그인 창이 존재) -->
			<c:choose>				
				<c:when test="${sessionScope.LOGIN_ID == null }">
					<jsp:include page="LoginWindow.html" />
				</c:when>
				<c:otherwise>
					<jsp:include page="LogoutWindow.jsp" />
				</c:otherwise> 				
			</c:choose>
				<a href="WebTemplate.jsp?BODY_PATH=Intro.html">회사소개</a><br /> 
				<a href="goods-list">책 정보</a><br /> 
				<a href="WebTemplate.jsp?BODY_PATH=BBSInput.jsp">게시판 글쓰기</a><br /> 
				<a href="bbs-list">게시판 글읽기</a><br />
			</td>
			<td valign="top" width="650">
				<jsp:include page="${param.BODY_PATH }" />
			</td>
		</tr>
	</table>
	<h5>Copyright@ 1993-2010 한빛미디어(주)</h5>
</body>
</html>