<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>게시판</title>
</head>
<body>
	<h4>게시판 목록 보기</h4>
	<table border="1">
		<tr>
			<td width="80">상품코드</td>
			<td width="300">제목</td>
			<td width="80">저자</td>
			<td width="80">가격</td>
		</tr>
		<c:forEach var="cnt" begin="0" end="${GOODS_LIST.listSize-1 }">
			<tr>
				<td>${GOODS_LIST.code[cnt] }</td>
				<td>${GOODS_LIST.title[cnt] }</td>
				<td>${GOODS_LIST.writer[cnt] }</td>
				<td>${GOODS_LIST.price[cnt] }</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${GOODS_LIST.minCode<param.LAST_CODE }">
		<a href='goods-list?LAST_CODE=${param.LAST_CODE-TEXT_PER_PAGE }'>이전 페이지</a>
	</c:if>
	<c:forEach var="cnt" begin="1" end="${GOODS_LIST.totalPageCount }">
		<a href='goods-list?LAST_CODE=${GOODS_LIST.minCode+(cnt-1)*TEXT_PER_PAGE-1  }'>${cnt }</a>
	</c:forEach>
	<c:if test="${!GOODS_LIST.lastPage }">
		<a href='goods-list?LAST_CODE=${GOODS_LIST.code[GOODS_LIST.listSize-1] }'>다음 페이지</a>
	</c:if>
</body>
</html>