import java.sql.*; // 패키지

class JDBCExample1 {
    public static void main(String args[]) {
        // 1단계: DB 연결을 위한 컨넥션 인터페이스
    	Connection conn = null;
    	
    	// try ~ catch 문에서 DB 연결 중에 예외가 발생하는지를 검사.
        try {
        	// 2단계: JDBC 드라이버를 로드한다.
            Class.forName("com.mysql.jdbc.Driver");
            // 3단계: 드라이버매니저 클래스는 DB를 연결한다.
            conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3307/mysql", "root", "12345"); // dbms가 설치된 주소, 계정, 비번
            System.out.println("데이터베이스에 접속했습니다.");
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