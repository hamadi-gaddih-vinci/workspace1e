import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class ABRDEntiers {

	private NoeudEntier racine;

	public int nombreEntiers(){
		return nombreEntiers(racine);
	}

	private int nombreEntiers(NoeudEntier noeud) {
		if(noeud==null)
			return 0;
		return 1 + nombreEntiers(noeud.gauche)+nombreEntiers(noeud.droit);
	}


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

		//appels recursifs

		//on evite de faire des appels recursifs inutiles
		//l'arbre est un ABR !

		//si l'entier contenu dans le noeud visite est negatif
		//on est sur que sa descendance gauche ne contient que des negatifs
		//il ne faut donc pas faire un appel recursif sur son fils gauche
		// mais uniquement sur son fils droit

		if(noeud.entier<=0){
			return nombrePositifs(noeud.droit);
		}

		//si l'entier est positif, il faut comptabiliser cet entier
		//il faut renvoyer le nombre d'entiers positifs qui se trouvent a gauche et a droite + 1

		return 1 + nombrePositifs(noeud.gauche) + nombrePositifs(noeud.droit);

		/*
		Amelioration :
		si l'entier du noeud visite est positif, tous les entiers à droite sont positifs
		on pourrait se contenter de calculer le nombre d'entiers a droite
		C'est ce que fait la methode nombreEntiers()
		return 1 + nombrePositifs(noeud.gauche) + nombreEntiers(noeud.droit);
		 */

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

		//appels recursifs

		//Dans un ABR, les entiers pairs peuvent etre n'importe ou
		//il faudra visite tout l'arbre

		//si l'entier du noeud visite est pair, il faut comptabiliser cet entier
		//il faut renvoyer le nombre d'entiers pairs qui se trouvent a gauche et a droite + 1
		if(noeud.entier%2==0)
			return 1 + nombrePairs(noeud.gauche) + nombrePairs(noeud.droit);

		//sinon
		//on renvoie le nombre d'entiers pairs qui se trouvent a gauche et a droite
		return nombrePairs(noeud.gauche) + nombrePairs(noeud.droit);

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

		//si l'entier du noeud visite est l'entier recherche, il faut comptabiliser cet entier
		//et continuer a rechercher sa presence a droite
		//(selon notre convention en cas de doublon)
		if(noeud.entier==entierRecherche)
			return 1 + nombreOccurrences(noeud.droit,entierRecherche);

		//si l'entier du noeud visite est > que l'entier recherche
		//il faut continuer a rechercher sa presence uniquement a gauche
		if(noeud.entier>entierRecherche)
			return nombreOccurrences(noeud.gauche,entierRecherche);

		//sinon (l'entier du noeud visite est < que l'entier recherche)
		//il faut continuer a rechercher sa presence uniquement a droite
		return nombreOccurrences(noeud.droit,entierRecherche);
	}

	public boolean contient(int entierRecherche){
		//TODO
		return contient(racine,entierRecherche);
	}

	private boolean contient(NoeudEntier noeud, int entierRecherche) {
		//methode booleenne --> 2 cas "betes"

		//cas bete 1
		//si "rien"
		if(noeud==null)
			return false;

		//cas bete 2
		if(noeud.entier==entierRecherche)
			return true;

		//si l'entier du noeud visite est > que l'entier recherche
		//il faut continuer a rechercher sa presence uniquement a gauche
		if(noeud.entier>entierRecherche)
			return contient(noeud.gauche,entierRecherche);

		//sinon (l'entier du noeud visite est < que l'entier recherche)
		//il faut continuer a rechercher sa presence uniquement a droite
		return contient(noeud.droit,entierRecherche);

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
		//si pas de negatif rencontre, tous les entiers sont positifs
		//(cas particulier : une liste vide ne contient pas de negatif --> la methode renvoie true)

		//cas bete 2
		if(noeud.entier<=0)
			return false;

		//appel recursif

		//l'entier contenu dans le noeud visite est positif
		//comme c'est un ABR, tous les entiers a droite sont positifs
		//il faut donc verifier (uniquement) le fils gauche

		return tousPositifs(noeud.gauche);

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

		//appel recursif

		return auMoins1Pair(noeud.gauche) || auMoins1Pair(noeud.droit);
		//il faut trouver au moins 1 pair, SOIT a gauche, SOIT a droite
		//SOIT SOIT --> OU --> ||
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
		if(noeud.entier<=entierVerifie)
			return false;

		//appel recursif

		//l'entier du noeud visite est > entierVerifie
		//tous les entiers a droite sont donc forcement > entierVerifie
		//il faut encore s'assurer que tous les entiers a gauche le sont aussi
		return tousPlusGrands(noeud.gauche,entierVerifie) ;
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

		//pour calculer la somme, il est necessaire de visiter tout l'arbre !

		//il faut renvoyer l'entier + la somme des entiers a gauche et la somme des entiers a droite
		return noeud.entier + somme(noeud.gauche) + somme(noeud.droit);

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
		//le max se trouve "le plus a droite possible"
		//donc si le noeud visite n'a pas de fils droit, il contient le max !
		if(noeud.droit==null)
			return noeud.entier;

		// appel recursif a droite
		// le max se trouve "le plus a droite possible"
		return max(noeud.droit);

	}

	// l'arrayList renvoyee contiendra les entiers selon l'ordre croissant
	public ArrayList<Integer> toArrayList(){
		//TODO

		//on cree l'arrayList (new)
		//cette arrayList est construite une seule fois
		//sa reference est passee lors de chaque appel recursif
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		//la methode "public" appelle une methode recursive "private"
		//cette methode peut etre de type void
		//car la reference vers l'arrayList est conservee d'un appel a l'autre
		toArrayList(racine,arrayList);

		//on renvoie l'arrayList
		return arrayList;
	}

	private void toArrayList(NoeudEntier noeud, ArrayList<Integer> arrayList) {
		//cas bete
		//si plus rien...
		if(noeud == null)
			return;

		//pour remplir la liste selon l'ordre croissant, il faut parcour l'arbre en in-ordre

		//on place d'abord les entiers du fils gauche
		toArrayList(noeud.gauche, arrayList);

		//a ce stade tous les entiers du fils gauche sont dans la liste
		//il faut ajouter l'entier du noeud visite
		arrayList.add(noeud.entier);

		//on place apres tous les entiers du fils droit
		toArrayList(noeud.droit, arrayList);
	}


	public ABRDEntiers () {
		this.racine = null ;
	}

	public ABRDEntiers (int entier) {
		this.racine = new NoeudEntier(entier) ;
	}

	public ABRDEntiers (ABRDEntiers filsGauche, int entier, ABRDEntiers filsDroit) {
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