package basicExamples;

public class ConditionTest1 {
	public static void main(String[] args) {
		int a=20, b=30, max;
		
		if(a<b) {
			max=b;
		}
		else {
			max=a;
		}
		System.out.println(max);
		
		// if else문을 ? 조건 연산자를 사용하면 간단히 작성
		max = a > b ? a : b;
		// ? : 는 조건 연산자로 비교 연산을 수행하여 true이면 앞의 값
		// false이면 뒤의 값을 선택
		System.out.println(max);
				
		String str = a < b ? "a가 b보다 작다." : "a가 b보다 크다.";
		System.out.println(str);
	}

}
