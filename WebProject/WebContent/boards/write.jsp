<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="myutil.SubStringEx"%>
<%@page import="com.sun.javafx.binding.StringFormatter"%>
<%@page import="oracle.sql.CLOB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,oracle.dbpool.*,java.util.*"%>
<%@ page import="org.apache.log4j.*"%>
<%@page import="myutil.MultiPart"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	request.setCharacterEncoding("utf-8");
	Logger log = Logger.getLogger(this.getClass());
%>
<%
	MultiPart multipart = new MultiPart(request);

	int b_id=0;
	String bbs_id = session.getAttribute("bbs_id").toString();
	String seq_number = "SEQ_" + bbs_id;
	// 자신의 글이 들어갈 시퀀스 받아오기
	try {
		DBConnectionManager pool = DBConnectionManager.getInstance();
		Connection con = pool.getConnection("ora8");
		String query = String.format("select socialCommunity.%s.nextval from dual", seq_number);
		log.info("글작성시퀀스조회쿼리: " + query);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()){			
			b_id = rs.getInt(1);
			log.info("글작성시퀀스조회쿼리: b_id=" + b_id);
		}		
		stmt.close();
		pool.freeConnection("ora8", con);
	} catch (Exception e) {
		out.println(e);
	}

	// 글 업로드
	String nickname = session.getAttribute("nickname")!=null? session.getAttribute("nickname").toString():multipart.getParameter("nickname");
	String email = session.getAttribute("mem_email")!=null? session.getAttribute("mem_email").toString():null;
	String pwd = multipart.getParameter("pwd");
	String title = multipart.getParameter("title");
	String contents = multipart.getParameter("contents");
	ArrayList<String> images = multipart.getFileNames("uploads"); // 업로드 된 그림 파일 이름 불러오기
	log.info("-글 업로드 정보- ");
	log.info("nickname: " + nickname);
	log.info("email: " + email);
	log.info("pwd: " + pwd);
	log.info("title: " + title);
	log.info("contents: " + contents);
	boolean isNotImage = false;
	for(String image : images){
		log.info("image: " + image);
		String filnameExtension = SubStringEx.getLastnCharacters(image, 3);
		log.info("filnameExtension: " + filnameExtension);
		/* if(!(image=="") && !filnameExtension.equals("bmp") && !filnameExtension.equals("jpg") && !filnameExtension.equals("png") && !filnameExtension.equals("gif"))
			isNotImage = true; */
	}
			
	//for(String image : images)
	//	log.info("image: " + image);
	
	//쿼리에 '가 들어가면 에러가 발생하므로 replace 처리해준다.
 	title = Replace(title,"'","''");
 	contents = Replace(contents,"'","''");
 	// 게행처리
 	contents = Replace(contents,"\r\n","<br/>");
 	
 	/* Validation Check */
 	if(email==null&&pwd==null || title==null || contents==null || nickname==null){
 		%>
		<script language="JavaScript">
			alert("정보를 제대로 입력해주세요.");
			history.back(); // 1단계 이전 페이지로 이동
		</script>
		<%
 	}else if(images!=null && isNotImage){
 		%>
		<script language="JavaScript">
			alert("이미지 업로드는 bmp, jpg, png, gif 파일만 가능합니다.");
			history.back(); // 1단계 이전 페이지로 이동
		</script>
		<%
 	}else{
 		try {
			DBConnectionManager pool = DBConnectionManager.getInstance();
			Connection con = pool.getConnection("ora8");
			
			// 회원 글 업로드
			if(session.getAttribute("mem_email")!=null){
				String query = "insert into sc_bbs_post(b_id, bbs_id, b_nickname, b_email, b_title, b_contents) values(?, ?, ?, ?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				Clob clob = con.createClob();
				clob.setString(1, contents);
				pstmt.setInt(1, b_id);
				pstmt.setInt(2, Integer.parseInt(bbs_id));
				pstmt.setString(3, nickname);
				pstmt.setString(4, email);
				pstmt.setString(5, title);
				pstmt.setClob(6, clob);
				pstmt.executeUpdate();
				pstmt.close();
				
			//비회원 글 업로드	
			}else{
				String query = "insert into sc_bbs_post(b_id, bbs_id, b_nickname, b_pwd, b_title, b_contents) values(?, ?, ?, ?, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				Clob clob = con.createClob();
				clob.setString(1, contents);
				pstmt.setInt(1, b_id);
				pstmt.setInt(2, Integer.parseInt(bbs_id));
				pstmt.setString(3, nickname);
				pstmt.setString(4, pwd);
				pstmt.setString(5, title);
				pstmt.setClob(6, clob);
				pstmt.executeUpdate();
				pstmt.close();
			}
			
			createCommentSeq(log, bbs_id, b_id); // 댓글 시퀀스 생성
			createGoodSeq(log, bbs_id, b_id); // 추천자 시퀀스 생성
			createImageSeq(log, bbs_id, b_id); // 이미지 시퀀스 생성
			
			// 이미지 업로드
			String uploadPath = application.getRealPath("/images/");
			multipart.saveFiles("images", uploadPath);
			
			int cnt=1;
			for(String image : images){
			// 업로드 된 이미지 정보 DB에 저장
			String query = String.format("insert into sc_bbs_post_image(bbs_id, b_id, i_id, i_path, i_line) values('%s', '%s', socialCommunity.SEQ_%s_%si.nextval, '%s', '%s')", bbs_id, b_id, bbs_id, b_id, image, cnt++);
			log.info("이미지정보저장쿼리: " + query);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			stmt.close();  
			}
			
			pool.freeConnection("ora8", con);
		} catch (SQLException e) {
			log.info("===SQLException 발생===");
			out.println(e);
		} catch (Exception e) {
			out.println(e);
		}	
		%>
		<script language="javascript">
			alert("글을 업로드했습니다.");
			setCookie('xyScroll', '0_0', '0');
		</script>
		<%
		// 새로 등록된 글로 화면을 넘긴다.
		String url = String.format("/WebProject/main/index.jsp?BODY_PATH=/boards/boardlist.jsp?POST=/boards/boardpost.jsp&bbs_id=%s&b_id=%s", bbs_id, b_id);
		log.info("url: " + url);
		response.sendRedirect(url);
		
 	}
	
