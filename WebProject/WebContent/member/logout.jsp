<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	session.removeAttribute("mem_email");
	session.removeAttribute("nickname");
%>
<script src="/WebProject/common/js/commonFunctions.js"></script>
<script language="javascript">
	alert('로그아웃 되었습니다.');
	location.href = getCookie("currentURL");
</script>
