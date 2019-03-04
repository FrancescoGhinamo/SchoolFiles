package xray;

import java.util.ArrayList;

public class Bone {
	
	private ArrayList<Centimeter> components;
	private int passings;

	public Bone(ArrayList<Centimeter> components) {
		super();
		this.components = components;
		this.passings = 0;
	}
	
	public boolean needsPassing() {
		boolean res = false;
		for(Centimeter c: components) {
			if(c.needsPassing()) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	public void pass() {
		passings++;
		boolean begun = false;
		for(Centimeter c: components) {
			if(c.needsPassing() && begun == false) {
				begun = true;
				c.pass();
			} else if(c.needsPassing() && begun == true) {
				c.pass();
			} else if(!c.needsPassing() && begun == true) {
				break;
			}
		}
	}
	
	public void passCompletely() {
		while(needsPassing()) {
			pass();
		}
	}

	public ArrayList<Centimeter> getComponents() {
		return components;
	}

	public int getPassings() {
		return passings;
	}
	
	
	

}