%>

<%! 
// 개행 처리를 위한 메소드 

public static String Replace(String original, String oldString, String newString) {
	for(int index = 0; (index = original.indexOf(oldString, index)) >= 0; index += newString.length())
	original = original.substring(0, index) + newString + original.substring(index + oldString.length());
  return original;
}

// 파일 업로드 메소드
public static String upload(HttpServletRequest request, ServletContext application) throws Exception{
	MultiPart multipart = new MultiPart(request);
	String fileName = multipart.getFileName("image");
	String newPath = application.getRealPath("/images/" + fileName);
	multipart.saveFile("image", newPath);
	return newPath;
}

// 댓글 시퀀스 생성
public static void createCommentSeq(Logger log, String bbs_id, int b_id) throws Exception{	
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	Statement stmt = con.createStatement();		
	String query = String.format("CREATE SEQUENCE SEQ_%s_%dc START WITH 1 INCREMENT BY 1 NOMAXVALUE", bbs_id, b_id);
	log.info("댓글시퀀스생성쿼리: " + query);
	stmt.executeUpdate(query);
	stmt.close();
	pool.freeConnection("ora8", con);
}
//추천자 시퀀스 생성
public static void createGoodSeq(Logger log, String bbs_id, int b_id) throws Exception{	
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	Statement stmt = con.createStatement();		
	String query = String.format("CREATE SEQUENCE SEQ_%s_%dg START WITH 1 INCREMENT BY 1 NOMAXVALUE", bbs_id, b_id);
	log.info("추천자시퀀스생성쿼리: " + query);
	stmt.executeUpdate(query);
	stmt.close();
	pool.freeConnection("ora8", con);
}
//이미지 시퀀스 생성
public static void createImageSeq(Logger log, String bbs_id, int b_id) throws Exception{	
	DBConnectionManager pool = DBConnectionManager.getInstance();
	Connection con = pool.getConnection("ora8");
	Statement stmt = con.createStatement();		
	String query = String.format("CREATE SEQUENCE SEQ_%s_%di START WITH 1 INCREMENT BY 1 NOMAXVALUE", bbs_id, b_id);
	log.info("이미지시퀀스생성쿼리: " + query);
	stmt.executeUpdate(query);
	stmt.close();
	pool.freeConnection("ora8", con);
}
%>

