import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * Algorithme de tri : UnshuffleSort 

 * Cet algorithme de tri necessite l�utilisation d�une liste de deques.
 * Cet algorithme de tri comporte deux etapes. La premiere consiste a repartir 
 * les entiers a trier dans un nombre variable de deques. Lorsque tous
 * les entiers auront ete repartis, la deuxieme etape se chargera de remplir la
 * table a renvoyer.
 *
 * Les 2 etapes sont basees sur le principe suivant : La liste des deques devra
 * toujours etre triee en utilisant le premier entier de chaque deque comme clef de tri.
 * Les deques aussi sont tries.
 *
 *
 */
public class UnshuffleSort {

	private LinkedList<ArrayDeque<Integer>>  listeDeDeques;

	public UnshuffleSort() {
		this.listeDeDeques = new LinkedList<ArrayDeque<Integer>>();
	}

	/**
	 * tri de la table d'entiers re�ue en parametre
	 *
	 * @param tableATrier la table a trier
	 * @return table contenant les entiers tries
	 */
	public int[] trier(int[] tableATrier) {
		remplirDeques(tableATrier);
		return viderDeques(tableATrier.length);
	}

	/**
	 * 1ere etape du tri : repartition des entiers dans des deques
	 * @param tableATrier la table a trier
	 */
	private void remplirDeques(int[]tableATrier) {
		// Pour le debug:
		System.out.println("etape1");

		// TODO
		for(int i  = 0; i < tableATrier.length; i++){
			placerEntier(tableATrier[i]);
		}
		// pour plus de lisibilite cette methode pourrait appeler la methode suivante :

	}

	public void placerEntier(int entier) {

		// TODO
		// methode private --> public car verifiee par la classe TestEtape1UnshuffleSort
		for(ArrayDeque<Integer> deque : listeDeDeques){
			if(deque.getFirst() >= entier){
				deque.addFirst(entier);
				return;
			}
			if (deque.getLast() <= entier){
				deque.addLast(entier);
				return;
			}
		}
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		deque.addFirst(entier);
		listeDeDeques.add(deque);
		// Pour le debug:
		System.out.println(listeDeDeques);
	}


	/**
	 * 2eme etape du tri : on vide les deques
	 *
	 * @param taille nombre d'entiers de la table a trier
	 * @return table contenant les entiers tries
	 */
	private int[] viderDeques(int taille) {

		// Pour le debug:
		System.out.println("etape2");
		int[] table = new int[taille];
		for(int i = 0; i < table.length; i++){
			table[i] = supprimerPlusPetitEntier();
		}
		return table;
		// TODO

		// pour plus de lisibilite cette methode pourrait appeler les methodes suivantes :

	}

	private int supprimerPlusPetitEntier(){

		// supprime et renvoie l'entier supprime
		int entier = listeDeDeques.getFirst().removeFirst();
		if(listeDeDeques.getFirst().size() != 0){
			reorganiserListe();
		}else{
			listeDeDeques.removeFirst();
		}

		return entier;
	}

	private void reorganiserListe(){

		// Pour le debug:
		System.out.println(listeDeDeques);
		ArrayDeque<Integer> premierDeque = listeDeDeques.removeFirst();
		int index = 0;
		for(ArrayDeque<Integer> deque : listeDeDeques){
			if(deque.getFirst() > premierDeque.getFirst())break;
			index++;
		}
		listeDeDeques.add(index, premierDeque);
		// pour plus de lisibilite cette methode pourrait appeler la methode suivante :

	}

	private void deplacerPremierDeque() {

	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	public String toString(){
		return listeDeDeques.toString();
	}

}