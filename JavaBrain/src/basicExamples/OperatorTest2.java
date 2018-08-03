package basicExamples;

public class OperatorTest2 {
	public static void main(String[] args) {
		int a=3, b=4, c=3, d=5;
		if((a == 2 | a == c) & !(c>d) & (1 == b ^ c != d)) { // 셋 다 true가 나옴
			System.out.println("맞습니다.");
		}
		else {
			System.out.println("틀립니다.");
		}
		
		// short-cut and, or는 &&와 ||를 사용하며 결과가 결정되면
		// 나머지 부분은 비교를 생략해 버림
		int num1 = 0, num2 = 0;
		if(++num1 > 0 || ++ num2 > 0)
			System.out.println("num1이 0보다 크거나 num2가 0보다 큽니다.");
		// ++num1이 0보다 커 true이므로 or에서는 뒷부분은 안해도 true를 얻음
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		// ++num2는 생략되었으므로 num2는 원래값 0이 나옴
	}

}
