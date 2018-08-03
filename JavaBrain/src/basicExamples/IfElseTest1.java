package basicExamples;

public class IfElseTest1 {
	public static void main(String[] args) {
		int num1 = 152, num2 = 173;
		if(num1 > num2) {
			if(num1 > 100) {
				System.out.println("num1: " + num1);
				// +연산자는 연결 연산자
			}
			
		}
		else {
			if(num2 > 100) {
				System.out.println("num2: " + num2);
			}
		}
		System.out.println("Done");
		
		/*
		 * 다중선택 조건문은 if ~ else if ~ else if ~ else 형태
		 * 여러 조건 중 true를 만나면 그곳의 블록을 실행하고
		 * if 관련 구문을 빠져 나옴
		 * (처음 만나는 true조건에서 빠져 나옴)
		 */
		
		int num3 = 1520;
		if(num3 < 10) {
			System.out.println("num3이 10보다 작습니다.");
		}
		else if(num3 <100) {
			System.out.println("num3이 100보다 작습니다.");
		}
		else if(num3 < 1000) {
			System.out.println("num3이 1000보다 작습니다.");
		}
		else {
			System.out.println("num3이 1000보다 큽니다.");
		}
		System.out.println("다중선택문 종료");
	}
}




















