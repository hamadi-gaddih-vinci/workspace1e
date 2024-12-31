import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeSDImpl<E> implements ListeSD<E>,Iterable<E> {

	private Noeud tete, queue;
	private HashMap<E, Noeud> mapElementNoeud;

	public ListeSDImpl () {
		//TODO
		this.mapElementNoeud = new HashMap<>();
		this.tete = new Noeud();
		this.queue = new Noeud();
		this.tete.suivant = this.queue;
		this.queue.precedent = this.tete;
	}

	public int taille () {
		return mapElementNoeud.size();
	}

	public boolean estVide () {
		//TODO
		return mapElementNoeud.isEmpty();

	}

	public boolean contient (E element) {
		//TODO
		return mapElementNoeud.get(element) != null;
	}

	public E premier() {
		//TODO
		return tete.suivant.element;

	}

	public E dernier() {
		//TODO
		return queue.precedent.element;

	}

	public E donnerPrecedent (E element) {
		//TODO
		if (!contient(element))
			return null;
		return mapElementNoeud.get(element).precedent.element;

	}

	public E donnerSuivant (E element) {
		//TODO
		if (!contient(element))
			return null;
		return mapElementNoeud.get(element).suivant.element;

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
		Noeud nouveauNoeud = new Noeud(element);
		Noeud noeudAvant = tete;
		Noeud noeudApres = tete.suivant;

		nouveauNoeud.precedent = noeudAvant;
		nouveauNoeud.suivant = noeudApres;

		noeudAvant.suivant = nouveauNoeud;
		noeudApres.precedent = nouveauNoeud;
		mapElementNoeud.put(element, nouveauNoeud);
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
		Noeud nouveauNoeud = new Noeud(element);
		Noeud noeudApres = queue;
		Noeud noeudAvant = queue.precedent;

		nouveauNoeud.precedent = noeudAvant;
		nouveauNoeud.suivant = queue;

		noeudAvant.suivant = nouveauNoeud;
		noeudApres.precedent = nouveauNoeud;
		mapElementNoeud.put(element, nouveauNoeud);
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
		if (contient(elementAInserer) || !contient(element))
			return false;
		Noeud noeudElement = mapElementNoeud.get(element);
		Noeud noeudAInsert = new Noeud(elementAInserer);
		Noeud noeudApres = noeudElement.suivant;

		noeudAInsert.precedent = noeudElement;
		noeudAInsert.suivant = noeudApres;

		noeudApres.precedent = noeudAInsert;
		noeudElement.suivant = noeudAInsert;
		mapElementNoeud.put(elementAInserer, noeudAInsert);
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
		if (contient(elementAInserer) || !contient(element))
			return false;

		Noeud noeudElement = mapElementNoeud.get(element);
		Noeud noeudAvant = noeudElement.precedent;
		Noeud noeudAInsert = new Noeud(elementAInserer);

		noeudAvant.suivant = noeudAInsert;
		noeudAInsert.precedent = noeudAvant;
		noeudAInsert.suivant = noeudElement;
		noeudElement.precedent = noeudAInsert;

		mapElementNoeud.put(elementAInserer, noeudAInsert);
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

		Noeud noeudASupp = mapElementNoeud.get(element);
		Noeud noeudAvant = noeudASupp.precedent;
		Noeud noeudApres = noeudASupp.suivant;

		noeudAvant.suivant = noeudApres;
		noeudApres.precedent = noeudAvant;

		mapElementNoeud.remove(element, noeudASupp);
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
		if (!contient(element1) || !contient(element2))
			return false;
		Noeud noeudE1 = mapElementNoeud.get(element1);
		Noeud noeudE2 = mapElementNoeud.get(element2);
		E e = element1 ;


		noeudE1.element = noeudE2.element;
		noeudE2.element = e;
		mapElementNoeud.put(element1, noeudE2);
		mapElementNoeud.put(element2, noeudE1);
		return true;

		// REMARQUE : CE SONT LES VALEURS QUI SONT PERMUTEES, PAS LES NOEUDS!!!
		// Il est donc inutile de revoir le chainage
		// N'oubliez pas de modifier les noeuds associes dans le map

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
			return noeudCourant != queue;

		}

		// renvoie l element qui se trouve dans le noeud courant
		// le noeud courant passe au noeud suivant
		public E next() {
			//TODO
			if (!hasNext())
				throw new NoSuchElementException();
			E ele = (E) noeudCourant.element;
			noeudCourant = noeudCourant.suivant;
			return ele;
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
