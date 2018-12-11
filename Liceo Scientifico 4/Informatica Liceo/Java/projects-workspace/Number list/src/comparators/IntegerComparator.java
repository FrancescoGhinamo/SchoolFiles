package comparators;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {
	
	private Rule r;
	
	

	public IntegerComparator(Rule r) {
		super();
		this.r = r;
	}



	@Override
	public int compare(Integer arg0, Integer arg1) {
		
		int res = 0;
		
		switch(r) {
		case INCREASING:
			res = arg0.compareTo(arg1);
			break;
		case DECREASING:
			res = -1 * arg0.compareTo(arg1);
			break;
	
		
		}
		
		return res;
	}

}
