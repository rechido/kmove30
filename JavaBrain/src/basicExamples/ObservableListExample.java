package basicExamples;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObservableListExample {

	public static void main(String[] args) {
		
		ObservableList<Integer> list = FXCollections.observableArrayList(1,2,3,4);
		for(int cnt=0;cnt<4;cnt++)
			System.out.print(list.get(cnt) + " ");
		System.out.println();
		
		list.remove(1);
		for(int cnt=0;cnt<3;cnt++)
			System.out.print(list.get(cnt) + " ");
		System.out.println();
		
		list.add(1, 10);
		
		for(int cnt=0;cnt<4;cnt++)
			System.out.print(list.get(cnt) + " ");

	}

}
