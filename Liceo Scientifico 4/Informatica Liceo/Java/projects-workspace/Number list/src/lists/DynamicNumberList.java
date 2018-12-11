package lists;

import java.util.ArrayList;

import comparators.IntegerComparator;
import comparators.Rule;

public class DynamicNumberList extends ArrayList<Integer> {

	
	private static final long serialVersionUID = 1720088992286688504L;
	
	public void addNumber(int v) {
		add(v);
	}
	
	public void printList() {
		System.out.println(" Content of the list:");
		for(int i = 0; i < size(); i++) {
			System.out.print(get(i)+" ");
		}
	}
	
	public void sortI() {
		sort(new IntegerComparator(Rule.INCREASING));
	}
	
	public void sortD() {
		sort(new IntegerComparator(Rule.DECREASING));
	}
	
	public String toString() {
		String ris = "";
		for(int i = 0; i < size(); i++) {
			ris += get(i)+" ";
		}
		return ris;
	}

}
