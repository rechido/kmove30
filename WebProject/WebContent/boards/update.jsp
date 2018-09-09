<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.io.IOException"%>
<%@page import="oracle.sql.CLOB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,oracle.dbpool.*,java.util.*"%>
<%@ page import="org.apache.log4j.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	request.setCharacterEncoding("utf-8");
	Logger log = Logger.getLogger(this.getClass());
%>
<%
	String b_id = session.getAttribute("b_id").toString();
	String bbs_id = session.getAttribute("bbs_id").toString();
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	log.info("-글 업데이트 정보- ");
	log.info("b_id: " + b_id);
	log.info("title: " + title);
	log.info("contents: " + contents);
	
	//쿼리에 '가 들어가면 에러가 발생하므로 replace 처리해준다.
 	title = Replace(title,"'","''");
 	contents = Replace(contents,"'","''");
 	// 게행처리
 	contents = Replace(contents,"\r\n","<br/>");
	
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	Statement stmt = con.createStatement();
	
	try {									
		String query = String.format("update sc_bbs_post set b_title = '%s', b_contents = '%s', b_date = (select sysdate from dual) where b_id = '%s' and bbs_id = '%s'",
				title, contents, b_id, bbs_id);
		log.info("글수정쿼리: " + query);
		stmt.executeUpdate(query);	
		stmt.close();
		pool.freeConnection("ora8", con);
		%>
		<script language="javascript">
			alert("글을 수정했습니다.");
			setCookie('xyScroll', '0_0', '0');
		</script>
		<%
		// 수정된 글로 화면을 넘긴다.
		String url = String.format("/WebProject/main/index.jsp?BODY_PATH=/boards/boardlist.jsp?POST=/boards/boardpost.jsp&bbs_id=%s&b_id=%s", bbs_id, b_id);
		log.info("url: " + url);
		response.sendRedirect(url);
		
	} catch (Exception e) {
		out.println(e);
		%>
		<script language="JavaScript">
			alert("글을 수정하지 못했습니다.");
			history.back(); // 1단계 이전 페이지로 이동
		</script>
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