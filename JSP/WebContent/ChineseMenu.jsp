<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>오늘의 메뉴</title>
</head>
<body>
	<h3>오늘의 메뉴</h3>
	- 짜장면 <br/>
	- 볶음밥 <br/>
	- 짬뽕 <br/><br/>
	<% 
		out.flush();
		RequestDispatcher dispatcher = request.getRequestDispatcher("Now.jsp");
		// dispatcher.forward(request, response); // forward는 타겟 jsp로 넘어간 뒤에 거기서 끝남
		 dispatcher.include(request, response); // include는 타겟 jsp를 전부 실행한 후에 다시 돌아와 본 jsp를 끝까지 실행.
	%>
</body>
</html>