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

	
	public void push(char c){
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)
		char tableTemp [] = new char[table.length*2];
		if (nombreCaracteres>= table.length) {
			for (int i = 0; i < table.length; i++) {
				tableTemp[i] = table[i];
			}
			table = tableTemp;
		}
		table[taille()] = c;
		nombreCaracteres++;
	}


	public char pop() throws PileVideException{
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)
		if (taille()<=0 || taille()>= table.length ){throw new PileVideException("Pile vide");}
		char caractere = table[taille()-1];
		nombreCaracteres--;
		return caractere;
	}


	public char sommet()throws PileVideException{
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)
		if (taille()<=0 || taille()>= table.length){throw new PileVideException("Pile vide");}
		char caractere = table[taille()-1];
		return caractere;
	}

} 
