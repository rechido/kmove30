/**
 * 2018. 5. 2. Dev. by D. A. Lee
 */

public class ObjectExample1 {

	public static void main(String[] args) {
		StringBuffer obj;
		obj = new StringBuffer("Hey, Java"); // 문자열 조작이 가능한 스트링클래스
		obj.deleteCharAt(1); // 배열 위치 1 문자 삭제 (2번째문자)
		obj.deleteCharAt(1);
		obj.insert(1, 'i'); // [1]칸에 문자 삽입 
		System.out.println(obj);
		int length = obj.length();
		System.out.println("문자열 \"" + obj + "\"의 길이는: " + length);
		
		// replace 메소드를 사용하여 Hi, Java -> Hello, Java로 치환해보세요.
		obj.replace(1, 2, "ello");
		System.out.println(obj);

	}

}
