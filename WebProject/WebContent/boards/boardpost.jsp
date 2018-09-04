<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.sql.*,oracle.dbpool.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="org.apache.log4j.*"%>
<%
	Logger log = Logger.getLogger(this.getClass());
%>
<%! 
//개행 처리를 위한 메소드 

public static String Replace(String original, String oldString, String newString) {
	for(int index = 0; (index = original.indexOf(oldString, index)) >= 0; index += newString.length())
	original = original.substring(0, index) + newString + original.substring(index + oldString.length());
  return original;
}
%>

<!-- 게시글 -->
<% 
	String bbs_id = session.getAttribute("bbs_id").toString();
	try {
		// 게시글 받아오기
		String b_id=request.getParameter("b_id");
		if(b_id!=null){
		// 게시판 글 내용 받아오는 쿼리
		
			DBConnectionManager pool = DBConnectionManager.getInstance();
			Connection con = pool.getConnection("ora8");

			String b_nickname = "", b_email = "", b_title = "", b_contents = "", b_date = "",
					b_hit = "", g_count = "", c_count = "";
			{
				String query = String.format("select b_nickname, b_email, b_title, b_contents, b_date, b_hit, g_count, c_count from post_view where b_id = '%s' and bbs_id = '%s'", b_id, bbs_id);
				log.info("게시판콘텐츠조회쿼리: " + query);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
	
				if(rs.next()){
					b_nickname = rs.getString(1);
					b_email = rs.getString(2);
					b_title = rs.getString(3);
					Clob clob = rs.getClob(4);
					b_contents = clob.getSubString(1, (int) clob.length());
					b_date = rs.getString(5);
					b_hit = String.valueOf(rs.getInt(6));
					g_count = String.valueOf(rs.getInt(7));
					c_count = String.valueOf(rs.getInt(8));
				}	
				rs.close();
				stmt.close();
			}
			ArrayList images = new ArrayList();
			
			{
				String query = String.format("select i_id, i_path, i_line from sc_bbs_post_image where b_id = '%s' and bbs_id = '%s'", b_id, bbs_id);
				log.info("게시글이미지조회쿼리: " + query);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()){
					String i_id = "", i_path = "", i_line = "";
					i_id = rs.getString(1);
					i_path = rs.getString(2);
					i_line = rs.getString(3);
					Map map = new HashMap<String, String>();
					map.put("i_id", i_id);
					map.put("i_path", i_path);
					map.put("i_line", i_line);
					images.add(map);
				}
				rs.close();
				stmt.close();
			}
			pageContext.setAttribute("images", images);
			session.setAttribute("b_id", b_id);
			pageContext.setAttribute("b_email", b_email);
	
%>
				
					<table class="table table-bordered" cellspacing="0">
					<thead>
							<tr>
								<th colspan="3">
									<span class="boardtitles">글제목</span>
									<span class="titleContents"><%=b_title%></span> 
									<span class="titleContents" style="float: right;"><%=b_date%></span>
									<span class="boardtitles" style="float: right;">날짜</span>
								</th>
							</tr>
							<tr>
								<th colspan="3">
									<span class="boardtitles">작성자</span>
									<span class="titleContents"><%=b_nickname%></span> 
									<span class="boardtitles">조회</span>
									<span class="titleContents"><%=b_hit%></span> 
									<span class="boardtitles">추천</span>
									<span class="titleContents"><%=g_count%></span> 
									<span class="boardtitles">댓글</span>
									<span class="titleContents"><%=c_count%></span>
									
									<!-- 회원 글수정/삭제 -->
									<c:if test="${pageScope.b_email != null && pageScope.b_email == sessionScope.mem_email}">									
										<ul class="navbar-nav ml-auto ml-md-0" style="float: right;">        
									        <li class="nav-item dropdown no-arrow">
									          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									            <i class="fas fa-pen fa-fw"></i>
									          </a>
									          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
								            	<a class="dropdown-item" href="index.jsp?BODY_PATH=/boards/boardlist.jsp?POST=/boards/updateForm.jsp&bbs_id=<%=bbs_id %>">수정</a>
								            	<a class="dropdown-item" href="#" data-toggle="modal" data-target="#deleteModal">삭제</a>								            									                          
									          </div>
									        </li>
								      	</ul>
							      	</c:if>
							      	<!-- 비회원 글수정/삭제 -->							      	 
							      	<c:if test="${pageScope.b_email == null}">
										<ul class="navbar-nav ml-auto ml-md-0" style="float: right;">        
									        <li class="nav-item dropdown no-arrow">
									          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									            <i class="fas fa-pen fa-fw"></i>
									          </a>
									          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
								            	<a class="dropdown-item" href="#" data-toggle="modal" data-target="#updateModalUnsigned">수정</a>
								            	<a class="dropdown-item" href="#" data-toggle="modal" data-target="#deleteModalUnsigned">삭제</a>								            									                          
									          </div>
									        </li>
								      	</ul>
							      	</c:if> 
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="3">
									<span class="boardContents">
										<c:forEach var="image" items="${images }">
											<IMG alt="" src="/WebProject/images/${image.i_path }" /><br/>
										</c:forEach>
										<br/>
										<%=b_contents%>
										<br />
										<br />
										<br />
										<br />
										<form method="post" action="/WebProject/boards/addgood.jsp">
											<button type="submit" class="btn btn-primary btn-block goodbtn" onclick="saveScrollSubmit()">추천</button>
										</form>										
										<br />
										<br /> 
									</span>
								</td>
							</tr>
						</tbody>
						<tfoot>
		<%
			{
			// 댓글 받아오는 쿼리
			String query = String.format(
					"select c_id, c_nickname, c_comments, c_email, c_pwd, c_date  from sc_bbs_post_comments where b_id='%s' and bbs_id='%s' order by c_id",
					b_id, bbs_id);
			log.info("댓글조회쿼리: " + query);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
	
			while (rs.next()) {
				String c_id = rs.getString(1);
				String c_nickname = rs.getString(2);
				String c_comments = rs.getString(3);
				String c_email = rs.getString(4);
				pageContext.setAttribute("c_email", c_email);
				String c_pwd = rs.getString(5);
				String c_date = rs.getString(6);
				//log.info("-댓글정보-");
				//log.info(c_id + " " + c_nickname + " " + c_comments + " " + c_email + " " + c_pwd + " " + c_date);
				
				// 게행처리
		 		String c_comments_edit = Replace(c_comments,"<br/>", "\r\n");
		%>
							<tr>
								<th class="comments" width="15%">
									<%=c_nickname%>
									<!-- 회원 댓글수정/삭제 -->
									<c:if test="${pageScope.c_email != null && pageScope.c_email == sessionScope.mem_email}">									
										<ul class="navbar-nav ml-auto ml-md-0" style="float: right;">        
									        <li class="nav-item dropdown no-arrow">
									          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									            <i class="fas fa-pen fa-fw"></i>
									          </a>
									          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
								            	<a class="dropdown-item" href="#" data-toggle="modal" data-target="#updateCommentModal<%= bbs_id %>_<%= b_id %>_<%= c_id %>">수정</a>
								            	<a class="dropdown-item" href="#" data-toggle="modal" data-target="#deleteCommentModal<%= bbs_id %>_<%= b_id %>_<%= c_id %>">삭제</a>								            									                          
									          </div>
									        </li>
								      	</ul>
							      	</c:if>
							      	<!-- 비회원 댓글수정/삭제 -->							      	 
							      	<c:if test="${pageScope.c_email == null}">
										<ul class="navbar-nav ml-auto ml-md-0" style="float: right;">        
									        <li class="nav-item dropdown no-arrow">
									          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									            <i class="fas fa-pen fa-fw"></i>
									          </a>
									          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
								            	<a class="dropdown-item" href="#" data-toggle="modal" data-target="#updateCommentModalUnsigned<%= bbs_id %>_<%= b_id %>_<%= c_id %>">수정</a>
								            	<a class="dropdown-item" href="#" data-toggle="modal" data-target="#deleteCommentModalUnsigned<%= bbs_id %>_<%= b_id %>_<%= c_id %>">삭제</a>								            									                          
									          </div>
									        </li>
								      	</ul>
							      	</c:if> 
							      	<!-- 회원 댓글 수정 Modal-->
								    <form method="post" action="/WebProject/boards/updateComment.jsp?c_id=<%= c_id %>">
									    <div class="modal fade" id="updateCommentModal<%= bbs_id %>_<%= b_id %>_<%= c_id %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
									      <div class="modal-dialog" role="document">
									        <div class="modal-content">
									          <div class="modal-header">
									            <h5 class="modal-title" id="exampleModalLabel">회원 댓글 수정</h5>
									            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
									              <span aria-hidden="true">×</span>
									            </button>
									          </div>
									          <div class="modal-body">수정할 내용을 입력해주세요<br/><br/>          	
									          		<textarea name="new_comment" rows=3><%=c_comments_edit%></textarea>         	
									          </div>
									          <div class="modal-footer">
									            <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>&nbsp; &nbsp;
									            <button type="submit" class="btn btn-primary" onclick="saveScrollSubmit()"/>수정</button>       
									          </div>
									        </div>
									      </div>
									    </div>
								    </form>
							      	<!-- 회원 댓글 삭제 Modal-->
							      	<form id="form_name" method="post" action="/WebProject/boards/deleteComment.jsp?c_id=<%= c_id %>">
								    <div class="modal fade" id="deleteCommentModal<%= bbs_id %>_<%= b_id %>_<%= c_id %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
									      <div class="modal-dialog" role="document">
									        <div class="modal-content">
									          <div class="modal-header">
									            <h5 class="modal-title" id="exampleModalLabel">댓글 삭제</h5>
									            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
									              <span aria-hidden="true">×</span>
									            </button>
									          </div>
									          <div class="modal-body">정말로 이 댓글을 삭제하시겠습니까?</div>
									          <div class="modal-footer">
									            <button class="btn btn-secondary" type="button" data-dismiss="modal">아니오</button>&nbsp; &nbsp; 
									            	<button type="submit" class="btn btn-primary" onclick="saveScrollSubmit()"/>예</button>
									          </div>
									        </div>
									      </div>
									    </div>
								    </form>	
								    <!-- 비회원 댓글 수정 Modal-->
								    <form method="post" action="/WebProject/boards/updateComment.jsp?c_id=<%= c_id %>">
									    <div class="modal fade" id="updateCommentModalUnsigned<%= bbs_id %>_<%= b_id %>_<%= c_id %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
									      <div class="modal-dialog" role="document">
									        <div class="modal-content">
									          <div class="modal-header">
									            <h5 class="modal-title" id="exampleModalLabel">비회원 댓글 수정</h5>
									            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
									              <span aria-hidden="true">×</span>
									            </button>
									          </div>
									          <div class="modal-body">댓글을 수정하려면 패스워드를 입력해주세요<br/><br/>          	
									          		<input type="password" name="pwd"/>	<br/><br/> 
									          		수정할 내용을 입력해주세요<br/><br/>          	
									          		<textarea name="new_comment" rows=3><%=c_comments_edit%></textarea>          	
									          </div>
									          <div class="modal-footer">
									            <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>&nbsp; &nbsp;
									            <button type="submit" class="btn btn-primary" onclick="saveScrollSubmit()"/>수정</button>      
									          </div>
									        </div>
									      </div>
									    </div>
								    </form>						      	
							      	<!-- 비회원 댓글 삭제 Modal-->
								    <form method="post" action="/WebProject/boards/deleteComment.jsp?c_id=<%= c_id %>">
									    <div class="modal fade" id="deleteCommentModalUnsigned<%= bbs_id %>_<%= b_id %>_<%= c_id %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
									      <div class="modal-dialog" role="document">
									        <div class="modal-content">
									          <div class="modal-header">
									            <h5 class="modal-title" id="exampleModalLabel">비회원 댓글 삭제</h5>
									            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
									              <span aria-hidden="true">×</span>
									            </button>
									          </div>
									          <div class="modal-body">댓글을 삭제하려면 패스워드를 입력해주세요<br/><br/>          	
									          		<input type="password" name="pwd"/>	          	
									          </div>
									          <div class="modal-footer">
									            <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>&nbsp; &nbsp;
									            <a class="btn btn-primary" href="#" data-toggle="modal" data-target="#deleteCommentModalUnsignedDoubleCheck<%= bbs_id %>_<%= b_id %>_<%= c_id %>" data-dismiss="modal">삭제</a>       
									          </div>
									        </div>
									      </div>
									    </div>
									    
									    <!-- 비회원 댓글 삭제 재확인 Modal -->
									    <div class="modal fade" id="deleteCommentModalUnsignedDoubleCheck<%= bbs_id %>_<%= b_id %>_<%= c_id %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
									      <div class="modal-dialog" role="document">
									        <div class="modal-content">
									          <div class="modal-header">
									            <h5 class="modal-title" id="exampleModalLabel">댓글 삭제</h5>
									            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
									              <span aria-hidden="true">×</span>
									            </button>
									          </div>
									          <div class="modal-body">정말로 이 댓글을 삭제하시겠습니까?</div>
									          <div class="modal-footer">
									            <button class="btn btn-secondary" type="button" data-dismiss="modal">아니오</button>&nbsp; &nbsp; 
									            	<button type="submit" class="btn btn-primary" onclick="saveScrollSubmit()"/>예</button>
									          </div>
									        </div>
									      </div>
									    </div>
								    </form>
								</th>
								<th class="comments" width="70%"><%=c_comments%></th>
								<th class="comments" width="15%"><%=c_date%></th>
							</tr>
		<%
			}
		%>
							<form name="form_name" method="post" action="/WebProject/boards/addcomment.jsp">
								<tr>
									<c:if test="${sessionScope.nickname == null}">
										<th class="comments" width="15%">
											닉네임 <br /> <input type="text" name="nickname" size="12" maxlength="12"/>
											<br /> 
											패스워드 <br />  <input type="password" name="pwd" size="12" maxlength="15"/>
										</th>
									</c:if>
									<c:if test="${sessionScope.nickname != null}">
										<th class="comments" width="15%">${sessionScope.nickname}</th>
									</c:if>
									<th class="comments" width="70%">									
										<textarea name="comment" rows="3"></textarea>
									</th>
									<th class="comments" width="15%">									
										<button type="submit" class="btn btn-primary btn-block"  onclick="saveScrollSubmit()">등록</button>
									</th>
								</tr>
							</form>
						</tfoot>
					</table>
				
		<%			
			rs.close();			
			stmt.close();
			pool.freeConnection("ora8", con);
			}
		
		}
	} catch (Exception e) {
		out.println(e);
	}
