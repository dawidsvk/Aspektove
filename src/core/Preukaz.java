package core;

import java.util.ArrayList;


public class Preukaz {

	private int cisloPreukazu;
	private Citatel majitel;
	private int typ;
	private long expiracia;
	private int pocetPozicanychKnihSpolu = 0;
	private ArrayList<Kniha> pozicaneKnihy = new ArrayList<Kniha>();
	
	public Preukaz(int cisloPreukazu, Citatel majitel, long expiracia){
		this.cisloPreukazu = cisloPreukazu;
		this.majitel = majitel;
		this.expiracia = expiracia;
		typ = 0;
	}
	
	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
		this.typ = typ;
	}

	public void pozicatKnihu(Kniha kniha){
		kniha = Kniznica.getInstance().pozicatKnihu(kniha);
		pozicaneKnihy.add(kniha);
		kniha.zmenitStav(Stav.POZICANA);
		pocetPozicanychKnihSpolu ++;
		kniha.setCasPozicania(System.currentTimeMillis());
	}
	
	public ArrayList<Kniha> getPozicaneKnihy() {
		return pozicaneKnihy;
	}

	public long getExpiracia() {
		return expiracia;
	}

	public void vratitKnihu(Kniha kniha){
		pozicaneKnihy.remove(kniha);
		kniha.zmenitStav(Stav.VKNIZNICI);
	}
	
}
