package basicExamples;

public class SimpleAdder {
	// public은 자바의 접근제한자(modifier)로 어느곳에서나 접근이 가능
	// class는 자바 키워드로 class임을 표시
	// SimpleAdder는 식별자로 클래스 이름
	// 클래스를 정의하기 위해서는 { } 안에 정의
	// class는 세 가지 구성 요소를 가짐 (멤버변수, 멤버메서드, 생성자)
	// 자바의 시작점을 나타내는 main()메서드가 프로젝트 내의 어딘가에 있어야만 그곳에서 시작
	
	public static void main(String[] args) {
		// static은 클래스메서드임을 나타내는 키워드
		// void는 메서드의 실행결과를 반환할 필요가 없음을 나타냄
		// main은 식별자로 메서드 이름
		// String은 자바가 제공하는 라이브러리의 문자처리클래스인 String클래스임
		// 지역변수 num선언
		// 지역변수는 메서드 안에서 선언된 변수로 메서드 안에서만 효력이 있음(메서드가 끝나면 메모리에서 사라짐)
		
		int num; // int는 자바의 기본 데이터 형인 정수형을 나타냄(32bit), short는 16bit, long이 64bit
		
		
		num = 10 + 20; // =은 대입 연산자로 우변의 값을 좌변 num 변수에 저장
		
		System.out.println(num);
		// 조건문 if문은 if(관계연산식) { } 형태임
		// 관계연산이 true일시만 블록 { } 안의 내용을 실행
		
		if(num>10) {
			System.out.println("num은 10보다 큽니다.");
		}
		
		if(num>40) {
			System.out.println("num은 40보다 큽니다.");
		}
		
		num = 1;
		
		/**
		 *  while 문은 while (관계연산식) { } 형태이며
		 *  관계연산식이 false가 될때까지 블록 안을 반복 실행
		 */
		
		while(num < 10) {
			System.out.println("num은 10보다 적음");
			num = num + 1;
		}
		
		//num=15.7; 
		//num은 int 타입인데 15.7은 double형이므로 에러 발생
		
		int sum ;
		// System.out.println(sum);
		// sum 변수를 초기화하지 않아 에러 발생
	}
}
