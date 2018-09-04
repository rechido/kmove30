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

	String category = request.getParameter("category");
	String boardName = request.getParameter("boardName");
	int new_bbs_id = 0, max_bbs_id = 0;
	log.info("-게시판 생성 정보-");
	log.info("category: " + category);
	log.info("boardName: " + boardName);
	
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	
	// 게시판 존재 유무 조회
	try {
		// 카테고리&게시판이름 조회
		Statement stmt = con.createStatement();
		String bbs_category = "", bbs_name = "";
		String query = "select bbs_category, bbs_name from sc_bbs";
		log.info("게시판생성_카테고리조회: " + query);
		ResultSet rs = stmt.executeQuery(query);
		
		boolean categoryExist = false;
		while(rs.next()){			
			bbs_category = rs.getString(1);
			bbs_name = rs.getString(2);
			if(category.equals(bbs_category) && boardName.equals(bbs_name)){
				%>
				<script language="JavaScript">
					alert("이미 존재하는 게시판입니다.");
					history.back(); // 1단계 이전 페이지로 이동
				</script>
				<%
				return;
			} else if(category.equals(bbs_category)){
				// 카테고리 존재 시 해당 카테고리에서 가장 큰 게시판 번호 조회
				Statement stmt2 = con.createStatement();
				String query2 = String.format("select max(bbs_id) from sc_bbs where bbs_category = '%s'", bbs_category);
				log.info("게시판생성_카테고리내max(bbs_id)조회: " + query2);
				ResultSet rs2 = stmt2.executeQuery(query2);
				if(rs2.next()){
					max_bbs_id = rs2.getInt(1);
					new_bbs_id = max_bbs_id+1;
					log.info("max_bbs_id: " + max_bbs_id);
				}
				categoryExist = true;
				stmt2.close();
				rs2.close();
				break;
			}
			
		}
		if(categoryExist==false){
			
			// 카테고리 비존재 시 전체 게시판 중 가장 큰 번호 조회
			Statement stmt2 = con.createStatement();
			String query2 = "select max(bbs_id) from sc_bbs";
			log.info("게시판생성_전체max(bbs_id)조회: " + query2);
			ResultSet rs2 = stmt.executeQuery(query2);
			if(rs2.next()){
				max_bbs_id = rs2.getInt(1);
				if(category.equals("히트게시판")){
					new_bbs_id = 10001; // 히트게시판 카테고리는 무조건 1만대로 들어감
				}else if(max_bbs_id<20000){
					new_bbs_id = 20001; // 히트게시판을 제외한 게시판은 무조건 20001부터 시작
				}else{
					new_bbs_id = (max_bbs_id/10000+1)*10000+1; // 카테고리 숫자+1 & 첫 게시판이므로 1부터 시작
				}
				
			}
			stmt2.close();
			rs2.close();
		}
			rs.close();
			stmt.close();
		
		
	} catch (Exception e) {
		out.println(e);
	}
	
	
	
	try {
		// 게시판 생성 쿼리
		Statement stmt = con.createStatement();		
		String query = String.format("insert into sc_bbs values('%d','%s', '%s')", new_bbs_id, boardName, category);
		log.info("게시판생성쿼리: " + query);
		stmt.executeUpdate(query);
		stmt.close();
		// 시퀀스 생성 쿼린
		Statement stmt2 = con.createStatement();		
		String query2 = String.format("CREATE SEQUENCE SEQ_%d START WITH 1 INCREMENT BY 1 NOMAXVALUE", new_bbs_id);
		log.info("게시판시퀀스생성쿼리: " + query2);
		stmt2.executeUpdate(query2);
		stmt2.close();
		
		pool.freeConnection("ora8", con);
		
		%>
		<script src="/WebProject/common/js/commonFunctions.js"></script>
		<script language="javascript">
			alert("게시판을 생성했습니다.");
			location.href = getCookie("currentURL");
		</script>		
		<%
		
	} catch (Exception e) {
		out.println(e);
	}	
	
%>
