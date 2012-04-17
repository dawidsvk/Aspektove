package core;

import java.util.ArrayList;


public class Citatel {

	private String name;
	private Preukaz preukaz;
	private ArrayList<Upomienka> zoznamUpomienok = new ArrayList<Upomienka>();
	private int pocetKnih;
	
	public Citatel(String name){
		this.name = name;
		preukaz = null;
	}
	
	public Preukaz getPreukaz() {
		return preukaz;
	}

	public void poziadatOClenstvo(){
		preukaz = Kniznica.getInstance().pridatCitatela(this);
	}
	
	public void zrusitClenstvo(){
		Kniznica.getInstance().odstranitCitatela(this);
		preukaz = null;
	}
	
	public void pridajUpomienku (Upomienka u){
		zoznamUpomienok.add(u);
	}
	
	public void pozicajKnihu(Kniha kniha){
		preukaz.pozicatKnihu(kniha);
	}

}
