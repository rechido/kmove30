<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*,oracle.dbpool.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="org.apache.log4j.*"%>
<%
	Logger log = Logger.getLogger(this.getClass());
%>
<% 
	//게시판 이름 받아오기
	String bbs_id="", bbs_name="", bbs_category="";
	try{ 
		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");
		
		
		String query3 = String.format("select bbs_id, bbs_name, bbs_category from sc_bbs where bbs_id between 10000 and 19999");
		log.info("게시판이름조회쿼리: " + query3);

		Statement stmt3 = con.createStatement();
		ResultSet rs3 = stmt3.executeQuery(query3);
		
		int seq = 1;
		while(rs3.next()){
			bbs_id = rs3.getString(1);
			bbs_name = rs3.getString(2);
			bbs_category = rs3.getString(3);
			
			if(seq==1){
				%>
				<!-- 분류 & 게시판 제목 -->
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item" style="font-weight: bold !important;"><%= bbs_category %></li>
				  </ol>
				<!-- 분류 & 게시판 제목 -->  
				<%
			}
			seq++;
			%>		
			
			<!-- 게시글 & 게시글 목록 -->
	        <div class="card mb-3">
	            <div class="card-header">
	              <i class="fas fa-table"></i>
	              <%= bbs_name %> 게시판
	            </div>
	            <div class="card-body">	   
	            			<!-- 게시글 목록 -->
	              <ul style="list-style-type:none;" >
<% 
	// 게시글 받아오기
	try{ 
		//DBConnectionManager pool = DBConnectionManager.getInstance();
		//Connection con = pool.getConnection("ora8");
		
		String b_id="", b_nickname="", b_pwd="", b_title="", b_date="", b_hit="", g_count="", c_count="";
		String query = "";
		switch (Integer.parseInt(bbs_id)) {
        case 10001: query ="select bbs_id, b_id, b_nickname, b_pwd, b_title, b_date, b_hit, g_count, c_count from hit_click_view";
                 	break;
        case 10002: query = "select bbs_id, b_id, b_nickname, b_pwd, b_title, b_date, b_hit, g_count, c_count from hit_good_view";
                 	break;
        case 10003: query = "select bbs_id, b_id, b_nickname, b_pwd, b_title, b_date, b_hit, g_count, c_count from hit_comment_view";
                 	break;
        default: query = String.format("select bbs_id, b_id, b_nickname, b_pwd, b_title, b_date, b_hit, g_count, c_count from post_view where bbs_id=%s order by b_id desc", bbs_id);
                 break;
    }
		log.info("게시글목록조회쿼리: " + query);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		
		int cnt=1;
		while(rs.next()){
			if(cnt>5) 
				break;
			cnt++;
			bbs_id = String.valueOf(rs.getInt(1));
			b_id = String.valueOf(rs.getInt(2));
			b_nickname = rs.getString(3);
			b_pwd = rs.getString(4);
			b_title = rs.getString(5);
			b_date = rs.getString(6);
			b_hit = String.valueOf(rs.getInt(7));
			g_count = String.valueOf(rs.getInt(8));
			c_count = String.valueOf(rs.getInt(9));
			
			b_title = b_title.length()>20?b_title.substring(0, 20) + "...": b_title;
			
			String query2 = String.format("select i_id, i_path, i_line from sc_bbs_post_image where b_id = '%s' and bbs_id = '%s'", b_id, bbs_id);
			log.info("게시글이미지조회쿼리: " + query2);
			Statement stmt2 = con.createStatement();
			ResultSet rs2 = stmt2.executeQuery(query2);
			
			String i_id="", i_path="";
			if(rs2.next()){
				i_id = String.valueOf(rs2.getInt(1));
				i_path = rs2.getString(2);
			}
			pageContext.setAttribute("i_path", i_path);
%>
                  
	              			<li class="horizontalList">
	                  		<c:if test="${i_path !='' }">
	                  			<IMG alt="" src="/WebProject/images/<%= i_path %>" style="width: 250px;" /><br/> 
	                  		</c:if>
	                  		
	                  		<a href="/WebProject/boards/addhitcount.jsp?bbs_id=<%= bbs_id %>&b_id=<%= b_id %>" onclick="setCookie('xyScroll', '0_0', '0')" ><%= b_title %></a>
	                  		</li>

<% 

			rs2.close();
			stmt2.close();
			
		}
		
		rs.close();
		stmt.close(); 
		pool.freeConnection("ora8", con);
		
	}catch (Exception e) {
		out.println(e);
	}
%>               	
                  </ul>
          <!-- 게시글 목록 -->         
            	</div>
          	</div>
	            

			<%
		}
		
		rs3.close();
		stmt3.close(); 
		pool.freeConnection("ora8", con);
		
	}catch (Exception e) {
		out.println(e);
	}

%>
              	

