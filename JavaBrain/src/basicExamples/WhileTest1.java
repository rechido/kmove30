package basicExamples;

public class WhileTest1 {
	public static void main(String[] args) {
		int cnt = 0;
		while(cnt < 10) {
			System.out.println("cnt = " + cnt);
			cnt++;
		}
		
		int num = 0;
		do {
			System.out.println("num = " + num);
			num++;
		} while(num < 10);	
		
	}	
}
