package aspects;

import core.*;
import java.util.ArrayList;

System.out.println("bude prdel");

public aspect pozicanieKnihy {
//	pointcut ciMaPreukaz (Preukaz pr): call(* Citatel.getPreukaz(..)) && target(pr);
//	
//	before(Preukaz pr): ciMaPreukaz(pr){
//		System.out.println("preukaz");
//	}
	
//	after() returning (Preukaz retr): call (* Citatel.getPreukaz(..)){
//		if (retr == null){
//			System.out.println("je null");
//			
//		} else {
//			System.out.println("neni null");	
//			
//		}
//	}
	
//	pointcut aaa(): call(* Citatel.getPreukaz(..));
//	
//	Preukaz around(): aaa(){
//
//		return null;
//	}
	
	pointcut kontrolaClenstva(Citatel c, Kniha k): call(* Citatel.pozicajKnihu(Kniha)) && target(c) && args(k);
	
	void around(Citatel c, Kniha k): kontrolaClenstva(c,k){
		try {
			int pocetPozKnih = c.getPreukaz().getPozicaneKnihy().size();
			long expiraciaPreukazu = c.getPreukaz().getExpiracia() - System.currentTimeMillis();
			ArrayList<Kniha> vKniznici = Kniznica.getInstance().getZoznamKnih();
			boolean verifikacia = true;
			System.out.println("Uzivatel ma preukaz");
			
			
			System.out.println("***Kontrola platnosti preukazu***");
			if (expiraciaPreukazu > 0) {
				System.out.println("Preukaz je platny");
			} else {
				System.out.println("Preukaz je neplatny");
				verifikacia = false;			
			}
			
			/*System.out.println("***Kontrola poctu knih na preukaze***");
			if (pocetPozKnih < 3) {
				System.out.println("Na preukaze je mozne pozicat este "+ (3-pocetPozKnih) + " knih");
			} else {
				System.out.println("Pocet pozicanych knih je maximalny");
				verifikacia = false;			
			}*/
			
			System.out.println("bububui");
			
			System.out.println("***Kontrola ci sa kniha nachadza v kniznici***");
			int pocetKnih = 0;
			for (Kniha kn : vKniznici){
				if (kn.getAutor().equals(k.getAutor()) && kn.getNazov().equals(k.getNazov()) && kn.getRok() == k.getRok() && kn.getZaner().equals(k.getZaner()) && kn.getStav().equals(Stav.VKNIZNICI)){
					pocetKnih++;	
				} 
			}
			System.out.println("V kniznici sa nachadzaju "+ pocetKnih + " taketo knihy");
			
			
			if (verifikacia && pocetKnih > 0){
				proceed(c,k);
				System.out.println("!!!KNIHA BOLA USPESNE POZICANA!!!\n");
			} else {
				System.out.println("!!!KNIHA NEBOLA POZICANA!!!\n");				
			}
			
			
		} catch(NullPointerException ex){
				System.out.println("Uzivatel nema preukaz");	
		}
	}
	
	
	//pointcut kontrolaExpiracie (Preukaz pr) : call (* Citatel.pozicajKnihu(..)) && target(pr) && if ((pr.getExpiracia() - System.currentTimeMillis()) < 0);
/*	pointcut kontrolaExpiracie (Citatel c) : call (* Citatel.pozicajKnihu(..)) && target(c) && if ((c.getPreukaz().getExpiracia() - System.currentTimeMillis()) > 0);
	
	
	void around(Citatel c): kontrolaExpiracie(c){
		System.out.println("platny preukaz");
		proceed(c);
	}
	*/	
	

	
}
