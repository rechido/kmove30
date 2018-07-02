/**
 * 2018. 5. 23. Dev. by D. A. Lee
 */
package chap11;

import java.io.File;

public class ObjectExample1 {
	public static void main(String[] args) {
		File file = new File("D:\\Da Eun Lee\\뻐꾸기.txt");
		String str = file.toString();		
		System.out.println(str);
	}

}
