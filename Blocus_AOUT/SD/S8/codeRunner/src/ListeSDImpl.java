import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeSDImpl<E> {

	private Noeud tete, queue;
	private HashMap<E, Noeud> mapElementNoeud;

	public ListeSDImpl () {
		mapElementNoeud = new HashMap<E, Noeud>();
		tete = new Noeud();   // sentinelle de tete
		queue = new Noeud();  // sentinelle de queue
		tete.suivant = queue;
		queue.precedent = tete;
	}

	public int taille () {
		return mapElementNoeud.size();
	}


	/**
	 * renvoie l element de tete sans l enlever
	 * @return l element de tete ou null s'il n'y a plus d'element
	 */
	public E premier() {
		//TODO
		//le premier element est dans le noeud qui suit le sentinelle de tete
		//(il faut renvoyer un element pas un noeud)
		//return ?;
		return tete.suivant.element;
	}

	/**
	 * insere un nouvel element en tete de liste si celui-ci n'etait pas deja present
	 * @param element le nouvel element a inserer en tete
	 * @return true si l'element a ete ajoute, false sinon
	 */
	public boolean insererEnTete (E element){
		//TODO

		//il ne peut y avoir des doublons, il faut donc s'assurer que l'element n'est pas encore dans la liste
		//le parcours de la liste est en O(N) --> A EVITER
		//la verification la presence de l'element dans le map est en O(1)
		if (mapElementNoeud.containsKey(element))
			return false;
		//creation du nouveau noeud (new)
		Noeud nouveauNoeud = new Noeud(element);

		//le noeud qui va se trouver avant le nouveau noeud est le sentinelle de tete
		Noeud noeudAvant = tete;

		//le noeud qui va se trouver apres le nouveau noeud est le noeud qui suit le sentinelle de tete
		Noeud noeudApres = tete.suivant;

		//il y a 4 raccords a faire
		noeudAvant.suivant = nouveauNoeud;
		noeudApres.precedent = nouveauNoeud;
		nouveauNoeud.precedent = noeudAvant;
		nouveauNoeud.suivant = noeudApres;

		//il ne faut pas oublier de mettre ce nouvel element dans le map
		mapElementNoeud.put(element, nouveauNoeud);
		return true;

	}

	/**
	 * supprime de la liste l element passe en parametre
	 * @param element l element a supprimer
	 * @return true si l element etait bien present, false sinon
	 */
	public boolean supprimer (E element) {
		//TODO
		//on recupere le noeud qui contient l element a supprimer via le map --> O(1)
		Noeud noeud = mapElementNoeud.get(element);

		//si le noeud recupere est null, cela signifie que l element ne se trouvait pas dans la liste
		if (noeud == null)
			return false;

		//le noeud qui se trouve avant le noeud a supprimer
		Noeud noeudAvant = mapElementNoeud.get(element).precedent;

		//le noeud qui se trouve apres le noeud a supprimer
		Noeud noeudApres = mapElementNoeud.get(element).suivant;

		//il y a 2 raccords a faire
		noeudAvant.suivant = noeudApres;
		noeudApres.precedent = noeudAvant;

		//il ne faut pas oublier de supprimer l element dans le map
		mapElementNoeud.remove(element);
		return true;
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

}
