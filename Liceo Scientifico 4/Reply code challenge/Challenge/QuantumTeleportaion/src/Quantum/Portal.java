package Quantum;

public class Portal {
	public int xIn,yIn,xOut,yOut;
	
	public Portal(int xIn, int yIn, int xOut, int yOut) {
		super();
		this.xIn = xIn;
		this.yIn = yIn;
		this.xOut = xOut;
		this.yOut = yOut;
	}
	public Qubit transport(Qubit q) {
		q.setX(xOut);
		q.setY(yOut);
		return q;

	}

}
