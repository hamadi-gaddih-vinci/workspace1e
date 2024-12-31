import java.util.HashMap;


public class EnsembleVoituresAutorisees {
	// TODO

	HashMap<String, Proprietaire> ensembleDeVoitures;
	

	/**
	 * construit un ensemble vide
	 */
	public EnsembleVoituresAutorisees(){
		// TODO
		ensembleDeVoitures = new HashMap<String, Proprietaire>();
	}

	/**
	 * ajoute une voiture a condition que celle-ci ne soit pas deja presente
	 * @param plaque la plaque de la voiture a ajouter
	 * @param proprietaire le proprietaire de la voiture a ajouter
	 * @return true si la voiture n'etait pas encore presente, false sinon
	 */
	public boolean ajouterVoiture(String plaque, Proprietaire proprietaire){
		if (ensembleDeVoitures.containsKey(plaque))
			return false;
		ensembleDeVoitures.put(plaque, proprietaire);
		return true;
		// TODO
	
	}


	/**
	 * retire une voiture a condition que celle-ci soit presente
	 * @param plaque la plaque de la voiture a ajouter
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(String plaque){
		if (!ensembleDeVoitures.containsKey(plaque))
			return false;
		ensembleDeVoitures.remove(plaque);
		return true;
		// TODO
		
	}


	
	/**
	 * verifie si la voiture est autorisee car presente dans l'ensemble
	 * @param plaque la plaque de la voiture a verifier
	 * @return true si la voiture est presente dans l'ensemble, false sinon
	 */
	public boolean voitureAutorisee(String plaque){
		return ensembleDeVoitures.containsKey(plaque);
		// TODO
		
	}
	
	/**
	 * renvoie le proprietaire de la voiture
	 * @param plaque la plaque de la voiture recherchee
	 * @return le proprietaire ou null si la plaque n'est pas dans l'ensemble
	 */
	public Proprietaire donnerProprietaire(String plaque){
		return ensembleDeVoitures.get(plaque);
		// TODO
	}
	
	public String toString(){
		String texte = "Voiture autorisees : ";
		for (String plaque: ensembleDeVoitures.keySet()) {
			texte += "\n" + ensembleDeVoitures.get(plaque) + "possède la voiture avec la plaque" + plaque;
		}
		return texte;
		// TODO
	}
}
