// 패키지
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class JDBCExample2 {
    public static void main(String args[]) {
        // 1단계: DB 연결을 위한 컨넥션 인터페이스
    	Connection conn = null;
    	// Statement 인터페이스 - SQL 실행
    	Statement stmt = null;
    	// ResultSet 인터페이스 - SQL 결과를 저장
    	ResultSet rs = null;
    	
    	// try ~ catch 문에서 DB 연결 중에 예외가 발생하는지를 검사.
        try {
        	
        	int age=0;
        	String juminCD=null, personName=null, gender=null;
        	
        	// 2단계: JDBC 드라이버를 로드한다.
            Class.forName("com.mysql.jdbc.Driver");
            // 3단계: 드라이버매니저 클래스는 DB를 연결한다.
            conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3307/mysql", "root", "12345"); // dbms가 설치된 주소, 계정, 비번
            System.out.println("데이터베이스에 접속했습니다.");
            // 컨넥션 객체가 Statement 객체를 생성
            stmt = conn.createStatement();
            
            
            // 시험 테이블 인출 및 출력해보기
            rs = stmt.executeQuery(	"select juminCD, personName, gender, age from person where gender = 'm';");
            
            System.out.println("주민번호		이름	성별	나이");
            
            while(rs.next()) {            
            
            	juminCD = rs.getString(1); 	//rs.getString("juminCD");
            	personName = rs.getString(2);//rs.getString("personName");
            	gender = rs.getString(3); 	//rs.getString("gender");
            	age = rs.getInt(4); 			// rs.getInt("age");
            
            System.out.println(juminCD + "	" + personName + "	" + gender + "	" + age );
            }
            
            conn.close();
            
            System.out.println();
            System.out.println(juminCD + "	" + personName + "	" + gender + "	" + age );
            
            
            // goodsinfo 테이블 불러오기
//            ResultSet goodsinfo = stmt.executeQuery
//            		("select goodsinfoCode,	goodsinfoName,	Price,	Maker from goodsinfo;");
//            
//            System.out.println("# goodsinfo table #");
//            System.out.println();
//            System.out.println("goodsinfoCode	goodsinfoName	Price	Maker");
//            
//            while(goodsinfo.next()) {            
//            
//            	String goodsinfoCode = goodsinfo.getString(1); 	
//            	String goodsinfoName = goodsinfo.getString(2);
//            	int Price = goodsinfo.getInt(3); 	
//            	String Maker = goodsinfo.getString(4); 		
//            	
//            	if(goodsinfoName.length() > 5)
//            		System.out.println
//            		(goodsinfoCode + "		" + goodsinfoName + "	" + Price + "	" + Maker );
//            	else
//            		System.out.println
//            		(goodsinfoCode + "		" + goodsinfoName + "		" + Price + "	" + Maker );
//            
//            }
//            System.out.println();
            
            
            
            // custinfo 테이블 불러오기
//            ResultSet custinfo = stmt.executeQuery
//            		("select goodinfoName,	address,	phoneno from custinfo;");
//            
//            System.out.println("# custinfo table #");
//            System.out.println();
//            System.out.println("goodinfoName	address						phoneno ");
//             
//            while(custinfo.next()) {            
//             
//             	String goodinfoName = custinfo.getString(1); 	
//             	String address = custinfo.getString(2);
//             	String phoneno = custinfo.getString(3); 			
//             
//             	//System.out.println(address.length());
//             	if(address.length()>=39)
//             		System.out.println(goodinfoName + "		" + address + "	" + phoneno );
//             	else if(address.length()>=22)
//                 	System.out.println(goodinfoName + "		" + address + "			" + phoneno );
//             	else
//             		System.out.println(goodinfoName + "		" + address + "				" + phoneno );
//             	
//             	
//             }
//            System.out.println();
            
            
             
            // stocks 테이블 불러오기
//            ResultSet stocks = stmt.executeQuery
//            		("select goodsinfoCode,	stock from stocks;");
//            
//            System.out.println("# stocks table #");
//            System.out.println();
//            System.out.println("goodsinfoCode	stock");
//             
//            while(stocks.next()) {            
//             
//             	String goodsinfoCode = stocks.getString(1); 	
//             	int stock = stocks.getInt(2);		
//             
//             System.out.println(goodsinfoCode + "		" + stock);
//             }
            
            
            
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