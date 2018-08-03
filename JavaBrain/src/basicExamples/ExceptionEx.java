package basicExamples;

public class ExceptionEx {
	public static void main(String args[]) {
		String str = "str";
		try {
			int i = Integer.parseInt(str);
			System.out.println("try");
		}catch (NumberFormatException e) {
			System.out.println("NumberFormatException");
		}
		catch (Exception e) {
			System.out.println("Exception");
		}finally {
			System.out.println("finally");
		}
	}
}
