<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>CSS3 Selector Basic</title>
<style>
/* img 태그 중에서 src 속성값이 png로 끝나는 태그의 border 속성에 3px solid red를 적용합니다. */
img[src$=png]{ border: 3px solid red; }
/* img 태그 중에서 src 속성값이 jpg로 끝나는 태그의 border 속성에 3px solid green을 적용합니다. */
img[src$=jpg]{ border: 3px solid green; }
/* img 태그 중에서 src 속성값이 gif로 끝나는 태그의 border 속성에 3px solid blue를 적용합니다. */
img[src$=gif]{ border: 3px solid blue; }
</style>
</head>
<body>
<img src="Remilia.png" width="200" height="250" />
<img src="aqua.jpg" width="200" height="250" />
</body>
</html>