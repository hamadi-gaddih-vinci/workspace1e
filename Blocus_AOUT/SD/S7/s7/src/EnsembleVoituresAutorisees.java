import java.util.HashMap;


public class EnsembleVoituresAutorisees {
	// TODO

	HashMap<String, Proprietaire> mapVoiture;
	/**
	 * construit un ensemble vide
	 */
	public EnsembleVoituresAutorisees(){
		// TODO
		mapVoiture = new HashMap<String, Proprietaire>();
	}

	/**
	 * ajoute une voiture a condition que celle-ci ne soit pas deja presente
	 * @param plaque la plaque de la voiture a ajouter
	 * @param proprietaire le proprietaire de la voiture a ajouter
	 * @return true si la voiture n'etait pas encore presente, false sinon
	 */
	public boolean ajouterVoiture(String plaque, Proprietaire proprietaire){
		if (mapVoiture.containsKey(plaque))
			return false;
		mapVoiture.put(plaque, proprietaire);
		return true;
		// TODO
	
	}


	/**
	 * retire une voiture a condition que celle-ci soit presente
	 * @param plaque la plaque de la voiture a ajouter
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(String plaque){
		if (mapVoiture.containsKey(plaque)) {
			mapVoiture.remove(plaque);
			return true;
		}
		return false;
			// TODO
		
	}


	
	/**
	 * verifie si la voiture est autorisee car presente dans l'ensemble
	 * @param plaque la plaque de la voiture a verifier
	 * @return true si la voiture est presente dans l'ensemble, false sinon
	 */
	public boolean voitureAutorisee(String plaque){
		return mapVoiture.containsKey(plaque);
		// TODO
		
	}
	
	/**
	 * renvoie le proprietaire de la voiture
	 * @param plaque la plaque de la voiture recherchee
	 * @return le proprietaire ou null si la plaque n'est pas dans l'ensemble
	 */
	public Proprietaire donnerProprietaire(String plaque){
		// TODO
		return mapVoiture.get(plaque);
	}
	
	public String toString(){
		String texte = "voiture autorisées";
		for (String plaque: mapVoiture.keySet()) {
			texte = "\n" + mapVoiture.get(plaque) + "possède la voiture avec plaque" + plaque;
		}
		return texte;
		// TODO
	}
}
