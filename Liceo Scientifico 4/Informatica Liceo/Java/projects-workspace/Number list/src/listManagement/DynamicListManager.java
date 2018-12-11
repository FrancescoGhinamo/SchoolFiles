package listManagement;


import comparators.IntegerComparator;
import comparators.Rule;
import lists.DynamicNumberList;
import stdIN.Keyboard;

public class DynamicListManager {

	private DynamicNumberList list;
	private Keyboard k;
	
	public DynamicListManager() {
		list = new DynamicNumberList();
		k = new Keyboard();
	}
	
	public void addNumber() {
		System.out.print(" Inset the number to add: ");
		list.add(k.readInt());
	}
	
	public void printList() {
		System.out.println(" Content of the list:");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	
	public void sortC() {
		list.sort(new IntegerComparator(Rule.INCREASING));
	}
	
	public void sortD() {
		list.sort(new IntegerComparator(Rule.DECREASING));
	}

	public static void main(String[] args) {
		DynamicListManager m = new DynamicListManager();
		
		int op = 0;
		
		do {
			System.out.println("\n Available options: ");
			System.out.println(" 1 - add a number to the list");
			System.out.println(" 2 - print the whole list");
			System.out.println(" 3 - sort increasing");
			System.out.println(" 4 - sort decreasing");
			System.out.println(" 0 - exit the program");
			System.out.print(" Insert your choice: ");
			op = m.getK().readInt();
			switch(op) {
			case 1:
				m.addNumber();
				break;
				
			case 2:
				m.printList();
				break;
				
			case 3:
				m.sortC();
				break;
				
			case 4:
				m.sortD();
				break;
				
			case 0:
				System.out.println(" Closing the program");
				break;
				
			default:
				System.out.println(" Unrecognised option");
			}
		}
		while(op != 0);

	}

	public Keyboard getK() {
		return k;
	}

}
