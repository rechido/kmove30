package basicExamples;

public class SwitchTest1 {
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		// 자바의 main 메서드 실행시 명령행인자 args값을 주어서 실행
		// Integer.parseInt(문자열값) 메서드는 문자열 값을 정수로 변환하는 메서드
		
		switch(num) { // switch문의 ( ) 값은 정수나 char형만 허용
		case 1:
			System.out.println("num: 1");
			break; // switch문을 빠짐
		case 2:
			System.out.println("num: 2");
			break;
		case 3:
			System.out.println("num: 3");
			break;
		default:
			System.out.println("입력받은 num이 없음");
			break;
		}
		
		switch(num) { // switch문의 ( ) 값은 정수나 char형만 허용
		case 1:
			System.out.println("num: 1");
		case 2:
			System.out.println("num: 2");
		case 3:
			System.out.println("num: 3");
			break; //만족하는 case를 전부 실행하고 break에서 빠짐 // waterfall 형식
		default:
			System.out.println("입력받은 num이 없음");
			break;
		}
		System.out.println("swtich문 종료");
	}
}
