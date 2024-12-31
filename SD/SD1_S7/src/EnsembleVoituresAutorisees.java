import java.util.HashMap;


public class EnsembleVoituresAutorisees {
	// TODO
private HashMap<String, Proprietaire> voitureA;

	/**
	 * construit un ensemble vide
	 */
	public EnsembleVoituresAutorisees(){
		// TODO
		voitureA = new HashMap<>();
	}

	/**
	 * ajoute une voiture a condition que celle-ci ne soit pas deja presente
	 * @param plaque la plaque de la voiture a ajouter
	 * @param proprietaire le proprietaire de la voiture a ajouter
	 * @return true si la voiture n'etait pas encore presente, false sinon
	 */
	public boolean ajouterVoiture(String plaque, Proprietaire proprietaire){
		if (voitureA.containsKey(plaque))
			return false;
		voitureA.put(plaque, proprietaire);
		return true;
		// TODO
	
	}


	/**
	 * retire une voiture a condition que celle-ci soit presente
	 * @param plaque la plaque de la voiture a ajouter
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(String plaque){
		if (!voitureA.containsKey(plaque))
			return false;
		voitureA.remove(plaque);
		return true;
		// TODO
		
	}


	
	/**
	 * verifie si la voiture est autorisee car presente dans l'ensemble
	 * @param plaque la plaque de la voiture a verifier
	 * @return true si la voiture est presente dans l'ensemble, false sinon
	 */
	public boolean voitureAutorisee(String plaque){
		return voitureA.containsKey(plaque);
		// TODO
		
	}
	
	/**
	 * renvoie le proprietaire de la voiture
	 * @param plaque la plaque de la voiture recherchee
	 * @return le proprietaire ou null si la plaque n'est pas dans l'ensemble
	 */
	public Proprietaire donnerProprietaire(String plaque){
		return voitureA.get(plaque);
		// TODO
	}
	
	public String toString(){
		return voitureA.toString();
		// TODO
	}
}
