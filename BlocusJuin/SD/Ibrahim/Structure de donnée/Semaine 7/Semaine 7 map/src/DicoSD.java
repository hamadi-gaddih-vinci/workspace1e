import java.util.HashMap;
import java.util.LinkedList;

public class DicoSD {
	
	//TODO
	// suivez l'implementation proposee dans l'enonce!

	private HashMap<String,LinkedList<String>> dico;

	// Au depart le dico est vide
	public DicoSD() {
		//TODO
		dico = new HashMap<String,LinkedList<String >>();
	}

	/**
	 * ajout dans le dico une association sd-url si cette association n'est pas encore presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si cette association n'etait pas encore presente dans le dico, false sinon
	 */
	public boolean ajouter(String sd, String url){
			//TODO
		LinkedList<String> list = new LinkedList<>();
		list.add(url);
		if (!dico.containsKey(sd)){
			dico.put(sd,list);
			return true;
		}
		if (dico.get(sd).contains(url))
			return false;
		return dico.get(sd).add(url);
	}
	
	/**
	 * verifie si la structure de donnees se trouve dans le dico
	 * cette structure de donnees doit posseder au moins une url!
	 * @param sd
	 * @return true si sd est present, false sinon
	 */
	public boolean contient(String sd){
		//TODO
		if (dico.containsKey(sd) && !dico.get(sd).isEmpty()){return true;}
		return false;
	}
	
	
	/**
	 * renvoie tous les urls associes a la structure de donnees passee en parametre
	 * @param sd
	 * @return une chaine de caracteres avec les urls selon le format : [urlPile1, urlPile2] ou [] si la structure de donnees n'existe pas
	 */
	public String lesURLs(String sd){
		//TODO
		if (dico.isEmpty()){return "[]";}
		return ""+dico.get(sd);
	}
	
	/**
	 * supprime dans le dico l'association sd-url si celle-ci est presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si l'association etait presente dans le dico, false sinon
	 */
	public boolean supprimer(String sd, String url){
		//TODO
		if (!dico.containsKey(sd)){return false;}
		if (dico.get(sd).contains(url)) {
			dico.get(sd).remove(url);
			return true;
		}
		return false;
	}
		
}
