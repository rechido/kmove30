package basicExamples;

public class AssignEx1 {
	public static void main(String[] args) {
		// 32비트 정수형 변수 num을 선언하고 초기값을 17로 함
		int num = 17;
		// num 변수에 1을 더하기
		num = num + 1;
		num += 1; // num = num + 1; 보다 복합대입연산자가 계산이 빠르다.
		// num에서 2를 빼기
		num = num - 2;
		num -= 2;
		// num에 3을 곱하기
		num = num * 3;
		num *= 3;
		// num을 4로 나누기
		num = num / 4;
		num /= 4;
		// num을 5로 나눈 나머지
		num = num % 5;
		num %= 5;
		
		//증감연산자
		num = 0;
		num++;
		System.out.println(num);
		++num;
		System.out.println(num);
		num--;
		System.out.println(num);
		--num;
		System.out.println(num);
		
		
	}
}
