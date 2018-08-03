/**
 * 2018. 5. 14. Dev. by D. A. Lee
 */
package chap09;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateFormatExample1 {
	public static void main(String[] args) {
		GregorianCalendar cal = new GregorianCalendar();
		Locale loc = new Locale("ENGLISH", "US");
		SimpleDateFormat dtfm = new SimpleDateFormat("yyyy-MMM-dd EEEE aa hh:mm:ss", loc);
		String str = dtfm.format(cal.getTime());
		System.out.println(str);
		
		SimpleDateFormat dtfm2 = new SimpleDateFormat("yyyy년 MM월 MMM dd일 EEEE aa hh시 mm분 ss초");
		String str2 = dtfm2.format(cal.getTime());
		System.out.println(str2);
		
		
	}

}
