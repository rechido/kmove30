

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Prop_JDBCExample {
	public static void main(String args[]) {
        // 1단계: DB 연결을 위한 컨넥션 인터페이스
    	Connection conn 	= null;
    	String driver 		= null;
    	String url			= null;
    	String username		= null;
    	String password		= null;
    	    	
    	// try ~ catch 문에서 DB 연결 중에 예외가 발생하는지를 검사.
        try {
        	Properties props = new Properties();
        	FileInputStream in = new FileInputStream("db.properties");
        	props.load(in);
        	in.close();

        	driver 		= props.getProperty("jdbc.driver");        	
        	url 		= props.getProperty("jdbc.url");
        	username 	= props.getProperty("jdbc.username");
        	password 	= props.getProperty("jdbc.password");
        	
        	if (driver != null) {
        	    Class.forName(driver) ;
        	}


        	conn = DriverManager.getConnection(url, username, password);
            
            System.out.println("데이터베이스에 접속했습니다.");
            
            conn.close();
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스를 찾을 수 없습니다." + 
                               cnfe.getMessage());
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        catch (Exception e) {
        	System.out.println(e.getMessage());
		}
    }

}
