import java.util.Arrays;

public class Temperatures {

	private String mois;
	private double[] tableDesTemperatures;

	// A NE PAS MODIFIER
	public Temperatures(String mois, double [] tableARecopier) {
		if(tableARecopier == null)
			throw new IllegalArgumentException();
		if(tableARecopier.length == 0)
			throw new IllegalArgumentException();
		this.mois = mois;
		this.tableDesTemperatures = new double[tableARecopier.length];
		for (int i = 0; i < tableARecopier.length; i++) {
			this.tableDesTemperatures[i]=tableARecopier[i];
		}
	}

	// A NE PAS MODIFIER
	public String toString(){
		String aRenvoyer = "temperatures du mois de " + this.mois + " : \n";
		return aRenvoyer + Arrays.toString(tableDesTemperatures);
	}


	/**
	 * calcule la moyenne des temperatures
	 * @return la moyenne
	 */
	public double moyenne(){
		//TODO
		double somme = 0;
		for (int i = 0; i< tableDesTemperatures.length; i ++){
			somme = tableDesTemperatures[i] + somme;

		}
		return somme/ tableDesTemperatures.length;
	}


	/**
	 * recherche la temperature la plus basse
	 * precondition (a ne pas verifier) la table des temperatures est non vide
	 * @return la temperature la plus basse
	 */
	public double temperatureMin() {
		// TODO
		double min = tableDesTemperatures[0];
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if (tableDesTemperatures[i] < min) {
				min = tableDesTemperatures[i];
			}

		}
		return min;
	}


		/**
		 * calcule le nombre de temperatures negatives (< 0)
		 * @return le nombre de jours de gel
		 */
		public int nombreJoursDeGel () {
			// TODO
			int sommeJoursDeGel = 0;
			for (int i = 0; i < tableDesTemperatures.length; i++) {
				if (tableDesTemperatures[i] <0) {
					sommeJoursDeGel ++;
				}


			} return sommeJoursDeGel;
		}




	/**
	 * remplit une table avec les numeros des jours de gel
	 * @return une table avec les jours de gel,
	 * la dimension de cette table correspond a ce nombre de jours
	 */
	public int[] joursDeGel(){
		//TODO
		// Attention, la dimension des tables renvoyees doivent TOUJOURS correspondre au nombre de donnees
		int [] tableARenvoyer = new int[nombreJoursDeGel()];
		int j = 0;
		for (int i = 0; i< tableDesTemperatures.length; i ++){
					tableARenvoyer [j] = i+j;
					j++;
		}
		return tableARenvoyer;
	}


	/**
	 * verifie si toutes les temperatures sont positives
	 * @return true si toutes les temperatures sont positives, false sinon
	 */
	public boolean toutesPositives(){
		//TODO
		// Pour une question d'efficacite, n'utilisez pas la methode nombreJoursDeGel()!
		// Il n'est peut-etre pas necessaire de parcourir toute la table pour cette methode

		for (int i = 0; i< tableDesTemperatures.length; i++){
			if (tableDesTemperatures[i] < 0);
			return false;
		}
		return true;
	}


	/**
	 * verifie la presence d'au moins une temperature negative (<0)
	 * @return true si la table contient au moins une temperature negative, false sinon
	 */
	public boolean contientAuMoinsUnJourDeGel(){
		//TODO
		// Pour une question d'efficacite, n'utilisez pas la methode nombreJoursDeGel()!
		// Par contre, reflechissez ! Ne serait-il pas possible d'utiliser la methode toutesPositives() ?
		for (int i = 0; i< tableDesTemperatures.length; i++){
			if (tableDesTemperatures[i] <0);
			return true;
		}
		return false;
	}


	/**
	 * verifie la presence d'au moins une temperature superieure a la temperature passee en parametre
	 * @param temperature la temperature qui sert a cette recherche
	 * @return true si la table contient au moins une temperature superieure a temperature, false sinon
	 */
	public boolean contientAuMoinsUneTemperatureSuperieureA(double temperature){
		//TODO
		// Ex supplementaire
		for (int i = 0; i< tableDesTemperatures.length; i++){
			if (tableDesTemperatures[i] > temperature);
			return true;
		}
		return false;
	}


	/**
	 * recherche la temperature la plus elevee
	 * precondition (a ne pas verifier) la table des temperatures est non vide
	 * @return la temperature la plus elevee
	 */
	public double temperatureMax(){
		//TODO
		// Ex supplementaire
		double max = tableDesTemperatures[0];
		for (int i = 0; i< tableDesTemperatures.length; i++){
			if (tableDesTemperatures[i]> max);
			max = tableDesTemperatures[i];
		}
		return max;

		}





	/**
	 * remplit une table avec les numeros des jours correspondant a la temperature la plus elevee
	 * @return une table avec les jours de haute temperature, la dimension de cette table correspond à ce nombre de jours
	 */
	public int[] joursMax(){
		// TODO
		// Ex supplementaire
		return null;
	}





	/**
	 * remplit une table avec les numeros des jours correspondant a la temperature la plus basse
	 * @return une table avec les jours de basse temperature, la dimension de cette table correspond à ce nombre de jours
	 */
	public int[] joursMin(){

		//TODO
		// Ex supplementaire
		// Suggestion : introduisez la methode nombreJours(double temperature)
		// Les methodes joursDeGel(), joursMax() peuvent aussi utiliser cette methode
		//
		return null;
	}

}
