package basicExamples;

public class ForTest1 {
	public static void main(String[] args) {
		
		for(int cnt=0; cnt<10; cnt++) {
			// cnt는 for문의 반복을 위한 반복 변수
			// 초기화부;조건부;증감부로 구성되고 필요없는 부분은 비워둠
			// 진행순서는 맨처음 초기값을 가지고 조건을 판단하고
			// 2번째부터는 증감부에서 증감을 시키고 조건을 판단함
			System.out.println(cnt);			
		}
		System.out.println(" ");		
		
		int[] arr = { 10, 20, 30, 40, 50 }; // 배열 선언 및 초기값 설정
		// int[] arr = new int[5];
		// arr[0] = 10, ... , arr[4] = 50;  
		
		for(int cnt = 0; cnt < arr.length; cnt++) {
			System.out.println(arr[cnt]);	
		}
		System.out.println(" ");		
		
		for(int cnt: arr)
			System.out.println(cnt);
		
	}

}
