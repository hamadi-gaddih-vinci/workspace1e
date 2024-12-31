
// implementation de l'interface Ensemble via un tableau de booleens

public class EnsembleTableBooleens<E> implements Ensemble<E>{
   
 	private boolean[] table; 
	private int taille;

	// capacite = nombre d'elements de l'univers
	public EnsembleTableBooleens(int capacite){
		table = new boolean[capacite];	
		taille = 0;		
	}

	public int taille(){
		// TODO
		return taille;

	}
	
	public boolean estVide(){
		// TODO
		return taille() == 0;

	}

	public boolean contient(E element){
		// TODO
		return table[element.hashCode()];
	}

	/**
	 * ajoute element si element n’appartient pas a l’ensemble
	 * @param element l'element a ajouter
	 * @return true si l'element a ete ajoute, false sinon
	 */
	public boolean ajouter(E element){
		// TODO
		if (contient(element))
			return false;
		table[element.hashCode()] = true;
		taille++;
		return true;
	}

	/**
	 * retire element si element appartient a l’ensemble
	 * @param element l'element a retirer
	 * @return true si l'element a ete retire, false sinon
	 */
	public boolean enlever(E element){
		// TODO
		if (!contient(element))
			return false;
		table[element.hashCode()] = false;
		taille--;
		return true;

	}

}