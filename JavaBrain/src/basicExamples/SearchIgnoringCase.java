package basicExamples;

public class SearchIgnoringCase {

	public static void main(String[] args) {
		String str1 = "AMD CPU";
		String str2 = "amd";
		System.out.println(str2.toLowerCase());
		System.out.println(str1.toLowerCase());
		if(str1.toLowerCase().contains(str2.toLowerCase()))
			System.out.println("str1이 str2를 포함합니다!");
		else
			System.err.println("포함하지 않습니다.");

	}

}
