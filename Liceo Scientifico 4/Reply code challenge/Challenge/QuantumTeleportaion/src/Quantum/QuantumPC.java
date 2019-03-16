package Quantum;

import java.util.ArrayList;

public class QuantumPC{
	private ArrayList<Portal> portals;
	private String fIn,FOut;
	private Qubit qubit;
	private long movements=0;


	public long getMovements() {
		return movements;
	}

	public void setMovements(long movements) {
		this.movements = movements;
	}

	public QuantumPC(ArrayList<Portal> portals, Qubit qubit) {
		super();
		this.portals = portals;
		this.qubit = qubit;
	}

	public Portal findClosestPortal() {
		Portal res = null;

		int[] dists = new int[portals.size()];
		
		for(int i = 0; i < portals.size(); i++) {
			Portal current = portals.get(i);
			dists[i] = Math.abs(current.xIn - qubit.getX()) + Math.abs(current.yIn - qubit.getY());
		}
		
		int minDist = Integer.MAX_VALUE;
		
		for(int i: dists) {
			if(i < minDist) {
				minDist = i;
			}
		}
		
		ArrayList<Portal> possiblePort = new ArrayList<Portal>();
		
		for(int i = 0; i < dists.length; i++) {
			if(dists[i] == minDist) {
				possiblePort.add(portals.get(i));
			}
		}
		
		res = possiblePort.get(0);
		for(Portal p: possiblePort) {
			if(res.xIn>p.xIn) {
				res=p;
			}
		}
		
		for(Portal p: possiblePort) {
			if(res.yIn>p.yIn) {
				res=p;
			}
		}
		
		return res;
		
	}

	public void runPC() {
		do {
			Portal p = findClosestPortal();

			int dX = Math.abs(p.xIn-qubit.getX());
			int dY = Math.abs(p.yIn-qubit.getY());
			qubit.setX(p.xIn);
			qubit.setY(p.yIn);
			
			movements+=dX;
			movements+=dY;
			qubit = p.transport(qubit);
			portals.remove(p);
		}
		while(portals.size()!=0);

	}

}
