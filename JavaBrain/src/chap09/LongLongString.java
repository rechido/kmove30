/**
 * 2018. 5. 15. Dev. by D. A. Lee
 */
package chap09;

public class LongLongString {
	public static void main(String[] args) {
		
		StringBuilder stBl = new StringBuilder();
		
		for(String str : args) {
			stBl.append(str);
			stBl.append(" ");
		}
		
		System.out.println(stBl);
		
	

	}

}
