<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h4>로그인</h4>
<c:choose>
	<c:when test="${param.LOGIN_RESULT == 'SUCCESS' }">
		로그인이 되었습니다. <br/> 안녕하세요 ${sessionScope.LOGIN_ID }님.
	</c:when>
	<c:otherwise>
		로그인에 실패했습니다. <br/> 아이디와 패스워드를 체크하세요.
	</c:otherwise>
</c:choose>