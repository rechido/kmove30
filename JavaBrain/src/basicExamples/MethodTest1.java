/**
 * class는 멤버변수, 멤버메서드, 생성자로 구성됨
 */

package basicExamples;

public class MethodTest1 {
	
	public static void main(String[] args) {
		/*
		 * 메서드 사용(호출)은 메서드 이름(파라메터와 이리하는 데이터 형의 값)
		 */
		printChar('*',10);
		printChar('뷁',20);
		
		int result = add(99,12);
		System.out.println(result);
	}
	
	// 메서드 정의부
	static void printChar(char c, int num) {
		/*
		 * 접근제한자는 public, private, 생략이 있는데 여기서는 생략.
		 * static은 메서드가 클래스 메서드임을 나타내고 생략하면 인스턴스 메서드임
		 * void는 return data type으로 메서드의 결과를 반환하지 않아도 됨
		 * printChar는 메서드 이름
		 * ( ) 안에는 매개변수(parameter)를 정의하는데 로컬변수 선언 방법과 동일
		 */
		
		for(int i=0; i<num; i++) {
			System.out.print(c);			
		}
		System.out.println(" ");
		
	}
	
	/**
	 * return data type이 int형인 메서드
	 * 메서드 실행 결과값을 int형으로 메서드를 호출한 곳으로 반환
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	static int add(int x, int y) {	 
		int sum;
		sum = x + y;
		return sum;
		/*
		 * return data type이 void가 아닌 경우에는
		 * 해당 return data type의 값을
		 * return 키워드로 반환해야 한다.
		 */
	}

}
