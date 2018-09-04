<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*,oracle.dbpool.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="org.apache.log4j.*"%>
<%
	Logger log = Logger.getLogger(this.getClass());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Social Community - Main</title>

    <!-- Bootstrap core CSS-->
    <link href="/WebProject/common/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="/WebProject/common/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="/WebProject/common/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/WebProject/common/css/sb-admin.css" rel="stylesheet">
    
    <link href="/WebProject/common/css/boardCommon.css" rel="stylesheet">
    
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
    <script src="/WebProject/common/js/commonFunctions.js"></script>
    <!-- Make sure the path to CKEditor is correct. -->
    <script src="/WebProject/ckeditor/ckeditor.js"></script>
    
<script language="javascript">
	window.onload = function() {
		loadScroll();
		setCookie("currentURL", window.location.href);
	}
	$(".disabled-link").click(function(event) {
		event.preventDefault();
	});
	$(document).ready( function() {
	  $('.boardlist').dataTable( {
	    "order": [[3,'desc']]
	  } );
	} );
</script>
<style>
a.disabled-link,
a.disabled-link:visited,
a.disabled-link:active,
a.disabled-link:hover {
    background-color: white !important;
    color: black !important;
}
</style>
    
</head>

 <body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1">소셜커뮤니티 사이트</a>

      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>

      <!-- Navbar Search -->
      <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
          <div class="input-group-append">
            <button class="btn btn-primary" type="button">
              <i class="fas fa-search"></i>
            </button>
          </div>
        </div>
      </form>

      <!-- Navbar -->
      	
      <ul class="navbar-nav ml-auto ml-md-0">
	      <c:if test="${sessionScope['mem_email']=='admin@admin.admin'}">
	        <li class="nav-item dropdown no-arrow mx-1">
	          <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	            <i class="fas fa-bell fa-fw"></i>
	            <span class="badge badge-danger">0</span>
	          </a>
	          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
	            <a class="dropdown-item" href="#">Action</a>
	            <a class="dropdown-item" href="#">Another action</a>
	            <div class="dropdown-divider"></div>
	            <a class="dropdown-item" href="#">Something else here</a>
	          </div>
	        </li>
	        <li class="nav-item dropdown no-arrow mx-1">
	          <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	            <i class="fas fa-envelope fa-fw"></i>
	            <span class="badge badge-danger">0</span>
	          </a>
	          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
	            <a class="dropdown-item" href="#">Action</a>
	            <a class="dropdown-item" href="#">Another action</a>
	            <div class="dropdown-divider"></div>
	            <a class="dropdown-item" href="#">Something else here</a>
	          </div>
	        </li>
	       </c:if>
        <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
          	<c:if test="${sessionScope.nickname == null}">
          		<a class="dropdown-item disabled-link" ><b>Guest</b> 님 어서오세요.<br/></a>
          		<div class="dropdown-divider"></div>
          		<a class="dropdown-item" href="../member/loginForm.jsp">로그인</a>
			</c:if>
            <c:if test="${sessionScope.nickname != null}">
            	<a class="dropdown-item disabled-link"><b>${sessionScope.nickname}</b> 님 어서오세요.<br/></a>
            	<div class="dropdown-divider"></div>
            	<a class="dropdown-item" href="../member/logout.jsp">로그아웃</a>
            </c:if>
            <a class="dropdown-item" href="../member/registerForm.jsp">회원가입</a>
            <a class="dropdown-item" href="../member/signOutForm.jsp">회원탈퇴</a>
            
          </div>
        </li>
      </ul>

    </nav>

    <div id="wrapper">

      <!-- Sidebar -->
      <ul class="sidebar navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="index.jsp">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>홈</span>
          </a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-fw fa-calendar"></i>
            <span>게시판</span>
          </a>
          <div class="dropdown-menu" aria-labelledby="pagesDropdown">
<% 
{
	//게시판 이름 받아오기
	String bbs_id="", bbs_name="", bbs_category="";
	try{ 
		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");		
		
		String query = "select bbs_id, bbs_name, bbs_category from sc_bbs order by bbs_id";
		log.info("홈메뉴게시판목록조회쿼리: " + query);		

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			int bbs_id_num = rs.getInt(1);
			bbs_id = String.valueOf(bbs_id_num);
			bbs_name = rs.getString(2);
			bbs_category = rs.getString(3);
				if(bbs_id_num%10000==1){
					%>	
					<h6 class="dropdown-header"><%= bbs_category %></h6>
					<a class="dropdown-item" href="index.jsp?BODY_PATH=/boards/boardlist.jsp?bbs_id=<%= bbs_id %>" onclick="setCookie('xyScroll', '0_0', '0')"><%= bbs_name %></a>
					<% 	
				} else{
					%>	
					<a class="dropdown-item" href="index.jsp?BODY_PATH=/boards/boardlist.jsp?bbs_id=<%= bbs_id %>" onclick="setCookie('xyScroll', '0_0', '0')"><%= bbs_name %></a>
					<% 
				}
			
			
					
		}		
		rs.close();
		stmt.close(); 
		pool.freeConnection("ora8", con);
		
	}catch (Exception e) {
		out.println(e);
	}
	
}

