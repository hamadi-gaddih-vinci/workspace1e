import java.util.ArrayList;

public class EnsembleTrieImpl<E> implements EnsembleTrie<E> {

	private Noeud racine;
	private int taille;

	public EnsembleTrieImpl() {
		racine = null;
		taille = 0;
	}

	public boolean estVide() {
		return racine == null;
	}

	public int taille() {
		return taille;
	}

	/**
	 * renvoie le plus petit element de l ensemble
	 * @return le min ou null si l'ensemble est vide
	 */
	public E min() {
		//TODO
		if (estVide())
			return null;
		return min(racine);
	}
	private E min(Noeud noeud){
		if (noeud.gauche == null)
			return noeud.element;
		return min(noeud.gauche);
	}

	public boolean contient(E element) {
		//TODO
		//Lisez bien les explications pour l'utilisation de la methode compareTo() dans l'enonce
		return contient(racine, element);
	}
	private boolean contient(Noeud noeud, E element){
		if (noeud == null)
			return false;
		if(((Comparable<E>)noeud.element).compareTo(element)>0){
			return contient(noeud.gauche,element);
		}
		else if(((Comparable<E>)noeud.element).compareTo(element)<0) {
			return contient(noeud.droit, element);
		}
		else{
		return true;
		}
	}

	/**
	 * ajoute element si element n appartient pas a l ensemble
	 * @param element l'element a ajouter
	 * @return true si l'element a ete ajoute, false sinon
	 */
	public boolean ajouter(E element) {
		//TODO
		//Lisez bien les explications pour l'utilisation de la methode compareTo() dans l'enonce
		if (racine == null) {
			racine = new Noeud(element);
			taille++;
		}
		return ajouter(racine, element);
	}
	private boolean ajouter(Noeud noeud, E element){
		if (contient(element))
			return false;
		if (((Comparable<E>)noeud.element).compareTo(element)>0){
			if (noeud.gauche == null){
				taille++;
				noeud.gauche = new Noeud(element);
				return true;
			}
			return ajouter(noeud.gauche, element);
		}
		else{
			if (noeud.droit == null){
				taille++;
				noeud.droit = new Noeud(element);
				return true;
			}
			return ajouter(noeud.droit, element);
		}
	}

	/**
	 * renvoie le plus grand element qui est strictement plus petit que l'element passe en parametre
	 * @param element l'element dont on recherche le predecesseur
	 * @return l'element predecesseur ou null si un tel element n'existe pas
	 */
	public E predecesseur(E element) {
		//TODO
		// Suggestion :
		// remplir une "arrayList" via un parcours en in-ordre
		// le predecesseur de l'element est l'element qui se trouve juste avant lui dans l'arrayList !
		// cette methode peut donc appeler la methode "private" remplirListe() qui suit
		ArrayList<E> liste = new ArrayList<>();
		remplirListe(racine, liste);
		int a = liste.indexOf(element)-1;
		if (a<0)
			return null;
		return liste.get(a);
	}

	private void remplirListe(Noeud noeud,ArrayList<E> liste) {
		// suggestion de methode a appeler par la methode predecesseur()
		if (noeud == null)
			return;
		remplirListe(noeud.gauche, liste);
		liste.add(noeud.element);
		remplirListe(noeud.droit, liste);
	}

	// A NE PAS MODIFIER!!!
	// VA SERVIR POUR LES TESTS!!!
	public String toString() {
		return "[ " + toString(racine) + " ]";
	}

	private String toString(Noeud n) {
		if (n == null)
			return "";
		if (n.gauche == null && n.droit == null)
			return "" + n.element;
		if (n.gauche == null)
			return " [ ] " + n.element + " [ " + toString(n.droit) + " ] ";
		if (n.droit == null)
			return " [ " + toString(n.gauche) + " ] " + n.element + " [ ] ";
		return " [ " + toString(n.gauche) + " ] " + n.element + " [ " + toString(n.droit) + " ] ";
	}

	// A NE PAS MODIFIER! VA SERVIR POUR LES TESTS
	// permet de construire l'ensembleTrie de l'enonce

	public EnsembleTrieImpl(E e1, E e2, E e3, E e4, E e5, E e6, E e7) {
		Noeud nG = new Noeud(null, e2, new Noeud(e5));
		Noeud nG1 = new Noeud(new Noeud(e7), e4, new Noeud(e6));
		Noeud nD = new Noeud(nG1, e3, null);
		racine = new Noeud(nG, e1, nD);
		taille = 7;
	}


	public class Noeud {

		private E element;
		private Noeud gauche;
		private Noeud droit;

		private Noeud(E element) {
			this.element = element;
			this.gauche = null;
			this.droit = null;
		}

		private Noeud(Noeud gauche, E element, Noeud droit) {
			this.element = element;
			this.gauche = gauche;
			this.droit = droit;
		}
	}

}
