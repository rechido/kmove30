import java.util.Scanner;
// DaEunLee33

/**
 * 2018. 5. 1. Dev By Lee D. E.
 * 
 * Calculator.java
 */

public class Calculator {
	// 속성필드(데이터)

	
	// 메소드(함수, 기능)
	public int plus(int x, int y, int z) {
		
		int total = x+y+z;
		return total;
	}

	public static void main(String[] args) {
		
		int number1;
		int number2;
		int number3;
		
		System.out.println("두개 숫자 입력");
		Scanner scan = new Scanner(System.in);
		number1 = scan.nextInt();
		number2 = scan.nextInt();
		number3 = scan.nextInt();
		//객체 생성
		Calculator cal = new Calculator();
		int result = cal.plus(number1, number2, number3);
		System.out.println("result: " + result);

	}

}
