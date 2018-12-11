package es2;

import java.util.Vector;


public class CC {

	private float saldo;
	private Vector<Movimento> movimenti;
	
	public CC(float saldo) {
		this.saldo = saldo;
		this.movimenti = new Vector<Movimento>();
	}
	
	public void aggiungiMovimento(Movimento m) throws SaldoNegativoException {
		float importo = 0;
		switch(m.getTipo()) {
		case PRELIEVO:
			importo = -m.getImporto();
			break;
		case VERSAMENTO:
			importo = m.getImporto();
			break;	
		}
		
		if(saldo + importo >= 0) {
			saldo += importo;
			movimenti.add(m);
		}
		else {
			throw new SaldoNegativoException();
		}
	}

	public Movimento[] ultimiMovimenti() {
		Movimento[] movs = new Movimento[5];
		int c2 = 0;
		for(int c = movimenti.size() - 1; (c >= movimenti.size() - 5) && (c >= 0); c--) {
			movs[c2] = movimenti.elementAt(c);
			c2++;
		}
		return movs;
	}
	
	
	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public Vector<Movimento> getMovimenti() {
		return movimenti;
	}

	public void setMovimenti(Vector<Movimento> movimenti) {
		this.movimenti = movimenti;
	}
	
	
	

}
