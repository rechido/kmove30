<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글쓰기 - 입력 화면</title>
</head>
<body>
	<H2>글쓰기</H2>
	<form action=bbs-post METHOD="post">
		이름: <input type="text" name="NAME"><br>
		제목: <input type="text" name="TITLE"><br>
		<textarea rows="5" cols="50" name="CONTENT"></textarea><br>
		<input type="submit" value='저장'>
		<input type="reset" value='취소'>		
	</form>
</body>
</html>