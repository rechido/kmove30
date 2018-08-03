<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>상품정보</title>
</head>
<body>
	<h3>상품정보</h3>
	<c:forEach var="goods" items="${GOODS }">
		코드:  ${goods.code }<br />
		제목:  ${goods.title }<br />
		저자:  ${goods.writer }<br />
		가격:  ${goods.price }<br />
		<br />
	</c:forEach>
<%-- 	
	<c:forEach begin="0" end="<%=goods.size() - 1%>">
		코드:  <%=goods.get(cnt).getCode()%><br />
		제목:  <%=goods.get(cnt).getTitle()%><br />
		저자:  <%=goods.get(cnt).getWriter()%><br />
		가격:  <%=goods.get(cnt).getPrice()%><br />
		<%
			cnt++;
		%><br />
	</c:forEach>
 --%>
</body>
</html>

