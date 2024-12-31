public class EnsembleVoituresAutorisees{

	private EnsembleTableHashing<Voiture> ensembleTableHashing;
	private static int CAPACITE = 500;
	// TODO
	// Utilisez un objet de la classe EnsembleTableHashing

	// construit un ensemble vide mais pouvant contenir jusqu'a 500 voitures
	public EnsembleVoituresAutorisees(){
		// TODO
		ensembleTableHashing = new EnsembleTableHashing<>(CAPACITE);
	}


	/**
	 * ajoute la voiture dans l ensemble des voitures autorisees
	 * @param voiture la voiture autorisee
	 * @return true si la voiture etait pas encore presente, false sinon
	 */
	public boolean ajouterVoiture(Voiture voiture){
		return ensembleTableHashing.ajouter(voiture);
		// TODO
 	
	}

	/**
	 * retire la voiture de l ensemble des voitures autorisees
	 * @param voiture la voiture non autorisee
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(Voiture voiture){
		return ensembleTableHashing.enlever(voiture);
		// TODO
	}

	
	/**
	 * verifie si la voiture est presente dans l ensemble des voitures autorisees
	 * @param voiture la voiture a verifier
	 * @return true si la voiture est presente, false sinon
	 */
	public boolean voitureAutorisee(Voiture voiture){	
		return ensembleTableHashing.contient(voiture);
		// TODO
	}




}