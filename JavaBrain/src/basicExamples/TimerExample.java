package basicExamples;

import java.util.Timer;

public class TimerExample {

	public static void main(String[] args) {
		Timer timer = new Timer();
		try {
			for(int cnt=0;cnt<10;cnt++) {
				System.out.println(cnt);
				timer.wait(1000);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
