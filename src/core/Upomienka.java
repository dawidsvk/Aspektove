package core;

public class Upomienka {

	private Kniha kniha;
	private boolean uhradena;
	
	public Upomienka(Kniha kniha, boolean uhradena){
		this.kniha = kniha;
		this.uhradena = uhradena;
	}

	public Kniha getKniha() {
		return kniha;
	}
}
