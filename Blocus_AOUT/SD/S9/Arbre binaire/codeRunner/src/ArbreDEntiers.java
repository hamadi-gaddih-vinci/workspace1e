import java.util.HashSet;
import java.util.NoSuchElementException;

public class ArbreDEntiers {
	
	private NoeudEntier racine;

	public int nombrePositifs() {
		//TODO
		//la methode "public" appelle une methode recursive "private" qui a comme parametre un noeud
		//ce parametre va "recevoir" les differents noeuds de l'arbre
		//(chaque noeud va etre "visite")
		//La premiere fois, le parametre est la racine

		return nombrePositifs(racine);
	}

	private int nombrePositifs(NoeudEntier noeud){

		//cas bete
		//si "rien", il n'y a pas de positif
		if(noeud==null)
			return 0;

		//2 appels recursifs

		//appel recursif fils gauche
		//(la methode renvoie un entier, appelons le nbPositifsGauche)
		int nbPositifsGauche = nombrePositifs(noeud.gauche);

		//appel recursif fils droit
		int nbPositifsDroit = nombrePositifs(noeud.droit);

		//si l'entier du noeud visite est positif, il faut comptabiliser cet entier
		//il faut renvoyer le nombre d'entiers positifs qui se trouvent a gauche et a droite + 1
		if(noeud.entier>0)
			return nbPositifsGauche + nbPositifsDroit + 1;

		//sinon il faut renvoyer le nombre d'entiers positifs qui se trouvent a gauche et a droite
		return nbPositifsGauche + nbPositifsDroit;

		//pour que cela compile

	}

	public int nombrePairs() {
		//TODO
		//la methode "public" appelle une methode recursive "private"
		return nombrePairs(racine);
	}

	private int nombrePairs(NoeudEntier noeud) {
		//methode recursive

		//cas bete
		//si "rien", ...
		if(noeud==null)
			return 0;


		//2 appels recursifs
		int nbPairsGauche = nombrePairs(noeud.gauche);
		int nbPairsDroit = nombrePairs(noeud.droit);

		//si l'entier du noeud visite est pair, il faut comptabiliser cet entier
		//il faut renvoyer le nombre d'entiers pairs qui se trouvent a gauche et a droite + 1
		if(noeud.entier%2==0)
			return 1 + nbPairsGauche + nbPairsDroit;

		//sinon il faut renvoyer le nombre d'entiers pairs qui se trouvent a gauche et a droite
		return nbPairsGauche + nbPairsDroit;

		//pour que cela compile
	}

	public int nombreOccurrences(int entierRecherche) {
		//TODO
		//la methode "public" appelle une methode recursive "private"
		return nombreOccurrences(racine,entierRecherche);
	}

	private int nombreOccurrences(NoeudEntier noeud, int entierRecherche) {
		//cas bete
		//si "rien", ...
		if(noeud==null)
			return 0;

		//2 appels recursifs
		int nbOccurrencesGauche = nombreOccurrences(noeud.gauche, entierRecherche);
		int nbOccurrencesDroit = nombreOccurrences(noeud.droit, entierRecherche);


		//si l'entier du noeud visite est l'entier recherche, il faut comptabiliser cet entier
		if(noeud.entier==entierRecherche)
			return 1 + nbOccurrencesGauche + nbOccurrencesDroit;
		return nbOccurrencesGauche + nbOccurrencesDroit;

		//pour que cela compile
	}

	public boolean contient(int entier){
		//TODO
		return contient(racine,entier);
	}

	private boolean contient(NoeudEntier noeud, int entier) {
		//methode booleenne --> 2 cas "betes"

		//cas bete 1
		//si "rien"
		if(noeud==null)
			return false;

		//cas bete 2
		if(noeud.entier == entier)
			return true;

		//la methode renvoie un booleen
		//on essaye d'eviter de faire d'office 2 appels recursifs
		//si le fils gauche contient l'entier, il est inutile de verifier le fils droit

		if(contient(noeud.gauche, entier))
			return true;

		//il faut verifier le fils droit
		return contient(noeud.droit, entier);

		//pour que cela compile
		/*
		remarque : generalement, pour les methodes de type booleen, on ne passe pas par ce test intermediaire :
		return contient(noeud.gauche, entier) || contient(noeud.droit,entier);

		POUR CERTAINES METHODES : ||, POUR D'AUTRES METHODES : &&
		A BIEN REFLECHIR !!!
		 */


	}

	//strictement positif (>0)
	public boolean tousPositifs() {
		//TODO
		//la methode "public" appelle une methode recursive "private"
		return tousPositifs(racine);
	}

	private boolean tousPositifs(NoeudEntier noeud) {

		// une methode booleenne a 2 cas "betes"
		// l'un des cas "betes" renvoie true, l'autre renvoie false
		// si on rencontre un negatif ou un zero, tous les entiers ne sont pas positifs, on connait la reponse

		//cas bete 1
		//si "rien"
		if(noeud==null)
			return true;

		//cas bete 2
		if(noeud.entier <= 0)
			return false;

		//appels recursifs
		return tousPositifs(noeud.gauche) && tousPositifs(noeud.droit);
		// OU ?
		//return tousPositifs(noeud.gauche) || tousPositifs(noeud.droit);

		//pour que cela compile
	}

