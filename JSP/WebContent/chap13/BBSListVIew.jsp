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
			<td width="40">순번</td>
			<td width="300">제목</td>
			<td width="80">작성자</td>
			<td width="90">작성일자</td>
			<td width="70">작성시각</td>
		</tr>
		<c:forEach var="cnt" begin="0" end="${BBS_LIST.listSize-1 }">
			<tr>
				<td>${BBS_LIST.seqNo[cnt] }</td>
				<td><a href="WebTemplate.jsp?BODY_PATH=BBSItemVIew.jsp?SEQ_NO=${BBS_LIST.seqNo[cnt] }">${BBS_LIST.title[cnt] }</a></td>
				<td>${BBS_LIST.writer[cnt] }</td>
				<td>${BBS_LIST.date[cnt] }</td>
				<td>${BBS_LIST.time[cnt] }</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${BBS_LIST.maxSeqNo>param.LAST_SEQ_NO }">
		<a href='bbs-list?LAST_SEQ_NO=${param.LAST_SEQ_NO+TEXT_PER_PAGE }'>이전 페이지</a>
	</c:if>
	<c:forEach var="cnt" begin="1" end="${BBS_LIST.totalPageCount }">
		<a href='bbs-list?LAST_SEQ_NO=${BBS_LIST.maxSeqNo-(cnt-1)*TEXT_PER_PAGE+1  }'>${cnt }</a>
	</c:forEach>
	<c:if test="${!BBS_LIST.lastPage }">
		<a href='bbs-list?LAST_SEQ_NO=${BBS_LIST.seqNo[BBS_LIST.listSize-1] }'>다음 페이지</a>
	</c:if>
</body>
</html>