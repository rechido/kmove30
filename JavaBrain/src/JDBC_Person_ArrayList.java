// 패키지
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 
class Person{
	
	public String 	juminCD		= null; 
	public String 	personName	= null; 
	public String 	gender		= null;
	public int 		age 		= 0;
	
	public Person() {
		this.juminCD 		= "주민번호 입력 누락";
		this.personName 	= "이름 입력 누락";
		this.gender 		= "성별 입력 누락";
		this.age 			= 0;
	}
	
	public String getJuminCD() {
		return juminCD;
	}
	public void setJuminCD(String juminCD) {
		this.juminCD = juminCD;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}


class JDBC_Person_ArrayList {
	public static void main(String args[]) {
				
		ArrayList<Person> listPersons = new ArrayList<Person>(); // 배열리스트 선언, 초기화
		Person persons;
		    	
		///////////////////////// JDBC 연결 시작 /////////////////////////
	
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
               "jdbc:mysql://localhost:3307/mysql", "root", "12345"); // dbms가 설치된 주소, 계정, 비번
            System.out.println("데이터베이스에 접속했습니다.");
            // 컨넥션 객체가 Statement 객체를 생성
            stmt = conn.createStatement();
            
             
            // 시험 테이블 인출 및 출력해보기
            //rs = stmt.executeQuery(	"select juminCD, personName, gender, age from person where gender = 'm';");
            rs = stmt.executeQuery(	"select juminCD, personName, gender, age from person;");
            
	            
	            while(rs.next()) {            
	            	persons = new Person();
	            	persons.setJuminCD(rs.getString(1)); 	//rs.getString("juminCD");
	            	persons.setPersonName(rs.getString(2));//rs.getString("personName");
	            	persons.setGender(rs.getString(3)); 	//rs.getString("gender");
	            	persons.setAge(rs.getInt(4)); 			// rs.getInt("age");
	            	listPersons.add(persons);
	            		            	
	            //System.out.println(persons[0].juminCD + "	" + persons[0].personName + "	" + persons[0].gender + "	" + persons[0].age );
	            }        
            
            // 4단계: DB 연결을 종료한다.
            conn.close();
            
            System.out.println("=========================================================================");

	    	for(int i=0; i<listPersons.size(); i++) {
				System.out.println("주민번호: " + listPersons.get(i).getJuminCD());
				System.out.println("이름: " + listPersons.get(i).getPersonName());
				System.out.println("성별: " + listPersons.get(i).getGender());
				System.out.println("나이: " + listPersons.get(i).getAge());
				System.out.println("=========================================================================");
			}
            
            
        }
        catch (ArrayIndexOutOfBoundsException arye) {
            System.out.println("배열 객체 용량 초과 index: " + 
                               arye.getMessage());
        }	        
        catch (ClassNotFoundException cnfe) {
            System.out.println("해당 클래스를 찾을 수 없습니다." + 
                               cnfe.getMessage());
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        
        ///////////////////////// JDBC 연결 종료 /////////////////////////
        
    }
}