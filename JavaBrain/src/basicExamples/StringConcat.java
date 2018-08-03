package basicExamples;

public class StringConcat {

	public static void main(String[] args) {
		String str1 = "a";
		String str2 = "b";
		String str3 = str1.concat(str2);
		System.out.println(str3);
		
		String str4 = "abcde";
		String str5 = str4.substring(1, 3);
		System.out.println(str5);
		
		// str5.equalsIgnoreCase(str4);
		// str5.lastIndexOf(0);
	}

}
