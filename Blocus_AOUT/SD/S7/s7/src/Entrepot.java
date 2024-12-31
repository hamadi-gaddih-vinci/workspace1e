import java.util.HashMap;

/**
 *
 * @author 													-------> METTEZ ICI VOS NOM ET PRENOM
 *
 *
 */

public class Entrepot {

	//TODO
	private Hangar[] tableHangar;
	private HashMap<Integer, Societe> societepresente;
	private int nombreHangarLibre;

	/**
	 * construit un entrepot contenant nombreHangars
	 *
	 * @param nombreHangars le nombre d'hangars
	 * @throws IllegalArgumentException si le nombre d'hangars est negatif ou nul
	 */
	public Entrepot(int nombreHangars) {
		if (nombreHangars <= 0)
			throw new IllegalArgumentException();
		// TODO
		tableHangar = new Hangar[nombreHangars];
		for (int i = 0; i < nombreHangars; i++) {
			Hangar hangar = new Hangar(i);
			tableHangar[i] = hangar;
		}
		societepresente = new HashMap<Integer, Societe>();
		this.nombreHangarLibre = nombreHangars;
	}

	/**
	 * renvoie le nombre d'hangars libres
	 *
	 * @return le nombre d'hangars libres
	 */
	public int nombreHangarsLibres() {
		//TODO
		return nombreHangarLibre;

	}


	/**
	 * renvoie le nombre de societes presentes
	 *
	 * @return le nombre de societes presentes
	 */
	public int nombreSocietesPresentes() {
		//TODO
		return societepresente.size();
	}

	/**
	 * renvoie la societe dont le numero est passe en parametre
	 *
	 * @param numeroSociete le numero de la societe
	 * @return la societe recherchee ou null si aucune societe presente ne possede ce numero
	 */
	public Societe getSociete(int numeroSociete) {
		//TODO
		return societepresente.get(numeroSociete);
	}

	/**
	 * attribue un hangar a la societe passee en parametre
	 * Si l'attribution a pu se faire :
	 * la societe est enregistree comme presente (si pas encore presente)
	 * le hangar lui est ajoute
	 *
	 * @param numeroSociete le numero de la societe
	 * @param nomSociete    le nom de la societe
	 * @return le numero du hangar attribue ou -1 s'il n'y en a plus de libre
	 */
	public int attribuerHangar(int numeroSociete, String nomSociete) {
		// TODO
		if (nombreHangarLibre <= 0)
			return -1;
		if (societepresente.get(numeroSociete) == null){
			Societe societe = new Societe(numeroSociete, nomSociete);
			societepresente.put(numeroSociete, societe);
		}
		if (nombreHangarLibre > 0){
			int attrib = numeroSociete% tableHangar.length;
			for (int i = attrib; i < tableHangar.length; i++) {
				if (tableHangar[i].getSociete() == null){
					Societe societe = new Societe(numeroSociete, nomSociete);
					tableHangar[i].setSociete(societe);
					nombreHangarLibre--;
					return i;
				}
			}
			for (int i = 0; i < attrib; i++) {
				if (tableHangar[i].getSociete() == null){
					Societe societe = new Societe(numeroSociete, nomSociete);
					tableHangar[i].setSociete(societe);
					nombreHangarLibre--;
					return i;
				}
			}
		}
		return -1;
	}
		// Pour une meilleure repartition des hangars occupes dans l'entrepot, 
		// veuillez suivre les indications donnees dans l'enonce!

	}
