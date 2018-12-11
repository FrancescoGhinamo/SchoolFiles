package es3;

import java.util.Vector;

public class Pila {
	
	private Vector<Integer> interi = new Vector<Integer>();
	
	
	public void push(int elem) {
		if(interi.size() < 5) {
			interi.add(elem);
		}
		
	}
	
	public int pop() {
		int _val = interi.elementAt(interi.size() - 1);
		interi.remove(interi.size() - 1);
		return _val;
	}

	public static void main(String[] args) {
		Pila p = new Pila();
		p.push(10);
		p.push(18);
		p.push(45);
		p.push(34);
		p.push(21);
		p.push(4);
		System.out.println(" Pop: "+p.pop());

	}

}
