package basicExamples;

public class BreakTest1 {
	public static void main(String[] args) {
		
		System.out.println("for 반복문");
		for(int x = 0; x < 10; x++) {
			System.out.println(x);
			if(x == 5) break;			
		}
		
		// 중첩 for 문
		System.out.println("중첩 반복문 & break문");
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 5; col++) {
				System.out.println("(" + row + ", " + col + ")");
				if(row == 1 && col == 3) break;
			}
		}
		
		
		
		// label을 이용한 break
		System.out.println("중첩 반복문 한꺼번에 빠져나오기");
		outerLoop: // 라벨
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 5; col++) {
				System.out.println("(" + row + ", " + col + ")");
				if(row == 1 && col == 3) break outerLoop;
			}
		}
		
	}
}
