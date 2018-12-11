package euqazione;

import java.util.ArrayList;

import equazione.eccezioni.InserimentoErratoException;

public class FunzioneLineare {
	
	private double m;
	private double q;
	
	public FunzioneLineare(String eqn) throws InserimentoErratoException {
		try {
			this.m = Double.parseDouble((String) eqn.subSequence(eqn.indexOf('=') + 1, eqn.indexOf('x')));
			this.q = Double.parseDouble((String) eqn.substring(eqn.indexOf('x') + 1));
		}
		catch(NumberFormatException e) {
			throw new InserimentoErratoException();
		}
		
	}
	
	public FunzioneLineare(double m, double q) {
		super();
		this.m = m;
		this.q = q;
	}
	
//	public static FunzioneLineare parseString(String eqn) {
//		double _m = Double.parseDouble((String) eqn.subSequence(eqn.indexOf('='), eqn.indexOf('x')));
//		double _q = Double.parseDouble((String) eqn.substring(eqn.indexOf('x')));
//		return new FunzioneLineare(_m, _q);
//	}
	
	public ArrayList<Punto> trovaPunti(int n) {
		ArrayList<Punto> punti = new ArrayList<Punto>();
		for(int i = 0; i < n; i++) {
			punti.add(new Punto(i, m * i + q));
		}
		return punti;
	}
	
	public double getM() {
		return m;
	}
	public void setM(double m) {
		this.m = m;
	}
	public double getQ() {
		return q;
	}
	public void setQ(double q) {
		this.q = q;
	}
	
	

}
