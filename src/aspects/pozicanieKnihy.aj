package aspects;

import core.*;

import java.util.ArrayList;



public aspect pozicanieKnihy {
	
	boolean verifikacia = true;
		
	pointcut kontrolaClenstva(Citatel c, Kniha k): call(* Citatel.pozicajKnihu(Kniha)) && target(c) && args(k);
	
	void around(Citatel c, Kniha k): kontrolaClenstva(c,k){
		
		KontrolaPozicania kontrola = new KontrolaPozicania();
		
		if(kontrola.jePreukaz(c)){
			proceed(c,k);
		}
		
	
	}
	
	
	//pointcut kontrolaExpiracie (Preukaz pr) : call (* Citatel.pozicajKnihu(..)) && target(pr) && if ((pr.getExpiracia() - System.currentTimeMillis()) < 0);
/*	pointcut kontrolaExpiracie (Citatel c) : call (* Citatel.pozicajKnihu(..)) && target(c) && if ((c.getPreukaz().getExpiracia() - System.currentTimeMillis()) > 0);
	
	
	void around(Citatel c): kontrolaExpiracie(c){
		System.out.println("platny preukaz");
		proceed(c);
	}
	*/	
	
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

	
	
}
