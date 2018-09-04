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
	String bbs_id=request.getParameter("bbs_id"), bbs_name="", bbs_category="";
	session.setAttribute("bbs_id", bbs_id);
	try{ 
		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");
		
		
		String query = String.format("select bbs_name, bbs_category from sc_bbs where bbs_id='%s'", bbs_id);
		log.info("게시판이름조회쿼리: " + query);		

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		if(rs.next()){
			bbs_name = rs.getString(1);
			bbs_category = rs.getString(2);
		}
		
		rs.close();
		stmt.close(); 
		pool.freeConnection("ora8", con);
		
	}catch (Exception e) {
		out.println(e);
	}

%>
	<!-- 분류 & 게시판 제목 -->
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item" style="font-weight: bold !important;"><%= bbs_category %></li>
	    <li class="breadcrumb-item active"><%= bbs_name %></li>
	  </ol>
	<!-- 분류 & 게시판 제목 -->  
          
          <!-- 게시글 -->
          <jsp:include page="${param.POST }" />
          <!-- 게시글 -->

          <!-- 게시글 & 게시글 목록 -->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fas fa-table"></i>
              <%= bbs_name %> 게시판
            </div>
            <div class="card-body">
              <div class="table-responsive">  
              	<!-- 게시글 목록 -->
                <table class="table table-bordered boardlist" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th width="8%">번호</th>
                      <th width="50%">제목</th>
                      <th width="10%">글쓴이</th>
                      <th width="16%">날짜</th>
                      <th width="8%">조회</th>
                      <th width="8%">추천</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>번호</th>
                      <th>제목</th>
                      <th>글쓴이</th>
                      <th>날짜</th>
                      <th>조회</th>
                      <th>추천</th>
                    </tr>
                  </tfoot>
                  <tbody>
<% 
	// 게시글 받아오기
	try{ 
		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");
		
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
		
		while(rs.next()){
			bbs_id = String.valueOf(rs.getInt(1));
			b_id = String.valueOf(rs.getInt(2));
			b_nickname = rs.getString(3);
			b_pwd = rs.getString(4);
			b_title = rs.getString(5);
			b_date = rs.getString(6);
			b_hit = String.valueOf(rs.getInt(7));
			g_count = String.valueOf(rs.getInt(8));
			c_count = String.valueOf(rs.getInt(9));
			
			
			b_title += " [" + c_count + "]";
%>
                  
					<tr>
                      <td><%= b_id %></td>
                      <td><a href="/WebProject/boards/addhitcount.jsp?bbs_id=<%= bbs_id %>&b_id=<%= b_id %>" onclick="setCookie('xyScroll', '0_0', '0')"><%= b_title %></a></td>
                      <td><%= b_nickname %></td>
                      <td><%= b_date %></td>
                      <td><%= b_hit %></td>
                      <td><%= g_count %></td>
                    </tr>
<% 
			
		}
		
		rs.close();
		stmt.close(); 
		pool.freeConnection("ora8", con);
		
	}catch (Exception e) {
		out.println(e);
	}
%>
                  </tbody>
                </table>
                <!-- 게시글 목록 -->
                
              </div>
            </div>
            <div class="card-footer small text-muted">Created at 2018-08-22
            <c:set var = "bbs_id" scope = "session" value = "${sessionScope.bbs_id}"/>
            <c:if test="${bbs_id > 20000}">	
	            <button class="btn btn-primary btn-block uploadbtn" style="float:right;"
	            onclick="location.href = 'index.jsp?BODY_PATH=/boards/boardlist.jsp?POST=/boards/writeForm.jsp&bbs_id=<%=bbs_id %>';" >
	            	글쓰기
	            </button>
            </c:if>
            </div>
          </div>
          

