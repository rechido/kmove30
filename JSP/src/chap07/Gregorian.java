package chap07;

import java.util.GregorianCalendar;

public class Gregorian {
	public static String now() {
		GregorianCalendar now = new GregorianCalendar();
		String date = String.format("%TF", now);
		String time = String.format("%TT", now);
		return date + " " + time;
	}
}
