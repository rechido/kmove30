package basicExamples;

public class ExceptionTest1 {
	public static void main(String[] args) {
		int a = 10, b = 0;
		int result;
		try { // 예외 발생 가능 문장을 적어주는 블록
			result = a / b;
			System.out.println(result);
		}
		catch(Exception e) { // 예외 발생 시 처리 부분
			System.out.println("Wrong calculation.");
			e.printStackTrace();
		}
		finally { // 예외 발생 유무에 상관 없이 꼭 처리하는 부분(선택사항)
			System.out.println("Done.");
		}		
		
	}
}
