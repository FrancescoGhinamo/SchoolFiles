package leJOS;

import lejos.nxt.Motor;

public class Motore {

	private Porta porta;

	public Motore(Porta porta) {
		super();
		this.porta = porta;
	}
	
	
	public void gira(Direzione d) {
		switch(d) {
		case AVANTI:
			switch(porta) {
			case A:
				Motor.A.forward();
				break;
			case B:
				Motor.B.forward();
				break;
			case C:
				Motor.C.forward();
				break;
			default:
				break;
			
			}
			break;
		case INDIETRO:
			switch(porta) {
			case A:
				Motor.A.backward();
				break;
			case B:
				Motor.B.backward();
				break;
			case C:
				Motor.C.backward();
				break;
			default:
				break;
			
			}
			break;
		
		}
	}
	
	
	public void avantiTemporizzato(long ms) {
		switch(porta) {
		case A:
			Motor.A.forward();
			try {
				Thread.sleep(ms);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Motor.A.stop();
		case B:
			Motor.B.forward();
			try {
				Thread.sleep(ms);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Motor.B.stop();
			break;
		case C:
			Motor.C.forward();
			try {
				Thread.sleep(ms);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Motor.C.stop();
			break;
		default:
			break;
		
		}
	}
	
}
