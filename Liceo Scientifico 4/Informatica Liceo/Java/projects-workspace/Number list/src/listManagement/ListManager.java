package listManagement;

import lists.NumberList;
import stdIN.Keyboard;

public class ListManager {
	
	private NumberList list;
	private Keyboard k;
	
	public ListManager() {
		list = new NumberList();
		k = new Keyboard();
	}
	
	public void addNumber() {
		System.out.print(" Inset the number to add: ");
		list.addNumber(k.readInt());
	}
	
	public void printList() {
		System.out.println(" Content of the list:");
		System.out.println(list.toString());
	}

	public static void main(String[] args) {
		ListManager m = new ListManager();
		
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