%>
<!-- 게시글 -->

<!-- 회원 글 삭제 Modal-->
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">글 삭제</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">정말로 이 글을 삭제하시겠습니까?</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">아니오</button>&nbsp; &nbsp;         
            	<a class="btn btn-primary" href="/WebProject/boards/delete.jsp">예</a>
          </div>
        </div>
      </div>
    </div>
    
    <!-- 비회원 글 삭제 Modal-->
    <form method="post" action="/WebProject/boards/delete.jsp">
	    <div class="modal fade" id="deleteModalUnsigned" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	      <div class="modal-dialog" role="document">
	        <div class="modal-content">
	          <div class="modal-header">
	            <h5 class="modal-title" id="exampleModalLabel">비회원 글 삭제</h5>
	            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
	              <span aria-hidden="true">×</span>
	            </button>
	          </div>
	          <div class="modal-body">글을 삭제하려면 패스워드를 입력해주세요<br/><br/>          	
	          		<input type="password" name="pwd"/>	          	
	          </div>
	          <div class="modal-footer">
	            <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>&nbsp; &nbsp;
	            <a class="btn btn-primary" href="#" data-toggle="modal" data-target="#deleteModalUnsignedDoubleCheck" data-dismiss="modal">삭제</a>       
	          </div>
	        </div>
	      </div>
	    </div>
	    
	    <!-- 비회원 글 삭제 재확인 Modal -->
	    <div class="modal fade" id="deleteModalUnsignedDoubleCheck" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">글 삭제</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">정말로 이 글을 삭제하시겠습니까?</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">아니오</button>&nbsp; &nbsp; 
            	<input type="submit" class="btn btn-primary" value="예" />
          </div>
        </div>
      </div>
    </div>
    </form>
    
    <!-- 비회원 글 수정 Modal-->
    <form method="post" action="index.jsp?BODY_PATH=/boards/updateForm.jsp">
	    <div class="modal fade" id="updateModalUnsigned" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	      <div class="modal-dialog" role="document">
	        <div class="modal-content">
	          <div class="modal-header">
	            <h5 class="modal-title" id="exampleModalLabel">비회원 글 수정</h5>
	            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
	              <span aria-hidden="true">×</span>
	            </button>
	          </div>
	          <div class="modal-body">글을 수정하려면 패스워드를 입력해주세요<br/><br/>          	
	          		<input type="password" name="pwd"/>	          	
	          </div>
	          <div class="modal-footer">
	            <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>&nbsp; &nbsp;
	            <input type="submit" class="btn btn-primary" value="수정" />        
	          </div>
	        </div>
	      </div>
	    </div>
    </form>
			
