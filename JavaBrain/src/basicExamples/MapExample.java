package basicExamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
		//ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		list.add(new HashMap<>());
		list.add(new HashMap<>());
		list.get(0).put("이름", "A씨");
		list.get(0).put("신장", "178cm");
		list.get(0).put("체중", "66kg");
		list.get(1).put("이름", "B씨");
		list.get(1).put("신장", "168cm");
		list.get(1).put("체중", "70kg");

		// System.out.println(list.get(1).get("체중"));
		
		boolean nameExist = false;
		for (int cnt = 0; cnt < list.size(); cnt++) {
			if (args[0].equals(list.get(cnt).get("이름")))
				nameExist = true;
		}
		if (nameExist)
			System.out.println("입력한 이름은 존재합니다.");
		else
			System.out.println("신장을 입력해주세요.");
	}

}
