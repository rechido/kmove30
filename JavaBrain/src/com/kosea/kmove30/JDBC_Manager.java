package com.kosea.kmove30;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Manager {
	
	////////// 속성(필드) //////////
	
	Connection conn = null; // 1단계: DB 연결을 위한 컨넥션 인터페이스
	Statement stmt = null; // Statement 인터페이스 - SQL 실행
	ResultSet rs = null; // ResultSet 인터페이스 - SQL 결과를 저장
	
	// 생성자
	public JDBC_Manager(Connection conn, Statement stmt, ResultSet rs) {
		super();
		this.conn = conn;
		this.stmt = stmt;
		this.rs = rs;
	}
	
	public JDBC_Manager() {
		//System.out.println("JDBC_Manager() 기본 생성자 호출");
	}
	
	
	
	////////// 기능(메소드) //////////
	
	// DB 연결
	public void connectDB(String driver, String url, String user, String password) throws Exception{
		
		Class.forName(driver); // 2단계: JDBC 드라이버를 로드한다.        
        conn = DriverManager.getConnection( // 3단계: 드라이버매니저 클래스는 DB를 연결한다.
           url, user, password); // dbms가 설치된 주소, 계정, 비번
        stmt = conn.createStatement();
        return;
	}
	
	// select
	public ResultSet selectTable(String sql) throws Exception{
		
		rs = stmt.executeQuery(sql); // sql에는 query 명령문이 들어가야함 예) "select personName, gender, age from person;"
		return rs;
	}
	
	// insert, delete, update
	public int updateTable(String sql) throws Exception{
		//stmt = conn.createStatement();
		//System.out.println(sql);
		int changeRecord = stmt.executeUpdate(sql); 		
		return changeRecord;
	}
	
	
	// DB 연결종료
	public void closeDB() throws Exception{
		conn.close();
	}

}
