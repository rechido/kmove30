/**
 * 2018. 5. 15. Dev. by D. A. Lee
 */
package chap09;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class After100Days {
	public static void main(String[] args) {
//		GregorianCalendar cal = new GregorianCalendar();
//		System.out.println(cal);
//		
//		//cal.add(Calendar.DATE, 100);
//
//		int year = cal.get(Calendar.YEAR);
//		int month = cal.get(Calendar.MONTH)+1;
//		int date = cal.get(Calendar.DATE);
//		int amPm = cal.get(Calendar.AM_PM);
//		//int hour = cal.get(Calendar.HOUR);
//		int hour = cal.get(Calendar.HOUR_OF_DAY);
//		int min = cal.get(Calendar.MINUTE);
//		int sec = cal.get(Calendar.SECOND);
//		
//		String sAmPm = (amPm == Calendar.AM) ? "오전" : "오후";
//		System.out.printf("%d년 %d월 %d일 %s %d시 %d분 %d초\n",
//				year, month, date, sAmPm, hour, min, sec);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date()); // 현재 시간 설정
		cal.add(Calendar.DATE, 100);
		
		SimpleDateFormat dtfm = new SimpleDateFormat("yyyy년 MM월 dd일");
		String str = dtfm.format(cal.getTime());
		System.out.println(str);
		
		
		
		
	}

}
