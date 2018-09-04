<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<h3>관리자 - 파일 업로드</h3>
	<form action="Upload.jsp" method="post" enctype="multipart/form-data">
		파일: <input type="file" name="upload_file1" multiple accept="image/*"/> <br/>
		파일2: <input type="file" name="upload_file2" multiple accept="image/*"/> <br/>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>