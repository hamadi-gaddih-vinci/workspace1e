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
		mapElementNoeud = new HashMap<E,Noeud>();

	}

	public int taille () {
		return mapElementNoeud.size();
	}

	public boolean estVide () {
		//TODO
		if (taille()==0){return true;}
		return false;
	
	}

	public boolean contient (E element) {
		//TODO
		if (mapElementNoeud.containsKey(element)){return true;}
		return false;

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
		if (tete.suivant.element == element){return null;}
		Noeud noeud = mapElementNoeud.get(element);
		if (noeud == null){return null;}
		return noeud.precedent.element;

	}

	public E donnerSuivant (E element) {
		//TODO
		if (queue.precedent.element == element){return null;}
		Noeud noeud = mapElementNoeud.get(element);
		if (noeud == null){return null;}
		return noeud.suivant.element;

	}

	public boolean insererEnTete (E element){
		//TODO
		if (mapElementNoeud.containsKey(element)){return false;}
		Noeud noeud = new Noeud(element);
		Noeud avant = tete;
		Noeud apres = tete.suivant;

		noeud.precedent = avant;
		noeud.suivant = apres;
		avant.suivant = noeud;
		apres.precedent = noeud;
		mapElementNoeud.put(element, noeud);
		return true;

	}

	public boolean insererEnQueue (E element) {
		//TODO
		if (mapElementNoeud.containsKey(element)){return false;}
		Noeud noeud = new Noeud(element);
		Noeud avant = queue.precedent;
		Noeud apres = queue;

		noeud.suivant = apres;
		noeud.precedent = avant;
		avant.suivant = noeud;
		apres.precedent = noeud;
		mapElementNoeud.put(element,noeud);
		return true;

	}

	public boolean insererApres (E element, E elementAInserer) {
		//TODO
		if (!mapElementNoeud.containsKey(element) || mapElementNoeud.containsKey(elementAInserer))
			return false;

		Noeud noeudAvant = mapElementNoeud.get(element);
		Noeud noeudApres = noeudAvant.suivant;

		Noeud noeudInserer = new Noeud(elementAInserer);
		noeudInserer.precedent = noeudAvant;
		noeudInserer.suivant = noeudApres;
		noeudAvant.suivant = noeudInserer;
		noeudApres.precedent = noeudInserer;

		mapElementNoeud.put(elementAInserer, noeudInserer);
		return true;

	}

	public boolean insererAvant (E element, E elementAInserer) {
		//TODO
		if (!mapElementNoeud.containsKey(element) || mapElementNoeud.containsKey(elementAInserer))
			return false;

		Noeud noeudApres = mapElementNoeud.get(element);
		Noeud noeudAvant = noeudApres.precedent;

		Noeud noeudInserer = new Noeud(elementAInserer);
		noeudInserer.suivant = noeudApres;
		noeudInserer.precedent = noeudAvant;
		noeudAvant.suivant = noeudInserer;
		noeudApres.precedent = noeudInserer;

		mapElementNoeud.put(elementAInserer,noeudInserer);
		return true;

	}


	public boolean supprimer (E element) {
		//TODO
		if (!mapElementNoeud.containsKey(element))
			return false;

		Noeud noeud = mapElementNoeud.get(element);
		Noeud noeudAvant = noeud.precedent;
		Noeud noeudApres = noeud.suivant;

		noeudAvant.suivant = noeudApres;
		noeudApres.precedent = noeudAvant;

		mapElementNoeud.remove(element);
		return true;
	}

	
	public boolean permuter (E element1, E element2) {

		//TODO

		// REMARQUE : CE SONT LES VALEURS QUI SONT PERMUTEES, PAS LES NOEUDS!!!
		// Il est donc inutile de revoir le chainage
		// N'oubliez pas de modifier les noeuds associes dans le map
		if (!mapElementNoeud.containsKey(element1) || !mapElementNoeud.containsKey(element2))
			return false;

		Noeud noeud1 = mapElementNoeud.get(element1);
		Noeud noeud2 = mapElementNoeud.get(element2);

		E elementTemp = noeud1.element;
		noeud1.element = noeud2.element;
		noeud2.element = elementTemp;

		mapElementNoeud.put(elementTemp,noeud2);
		mapElementNoeud.put(element2,noeud1);
		return true;
	}

	public Iterator<E> iterator() {
		//TODO
		//il faut renvoyer un objet de type Iterator :
		//return new IterateurImpl<E>();
		//completez la classe interne IterateurImpl !

		return new IterateurImpl<>();
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

			if (noeudCourant.suivant == null)
				return false;
			return true;
		}

		// renvoie l element qui se trouve dans le noeud courant
		// le noeud courant passe au noeud suivant
		public E next() {
			//TODO

			Noeud noeud = noeudCourant;

			if (hasNext()){
				noeudCourant = noeudCourant.suivant;
			}

			return (E) noeud.element;
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
