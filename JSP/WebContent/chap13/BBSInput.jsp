<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="chap13.BBSItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h4>게시판 글쓰기</h4>
<form action="bbs-post" method="post" onsubmit="CURRENT_URL.value = window.location.href">
	제목: <input type="text" name="TITLE" value="${sessionScope.TITLE }"><br/>
	<textarea rows="5" cols="80" name="CONTENT">${sessionScope.CONTENT }</textarea><br/>
	<input type="hidden" name="CURRENT_URL">
	<input type="submit" name="save" value="저장">
	<input type="reset" value="취소">
	<input type="submit" name="temporarySave" value="임시저장" />
</form>