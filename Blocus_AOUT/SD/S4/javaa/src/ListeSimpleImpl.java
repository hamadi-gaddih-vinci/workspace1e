import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * implementation de l'interface ListeSimple avec une liste simplement chainee 
 * 
 * @author 
 * 
 */
public class ListeSimpleImpl<E> implements ListeSimple<E> {
	
	private Noeud tete;
	private int taille;
	

	public ListeSimpleImpl(){
		tete = null;
		taille=0;
	}

	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public ListeSimpleImpl(Object[] table) {
		if(table==null)
			throw new IllegalArgumentException();
		this.taille = table.length;
		for (int i = table.length-1; i>=0; i--) {
			E element = (E)table[i];
			this.tete=new Noeud(element,tete);
		}	
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public String toString(){
		String aRenvoyer="";
		Noeud baladeur=tete;
		int cpt = 0;
		while(baladeur!=null) {
			cpt++;
			if(cpt>taille){
				aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
				return aRenvoyer;
			}
			aRenvoyer+=" "+baladeur.element;
			baladeur=baladeur.suivant;
		}
		return aRenvoyer;
	}

	
	public int taille(){
		return taille;
	}
		
	public boolean estVide(){
		return taille==0;
	}
	
	// renvoie l element contenu dans le noeud de tete
	/**
	 * renvoie l element de tete sans l enlever
	 * @return l element de tete
	 * @throws ListeVideException si la liste est vide
	 */
	public E premier()throws ListeVideException{
		if (estVide())
			throw new ListeVideException();
		return tete.element;
		// TODO

	}


	// insere un nouveau noeud en tete de liste avec l element 
	/**
	 * insere un nouvel element en tete de liste
	 * @param element le nouvel element a inserer en tete
	 */
	public void insererEnTete(E element) {
		// TODO
		tete = new Noeud(element, tete);
		taille++;
	}
	

	// verifie la presence d un noeud contenant l element passe en parametre
	/**
	 * verifie la presence de l element passe en parametre dans la liste
	 * @param element l element recherche
	 * @return true si l element est present, false sinon
	 */
	public boolean contient(E element){
		// TODO
		Noeud baladeur = tete;
		while (baladeur != null){
			if (baladeur.element.equals(element))
				return true;
			baladeur = baladeur.suivant;
		}
		return false;
	}


	// insere un nouveaud noeud apres le noeud contenant la premiere occurrence de l'element passe en parametre
	/**
	 * insere le 2eme element passe en parametre apres la premiere occurrence du 1er element passe en parametre
	 * @param element l element apres lequel un nouvel element doit etre insere
	 * @param elementAInserer le nouvel element a inserer
	 * @return true si le 1er element passe en parametre est present dans la liste, false sinon
	 */
	public boolean insererApres(E element, E elementAInserer){
		// TODO
		Noeud noeudInsert = new Noeud(elementAInserer, null);
		Noeud baladeur = tete;
		while (baladeur != null) {
			if (baladeur.element.equals(element)){
				noeudInsert.suivant = baladeur.suivant;
				baladeur.suivant = noeudInsert;
				taille++;
				return true;
			}
			baladeur = baladeur.suivant;
		}
		return false;
	}


	//supprime le noeud contenant la premiere occurrence de l'element passe en parametre
	/**
	 * supprime de la liste la 1ere occurrence de l element passe en parametre
	 * @param element l element a supprimer
	 * @return true si l element est present, false sinon
	 */
	public boolean supprimer(E element){
		// TODO
		Noeud baladeur = tete;
		while (baladeur != null) {
			if (tete.element.equals(element)){
				tete = tete.suivant;
				taille--;
				return true;
			} else if (baladeur.suivant != null && baladeur.suivant.element.equals(element)) {
				baladeur.suivant = baladeur.suivant.suivant;
				taille--;
				return true;
			} baladeur = baladeur.suivant;
		}
		return false;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new IterateurImpl();
	}
	
	
	private class Noeud{
		private E element;
		private Noeud suivant;

		public Noeud(E element, Noeud suivant){
			this.element = element;
			this.suivant = suivant;
		}
	}
	
	
	private class IterateurImpl implements Iterator{
		
		private Noeud noeudNext;
		
	
		// Au depart le noeud "next" est le noeud de tete
		private IterateurImpl() {
			noeudNext =  tete;
		}
		
		@Override
		// verifie si le noeud "next" est null
		public boolean hasNext() {
			// TODO
			return noeudNext != null;
		}

		
		@Override
		// renvoie l element qui se trouve dans le noeud "next"
		// le noeud "next" passe au noeud suivant
		public E next() {	  
		   // TODO
		   // pensez a consulter la JAVADOC de la classe Iterator!!!
		   if (!hasNext()){
			   throw new NoSuchElementException();
		   }
		   E e = noeudNext.element;
		   noeudNext = noeudNext.suivant;
		   return e;
		}

		
		@Override
		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}
		
	}

}
