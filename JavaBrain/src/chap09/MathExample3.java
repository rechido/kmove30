/**
 * 2018. 5. 15. Dev. by D. A. Lee
 */
package chap09;

import java.util.Date;
import java.util.Random;

public class MathExample3 {
	public static void main(String[] args) {
		
//		for(int i=0; i<100; i++) {
//			System.out.println(i + " " + Math.random());
//		}
		
//		for(int i=0; i<100; i++) {
//			System.out.println(i + " " + (int)(Math.random()*10));
//		}
			
		// 랜덤 클래스 이용 난수 발생
//		Random ran = new Random();
//		for(int i=0; i<100; i++) {
//			System.out.println(i + " " + ran.nextInt(100));
//		}
			
		// 시드 주기 -> 항상 같은 패턴 난수 발생
//		Random ran = new Random(100);
//		for(int i=0; i<100; i++) {
//			System.out.println(i + " " + ran.nextInt(100));
//		}
		
		// 시드 주기 -> 항상 같은 패턴 난수 발생
//		Date date = new Date();
//		System.out.println(date.getTime());
//		Random ran = new Random(date.getTime());
//		for(int i=0; i<10; i++) {
//			System.out.println(i + " " + ran.nextInt(100));
//		}
		
		// 불린 난수 이용해서 동전 던지기 예제
		Random ran = new Random();
		int head = 0, tale = 0;
		for(int i=0; i<100; i++) {			
			//if(ran.nextBoolean() == true)
			if(ran.nextInt(2) == 0)
				head++;
			else
				tale++;			
		}
		
		System.out.println("앞면 = " + head);
		System.out.println("뒷면 = " + tale);
		
		
		

	}

}
