package bicicletta;

public class Bicicletta {
	
	private Ruota rAnt;
	private Ruota rPost;
	private Freno fAnt;
	private Freno fPost;
	private Telaio telaio;
	private Manubrio manubrio;
	private Trasmissione trasmissione;
	private Sellino sellino;
	private Cavalletto cavalletto;
	public Bicicletta(Ruota rAnt, Ruota rPost, Freno fAnt, Freno fPost, Telaio telaio, Manubrio manubrio,
			Trasmissione trasmissione, Sellino sellino, Cavalletto cavalletto) {
		super();
		this.rAnt = rAnt;
		this.rPost = rPost;
		this.fAnt = fAnt;
		this.fPost = fPost;
		this.telaio = telaio;
		this.manubrio = manubrio;
		this.trasmissione = trasmissione;
		this.sellino = sellino;
		this.cavalletto = cavalletto;
	}
	
	public void avanza() {
		trasmissione.avanza();
	}
	public void sterza() {
		manubrio.sterza();
	}
	public void aumentaCambio() {
		trasmissione.getCambio().aumenta();
	}
	public void diminuisciCambio() {
		trasmissione.getCambio().diminuisci();
	}
	public void abbassaCavalletto() {
		cavalletto.abbassa();
	}
	public void alzaCavalletto() {
		cavalletto.alza();
	}
	public void abbassaSellino() {
		sellino.abbassa();
	}
	public void alzaSellino() {
		sellino.alza();
	}
	public void frenaDavanti() {
		fAnt.frena();
	}
	public void frenaDietro() {
		fPost.frena();
	}
	public Ruota getrAnt() {
		return rAnt;
	}
	public Ruota getrPost() {
		return rPost;
	}
	public Freno getfAnt() {
		return fAnt;
	}
	public Freno getfPost() {
		return fPost;
	}
	public Telaio getTelaio() {
		return telaio;
	}
	public Manubrio getManubrio() {
		return manubrio;
	}
	public Trasmissione getTrasmissione() {
		return trasmissione;
	}
	public Sellino getSellino() {
		return sellino;
	}
	public Cavalletto getCavalletto() {
		return cavalletto;
	}
	
	
	
	
}
