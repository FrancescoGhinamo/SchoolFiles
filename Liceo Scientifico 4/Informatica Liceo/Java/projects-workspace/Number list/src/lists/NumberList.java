package lists;

public class NumberList {
	
	private static final int MAX_NUM = 100;
	
	private int[] list;
	private int lastIndex;
	
	public NumberList() {
		list = new int[MAX_NUM];
		lastIndex = 0;
	}
	
	public void addNumber(int n) {
		list[lastIndex] = n;
		lastIndex++;
	}
	
	public String toString() {
		String ris = "";
		for(int i = 0; i < lastIndex; i++) {
			ris += list[i] + " ";
		}
		return ris;
		
	}

}
