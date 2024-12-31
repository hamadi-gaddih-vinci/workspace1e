// implementation d'une pile en utilisant un tableau de taille variable redimensionnable

/**
 * @author 
 *
 */

public class PileDeCaracteresImpl implements PileDeCaracteres{

	private char[] table; 			// ne modifiez pas cet identifiant, va servir pour les tests
	private int nombreCaracteres; 	// taille logique
								  	//ne mofifiez pas cet identifiant, va servir pour les tests

	
	public PileDeCaracteresImpl(){
		table = new char[4];
		nombreCaracteres = 0;
	}

	
	public PileDeCaracteresImpl(int capacite){
		if (capacite <= 0)
			throw new IllegalArgumentException("la taille physique ne peut etre negative ou nulle");
		table = new char[capacite];
		nombreCaracteres = 0;
	}

	
	public int taille(){
		return nombreCaracteres;
	}

	
	public boolean estVide(){
		return nombreCaracteres == 0;
	}

	/**
	 * ajoute le caractere c sur la pile
	 * @param caractere le caractere a ajouter
	 */
	public void push(char c){
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)
		if (nombreCaracteres == table.length){
			char [] tableBis = new char[table.length*2];
			for (int i = 0; i < table.length; i++) {
				tableBis[i] = table[i];
			}
			table = tableBis;
		}
		table[taille()] = c;
		nombreCaracteres++;
	}

	/**
	 * renvoie le caractere qui se trouve au sommet de la pile et l'enleve de la pile
	 * @return le caractere au sommet
	 * @throws PileVideException si la pile est vide
	 */
	public char pop() throws PileVideException{
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)
		if (estVide())
			throw new PileVideException();
		char a = table[nombreCaracteres-1];
		nombreCaracteres--;
		return a;
	}


	public char sommet()throws PileVideException{
		if (estVide())
			throw new PileVideException();
		return table[nombreCaracteres-1];
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)
	}

} 
