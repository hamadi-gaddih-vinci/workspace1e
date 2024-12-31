import java.util.HashMap;
import java.util.LinkedList;

public class DicoSD {

	private HashMap<String, LinkedList<String>> myDico;

	//TODO
	// suivez l'implementation proposee dans l'enonce!


	// Au depart le dico est vide
	public DicoSD() {
		//TODO
		myDico = new HashMap<>();
	}

	/**
	 * ajout dans le dico une association sd-url si cette association n'est pas encore presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si cette association n'etait pas encore presente dans le dico, false sinon
	 */
	public boolean ajouter(String sd, String url) {
		LinkedList<String> list = new LinkedList<>();
		list.add(url);
		if (!myDico.containsKey(sd)) {
			myDico.put(sd, list);
			return true;
		}
		if (myDico.get(sd).contains(url))
			return false;
		return myDico.get(sd).add(url);
	}
	/**
	 * verifie si la structure de donnees se trouve dans le dico
	 * cette structure de donnees doit posseder au moins une url!
	 * @param sd
	 * @return true si sd est present, false sinon
	 */
	public boolean contient(String sd){
		if (myDico.containsKey(sd) && !myDico.get(sd).isEmpty()){
			return true;
		}
		return false;
		//TODO
	}
	
	
	/**
	 * renvoie tous les urls associes a la structure de donnees passee en parametre
	 * @param sd
	 * @return une chaine de caracteres avec les urls selon le format : [urlPile1, urlPile2] ou [] si la structure de donnees n'existe pas
	 */
	public String lesURLs(String sd){
		if (!contient(sd))
			return "[]";
		return myDico.get(sd).toString();
		//TODO
	}
	
	/**
	 * supprime dans le dico l'association sd-url si celle-ci est presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si l'association etait presente dans le dico, false sinon
	 */
	public boolean supprimer(String sd, String url){
		LinkedList<String> liste = myDico.get(sd);
		if (liste == null || !liste.contains(url))
			return false;
		return liste.remove(url);

		//TODO
	}
		
}
