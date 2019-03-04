package xray;

public class Centimeter {
	
	private int target;
	
	private int currentValue;

	public Centimeter(int target) {
		super();
		this.target = target;
		this.currentValue = 0;
	}
	
	
	public boolean needsPassing() {
		boolean res = false;
		if(currentValue < target) {
			res = true;
		}
		return res;
	}
	
	public void pass() {
		currentValue++;
	}

	public int getCurrentValue() {
		return currentValue;
	}


	public int getTarget() {
		return target;
	}
	
	
	
	
	

}
