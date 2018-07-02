/**
 * 2018. 5. 18. Dev. by D. A. Lee
 */
package chap6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InterfaceExample3 {
	public static void main(String[] args) {
		SeparateVolume obj1 = new SeparateVolume("863?774개", "개미", "베르베르");
		Date date = new Date();
		//System.out.println(date);
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		//System.out.println(sf.format(date));
		String today = sf.format(date); // 실시간으로 날짜 갱신돼서 반영됨
		
		printState(obj1);
//		try {
//			obj1.checkOut("둘리", today);
//		}
//		catch (Exception e) {
//			String msg = e.getMessage();
//			System.out.println(msg);
//		}
//		try {
//			obj1.checkOut("고길동", today);
//		}
//		catch (Exception e) {
//			String msg = e.getMessage();
//			System.out.println(msg);
//		}
		obj1.checkOut("고길동", today);
		printState(obj1);
		obj1.checkIn();
		printState(obj1);
		

	}
	
	static void printState(SeparateVolume obj) {
		if(obj.state == Lendable.STATE_NORMAL) {
			System.out.println("--------------------");
			System.out.println("대출상태: 대출가능");
			System.out.println("--------------------\n");
		}
		if(obj.state == Lendable.STATE_BORROWED) {
			System.out.println("--------------------");
			System.out.println("대출상태: 대출가능");
			System.out.println("대출인: " + obj.borrower);
			System.out.println("대출일: " + obj.checkOutDate);
			System.out.println("--------------------\n");
		}
	}

}
