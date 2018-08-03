<%@page contentType="text/html; charset=UTF-8" errorPage="DBError.jsp" %>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
<HTML>
    <HEAD><TITLE>데이터베이스 커넥션 풀 테스트</TITLE></HEAD>
    <BODY>
    <H3>데이터베이스 커넥션 풀 테스트</H3>
    <%
        Context context = new InitialContext();
        DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/wdbpool");
        Connection conn = ds.getConnection(); 
        if (conn != null) {
            out.println("연결 취득 완료<BR>");
            conn.close();
            out.println("연결 반환 완료<BR>");
        }
        else {
            out.println("연결 취득 실패<BR>");
        }
    %>
    </BODY>
</HTML>