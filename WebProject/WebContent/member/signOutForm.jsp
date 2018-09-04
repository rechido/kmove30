<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	if (session.getAttribute("mem_email") == null) {
%>
   <script language="Javascript">
   alert("로그인을 하세요")
   location.href="loginForm.jsp";
   </script>
<%
	} else{
%>
<html xmlns="http://www.w3.org/1999/xhtml">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SocialCommerce - Sign Out</title>

    <!-- Bootstrap core CSS-->
    <link href="../common/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="../common/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="../common/css/sb-admin.css" rel="stylesheet">

  </head>

  <body class="bg-dark">

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">회원탈퇴를 위하여 회원정보를 재입력해주세요.</div>
        <div class="card-body">
          <form method="post" action="signOut.jsp">
            <div class="form-group">
              <div class="form-label-group">
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required="required" autofocus="autofocus">
                <label for="inputEmail">이메일</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                <input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="Password" required="required">
                <label for="inputPassword">패스워드</label>
              </div>
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="회원탈퇴" />
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="../main/index.jsp">홈페이지로</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="../common/vendor/jquery/jquery.min.js"></script>
    <script src="../common/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="../common/vendor/jquery-easing/jquery.easing.min.js"></script>

  </body>

</html>
<%		
		
	}
%>