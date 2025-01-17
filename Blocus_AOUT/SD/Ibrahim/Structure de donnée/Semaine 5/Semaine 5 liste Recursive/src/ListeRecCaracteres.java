import java.util.NoSuchElementException;

import java.util.ArrayList;

public class ListeRecCaracteres {

	private NoeudCaractere tete;
	// N'ajoutez pas d'autres attributs
	
	public ListeRecCaracteres() {
		this.tete=null;
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public ListeRecCaracteres(char[] tableCaracteres) {
		if(tableCaracteres==null)
			throw new IllegalArgumentException();
		for (int i = tableCaracteres.length-1; i>=0; i--) {
			this.tete=new NoeudCaractere(tableCaracteres[i],tete);
		}	
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public String toString(){
		String aRenvoyer = "";
		NoeudCaractere baladeur = tete;
		while(baladeur != null) {
			aRenvoyer += " " + baladeur.caractere;
			baladeur = baladeur.suivant;
		}
		return aRenvoyer;
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS !!!
	public void remplacerToutParX(){
		NoeudCaractere baladeur = tete;
		while(baladeur != null) {
			baladeur.caractere = 'x';
			baladeur = baladeur.suivant;
		}
	}
	
	/**
	 * verifie la presence du caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return true si le caractere est present dans la liste, false sinon
	 */
	public boolean contient(char caractereRecherche){
		return contient(caractereRecherche,tete);

		//TODO
	}
	private boolean contient (char caractereRecherche, NoeudCaractere noeudCaractere){
		if (noeudCaractere == null){
			return false;
		}
		if (noeudCaractere.caractere == caractereRecherche){
			return true;
		}
		return contient(caractereRecherche,noeudCaractere.suivant);
	}

	
	/**
	 * calcule le nombre de fois qu'apparait le caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return le nombre d'occurrences du caractere
	 */
	public int nombreOccurrences(char caractereRecherche){
		return nombreOccurrences(caractereRecherche, tete);
		//TODO
	}
	private int nombreOccurrences (char caractereRecherche, NoeudCaractere noeudCaractere){
		if (noeudCaractere == null){
			return 0;
		}
		if (noeudCaractere.caractere == caractereRecherche){
			return 1 + nombreOccurrences(caractereRecherche, noeudCaractere.suivant);
		}
		return nombreOccurrences(caractereRecherche, noeudCaractere.suivant);
	}

	
	/**
	 * remplace la 1ere occurrences du caractere a remplacer par un nouveau caractere
	 * @param caractereARemplacer le caractere a remplacer
	 * @param nouveauCaractere le nouveau caractere
	 */
	public void remplacer(char caractereARemplacer, char nouveauCaractere){
		remplacer(caractereARemplacer, nouveauCaractere, tete);
		//TODO
	}
	private void remplacer (char caractereARemplacer, char nouveauCaractere, NoeudCaractere noeudCaractere){
		if (noeudCaractere == null){return;}
		if (noeudCaractere.caractere == caractereARemplacer){
			noeudCaractere.caractere = nouveauCaractere;
			return;
		}
		remplacer(caractereARemplacer,nouveauCaractere,noeudCaractere.suivant);
	}

	
	/**
	 * remplace toutes les occurrences du caractere a remplacer par un nouveau caractere
	 * @param caractereARemplacer le caractere a remplacer
	 * @param nouveauCaractere le nouveau caractere
	 */
	public void remplacerTout(char caractereARemplacer, char nouveauCaractere){
		remplacerTout(caractereARemplacer, nouveauCaractere, tete);
		//TODO
	}
	private void remplacerTout (char caractereARemplacer, char nouveauCaractere, NoeudCaractere noeudCaractere){
		if (noeudCaractere == null){return;}
		if (noeudCaractere.caractere == caractereARemplacer){
			noeudCaractere.caractere = nouveauCaractere;
		}
		remplacerTout(caractereARemplacer,nouveauCaractere,noeudCaractere.suivant);
	}
	/**
	 * recherche le plus grand caractere de la liste ('a'<'b'< ...)
	 * @return le plus grand caractere 
	 * @throws NoSuchElementException si la liste est vide
	 */
	public char max() throws NoSuchElementException{
		// le plus petit caractere : ' '
		//TODO
		if (tete == null){throw new NoSuchElementException();}
		
		// c'est cette methode qui leve une exception en cas de liste vide!
		// suggestion : la methode recursive (private!) pourrait renvoyer ' ' si le noeud passe en parametre est null
		return max(tete);
	}
	private char max (NoeudCaractere noeudCaractere){
		if (noeudCaractere == null){return ' ';}
		if (noeudCaractere.caractere > max(noeudCaractere.suivant)){
			return noeudCaractere.caractere;
		}
		return max(noeudCaractere.suivant);
	}
	
	
	
	
	/**
	 * cree une arrayList contenant les caracteres de la liste 
	 * L'ordre doit etre respecte (une liste est une structure lineaire)
	 * @return l'arrayList cree
	 */
	public ArrayList<Character> enArrayList(){
		// TODO
		ArrayList<Character> liste = new ArrayList<>();
		enArrayList(liste,tete);
		return liste;
		// cette methode s'occupe de creer (1x!) l'arraylist et la passe en parametre de la methode recursive
		// l'arrayList est un objet --> passage de parametre par adresse 
		// La methode recursive est une methode void!
		
	}
	private void enArrayList (ArrayList liste, NoeudCaractere noeudCaractere){
		if (noeudCaractere == null)return;
		liste.add(noeudCaractere.caractere);
		enArrayList(liste,noeudCaractere.suivant);
	}

	/**
	 * verifie si les 2 listes contiennent les memes caracteres et ceci dans le meme ordre
	 * Une liste est une structure LINEAIRE!
	 * @param l la liste a comparer a la liste courante
	 * @return true si les 2 listes sont les memes, false sinon
	 */
	public boolean estEgalA(ListeRecCaracteres l) {
		// N'utilisez pas la methode toString()!
		// TODO

		return estEgalA(tete, l.tete);
	}

	private boolean estEgalA(NoeudCaractere noeud1, NoeudCaractere noeud2) {
		//les 2 listes sont vides
		if (noeud1 == null && noeud2 == null)
			return true;

		//1 liste est vide, l'autre pas
		if (noeud1 == null || noeud2 == null)
			return false;

		//les entiers contenus dans les 2 noeuds courants ne sont pas les memes
		if (noeud1.caractere != noeud2.caractere)
			return false;

		//appel recursif
		return estEgalA(noeud1.suivant, noeud2.suivant);
	}
	
	

	

	/**
	 * supprime une fois le caractere passe en parametre
	 * si le caractere se trouve plusieurs fois, c est sa premiere occurrence qui sera supprimee
	 * @param caractereASupprimer
	 * @return true si le caractere etait bien present dans la liste, false sinon
	 */
	
	// VERSION 1
	
	public boolean supprimerPremiereOccurrence(char caractereASupprimer){
		if(!contient(caractereASupprimer))
			return false;
		tete = supprimerPremiereOccurrence(tete,caractereASupprimer);
		return true;		
	}
	
	private NoeudCaractere supprimerPremiereOccurrence(NoeudCaractere noeud, char caractereASupprimer) {
		if(noeud==null)
			return null;
		if(noeud.caractere==caractereASupprimer)
			return noeud.suivant;
		noeud.suivant=supprimerPremiereOccurrence(noeud.suivant, caractereASupprimer);
		return noeud;
	}
	
	// VERSION 2
	
//	public boolean supprimerPremiereOccurrence(char caractereASupprimer) {
//		if(tete == null)
//			return false;
//		if(tete.caractere==caractereASupprimer){
//			tete = tete.suivant;
//			return true;
//		}
//			
//		return this.supprimerPremiereOccurrence(tete, caractereASupprimer) ;
//	}
//	
//	private boolean supprimerPremiereOccurrence(NoeudCaractere noeud, char caractereASupprimer) {
//		if (noeud.suivant == null)
//			return false ;
//		if (noeud.suivant.caractere == caractereASupprimer) {
//			noeud.suivant = noeud.suivant.suivant ;
//			return true ;
//		}
//		return supprimerPremiereOccurrence(noeud.suivant, caractereASupprimer);
//	}
	
	
	

	/**
	 * cree une liste qui est une copie de la liste courante (meme ordre)
	 * @return une copie de la liste courante
	 */
	public ListeRecCaracteres clone(){
		
		return null;

		// TODO
		
		// DEFI!
		
		// La methode recursive renvoie un noeud!
		// Lisez attentivement la version 1 de la solution de supprimerPremiereOccurrence
		
	}

	
	/**
	 * supprime le caractere autant de fois qu'il est present dans la liste
	 * @param caractereASupprimer
	 * @return le nombre de suppressions effectuees
	 */
	public int supprimerToutesLesOccurrences(char caractereASupprimer){
		
		return 0;
	
		// TODO
		
		// DEFI!
		
		// Lisez attentivement la version 1 ou la version 2 de la solution recursive de supprimerPremiereOccurrence
	}
	

	

	private class NoeudCaractere{
		private char caractere;
		private NoeudCaractere suivant;

		public NoeudCaractere(char caractere, NoeudCaractere suivant){
			this.caractere = caractere;
			this.suivant = suivant;
		}

	}
}
