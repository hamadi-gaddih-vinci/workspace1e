import java.util.HashMap;


public class EnsembleVoituresAutorisees {
	// TODO
	HashMap<String, Proprietaire>voitures;

	/**
	 * construit un ensemble vide
	 */
	public EnsembleVoituresAutorisees(){
		// TODO
		voitures = new HashMap<String , Proprietaire>();

	
	}

	/**
	 * ajoute une voiture a condition que celle-ci ne soit pas deja presente
	 * @param plaque la plaque de la voiture a ajouter
	 * @param proprietaire le proprietaire de la voiture a ajouter
	 * @return true si la voiture n'etait pas encore presente, false sinon
	 */
	public boolean ajouterVoiture(String plaque, Proprietaire proprietaire){
		// TODO
		if (voitures.containsKey(plaque)){return false;}
		voitures.put(plaque,proprietaire);
		return true;
	
	}


	/**
	 * retire une voiture a condition que celle-ci soit presente
	 * @param plaque la plaque de la voiture a ajouter
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(String plaque){
		// TODO
		if (voitures.containsKey(plaque)){
			voitures.remove(plaque);
			return true;
		}
		return false;
	}


	
	/**
	 * verifie si la voiture est autorisee car presente dans l'ensemble
	 * @param plaque la plaque de la voiture a verifier
	 * @return true si la voiture est presente dans l'ensemble, false sinon
	 */
	public boolean voitureAutorisee(String plaque){
		// TODO
		if (voitures.containsKey(plaque)){return true;}
		return false;
	}
	
	/**
	 * renvoie le proprietaire de la voiture
	 * @param plaque la plaque de la voiture recherchee
	 * @return le proprietaire ou null si la plaque n'est pas dans l'ensemble
	 */
	public Proprietaire donnerProprietaire(String plaque){
		// TODO
		return voitures.get(plaque);
	}
	
	public String toString(){
		// TODO
		String texte = "voiture autorisée : ";
		for (String plaque : voitures.keySet()){
			texte = "\n"+ voitures.get(plaque) + "possède la voiture avec la plaque : " + plaque;
		}
		return texte;
	}
}
