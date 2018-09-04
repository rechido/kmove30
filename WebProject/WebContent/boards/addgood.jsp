<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*,oracle.dbpool.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.net.InetAddress" %>
<%@ page import="org.apache.log4j.*"%>
<%
	request.setCharacterEncoding("utf-8");
	Logger log = Logger.getLogger(this.getClass());
%>
<%
	String b_id = session.getAttribute("b_id").toString();
	String bbs_id = session.getAttribute("bbs_id").toString();
	String g_email="";
	String mem_email = session.getAttribute("mem_email")==null?null:session.getAttribute("mem_email").toString();
	
	// 추천자 정보가 들어갈 시퀀스 받아오기
	int g_id=0;
	try {
		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");
		String query = String.format("select socialCommunity.SEQ_%s_%sg.nextval from dual", bbs_id, b_id);
		log.info("추천자시퀀스조회쿼리: " + query);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()){			
			g_id = rs.getInt(1);
			log.info("추천자시퀀스조회쿼리: g_id=" + g_id);
		}		
		stmt.close();
		pool.freeConnection("ora8", con);
	} catch (Exception e) {
		out.println(e);
	}
	
	
	try{
		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");	
		
		boolean alreadydidgood = false;
		// 비회원 추천
		if(session.getAttribute("mem_email")==null){
			log.info("비회원입니다.");
			String ipAddress=request.getRemoteAddr();
			// 추천 이미 했는지 여부 받아오기
			{
				Statement stmt = con.createStatement();
				String query = String.format("select g_email from sc_bbs_post_good where b_id = '%s' and bbs_id = '%s'", b_id, bbs_id);
				log.info("추천기록조회쿼리: " + query);
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()){
					g_email = rs.getString(1);
					log.info("g_email: " + g_email);
					if(g_email.equals(ipAddress))
						alreadydidgood = true;
				}
				
				stmt.close();
				rs.close();	
			}
			if(alreadydidgood){
				%>
				<script language=javascript>
					alert("이미 추천하셨습니다!");
					history.back();
				</script>		
				<%
			}else{
				
				Statement stmt = con.createStatement();
				String query = String.format("insert into sc_bbs_post_good(bbs_id, b_id, g_id, g_email) values('%S', '%s', '%s', '%s')", bbs_id, b_id, String.valueOf(g_id), ipAddress);
				log.info("비회원추천정보기록쿼리: " + query);
				stmt.executeUpdate(query);
				stmt.close();
				pool.freeConnection("ora8", con);
				%>
				<script src="/WebProject/common/js/commonFunctions.js"></script>
				<script language="javascript">
					alert("글을 추천하셨습니다!");
					location.href = getCookie("currentURL");
				</script>		
				<%
			}
			
		// 회원 추천	
		} else if(mem_email!=null){
			log.info("회원입니다.");
			// 추천 이미 했는지 여부 받아오기
			{
				Statement stmt = con.createStatement();
				String query = String.format("select g_email from sc_bbs_post_good where b_id = '%s' and bbs_id = '%s'", b_id, bbs_id);
				log.info("추천기록조회쿼리: " + query);
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()){
					g_email = rs.getString(1);
					log.info("g_email: " + g_email);
					if(g_email.equals(mem_email))
						alreadydidgood = true;
				}
				
				stmt.close();
				rs.close();	
			}
			
			if(alreadydidgood){
				%>
				<script language=javascript>
					alert("이미 추천하셨습니다!");
					history.back();
				</script>		
				<%
			}else{
				
				Statement stmt = con.createStatement();
				String query = String.format("insert into sc_bbs_post_good(bbs_id, b_id, g_id, g_email) values('%s', '%s', '%s', '%s')", bbs_id, b_id, String.valueOf(g_id), mem_email);
				log.info("회원추천정보기록쿼리: " + query);
				stmt.executeUpdate(query);
				stmt.close();
				pool.freeConnection("ora8", con);
				%>
				<script src="/WebProject/common/js/commonFunctions.js"></script>
				<script language="javascript">
					alert("글을 추천하셨습니다!");
					location.href = getCookie("currentURL");
				</script>		
				<%
			}
		}	
		
	}catch (Exception e) {
		out.println(e);
	}
	
%>

