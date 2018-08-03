<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
	<script>
$(document).ready(function(){
    $("seldiv_h1").click(function(){
    	$("h1").css('background-color', 'red');
    });
});
</script>
</head>
<body>
	<h1
		style="border-color: rgb(255, 102, 102); background-color: rgb(255, 255, 153);">
		<span class="markup">&lt;h1&gt;</span>Welcome to My Homepage<span
			class="markup">&lt;/h1&gt;</span>
	</h1>
	<div id="seldiv_h1" onclick="clickSelOpt(&quot;h1&quot;);"
		style="font-weight: bold;">$("h1")</div>

</body>
</html>