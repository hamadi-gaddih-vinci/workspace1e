
public class ABR {
	
	// ABR vide
	public static ABRDEntiers   ABR1(){
		return new ABRDEntiers();
	}
	
	
	// tous positifs, ex-aequo!
	public static ABRDEntiers ABR2(){
		ABRDEntiers ag = new ABRDEntiers(6);
		ABRDEntiers ad = new ABRDEntiers(10);
		ad = new ABRDEntiers(ag,8,ad);
		ag = new ABRDEntiers(4);	
		ABRDEntiers a = new ABRDEntiers(ag,6,ad);
		ad = new ABRDEntiers(12);
		ag = new ABRDEntiers(ABR1(),12,ad);
		ad = new ABRDEntiers(ag,18,ABR1());
		a = new ABRDEntiers(a,12,ad);
		return a;
	}
	
	
	// tous positifs, pas d'ex-aequo
	public static ABRDEntiers ABR3(){
		ABRDEntiers ag = new ABRDEntiers(7);
		ABRDEntiers ad = new ABRDEntiers(10);
		ad = new ABRDEntiers(ag,8,ad);
		ag = new ABRDEntiers(4);	
		ABRDEntiers a = new ABRDEntiers(ag,6,ad);
		ad = new ABRDEntiers(15);
		ag = new ABRDEntiers(ABR1(),13,ad);
		ad = new ABRDEntiers(ag,18,ABR1());
		a = new ABRDEntiers(a,12,ad);
		return a;
	}
	
	// negatifs,positifs, pas d'ex-aequo!
	public static ABRDEntiers ABR4(){
		ABRDEntiers ag = new ABRDEntiers(-5);
		ABRDEntiers ad = new ABRDEntiers(10);
		ad = new ABRDEntiers(ag,-4,ad);
		ag = new ABRDEntiers(-8);	
		ABRDEntiers a = new ABRDEntiers(ag,-6,ad);
		ad = new ABRDEntiers(15);
		ag = new ABRDEntiers(ABR1(),13,ad);
		ad = new ABRDEntiers(ag,18,ABR1());
		a = new ABRDEntiers(a,12,ad);
		return a;
	}
	
	// negatifs et 1 positif
	public static ABRDEntiers ABR5(){
		ABRDEntiers ag = new ABRDEntiers(-18);
		ABRDEntiers ad = new ABRDEntiers(-12);
		ad = new ABRDEntiers(ag,-16,ad);
		ag = new ABRDEntiers(-25);	
		ABRDEntiers a = new ABRDEntiers(ag,-20,ad);
		ad = new ABRDEntiers(-5);
		ag = new ABRDEntiers(ABR1(),-6,ad);
		ad = new ABRDEntiers(ag,4,ABR1());
		a = new ABRDEntiers(a,-10,ad);
		return a;
	}
	
	// tous negatifs 
	public static ABRDEntiers ABR6(){
		ABRDEntiers ag = new ABRDEntiers(-18);
		ABRDEntiers ad = new ABRDEntiers(-12);
		ad = new ABRDEntiers(ag,-16,ad);
		ag = new ABRDEntiers(-25);	
		ABRDEntiers a = new ABRDEntiers(ag,-20,ad);
		ad = new ABRDEntiers(-5);
		ag = new ABRDEntiers(ABR1(),-6,ad);
		ad = new ABRDEntiers(ag,-4,ABR1());
		a = new ABRDEntiers(a,-10,ad);
		return a;
	}
	
	// ABR3 + 25
	public static ABRDEntiers ABR7(){
		ABRDEntiers ag = new ABRDEntiers(7);
		ABRDEntiers ad = new ABRDEntiers(10);
		ad = new ABRDEntiers(ag,8,ad);
		ag = new ABRDEntiers(4);	
		ABRDEntiers a = new ABRDEntiers(ag,6,ad);
		ad = new ABRDEntiers(15);
		ag = new ABRDEntiers(ABR1(),13,ad);
		ABRDEntiers  anv = new ABRDEntiers(25);
		ad = new ABRDEntiers(ag,18,anv);
		a = new ABRDEntiers(a,12,ad);
		return a;
	}


	
}
