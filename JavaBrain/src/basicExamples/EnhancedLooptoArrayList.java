package basicExamples;

import java.util.ArrayList;

public class EnhancedLooptoArrayList {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("사토리");
		list.add("앨리스");
		list.add("파츄리");
		
		for(String str : list)
			System.out.println(str);

	}

}
