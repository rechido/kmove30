package basicExamples;

public class SubstituteString {

	public static void main(String[] args) {
		String str = "abcd";
		StringBuffer str2 = new StringBuffer();
		str2.append("abdc");
		str2.deleteCharAt(str2.length()-1);
		System.out.println(str2);

	}

}
