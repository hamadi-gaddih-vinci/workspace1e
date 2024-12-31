public class EtudiantCotesTriees{

	private double[] tableCotes;  // table triee
	private int matricule;

	/** 
	 * methode qui calcule la moyenne des cotes de l'etudiant
	 * precondition (a ne pas verifier) : la table contient au moins 1 cote
	 * @return moyenne des cotes de l'etudiant
	 */
	public double moyenne(){

		double somme = 0;
		for(int i = tableCotes.length-1;i >= tableCotes[1] ; i--)
			if (tableCotes[i] > tableCotes[i+1])
			somme = somme + tableCotes[i];
		return somme/tableCotes.length;
		// A RENDRE PLUS EFFICACE SI POSSIBLE	
	}

	/** 
	 * methode qui calcule le nombre d'echecs de l'etudiant
	 * precondition (a ne pas verifier) : la table contient au moins 1 cote
	 * @return nombre d'echecs (cote < 10) de l'etudiant
	 */
	public int nombreEchecs(){

		int nombreEchecs = 0;
		for(int i = 0; i < tableCotes.length; i++) 
			if(tableCotes[i]<10) 
				nombreEchecs++;
		return nombreEchecs;

		// A RENDRE PLUS EFFICACE SI POSSIBLE	
	}

	/** 
	 * methode qui recherche la plus petite cote de l'etudiant
	 * precondition (a ne pas verifier) : la table contient au moins 1 cote
	 * @return la plus petite cote de l'etudiant
	 */
	public double min(){

		double min = 20;
		for(int i = 0; i < tableCotes.length; i++) 
			if(tableCotes[i] < min) 
				min = tableCotes[i];
		return min;

		// A RENDRE PLUS EFFICACE SI POSSIBLE
	}

	/** 
	 * methode qui recherche la cote la plus elevee de l'etudiant
	 * precondition (a ne pas verifier) : la table contient au moins 1 cote
	 * @return la cote la plus elevee de l'etudiant
	 */
	public double max(){

		double max = 0;
		for(int i = 0; i < tableCotes.length; i++) 
			if(tableCotes[i] > max) 
				max = tableCotes[i];
		return max;

		// A RENDRE PLUS EFFICACE SI POSSIBLE
	}

	//A NE PAS MODIFIER
	//VA SERVIR POUR LES TESTS
	public EtudiantCotesTriees(int matricule, double[] tableARecopier){
		if(tableARecopier.length==0)
			throw new IllegalArgumentException();
		this.matricule = matricule;
		this.tableCotes = new double[tableARecopier.length];
		tableCotes[0] = tableARecopier[0];
		for(int i = 1; i < tableARecopier.length; i++) {
			if(tableARecopier[i]<tableARecopier[i-1]){
				throw new IllegalArgumentException();
			}
			tableCotes[i] = tableARecopier[i];
		}
	}


	public String toString(){
		String aRenvoyer = "\n matricule : " + this.matricule +"\n cotes : ";
		for(int i = 0; i < tableCotes.length; i++)
			aRenvoyer = aRenvoyer + "  " + tableCotes[i];
		return aRenvoyer;
	}

}