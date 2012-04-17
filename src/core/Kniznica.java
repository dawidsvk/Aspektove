package core;

import java.util.ArrayList;

public class Kniznica {

	private ArrayList<Kniha> zoznamKnih = new ArrayList<Kniha>();
	private ArrayList<Citatel> zoznamCitatelov = new ArrayList<Citatel>();
	private int pocetPreukazov = 0;
	public static Kniznica instance = null;
	
	public static Kniznica getInstance(){
		if (instance == null){
			instance = new Kniznica();
		}
		return instance;
	}
	
	
	public void pridatKnihu(Kniha kniha){
		zoznamKnih.add(kniha);
	}
	
	public ArrayList<Kniha> getZoznamKnih() {
		return zoznamKnih;
	}


	public void odstranitKnihu(String nazov, String autor, int rok, String zaner){
		for (int i = 0; i< zoznamKnih.size();i++){
			if ((zoznamKnih.get(i).getAutor().equals(autor)) && (zoznamKnih.get(i).getNazov().equals(nazov)) && (zoznamKnih.get(i).getRok() == rok) && (zoznamKnih.get(i).getZaner().equals(zaner))){
				zoznamKnih.remove(i);
			}
		}
	}
/*	
	public Kniha pozicatKnihu(String nazov, String autor, int rok, String zaner){
		for (int i = 0; i< zoznamKnih.size();i++){
			if ((zoznamKnih.get(i).getAutor().equals(autor)) && (zoznamKnih.get(i).getNazov().equals(nazov)) && (zoznamKnih.get(i).getRok() == rok) && (zoznamKnih.get(i).getZaner().equals(zaner))){
				zoznamKnih.get(i).zmenitStav(Stav.POZICANA);
				return zoznamKnih.get(i);
			}
		}
		return null;
	}
*/
	
	public Kniha pozicatKnihu(Kniha kniha){
		for(Kniha k1 : zoznamKnih){
			if(kniha.saRovna(k1)){
				//k1.zmenitStav(Stav.POZICANA);
				k1.setCasPozicania(System.currentTimeMillis());
				return k1;
			}
		}
		return null;
	}
	
	public Preukaz pridatCitatela(Citatel citatel){
		zoznamCitatelov.add(citatel);
		return new Preukaz(++pocetPreukazov, citatel, System.currentTimeMillis() + 5000);
	}

	public void odstranitCitatela(Citatel citatel){
		zoznamCitatelov.remove(citatel);
	}	
	
	public void odoslatUpomienku(){
		for (int i = 0; i< zoznamCitatelov.size();i++){
			Citatel c = zoznamCitatelov.get(i);
			Preukaz p = c.getPreukaz();
			if (p!=null){
				for (int j = 0;j< p.getPozicaneKnihy().size();j++){
					if(p.getPozicaneKnihy().get(j).getCasPozicania() > 10){
						c.pridajUpomienku(new Upomienka(p.getPozicaneKnihy().get(j),false));
					}
				}
			}
		}
	}
}
