package core;

public class Kniha {

	private String nazov;
	private String autor;
	private int rok;
	private String zaner;
	private Stav stav;
	private long casPozicania;
	
	public Kniha(String nazov, String autor, int rok, String zaner){
		this.nazov = nazov;
		this.autor = autor;
		this.rok = rok;
		this.zaner = zaner;
		stav = Stav.VKNIZNICI;
	}
	
	public String getNazov() {
		return nazov;
	}

	public String getAutor() {
		return autor;
	}

	public long getCasPozicania() {
		return casPozicania;
	}

	public void setCasPozicania(long casPozicania) {
		this.casPozicania = casPozicania;
	}

	public int getRok() {
		return rok;
	}

	public String getZaner() {
		return zaner;
	}

	public Stav getStav() {
		return stav;
	}

	public void zmenitStav(Stav stav) {
		this.stav = stav;
	}
	
	public boolean saRovna(Kniha k1){
		if(k1.getAutor().equals(this.getAutor()) && k1.getNazov().equals(this.getNazov()) && k1.getZaner().equals(this.getZaner()) && k1.getRok() == this.getRok()){
			return true;
		} else {
			return false;
		}
	}

}
