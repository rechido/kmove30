/**
 * 2018. 5. 14. Dev. by D. A. Lee
 */
package chap09;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class CalendarExample1 {
	public static void main(String[] args) {
		GregorianCalendar cal = new GregorianCalendar();
		System.out.println(cal);
		
		//TimeZone tz = TimeZone.getTimeZone("Africa/Abidjan");
		//cal.setTimeZone(tz);
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);
		int amPm = cal.get(Calendar.AM_PM);
		//int hour = cal.get(Calendar.HOUR);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		String sAmPm = (amPm == Calendar.AM) ? "오전" : "오후";
		System.out.printf("%d년 %d월 %d일 %s %d시 %d분 %d초\n",
				year, month, date, sAmPm, hour, min, sec);

	}

}
