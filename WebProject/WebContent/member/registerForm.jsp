<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Social Commerce - Register</title>

    <!-- Bootstrap core CSS-->
    <link href="../common/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="../common/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="../common/css/sb-admin.css" rel="stylesheet">
    
</head>
<script language="JavaScript">
	var msg;
	function form_check() {

		var form = document.form_name;
		msg = "";
		
		if (form.email.value == "")
			msg += "이메일을 입력해주세요.<br/><br/>";
			
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

		if(exptext.test(form.email.value)==false){
			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우		
			msg += "이메일 형식이 올바르지 않습니다.<br/><br/>";
		}
			
		if (form.nickname.value == "")
			msg += "닉네임을 입력해주세요.<br/><br/>";
			
		if (form.pwd.value == "")
			msg += "패스워드를 입력해주세요.<br/><br/>";
			
		if (form.repwd.value == "")
			msg += "패스워드 확인란을 입력해주세요.<br/><br/>";
				
		if (form.pwd.value != form.repwd.value)
			msg += "비밀번호와 비밀번호 확인란의 값이 서로 다릅니다.<br/><br/>";

		if (msg == "") {
			form.submit();
		} else {
			document.getElementById("errorMessage").innerHTML = msg;
			errorAlert.click();
			return;
		}
	}

	// 숫자와 영문 입력 체크
	function a_or_d(str) {
		lower_str = str.toLowerCase();
		for (i = 0; i < lower_str.length; i++) {
			ch = lower_str.charAt(i);
			if (((ch < 'a') || (ch > 'z')) && ((ch < '0') || (ch > '9')))
				return 0;
		}
		return 1;
	}

	// ID 공백 체크
	function openuid_check() {
		if (document.form_name.uid.value == "") {
			alert("아이디를 입력하세요");
			return;
		}
		url = "id_check.jsp?uid=" + document.form_name.uid.value;
		open(url, "id_repeat_check", "width=300, height=220");
	}
	
	// 경고 다이얼로그 띄우기
	function alertDialog(){
		errorAlert.click();
	}
</script>
<body class="bg-dark">

    <div class="container">
      <div class="card card-register mx-auto mt-5">
        <div class="card-header">회원가입</div>
        <div class="card-body">
          <form name=form_name method="post" action="register.jsp">
            <div class="form-group">
              <div class="form-label-group">
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required="required" maxlength="30" autofocus="autofocus">
                <label for="inputEmail">이메일 주소</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-label-group">
                    <input type="text" name="nickname" id="nickname" class="form-control" placeholder="Last name" required="required" maxlength="20">
                    <label for="nickname">닉네임</label>
              </div>
            </div>
            <div class="form-group">
              <div class="form-row">
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="Password" required="required" maxlength="15">
                    <label for="inputPassword">패스워드</label>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-label-group">
                    <input type="password" name="repwd" id="confirmPassword" class="form-control" placeholder="Confirm password" required="required" maxlength="15">
                    <label for="confirmPassword">패스워드 확인</label>
                  </div>
                </div>
              </div>
            </div>
            <input type="button" class="btn btn-primary btn-block" value="가입" onclick="form_check()"/>
            <input type="hidden" id="errorAlert" data-toggle="modal" data-target="#alertModal"/>
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="../main/index.jsp">홈페이지로</a>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Logout Modal-->
    <div class="modal fade" id="alertModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">입력 에러</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body"><p id="errorMessage"></p></div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">확인</button>
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