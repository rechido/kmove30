package basicExamples;

public class CommaInNumber {

	public static void main(String[] args) {
		int i = 1000000;
		String str = String.format("%,d", i);
		System.out.println(str);

	}

}
