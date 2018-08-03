<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fibonacci Sum</title>
</head>
<body>
	<%
	int num1 = 1;
	int num2 = 1;
	int num3 = 2;
	int sum = 2;
	while (true) {
		sum += num3;
		num1 = num2;
		num2 = num3;
		num3 = num1 + num2;
		if (num3 > 100)
			break;
	}
	%>
	
	<h2>Fibonacci Sum</h2>
	1+1+2+...+<%= num2%> = <%= sum%>
</body>
</html>