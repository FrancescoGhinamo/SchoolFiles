package numeriCasuali.backend.beam;

import java.util.Observable;

public class NumeroCasualeAutogenerato extends Observable implements Runnable {
	
	private int val;
	
	private boolean stopped;
	
	

	public NumeroCasualeAutogenerato() {
		super();
		this.stopped = false;
	}



	@Override
	public void run() {
		while(!stopped) {
			val = (int) (Math.random() * 1000000) % 1001;
			setChanged();
			notifyObservers(Integer.valueOf(val));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}



	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

	
	
}
