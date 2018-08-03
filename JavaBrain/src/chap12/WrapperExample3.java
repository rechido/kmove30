/**
 * 2018. 7. 2. Dev. by D. A. Lee
 */
package chap12;

public class WrapperExample3 {
	public static void main(String[] args) {
		String[] strAry = {"1", "2", "3", "4", "5"};
		
		int total = 0;
		
		for(int i=0; i<strAry.length; i++) 
			total += Integer.parseInt(strAry[i]);
		System.out.println(total);
		
		
			

	}

}
