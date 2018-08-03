package basicExamples;

public class OperatorTest1 {
	public static void main(String[] args) {
		
		int num1 = 1/2-3;
		double num2 = 2.0+1.5*2.0;
		int num3 = 10/3/2;
		int num4 = 2*5/2;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		
		byte a = 2, b = 3, sum;
		// sum = a + b; // byte 형의 값을 연산하면 결과는 int
		sum = (byte)(a+b);  // 더 큰 데이터 형인 int에서 작은 형인 byte로 바꾸기 위해 형변환을 함 
		System.out.println(sum);
		
		short s1 = 100; // 100은 int형이나 short형의 범위에 들어가는 숫자이므로 수용함
		//short s2 = -s1; // -부호 연산자 연산 후에는 int형이 되어 에러가 뜸
		short s2 = (short)(-s1);
		System.out.println(s2);
		
		String str1 = "num = " + 3 + 4;
		System.out.println(str1);
		String str2 = 3 + 4 + " = num";
		System.out.println(str2);
		
		// 변수 데이터 타입이 작은 곳에서 큰 곳으로의 변환은 무방
		byte n1 = 9;
		short n2 = n1;
		int n3 = n2;
		long n4 = n3;
		float n5 = n4;
		double n6 = n5;
		System.out.println(n6);
		
		// 문자를 int로 변환
		char ch = 'A';
		System.out.println(ch);
		int ch1 = ch;
		System.out.println(ch1);
		
		ch = '가';
		ch1 = ch;
		System.out.println(ch);
		System.out.println(ch1);
		
		// 증감연산자 및 증감처리 순서
		int a1 = 2, b1 = 3, result;
		result = ++a1 + -- b1 * a1--;
		// 증감연산자는 앞에 있으면 연산식 시행 전 증감하고 뒤에 있으면 연산 후 증감.
		System.out.println("a1 = " + a1);
		System.out.println("b1 = " + b1);
		System.out.println("result = " + result);
		
		// 동등 연산
		short r1 = 5;
		int r2 = 2 + 3;
		if(r1 == r2) // r1과 r2가 같은지 비교
			System.out.println("r1과 r2는 동일합니다.");
		if((r1 != r2) == false) // r1과 r2가 다른지 비교
			System.out.println("r1과 r2가 다르다고 하면 거짓말");
		
		// 부동소수점 비교
		double d1 = 1.1 + 2.2;
		double d2 = 3.3;
		System.out.println(d1);
		System.out.println(d2);
		if(d1 == d2)
			System.out.println("같음");
		if(d1 != d2)
			System.out.println("다름");
		
		
		
				
	}

}
