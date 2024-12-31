public class EnsembleVoituresAutorisees {

	private EnsembleTableHashing<Voiture> ensembleVoiture;

	// TODO
	// Utilisez un objet de la classe EnsembleTableHashing

	// construit un ensemble vide mais pouvant contenir jusqu'a 500 voitures
	public EnsembleVoituresAutorisees(){
		// TODO
		ensembleVoiture = new EnsembleTableHashing<>(500);
	}


	/**
	 * ajoute la voiture dans l ensemble des voitures autorisees
	 * @param voiture la voiture autorisee
	 * @return true si la voiture etait pas encore presente, false sinon
	 */
	public boolean ajouterVoiture(Voiture voiture){
		return ensembleVoiture.ajouter(voiture);
		// TODO
 	
	}

	/**
	 * retire la voiture de l ensemble des voitures autorisees
	 * @param voiture la voiture non autorisee
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(Voiture voiture){
		return ensembleVoiture.enlever(voiture);
		// TODO
	}

	
	/**
	 * verifie si la voiture est presente dans l ensemble des voitures autorisees
	 * @param voiture la voiture a verifier
	 * @return true si la voiture est presente, false sinon
	 */
	public boolean voitureAutorisee(Voiture voiture){	
		return ensembleVoiture.contient(voiture);
		// TODO
	}




}