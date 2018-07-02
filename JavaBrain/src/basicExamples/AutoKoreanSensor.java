/**
 * 2018. 5. 18. Dev. by D. A. Lee
 */
package basicExamples;

public class AutoKoreanSensor {
	
	
	public static void main(String[] args) {
		
		String name1 = "소악마";
		String name2 = "고블린";
		
		System.out.println(iga(name1) + " 출현했습니다.");
		System.out.println(iga(name2) + " 출현했습니다.");
		
		System.out.println(ulrl(name1) + " 물리쳤습니다.");
		System.out.println(ulrl(name2) + " 물리쳤습니다.");
		
		System.out.println(unnn(name1) + " 퇴각을 원합니다.");
		System.out.println(unnn(name2) + " 퇴각을 원하지 않습니다.");

	}
	
	static String iga(String name) {
		char lastName = name.charAt(name.length()-1);
		String seletedValue = (lastName - 0xAC00) % 28 > 0 ? "이" : "가";
		return name + seletedValue;
		
	}
	
	static String ulrl(String name) {
		char lastName = name.charAt(name.length()-1);
		String seletedValue = (lastName - 0xAC00) % 28 > 0 ? "을" : "를";
		return name + seletedValue;
		
	}
	
	static String unnn(String name) {
		char lastName = name.charAt(name.length()-1);
		String seletedValue = (lastName - 0xAC00) % 28 > 0 ? "은" : "는";
		return name + seletedValue;
		
	}

}
