package basicExamples;

public class PriorityTest1 {
	public static void main(String[] args) {
		
		int a = 2, b = 3, c = 5;
		double d = 4.0, e = 0.5, f;
		
		f = ((a + b) == c) ? d : e;
		System.out.println(f);
		// 우선 순위에서 제일 높은 우선순위는 ( ) -> { } -> [ ] 
		// 내부 괄호가 있을 시는 외부 괄호가 먼저 선택되고 내부 괄호 선택
		// 우선순위 적용이 애매할 시는 괄호를 활용
		
		 f = a + b == c ? d : e;
		 System.out.println(f);
		 // 이 코드도 위와 같은 결과 -> 우선순위를 명백히 알아야 함.
		
	}

}
