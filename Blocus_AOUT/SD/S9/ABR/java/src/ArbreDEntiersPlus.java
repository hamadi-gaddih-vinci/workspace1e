
public class ArbreDEntiersPlus extends ArbreDEntiers {

	public ArbreDEntiersPlus () {
		super();
	}

	public ArbreDEntiersPlus (ArbreDEntiersPlus sousArbreGauche, int entier, ArbreDEntiersPlus sousArbreDroit) {
		super(sousArbreGauche, entier, sousArbreDroit);
	}

	public ArbreDEntiersPlus (int entier) {
		super(new ArbreDEntiersPlus(),entier,new ArbreDEntiersPlus());
	}
	
	public int hauteur () {
		//TODO
		// Ex obligatoire
		return hauteur(racine);
	}
	private int hauteur(NoeudEntier noeud){
		if (noeud == null)
			return 0;
		int g = 0;
		int d = 0;
		if (noeud.gauche != null){
			g = 1 + hauteur(noeud.gauche);
		}
		if (noeud.droit != null){
			d = 1 + hauteur(noeud.droit);
		}
		return Math.max(g, d);
	}

	public boolean estCompletementRempli () {
		//TODO
		// Ex supplementaire
		//La definition (non recursive!) de cette methode est donnee dans l'enonce
		return false;
	}

	public boolean estComplet () {
		//TODO
		// Ex supplementaire
		//La definition recursive! de cette methode est donnee dans l'enonce
		return false;
	}	

}
