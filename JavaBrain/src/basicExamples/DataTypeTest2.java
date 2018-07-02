package basicExamples;

public class DataTypeTest2 {
	public static void main(String[] args) {
		double smallest1 = 4.9e-324;
		double smallest2 = -4.9e-324;
		//e-324는 지수 표기법으로 10의 -324승을 의미
		
		double result1 = smallest1 / 2.0; // 가장 미세한 +값을 2로 나누는 식
		double result2 = smallest2 / 2.0; // 가장 미세한 +값을 2로 나누는 식
		
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		
		result1 = 2.0 / 0.0; // 2.0, 0.0은 자바에서는 기본형 double
		result2 = 2.0 / -0.0;
		
		System.out.println("result1 = \'" + result1 + "\'");
		System.out.println("result2 = " + result2);
		
		System.out.println(120); // 10진수 int형
		System.out.println(024); // 024는 8진수
		System.out.println(0x30A1); // 0x30A1은 16진수
		System.out.println(0x0030a1); // 16진수의 a~f는 대소문자 안가림	
		
		char arr[] = {'뇌', '를', ' ', '\uC790', '\uADF9', '하', 
				'는', '\n', 'J', 'a', '\166', '\141' };
		
		for(char ch: arr)
			System.out.print(ch);
		System.out.print("\n");
		// print메서드는 줄을 안 바꾸고 출력
		/*
		 *  \n은 줄바꾸기 escape sequence
		 *  \uC790은 유니코드 C790이 가리키는 문자
		 *  \166은 10진수 166이 가리키는 문자
		 */
		System.out.println("C790은 " + 0xC790); // 한글 '자'의 유니코드 번호
		
		String str1 = "Hello, Java. \nNice to meet you.";
		String str2 = "나는 \"비틀즈는 1970년에 해체됐어요.\"라고 말했다.";
		// String은 자바에서 제공하는 문자열 처리 클래스임
		// 자바는 클래스를 데이터형으로 사용할 수 있고 이와 같은 변수를
		// 참조형 변수 또는 instance 또는 객체형 변수라 함
		// 문자열의 값은 " "안에 넣어줌
		// 문자열 안에서 따옴표를 쓸 경우에는 \"로 사용
		System.out.println(str1);
		System.out.println(str2);
	}

}
