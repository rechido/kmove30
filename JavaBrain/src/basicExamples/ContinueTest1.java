package basicExamples;

public class ContinueTest1 {
	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			if(i==5) continue; // 다음 문장으로 진행하지 않고 반복부로 이동
			System.out.println(i);
		}
		
		// 라벨을 이용한 continue
		System.out.println("label을 이용한 continue");
		outerloop:
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 5; col++) {
				if(row == 1 && col == 3) 
					continue outerloop; // 라벨 for 문으로 가서 계속 반복
				System.out.println("(" + row + ", " + col + ")");
			}
		}
	}
}

