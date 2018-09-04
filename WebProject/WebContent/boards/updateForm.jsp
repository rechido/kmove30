<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*,oracle.dbpool.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="org.apache.log4j.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Logger log = Logger.getLogger(this.getClass());
%>
<%	
	String b_id = session.getAttribute("b_id").toString();
	String bbs_id = session.getAttribute("bbs_id").toString();
	String pwd = request.getParameter("pwd");
	String b_pwd="", b_email="";
	
	//회원글/ 비회원글 판별
	try {		
		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");
		
		String query = String.format("select b_pwd, b_email from sc_bbs_post where b_id='%s' and bbs_id = '%s'", b_id, bbs_id);
		log.info("글수정회원판별쿼리: " + query);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			b_pwd = rs.getString(1);
			b_email = rs.getString(2);
			log.info("b_pwd: " + b_pwd);
			log.info("b_email: " + b_email);
		} 
		stmt.close();
		pool.freeConnection("ora8", con);
		
	}catch (Exception e) {			
		out.println(e);
		%>
		<script language="JavaScript">
			alert("글을 수정하지 못했습니다.");
			history.back(); // 1단계 이전 페이지로 이동
		</script>
		<%
		
	}
	
	if(b_email==null && !pwd.equals(b_pwd)){
		%>
		<script language="JavaScript">
			alert("패스워드가 일치하지 않습니다!");
			history.back(); // 1단계 이전 페이지로 이동
		</script>
		<%
	}else{
		String b_title = "", b_contents = "";
		// 게시판 글 내용 받아오는 쿼리
		try {
			DBConnectionManager pool = DBConnectionManager.getInstance();
			Connection con = pool.getConnection("ora8");
			
			String query = String.format("select b_title, b_contents from sc_bbs_post where b_id='%s' and bbs_id = '%s'", b_id, bbs_id);
			log.info("글수정이전글내용조회쿼리: " + query);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			if(rs.next()){
				b_title = rs.getString(1);
				Clob clob = rs.getClob(2);
				b_contents = clob.getSubString(1, (int) clob.length());
				log.info("b_title: " + b_title);
				log.info("b_contents: " + b_contents);
			}
			rs.close();
			stmt.close();
			pool.freeConnection("ora8", con);
			
			// 게행처리
		 	b_contents = Replace(b_contents,"<br/>", "\r\n");

		} catch (Exception e) {
			out.println(e);
		}
		%>

	<form method="post" action="/WebProject/boards/update.jsp">
		<table class="table table-bordered" cellspacing="0">						
			<thead>
				<tr>
					<th colspan="3">
						<span class="boardtitles">글제목</span>
						<span class="titleContents"><input type="text" name="title" size="100" maxlength="100" value="<%= b_title %>"/></span>
					</th>
				</tr>							
			</thead>
			<tbody>
				<tr>
					<td colspan="3">									
						<span class="boardContents">
							<textarea name="contents" rows="20"><%= b_contents %></textarea>
							<br />
						</span>
						<span>
							<button type="button" class="btn btn-secondary btn-block cancelbtn" onclick="history.go(-1);">취소</button>
							<button type="submit" class="btn btn-primary btn-block uploadbtn">업로드</button>
							<br />
						</span>
					</td>
				</tr>
			</tbody>	
								
		</table>
	</form>				
			
		<% 
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
			

	