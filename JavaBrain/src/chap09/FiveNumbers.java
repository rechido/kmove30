/**
 * 2018. 5. 15. Dev. by D. A. Lee
 */
package chap09;

import java.util.Random;

public class FiveNumbers {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		Random random = new Random();
		int index = random.nextInt(5);
		System.out.println(arr[index]);

	}

}