	public boolean auMoins1Pair() {
		//TODO
		//la methode "public" appelle une methode recursive "private"
		return auMoins1Pair(racine);
	}

	private boolean auMoins1Pair(NoeudEntier noeud) {

		// une methode booleenne a 2 cas "betes"
		// l'un des cas "betes" renvoie true, l'autre renvoie false

		//cas bete 1
		//si "rien" ...
		if(noeud==null)
			return false;

		//cas bete 2
		if(noeud.entier%2 == 0)
			return true;

		//appels recursifs
		// return auMoins1Pair(noeud.gauche) && auMoins1Pair(noeud.droit);
		// OU ?
		return auMoins1Pair(noeud.gauche) || auMoins1Pair(noeud.droit);

		//pour que cela compile

	}

	//strictement plus grands
	public boolean tousPlusGrands(int entierVerifie) {
		//TODO
		//la methode "public" appelle une methode recursive "private"
		return tousPlusGrands(racine,entierVerifie);
	}

	//strictement plus grand (>)
	private boolean tousPlusGrands(NoeudEntier noeud, int entierVerifie) {

		// une methode booleenne a 2 cas "betes"
		// l'un des cas "betes" renvoie true, l'autre renvoie false

		//cas bete 1
		//si "rien"
		if(noeud==null)
			return true;

		//cas bete 2
		if(noeud.entier <= entierVerifie)
			return false;

		//appels recursifs
		return tousPlusGrands(noeud.gauche,entierVerifie) && tousPlusGrands(noeud.droit,entierVerifie);
		// OU ?
		// return tousPlusGrands(noeud.gauche,entierVerifie) && tousPlusGrands(noeud.droit,entierVerifie);

		//pour que cela compile
	}


	public int somme() {
		//TODO
		//la methode "public" appelle une methode recursive "private"
		return somme(racine);
	}

	private int somme(NoeudEntier noeud) {

		//cas bete
		//(si "rien")
		if(noeud==null)
			return 0;

		//appels recursifs
		//(Si c'est plus clair, introduisez des variables sommeGauche et sommeDroit)

		//il faut renvoyer l'entier + la somme des entiers a gauche et la somme des entiers a droite
		return noeud.entier + somme(noeud.gauche) + somme(noeud.droit);

		//pour que cela compile

	}

	public int max() {
		//TODO
		if(racine==null)
			throw new NoSuchElementException();
		//la methode "public" appelle une methode recursive "private"
		return max(racine);
	}

	private int max(NoeudEntier noeud) {

		//cas bete
		//si rien --> on renvoie le plus petit entier
		//cet entier "bidon" ne sera pas selectionne comme max
		if(noeud==null)
			return Integer.MIN_VALUE;

		// 2 appels recursifs
		//(le max peut aussi bien etre a gauche qu'a droite)
		int maxGauche = max(noeud.gauche);
		int maxDroit = max(noeud.droit);

		//on renvoie le plus grand entier
		// parmi l'entier contenu dans le noeud visite, maxGauche et maxDroit

		//test a faire
		if (noeud.entier > maxGauche && noeud.entier > maxDroit)
			return noeud.entier;
		if (maxGauche > maxDroit)
			return maxGauche;
		return maxDroit;

		//pour que cela compile

	}
	
	public boolean contientExAequo(){
		//TODO

		//ensemble des entiers deja rencontres
		//la reference vers cet ensemble est fournie a chaque appel recursif
		HashSet<Integer> ensemble = new HashSet<Integer>();

		//la methode "public" appelle une methode recursive "private"
		return contientExAequo(racine,ensemble);
	}
	
	private boolean contientExAequo(NoeudEntier noeud, HashSet<Integer> ensemble) {

		// une methode booleenne a 2 cas "betes"
		// l'un des cas "betes" renvoie true, l'autre renvoie false

		//cas bete 1
		//si "rien" ...
		if(noeud == null)
			return false;

		//cas bete 2
		//si l'entier du noeud visite appartient a l'ensemble des entiers deja rencontres
		if(ensemble.contains(noeud.entier))
			return true;

		//on ajoute l'entier du noeud courant a l'ensemble des entiers rencontres
		ensemble.add(noeud.entier);

		//appel recursif
		//return contientExAequo(noeud.gauche, ensemble) && contientExAequo(noeud.droit, ensemble);
		//OU ?
		return contientExAequo(noeud.gauche, ensemble) || contientExAequo(noeud.droit, ensemble);

		//pour que cela compile
	}

	
	public ArbreDEntiers () {
		this.racine = null ;
	}

	public ArbreDEntiers (int entier) {
		this.racine = new NoeudEntier(entier) ;
	}
	
	public ArbreDEntiers (ArbreDEntiers filsGauche, int entier, ArbreDEntiers filsDroit) {
		this.racine = new NoeudEntier(filsGauche.racine, entier, filsDroit.racine);
	}
	

	
	// classe interne
	protected class NoeudEntier {
		
		protected int entier; 
		protected NoeudEntier gauche;
		protected NoeudEntier droit;

		public NoeudEntier (int entier){
			this.entier = entier;
			this.gauche = null;
			this.droit = null;
		}
		
		public NoeudEntier (NoeudEntier g, int entier, NoeudEntier d){
			this.entier = entier;
			this.gauche = g;
			this.droit = d;
		}
	}
}
