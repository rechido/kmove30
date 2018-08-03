package com.malldb;
// 패키지
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

class JDBCExample1 {
    public static void main(String args[]) {
        // 1단계: DB 연결을 위한 컨넥션 인터페이스
    	Connection conn = null;
    	// Statement 인터페이스 - SQL 실행
    	Statement stmt = null;
    	// ResultSet 인터페이스 - SQL 결과를 저장
    	ResultSet rs = null;
    	
    	
    	// try ~ catch 문에서 DB 연결 중에 예외가 발생하는지를 검사.
        try {
        	// 2단계: JDBC 드라이버를 로드한다.
            Class.forName("com.mysql.jdbc.Driver");
            // 3단계: 드라이버매니저 클래스는 DB를 연결한다.
            conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3307/malldb", "root", "12345"); // dbms가 설치된 주소, 계정, 비번
            System.out.println("데이터베이스에 접속했습니다.");
            
            // 컨넥션 객체가 Statement 객체를 생성
            stmt = conn.createStatement();
            // 시험 테이블 인출 및 출력해보기
            rs = stmt.executeQuery(	"show tables;");
            while(rs.next()) {
            	System.out.println(rs.getString(1));
            }            
            System.out.println();
            
            // 현재시간 출력            
            rs = stmt.executeQuery(	"select now();");
            if(rs.next()) 
            	System.out.println(rs.getString(1));
            
            System.out.println();
            
            // PROCESSLIST 출력
            rs = stmt.executeQuery(	"show PROCESSLIST;");
            ResultSetMetaData rsmd = rs.getMetaData();
            
            if(rs.next()) {
            	int i=1;
            	while(i<=rsmd.getColumnCount()) {
            		System.out.printf(rs.getString(i) + " ");
            		i++;
            	} 
            } 
            System.out.println();
            System.out.println();
            
            
            
            // 4단계: DB 연결을 종료한다.
            conn.close();
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스를 찾을 수 없습니다." + 
                               cnfe.getMessage());
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }
}