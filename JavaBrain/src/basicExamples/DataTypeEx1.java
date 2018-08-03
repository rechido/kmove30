package basicExamples;

public class DataTypeEx1 {
	public static void main(String[] args) {
		
		/*
		 * byte는 8비트 정수이므로 범위는 -128 ~ +127 
		 */
		byte num0 = 127;
		/*
		 *  short는 16비트 정수이므로 범위는 -32,768 ~ +32,767
		 */
		short num1 = 32767; 
		/*
		 *  int형은 32비트 정수이므로 범위는 -2,147,483,648 ~ +2,147,483,647
		 */
		int num2 = 2147483647;
		/*
		 * long형은 64비트 정수이므로 범위는 -9,223,372,036,854,775,808 ~ +9,223,372,036,854,775,807
		 */
		long num3 = 9223372036854775807l; //l은 long형 표시
		/*
		 *  float는 32비트 소수
		 */
		float num4 = 1.23456789f;
		//float num4 = (float)12.75; // 12.75가 64비트 double이므로 형변환
		System.out.println(num4);		
		/*
		 * double형은 64비트 소수
		 */
		double num5 = 12345678901234567.0;
		System.out.println(num5);	
		/*
		 * boolean형은 참과 거짓을 나타내는 데이터형
		 * 값은 true와 false 두 개만 가짐
		 */
		boolean b1 = false;
		/*
		 * char는 16비트 유니코드 데이터형
		 * char는 정수값 0 ~ 65535까지의 정수값으로 변환 가능
		 */
		char ch = 'a';
		/*
		 * String은 기본형이 아니나 자주 사용하므로 java API에서 제공
		 */
		String str = "My name is Lee";
		
		/*
		 * 변수는 선언된 블록 내에서만 효력
		 */
		{
			int bnum = 10;
			System.out.println(bnum);
		}
		//System.out.println(bnum); 변수가 선언된 블록을 벗어나서 사용하므로 에러
		/*
		 * final 변수는 한 번만 변수값을 초기화 할 수 있음
		 * 변수 선언문 앞에 final을 적어줌		 
		 */
		final double pi = 3.14;
		// pi = 314159; // final 변수값을 재 대입하면 에러 
		
	}
}
