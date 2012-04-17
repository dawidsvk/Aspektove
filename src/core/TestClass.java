package core;

public class TestClass {
	private Kniznica kniznica;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestClass();
	}
	
	public TestClass(){
		kniznica = Kniznica.getInstance();
		Kniha k1 = new Kniha("zmraka sa", "Jan Smrek", 1927, "beletria");
		Kniha k2 = new Kniha("Robinson", "neznamy", 1967, "dobrodruzne");
		kniznica.pridatKnihu(k1);
		kniznica.pridatKnihu(k2);
		kniznica.pridatKnihu(k2);
		kniznica.pridatKnihu(k2);
		Citatel c1 = new Citatel("Laco");
		c1.poziadatOClenstvo();
		
		
		Kniha k3 = new Kniha("je temno", "Jan Smrek", 1945, "beletria");
	
		c1.pozicajKnihu(k3);
		c1.pozicajKnihu(k2);
		c1.pozicajKnihu(k2);
		c1.pozicajKnihu(k1);
		
		
		for (int i = 0; i< Kniznica.getInstance().getZoznamKnih().size();i++){
			System.out.println(Kniznica.getInstance().getZoznamKnih().get(i).getNazov() + " " + Kniznica.getInstance().getZoznamKnih().get(i).getStav());
		}		
		
	}

}