%>            
          </div>
        </li>        
        <c:if test="${sessionScope['mem_email']=='admin@admin.admin'}">	
	        <li class="nav-item">
	          <a class="nav-link" href="#" data-toggle="modal" data-target="#addBoardModal">
	            <i class="fas fa-fw fa-calendar-plus"></i>
	            <span>게시판 생성</span></a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#" data-toggle="modal" data-target="#deleteBoardModal">
	            <i class="fas fa-fw fa-calendar-minus"></i>
	            <span>게시판 삭제</span></a>
	        </li>
        </c:if>
      </ul>

      <div id="content-wrapper">
      
		
        <div class="container-fluid">
        
        	<c:if test="${param.BODY_PATH != null}">
				<jsp:include page="${param.BODY_PATH }" />
			</c:if>
			<c:if test="${param.BODY_PATH == null}">
				<%-- <jsp:include page="home.html" /> --%>
				<div style="float: left; width: 32%; margin-right: 1%;">
					<jsp:include page="home.jsp" />
				</div>
				<div style="float: left; width: 32%; margin-right: 1%;">
					<jsp:include page="home2.jsp" />
				</div>
				<div style="float: left; width: 32%">
					<jsp:include page="home3.jsp" />
				</div>
				
			</c:if>
        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright © Da Eun Lee by Kmove-30 Web Project</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->  
    

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>
    
    
    
    
     <!-- 게시판 생성 Modal-->
    <form method="post" action="/WebProject/admin/addboard.jsp">
	    <div class="modal fade" id="addBoardModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	      <div class="modal-dialog" role="document">
	        <div class="modal-content">
	          <div class="modal-header">
	            <h5 class="modal-title" id="exampleModalLabel">관리자 게시판 생성</h5>
	            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
	              <span aria-hidden="true">×</span>
	            </button>
	          </div>
	          <div class="modal-body">
	          		생성하려는 게시판의 카테고리 & 이름 정보 입력<br/><br/>
	          		카테고리 <input type="text" name="category" style="float: right;"/><br/><br/>
	          		게시판 이름 <input type="text" name="boardName" style="float: right;"/><br/><br/>         	
	          </div>
	          <div class="modal-footer">
	            <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>&nbsp; &nbsp;
	            <button type="submit" class="btn btn-primary" onclick=""/>생성</button>      
	          </div>
	        </div>
	      </div>
	    </div>
    </form>	
    
    <!-- 게시판 삭제 Modal-->
    <form method="post" action="/WebProject/admin/deleteboard.jsp"">
	    <div class="modal fade" id="deleteBoardModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	      <div class="modal-dialog" role="document">
	        <div class="modal-content">
	          <div class="modal-header">
	            <h5 class="modal-title" id="exampleModalLabel">관리자 게시판 삭제</h5>
	            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
	              <span aria-hidden="true">×</span>
	            </button>
	          </div>
	          <div class="modal-body">게시판을 삭제하려면 관리자 패스워드를 다시 한 번 입력해주세요<br/><br/>        	
	          		<input type="password" name="admin_pwd" style="float: right;"/><br/><br/>
	          		삭제하려는 게시판의 카테고리 & 이름 정보 입력<br/><br/>
	          		카테고리 <input type="text" name="category" style="float: right;"/><br/><br/>
	          		게시판 이름 <input type="text" name="boardName" style="float: right;"/><br/><br/>   
	          </div>
	          <div class="modal-footer">
	            <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>&nbsp; &nbsp;
	            <a class="btn btn-primary" href="#" data-toggle="modal" data-target="#deleteBoardModalDoubleCheck" data-dismiss="modal">삭제</a>       
	          </div>
	        </div>
	      </div>
	    </div>
	    
	    <!-- 게시판 삭제 재확인 Modal -->
	    <div class="modal fade" id="deleteBoardModalDoubleCheck" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	      <div class="modal-dialog" role="document">
	        <div class="modal-content">
	          <div class="modal-header">
	            <h5 class="modal-title" id="exampleModalLabel">관리자 게시판 삭제</h5>
	            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
	              <span aria-hidden="true">×</span>
	            </button>
	          </div>
	          <div class="modal-body">정말로 게시판을 삭제하시겠습니까?</div>
	          <div class="modal-footer">
	            <button class="btn btn-secondary" type="button" data-dismiss="modal">아니오</button>&nbsp; &nbsp; 
	            	<button type="submit" class="btn btn-primary" onclick=""/>예</button>
	          </div>
	        </div>
	      </div>
	    </div>
    </form>
    




  </body>
</html>