package listManagement;


import lists.HashtableList;
import stdIN.Keyboard;

public class HashtableManager {
	private HashtableList list;
	private Keyboard k;
	
	public HashtableManager() {
		list = new HashtableList();
		k = new Keyboard();
	}
	
	public void addNumber() {
		System.out.print(" Inset the number to add: ");
		list.put(k.readInt());
	}
	
	public void printList() {
		System.out.println(" Content of the list: "+list.getElements());
		
	}
	
	
	public static void main(String[] args) {
		DynamicListManager m = new DynamicListManager();
		
		int op = 0;
		
		do {
			System.out.println("\n Available options: ");
			System.out.println(" 1 - add a number to the list");
			System.out.println(" 2 - print the whole list");
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
