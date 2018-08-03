package basicExamples;

public class BitOPTest1 {
	public static void main(String[] args) {
		
		int num1 = 0xFFFF0000; // 16진수 표시
		// 2진수 11111111111111110000000000000000
		int num2 = 0xFF00FF00;
		// 111111110000000001111111100000000
		
		int result1 = num1 & num2; // AND bit연산 (2개 모두 1일 시에만 1로)
		int result2 = num1 | num2; // OR bit연산 (2개 중 하나라도 1이면 1로)
		int result3 = num1 ^ num2; // Exclusive-OR bit연산 (2개가 서로 다를 때만 1로)
		int result4 = ~num1; // NOT bit연산 (1의 보수 시 활용)

		System.out.printf("%08X %n", result1);
		// printf는 " "안에 서식을 주어 출력. 
		// %로 서식 표시 08x는 16진수 8자리인데 값이 없는 부분은 0으로 채움
		// %n은 줄바꿈
		// 자리수 앞에 -가 오면 외쪽부터 채움
		System.out.printf("%08X %n", result2);
		System.out.printf("%08X %n", result3);
		System.out.printf("%08X %n", result4);
		
		System.out.println(Integer.toBinaryString(result1));
		// int값을 2진수 형태 문자열로 출력하는 toBinaryString(int x) 메서드
		
	}

}

/**
 * %c character
 * %d decimal
 * %e exponential
 * %f floating
 * %i integer
 * %o octal (8진수)
 * %s string
 * %u unsigned decimal
 * %x hexadecimal (16진수)
 * %% print a percent sign
 * \%
*/