<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*,oracle.dbpool.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="org.apache.log4j.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Logger log = Logger.getLogger(this.getClass());
%>
<%
int c_id=0;
String b_id=session.getAttribute("b_id").toString();
String bbs_id=session.getAttribute("bbs_id").toString();

	//자신의 댓글이 들어갈 시퀀스 받아오기
	try {
		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");
		String query = String.format("select socialCommunity.SEQ_%s_%sc.nextval from dual", bbs_id, b_id);
		log.info("댓글작성시퀀스조회쿼리: " + query);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()){			
			c_id = rs.getInt(1);
			log.info("댓글작성시퀀스조회쿼리: c_id=" + c_id);
		}		
		stmt.close();
		pool.freeConnection("ora8", con);
	} catch (Exception e) {
		out.println(e);
	}

try{ 
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	Statement stmt = con.createStatement();
	Statement stmt2 = con.createStatement();
	
	String comments=request.getParameter("comment");
	String nickname=session.getAttribute("nickname")==null?request.getParameter("nickname"):session.getAttribute("nickname").toString();
	String email=session.getAttribute("mem_email")==null?null:session.getAttribute("mem_email").toString();
	String pwd=request.getParameter("pwd");
	log.info("-댓글 등록 정보-");
	log.info("nickname: " + nickname);
	log.info("email: " + email);
	log.info("pwd: " + pwd);
	log.info("comments: " + comments);
	//쿼리에 '가 들어가면 에러가 발생하므로 replace 처리해준다.
 	comments = Replace(comments,"'","''");
 	// 게행처리
 	comments = Replace(comments,"\r\n","<br/>");
	
	// 회원 댓글 달기
	if(email != null && comments!=""){
		String query = String.format("insert into sc_bbs_post_comments(c_id, b_id, bbs_id, c_comments, c_nickname, c_email) values('%d', '%s', '%s', '%s', '%s', '%s')", c_id, b_id, bbs_id, comments, nickname, email);
		log.info("회원댓글추가쿼리: " + query);
		stmt.executeUpdate(query);
		stmt.close(); 		
		con.close(); 
		pool.freeConnection("ora8", con);
		%>
		<script src="/WebProject/common/js/commonFunctions.js"></script>
		<script language="javascript">
			location.href = getCookie("currentURL");
		</script>		
		<%
	// 비회원 댓글 달기
	} else if(pwd!="" && nickname!="" && comments!=""){
		String query = String.format("insert into sc_bbs_post_comments(c_id, b_id, bbs_id, c_comments, c_nickname, c_pwd) values('%d', '%s', '%s', '%s', '%s', '%s')", c_id, b_id, bbs_id, comments, nickname, pwd);
		log.info("비회원댓글추가쿼리: " + query);
		stmt.executeUpdate(query);
		stmt.close();
		con.close();
		pool.freeConnection("ora8", con);
		%>
		<script src="/WebProject/common/js/commonFunctions.js"></script>
		<script language="javascript">
			location.href = getCookie("currentURL");
		</script>		
		<%
	} else{
	%>
	<script language=javascript>
		alert("정보를 정확히 입력해주세요.");
		history.back();
	</script>		
	<%
	}

	

}catch (Exception e) {
	out.println(e);
}	
%>
<%! 
//개행 처리를 위한 메소드 

public static String Replace(String original, String oldString, String newString) {
	for(int index = 0; (index = original.indexOf(oldString, index)) >= 0; index += newString.length())
	original = original.substring(0, index) + newString + original.substring(index + oldString.length());
  return original;
}
%>

