/**
 * 2018. 6. 1. Dev. by D. A. Lee
 */
package chap19;

import com.kosea.kmove30.JDBC_Manager;

public class MainProcess {

	public static void main(String[] args) {
		JDBC_Manager jdbcManager = new JDBC_Manager();
		
		new LoginEx1(jdbcManager);
		
		//new MallDBTableExample(jdbcManager);
		
		
		

	}

}
