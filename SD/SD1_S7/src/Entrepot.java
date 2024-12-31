import java.util.HashMap;

/**
 *
 * @author 													-------> METTEZ ICI VOS NOM ET PRENOM
 *
 *
 */

public class Entrepot {
	private Hangar [] tableHangar;
	private HashMap<Integer, Societe> mapSocietePresente;
	private int nombreHangarsLibres;
	//TODO


	/**
	 * construit un entrepot contenant nombreHangars
	 * @param nombreHangars le nombre d'hangars
	 * @throws IllegalArgumentException si le nombre d'hangars est negatif ou nul
	 */
	public Entrepot(int nombreHangars) {
		if(nombreHangars<=0)
			throw new IllegalArgumentException();
		// TODO
		this.nombreHangarsLibres = nombreHangars;
		this.mapSocietePresente = new HashMap<>();
		this.tableHangar = new Hangar[nombreHangars];
		for (int i = 0; i < nombreHangars; i++) {
			tableHangar[i] = new Hangar(i);
		}
	}

	/**
	 * renvoie le nombre d'hangars libres
	 * @return le nombre d'hangars libres
	 */
	public int nombreHangarsLibres(){
		//TODO
		return nombreHangarsLibres;

	}


	/**
	 * renvoie le nombre de societes presentes
	 * @return le nombre de societes presentes
	 */
	public int nombreSocietesPresentes(){
		//TODO
		return mapSocietePresente.size();

	}

	/**
	 * renvoie la societe dont le numero est passe en parametre
	 * @param numeroSociete le numero de la societe
	 * @return la societe recherchee ou null si aucune societe presente ne possede ce numero
	 */
	public Societe getSociete(int numeroSociete){
		//TODO
		return mapSocietePresente.get(numeroSociete);
	}

	/**
	 * attribue un hangar a la societe passee en parametre
	 * Si l'attribution a pu se faire :
	 * la societe est enregistree comme presente (si pas encore presente)
	 * le hangar lui est ajoute
	 * @param numeroSociete le numero de la societe
	 * @param nomSociete le nom de la societe
	 * @return le numero du hangar attribue ou -1 s'il n'y en a plus de libre
	 */
	public int attribuerHangar(int numeroSociete, String nomSociete) {
		// TODO

		// Pour une meilleure repartition des hangars occupes dans l'entrepot, 
		// veuillez suivre les indications donnees dans l'enonce!
		Societe societe = mapSocietePresente.get(numeroSociete);
		if (nombreHangarsLibres == 0)
			return -1;
		if (societe == null){
			societe = new Societe(numeroSociete, nomSociete);
			mapSocietePresente.put(societe.getNumeroSociete(), societe);
		}
		int numH = societe.getNumeroSociete()%tableHangar.length;
		if (tableHangar[numH].getSociete() == null){
			tableHangar[numH].setSociete(societe);
			societe.ajouterHangar(numH);
			nombreHangarsLibres--;
			return numH;
		}

		else {
			for (int i = numH+1; i < tableHangar.length; i++) {
				if (tableHangar[i].getSociete() == null){
					tableHangar[i].setSociete(societe);
					societe.ajouterHangar(i);
					nombreHangarsLibres--;
					return i;
				}
			}
			for (int i = 0; i < numH-1; i++) {
				if (tableHangar[i].getSociete() == null){
					tableHangar[i].setSociete(societe);
					societe.ajouterHangar(i);
					nombreHangarsLibres--;
					return i;
				}
			}
			return -1;
		}

	}




}
