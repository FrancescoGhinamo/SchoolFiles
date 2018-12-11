package es4;

import java.util.Vector;

public class Coda {
	
	private Vector<Integer> elementi = new Vector<Integer>();
	
	private void shift() {
		for(int i = 0; i < elementi.size() - 1; i++) {
			elementi.set(i, elementi.elementAt(i + 1));
		}
	}
	
	public int push(int elem) {
		int ret = 0;
		if(elementi.size() >= 5) {
			ret = pop();
		}
		elementi.add(elem);
		return ret;
	}
	
	public int pop() {
		int ret = 0;
		ret = elementi.elementAt(0);
		shift();
		elementi.remove(elementi.size() - 1);
		return ret;
	}

	public static void main(String[] args) {
		Coda c = new Coda();
		c.push(10);
		c.push(23);
		c.push(54);
		c.push(6);
		c.push(90);
		System.out.println(" Push: "+c.push(56));
		System.out.println(" Pop: "+c.pop());

	}

}
