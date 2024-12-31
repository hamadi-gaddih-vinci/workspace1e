
public class A {

	// arbre vide
	public static ArbreDEntiers   arbre1(){
		return new ArbreDEntiers();
	}
	
	// tous positifs, tous impairs, pas d'ex-aequos
	public static ArbreDEntiers arbre2(){
		ArbreDEntiers ag = new ArbreDEntiers(11);
		ArbreDEntiers ad = new ArbreDEntiers(7);
		ad = new ArbreDEntiers(ag,15,ad);
		ag = new ArbreDEntiers(3);	
		ArbreDEntiers a = new ArbreDEntiers(ag,17,ad);
		ad = new ArbreDEntiers(13);
		ag = new ArbreDEntiers(arbre1(),9,ad);
		ad = new ArbreDEntiers(ag,5,arbre1());
		a = new ArbreDEntiers(a,1,ad);
		return a;
	}
	
	// tous positifs, tous impairs, avec ex-aequos
	public static ArbreDEntiers arbre3(){
		ArbreDEntiers ag = new ArbreDEntiers(11);
		ArbreDEntiers ad = new ArbreDEntiers(7);
		ad = new ArbreDEntiers(ag,15,ad);
		ag = new ArbreDEntiers(3);	
		ArbreDEntiers a = new ArbreDEntiers(ag,17,ad);
		ad = new ArbreDEntiers(11);
		ag = new ArbreDEntiers(arbre1(),9,ad);
		ad = new ArbreDEntiers(ag,3,arbre1());
		a = new ArbreDEntiers(a,13,ad);
		return a;
	}


	// tous positifs, impairs et pairs, pas d'ex-aequos
	public static ArbreDEntiers arbre4(){
		ArbreDEntiers ag = new ArbreDEntiers(11);
		ArbreDEntiers ad = new ArbreDEntiers(7);
		ad = new ArbreDEntiers(ag,15,ad);
		ag = new ArbreDEntiers(3);	
		ArbreDEntiers a = new ArbreDEntiers(ag,17,ad);
		ad = new ArbreDEntiers(13);
		ag = new ArbreDEntiers(arbre1(),8,ad);
		ad = new ArbreDEntiers(ag,5,arbre1());
		a = new ArbreDEntiers(a,2,ad);
		return a;
	}


	// tous positifs, tous pairs, pas d'ex-aequos	
	public static ArbreDEntiers arbre5(){
		ArbreDEntiers ag = new ArbreDEntiers(12);
		ArbreDEntiers ad = new ArbreDEntiers(8);
		ad = new ArbreDEntiers(ag,16,ad);
		ag = new ArbreDEntiers(4);	
		ArbreDEntiers a = new ArbreDEntiers(ag,18,ad);
		ad = new ArbreDEntiers(14);
		ag = new ArbreDEntiers(arbre1(),10,ad);
		ad = new ArbreDEntiers(ag,6,arbre1());
		a = new ArbreDEntiers(a,2,ad);
		return a;
	}

		



	// tous negatifs
	public static ArbreDEntiers arbre6(){
		ArbreDEntiers ag = new ArbreDEntiers(-11);
		ArbreDEntiers ad = new ArbreDEntiers(-7);
		ad = new ArbreDEntiers(ag,-15,ad);
		ag = new ArbreDEntiers(-3);	
		ArbreDEntiers a = new ArbreDEntiers(ag,-17,ad);
		ad = new ArbreDEntiers(-13);
		ag = new ArbreDEntiers(arbre1(),-8,ad);
		ad = new ArbreDEntiers(ag,-5,arbre1());
		a = new ArbreDEntiers(a,-2,ad);
		return a;
	}


	// negatifs	et positifs sont melanges	
	public static ArbreDEntiers arbre7(){
		ArbreDEntiers ag = new ArbreDEntiers(11);
		ArbreDEntiers ad = new ArbreDEntiers(7);
		ad = new ArbreDEntiers(ag,15,ad);
		ag = new ArbreDEntiers(3);	
		ArbreDEntiers a = new ArbreDEntiers(ag,17,ad);
		ad = new ArbreDEntiers(13);
		ag = new ArbreDEntiers(arbre1(),-8,ad);
		ad = new ArbreDEntiers(ag,5,arbre1());
		a = new ArbreDEntiers(a,-2,ad);
		return a;
	}

	// positifs et 1 negatif	
	public static ArbreDEntiers arbre8(){
		ArbreDEntiers ag = new ArbreDEntiers(11);
		ArbreDEntiers ad = new ArbreDEntiers(7);
		ad = new ArbreDEntiers(ag,15,ad);
		ag = new ArbreDEntiers(3);	
		ArbreDEntiers a = new ArbreDEntiers(ag,17,ad);
		ad = new ArbreDEntiers(13);
		ag = new ArbreDEntiers(arbre1(),-8,ad);
		ad = new ArbreDEntiers(ag,5,arbre1());
		a = new ArbreDEntiers(a,2,ad);
		return a;
	}
	
	// tous impairs et 1 pair, pas d'ex-aequos
	public static ArbreDEntiers arbre9(){
		ArbreDEntiers ag = new ArbreDEntiers(11);
		ArbreDEntiers ad = new ArbreDEntiers(7);
		ad = new ArbreDEntiers(ag,15,ad);
		ag = new ArbreDEntiers(3);	
		ArbreDEntiers a = new ArbreDEntiers(ag,17,ad);
		ad = new ArbreDEntiers(8);
		ag = new ArbreDEntiers(arbre1(),9,ad);
		ad = new ArbreDEntiers(ag,5,arbre1());
		a = new ArbreDEntiers(a,1,ad);
		return a;
	}
	
	// idem 9 avec 1 entier de moins
	public static ArbreDEntiers arbre10(){
		ArbreDEntiers ag = new ArbreDEntiers(11);
		ArbreDEntiers ad = new ArbreDEntiers(7);
		ad = new ArbreDEntiers(ag,15,ad);
		ag = new ArbreDEntiers(3);	
		ArbreDEntiers a = new ArbreDEntiers(ag,17,ad);
		ad = new ArbreDEntiers();
		ag = new ArbreDEntiers(arbre1(),9,ad);
		ad = new ArbreDEntiers(ag,5,arbre1());
		a = new ArbreDEntiers(a,1,ad);
		return a;
	}
	
	// idem 10 avec 1 entier different
	public static ArbreDEntiers arbre11(){
		ArbreDEntiers ag = new ArbreDEntiers(11);
		ArbreDEntiers ad = new ArbreDEntiers(7);
		ad = new ArbreDEntiers(ag,15,ad);
		ag = new ArbreDEntiers(3);	
		ArbreDEntiers a = new ArbreDEntiers(ag,17,ad);
		ad = new ArbreDEntiers();
		ag = new ArbreDEntiers(arbre1(),6,ad);
		ad = new ArbreDEntiers(ag,5,arbre1());
		a = new ArbreDEntiers(a,1,ad);
		return a;
	}


}
