import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeSDImpl<E> implements ListeSD<E>,Iterable<E> {

	private Noeud tete, queue;
	private HashMap<E, Noeud> mapElementNoeud;

	public ListeSDImpl () {
		//TODO
		tete = new Noeud();
		queue = new Noeud();
		tete.suivant = queue;
		queue.precedent = tete;
		mapElementNoeud = new HashMap<E, Noeud>();
	}

	public int taille () {
		return mapElementNoeud.size();
	}

	/**
	 * verifie si la liste est vide
	 * @return true si la liste est vide, false sinon
	 */
	public boolean estVide () {
		//TODO
		return tete.suivant == queue && queue.precedent == tete;
	}

	/**
	 * verifie la presence de l element passe en parametre dans la liste
	 * @param element l element recherche
	 * @return true si l element est present, false sinon
	 */
	public boolean contient (E element) {
		//TODO
		return mapElementNoeud.containsKey(element);
	}

	/**
	 * renvoie l element de tete sans l enlever
	 * @return l element de tete ou null s'il n'y a plus d'element
	 */
	public E premier() {
		//TODO
		if (tete.suivant == queue)
			return null;
		return tete.suivant.element;
	}

	/**
	 * renvoie l element de queue sans l enlever
	 * @return l element de queue ou null s'il n'y a plus d'element
	 */
	public E dernier() {
		//TODO
		if (queue.precedent == tete)
			return null;
		return queue.precedent.element;
	}

	/**
	 * donne l element qui se trouve avant l element passe en parametre
	 * @param element
	 * @return l'element ou null si l element passe en parametre n est pas present ou est le premier
	 */
	public E donnerPrecedent (E element) {
		//TODO
		if (!contient(element))
			return null;
		if (mapElementNoeud.get(element).equals(tete))
			return null;
		Noeud noeud = mapElementNoeud.get(element).precedent;
		return noeud.element;
	}

	/**
	 * donne l element qui se trouve apres l element passe en parametre
	 * @param element
	 * @return l'element ou null si l element passe en parametre n est pas present ou est le dernier
	 */
	public E donnerSuivant (E element) {
		//TODO
		if (!contient(element))
			return null;
		if (mapElementNoeud.get(element).equals(tete))
			return null;
		Noeud noeud = mapElementNoeud.get(element).suivant;
		return noeud.element;
	}

	/**
	 * insere un nouvel element en tete de liste si celui-ci n'etait pas deja present
	 * @param element le nouvel element a inserer en tete
	 * @return true si l'element a ete ajoute, false sinon
	 */
	public boolean insererEnTete (E element){
		//TODO
		if (contient(element))
			return false;
		Noeud nvNoeud = new Noeud(element);
		Noeud noeudAvant = tete;
		Noeud noeudApres = tete.suivant;
		noeudAvant.suivant = nvNoeud;
		noeudApres.precedent = nvNoeud;
		nvNoeud.precedent = noeudAvant;
		nvNoeud.suivant = noeudApres;
		mapElementNoeud.put(element, nvNoeud);
		return true;

	}

	/**
	 * insere un nouvel element en queue de liste si celui-ci n'etait pas deja present
	 * @param element le nouvel element a inserer en queue
	 * @return true si l'element a ete ajoute, false sinon
	 */
	public boolean insererEnQueue (E element) {
		//TODO
		if (contient(element))
			return false;
		Noeud nvNoeud = new Noeud(element);
		Noeud noeudApres = queue;
		Noeud noeudAvant = queue.precedent;

		noeudApres.precedent = nvNoeud;
		noeudAvant.suivant = nvNoeud;
		nvNoeud.suivant = noeudApres;
		nvNoeud.precedent = noeudAvant;
		mapElementNoeud.put(element, nvNoeud);
		return true;
	}

	/**
	 * insere le 2eme element passe en parametre apres le 1er element passe en parametre
	 * l'insertion reussit si l'element a inserer n'est pas deja present
	 * et si l'element apres lequel le nouvel element doit etre insere est present
	 * @param element l element apres lequel un nouvel element doit etre insere
	 * @param elementAInserer le nouvel element a inserer
	 * @return true si l'insertion a reussi, false sinon
	 */
	public boolean insererApres (E element, E elementAInserer) {
		//TODO
		if (contient(elementAInserer))
			return false;
		if (!contient(element))
			return false;
		Noeud noeud = mapElementNoeud.get(element);
		Noeud nvNoeud = new Noeud(elementAInserer);

		nvNoeud.suivant = noeud.suivant;
		noeud.suivant.precedent = nvNoeud;
		nvNoeud.precedent = noeud;
		noeud.suivant = nvNoeud;
		mapElementNoeud.put(elementAInserer, nvNoeud);
		return true;
	}

	/**
	 * insere le 2eme element passe en parametre avant le 1er element passe en parametre
	 * l'insertion reussit si l'element a inserer n'est pas deja present
	 * et si l'element avant lequel le nouvel element doit etre insere est present
	 * @param element l element avant lequel un nouvel element doit etre insere
	 * @param elementAInserer le nouvel element a inserer
	 * @return true si l'insertion a reussi, false sinon
	 */
	public boolean insererAvant (E element, E elementAInserer) {
		//TODO
		if (contient(elementAInserer))
			return false;
		if (!contient(element))
			return false;
		Noeud noeud = mapElementNoeud.get(element);
		Noeud nvNoeud = new Noeud(elementAInserer);

		nvNoeud.precedent = noeud.precedent;
		noeud.precedent.suivant = nvNoeud;
		nvNoeud.suivant = noeud;
		noeud.precedent = nvNoeud;
		mapElementNoeud.put(elementAInserer, nvNoeud);
		return true;
	}

	/**
	 * supprime de la liste l element passe en parametre
	 * @param element l element a supprimer
	 * @return true si l element etait bien present, false sinon
	 */

	public boolean supprimer (E element) {
		//TODO
		if (!contient(element))
			return false;
		Noeud noeud = mapElementNoeud.get(element);
		Noeud noeudAv = noeud.precedent;
		Noeud noeudAp = noeud.suivant;

		noeudAv.suivant = noeudAp;
		noeudAp.precedent = noeudAv;
		mapElementNoeud.remove(element);
		return true;

	}



	/**
	 * permute les 2 elements passes en parametre
	 * @param element1
	 * @param element2
	 * @return true si les 2 elements sont bien presents, false sinon
	 */
	public boolean permuter (E element1, E element2) {

		//TODO

		// REMARQUE : CE SONT LES VALEURS QUI SONT PERMUTEES, PAS LES NOEUDS!!!
		// Il est donc inutile de revoir le chainage
		// N'oubliez pas de modifier les noeuds associes dans le map
		if (!contient(element1) || !contient(element2))
			return false;
		Noeud noeud1 = mapElementNoeud.get(element1);
		Noeud noeud2 = mapElementNoeud.get(element2);
		E el1 = noeud1.element;
		noeud1.element = noeud2.element;
		noeud2.element = el1;
		mapElementNoeud.put(el1, noeud2);
		mapElementNoeud.put(element2, noeud1);
		return true;
	}

	public Iterator<E> iterator() {
		//TODO
		return new IterateurImpl<E>();
		// il faut renvoyer un objet de type Iterator :
		//return new IterateurImpl<E>();
		// completez la classe interne IterateurImpl !
	}

	public String toString () {
		String aRenvoyer = "";
		int num = 1;
		Noeud baladeur = tete.suivant;
		while (baladeur != queue) {
			aRenvoyer += num + " - " + baladeur.element + "\n";
			baladeur = baladeur.suivant;
			num++;
		}
		return aRenvoyer;   
	}



	// Classe interne Noeud
	private class Noeud{
		private E element;
		private Noeud suivant;
		private Noeud precedent;

		private Noeud() {
			this(null, null, null);
		}

		private Noeud(E element) {
			this(null, element, null);
		}

		private Noeud(Noeud precedent, E element, Noeud suivant) {
			this.element = element;
			this.suivant = suivant;
			this.precedent = precedent;
		}
	}

	

	// Classe interne IterateurImpl
	private class IterateurImpl<E> implements Iterator<E>{

		private Noeud noeudCourant;

		private IterateurImpl() {
			//TODO
			noeudCourant = tete.suivant;
		}

		public boolean hasNext() {
			//TODO
			return noeudCourant.suivant != null;

		}

		// renvoie l element qui se trouve dans le noeud courant
		// le noeud courant passe au noeud suivant
		public E next() {
			//TODO
			E element = (E) noeudCourant.element;
			if (hasNext()){
				noeudCourant = noeudCourant.suivant;
			}
			return (E) element;

		}

		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}
	}

	// pour les tests
	public ListeSDImpl(E[] tableACopier) {
		mapElementNoeud = new HashMap<E, Noeud>();
		tete = new Noeud();   // sentinelle de tete
		queue = new Noeud();  // sentinelle de queue
		Noeud prec = tete;
		for (int i = 0; i < tableACopier.length; i++) {
			Noeud nouveauNoeud = new Noeud(tableACopier[i]);
			mapElementNoeud.put(tableACopier[i], nouveauNoeud);
			nouveauNoeud.precedent = prec;
			prec.suivant = nouveauNoeud;
			prec = nouveauNoeud;
		}
		prec.suivant = queue;
		queue.precedent = prec;
	}

	// pour les tests
	public String teteQueue(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = tete.suivant;
			int cpt=0;
			while (baladeur != queue) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
				baladeur = baladeur.suivant;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

	// pour les tests
	public String queueTete(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = queue.precedent;
			int cpt=0;
			while (baladeur != tete) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
				baladeur = baladeur.precedent;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

}
