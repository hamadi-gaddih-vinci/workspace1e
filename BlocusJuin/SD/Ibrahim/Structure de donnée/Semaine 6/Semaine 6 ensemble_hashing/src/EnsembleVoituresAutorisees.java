public class EnsembleVoituresAutorisees{

	// TODO
	// Utilisez un objet de la classe EnsembleTableHashing
	private EnsembleTableHashing<Voiture>tableVoiture;
	private final static int CAPACITE =500;

	// construit un ensemble vide mais pouvant contenir jusqu'a 500 voitures
	public EnsembleVoituresAutorisees(){
		// TODO
		tableVoiture = new EnsembleTableHashing(CAPACITE);
	}


	/**
	 * ajoute la voiture dans l ensemble des voitures autorisees
	 * @param voiture la voiture autorisee
	 * @return true si la voiture etait pas encore presente, false sinon
	 */
	public boolean ajouterVoiture(Voiture voiture){
		// TODO
		return tableVoiture.ajouter(voiture);
	}

	/**
	 * retire la voiture de l ensemble des voitures autorisees
	 * @param voiture la voiture non autorisee
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(Voiture voiture){
		return tableVoiture.enlever(voiture);
		// TODO
	}

	
	/**
	 * verifie si la voiture est presente dans l ensemble des voitures autorisees
	 * @param voiture la voiture a verifier
	 * @return true si la voiture est presente, false sinon
	 */
	public boolean voitureAutorisee(Voiture voiture){	
		return tableVoiture.contient(voiture);
		// TODO
	}




}