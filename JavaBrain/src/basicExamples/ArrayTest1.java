package basicExamples;

public class ArrayTest1 {
	//메인 메서드 선언 
	public static void main(String args[]) {
		 //32비트 정수로 된 배열 변수 arr을 선언
		int arr[]; // int[] arr;
		// int는 배열 변수의 원소들의 데이터형, arr은 배열 변수 이름
		// []는 배열 첨자 
		// 배열첨자[]이 하나이면 1차원 배열이고 각각의 원소에 하나의 값이 들어감
		// 배열 변수 arr을 생성
		arr = new int[10];
		// 배열 변수 arr이 선언되어 있으므로 배열 변수 이름으로 이용
		// new는 배열 변수를 생성하는 키워드
		// 배열 변수 생성은 new 데이터형[크기];로 생성
		// 크기 10은 배열의 원소의 개수로 length라고 부름
		// 배열은 각각의 원소(방) 접근은 배열 이름[색인번호]로 접근
		// 색인번호는 0번부터 시작
		arr[0] = 10;
		// 두번째 방에는 20을 대입
		arr[1] = 20;
		arr[2] = arr[0] + arr[1];
		
		System.out.println("arr[0] = " + arr[0]);
		System.out.println("arr[1] = " + arr[1]);
		System.out.println("arr[2] = " + arr[2]);
		
		
		/*
		 * 2차원 배열은 행과 열 형태로 된 배열(배열 안의 배열)
		 * 배열첨자 []를 두 개 이용 int arr[][];
		 * 배열처자 중 앞의 배열첨자는 행번호, 뒤는 열번호
		 */
		// 32비트 정수형 배열변수 table은 2차원 배열
		int table[][];
		
		table = new int[3][4];
		table[0][0] = 10;
		table[1][1] = 20;
		table[2][3] = table[0][0] + table[1][1];
		
		System.out.println("table[0][0] = " + table[0][0]);
		System.out.println("table[1][1] = " + table[1][1]);
		System.out.println("table[2][3] = " + table[2][3]);
		
		// 배열 선언시 초기화 하는 가장 간단한 방법은 { } 안에 배열 원소를 나열하는 것
		int arr1[] = {1,2,3,4,5,6};
		// arr1 배열은 원소가 6개인 배열
		int table1[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		// table1은 3행 4열의 배열 table1 = new int[3][4];
		
		// length 속성은 배열의 원소수
		System.out.println("arr1배열크기 = " + arr1.length);
		// 2차원 배열은 행의 개수를 표시
		System.out.println("table1배열크기 = " + table1.length);
		
	 }

}
