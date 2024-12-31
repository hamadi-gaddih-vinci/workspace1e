import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FancyFair {
	
	// suivez l'implementation imposee dans l'enonce

	private String[] tableReservations; //table des reservations
	private HashMap<String, HashSet<Integer>> mapEnfants; //cle = enfant, valeur = ensemble de ses places

	/**
	 * initialise un spectacle de fancy fair
	 * @param nombreTotalPlaces le nombre total de places disponibles
	 * @param tablePrenoms la table avec les prenoms des enfants qui appartiennent au spectacle
	 * @throws IllegalArgumentException si un des parametres ne permet pas d'initialiser le spectacle :
	 *         il faut au moins une place
	 *         la table des prenoms ne peut etre null ou vide
	 *         les prenoms ne peuvent etre null ou vides
	 *         il ne peut y avoir des doublons dans la table des prenoms
	 */
	public FancyFair(int nombreTotalPlaces, String[] tablePrenoms){
		// TODO
		// pour verifier la presence de doublons dans la table des prenoms :
		// verifier si les ajouts dans le map se font bien
		// Dans un map, chaque cle est unique !
		if (nombreTotalPlaces <= 0)
			throw new IllegalArgumentException();
		if (tablePrenoms == null || tablePrenoms.length == 0)
			throw new IllegalArgumentException();

		tableReservations = new String[nombreTotalPlaces];
		mapEnfants = new HashMap<String, HashSet<Integer>>();
		for (int i = 0; i < tablePrenoms.length; i++) {
			if (tablePrenoms[i].isEmpty() || tablePrenoms[i].equals(" "))
				throw new IllegalArgumentException();
			String prenom = tablePrenoms[i];
			if (mapEnfants.containsKey(prenom))
				throw new IllegalArgumentException();
			mapEnfants.put(prenom, null);
		}
	}


	/**
	 * reserve une ou plusieurs places
	 * la reservation reussit si toutes les places demandees sont libres
	 * ATTENTION : PAS de reservation partielle (tout ou rien)
	 * @param prenom le prenom de l'enfant qui demande des places
	 * @param ensemblePlacesDemandees l'ensemble avec les numeros des places demandees
	 * @return true si la reservation a reussi, false sinon
	 * @throws IllegalArgumentException si le prenom est null ou vide
	 * 								 ou si l'enfant n'appartient pas au spectacle
	 *                               ou si l'ensemble est null ou vide
	 *                               ou si l'enseble contient un numero de place inexistant
	 */
	public boolean reserver(String prenom, HashSet<Integer> ensemblePlacesDemandees){
		// TODO
		if (prenom == null || prenom.isEmpty() || !mapEnfants.containsKey(prenom) || ensemblePlacesDemandees == null ||ensemblePlacesDemandees.isEmpty())
			throw new IllegalArgumentException();
		for (int value: ensemblePlacesDemandees) {
			if (value > tableReservations.length-1)
				throw new IllegalArgumentException();
			if (tableReservations[value] != null)
				return false;
			tableReservations[value] = prenom;
			mapEnfants.get(prenom).add(value);
		}
		return true;

	}


	/**
	 * renvoie une table contenant les places reservees par un enfant
	 * cette table doit etre triee selon l'ordre croissant des numeros de place
	 * la table sera de dimension 0, si l'enfant n'a aucune reservation
	 * @param prenom le prenom de l'enfant
	 * @return la table avec les places reservees par un enfant
	 * @throws IllegalArgumentException si le prenom est null ou vide
	 * 								 ou si l'enfant n'appartient pas au spectacle
	 */
	public int[] placesReservees (String prenom) {
		//TODO
		if (prenom == null || prenom.isEmpty() || !mapEnfants.containsKey(prenom))
			throw new IllegalArgumentException();
		int[] table = new int[mapEnfants.get(prenom).size()];
		int index = 0;
		for (int value : mapEnfants.get(prenom)) {
			table[index] = value;
			index++;
		}
		Arrays.sort(table);
		return table;
		// Pour trier la table, utilisez la methode static sort() de la classe Arrays

	}


	/**
	 * renvoie la table des reservations et le map
	 */
	public String toString(){
		// vous pouvez modifier cette methode comme vous voulez
		// MAIS cette methode ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		if(tableReservations ==null)
			return "attention table des reservations est null";
		if(mapEnfants==null)
			return "attention mapEnfants est null";
		return "table des reservations :\n"+Arrays.toString(tableReservations)+"\nmapEnfants :\n"+mapEnfants.toString();
	}
	
}
