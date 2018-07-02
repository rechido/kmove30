/**
 * 2018. 6. 5. Dev. by D. A. Lee
 */
package messenger;

public class MainProcess {
	public static void main(String[] args) {	

		MybatisQuery query = new MybatisQuery("messenger/mybatis-config.xml");
		Login login1 = new Login(query);
		//Login login2 = new Login(query);	
		Server server = new Server();
		
		//new MessengerClient("aaaa");
		
		
		
		
		

	}

}
