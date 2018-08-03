<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<form action="new-logout" method="get" onsubmit="CURRENT_URL.value = window.location.href">
	안녕하세요, ${sessionScope.LOGIN_ID }님<br/>
	<input type="hidden" name="CURRENT_URL">
	<input type="submit" value="로그아웃"><br/>
</form>