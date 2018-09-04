<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="org.apache.log4j.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Logger log = Logger.getLogger(this.getClass());
%>
<% 
	Cookie[] cookies = request.getCookies();
	String userEmail="", userPwd="";

	for(int i = 0; i < cookies.length; i++)	{ 
		Cookie c = cookies[i];
		if (c.getName().equals("userEmail"))
			userEmail = c.getValue();			
		else if(c.getName().equals("userPwd"))
			userPwd = c.getValue();		
	} 
	if(userEmail != "" && userPwd != ""){
		log.info("쿠키에 저장된 회원정보: " + userEmail + " " + userPwd);
	}
		
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>SocialCommerce - Login</title>

    <!-- Bootstrap core CSS-->
    <link href="/WebProject/common/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="/WebProject/common/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="/WebProject/common/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/WebProject/common/css/sb-admin.css" rel="stylesheet">

</head>
<body class="bg-dark">

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">로그인</div>
        <div class="card-body">
          <form method="post" action="login.jsp">
            <div class="form-group">
              <div class="form-label-group">
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required="required" autofocus="autofocus" value="${cookie.userEmail.value}">
                <label for="inputEmail">이메일</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="password" name="pwd"  id="inputPassword" class="form-control" placeholder="Password" required="required" value="${cookie.userPwd.value}">
                <label for="inputPassword">패스워드</label>
              </div>
            </div>
            <div class="form-group">
              <div class="checkbox">
                <label>
                	<c:if test="${cookie.userEmail == null}">
                  	<input type="checkbox" name="rememberMe" value="on" >
                  	</c:if>
                  	<c:if test="${cookie.userPwd != null}">
                  	<input type="checkbox" name="rememberMe" value="on" checked="checked">
                  	</c:if>
                  Remember Me
                </label>
                	
              </div>
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="로그인" />
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="/WebProject/main/index.jsp">홈페이지로</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/WebProject/common/vendor/jquery/jquery.min.js"></script>
    <script src="/WebProject/common/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/WebProject/common/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="/WebProject/common/vendor/chart.js/Chart.min.js"></script>
    <script src="/WebProject/common/vendor/datatables/jquery.dataTables.js"></script>
    <script src="/WebProject/common/vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/WebProject/common/js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <script src="/WebProject/common/js/demo/datatables-demo.js"></script>
    <script src="/WebProject/common/js/demo/chart-area-demo.js"></script>
    
    <!-- Scroll & URL Saver -->
    <script src="/WebProject/common/js/scroll&urlSaver.js"></script>
</body>
</html>