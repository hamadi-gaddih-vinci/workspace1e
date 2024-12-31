public class NoirJauneRouge {
	
	private Ecolier[] tableTriee;   // table triee d'abord les noirs puis les jaunes puis les rouges
										// Pas de doublons
	private int nombreNoirs;
	private int nombreJaunes;
	private int nombreRouges;
	private static final int NOMBRE_MAX_ECOLIERS = 10;
	
	
	public NoirJauneRouge(){
		this.tableTriee = new Ecolier[NOMBRE_MAX_ECOLIERS];
		this.nombreNoirs = 0;
		this.nombreJaunes = 0;
		this.nombreRouges = 0;
	}
	


	

	/**
	 * determine le nombre d ecoliers contenu dans la table
	 * @return le nombre d ecoliers
	 */
	public int nombreEcoliers(){
		return nombreNoirs + nombreJaunes + nombreRouges;
	}
	

	private int trouverIndiceEcolier(String nom){

		// methode private
		// recherche a quel indice de la table se trouve l'ecolier dont le nom est passe en parametre
		// si le nom n'est pas dans la table, la methode renvoie -1

		for (int i = 0; i < nombreEcoliers(); i++) {
			if(tableTriee[i].getNom().equals(nom))
				return i;
		}
		return -1;
		
	}

	/**
	 * ajoute l ecolier, s'il n'y a pas d ecolier avec ce nom et si le nombre max d ecoliers n'est pas atteint
	 * @param nom
	 * @return true si l'ajout a pu etre fait, false sinon
	 */
	public boolean ajouter(String nom, char couleur){
		
		if(nom == null||nom.equals(""))
			throw new IllegalArgumentException();
		
		if(couleur!='n' && couleur!='j' && couleur!='r')
			throw new IllegalArgumentException();

		// TODO
		if(nombreEcoliers() == NOMBRE_MAX_ECOLIERS){
			System.out.println("Le nombre maximum d'élèves a été atteint.");
			return false;
		}

		if(trouverIndiceEcolier(nom) != -1){
			System.out.println("Un élève avec ce nom existe déjà.");
			return false;
		}

		Ecolier ecolier = new Ecolier(nom, couleur);

		int indice = nombreNoirs + nombreJaunes + nombreRouges;
		for(int i = 0; i < indice; i++){
			if(tableTriee[i].getCouleur() > couleur){
				indice = i;
				break;
			}
		}

		for(int i = nombreEcoliers(); i > indice; i--){
			tableTriee[i] = tableTriee[i-1];
		}

		tableTriee[indice] = ecolier;

		if(couleur == 'n'){
			nombreNoirs++;
		}
		else if(couleur == 'j'){
			nombreJaunes++;
		}
		else{
			nombreRouges++;
		}
		return true;
	}

		// Pensez a utiliser la methode trouverIndiceEcolier() donnee ci-dessus
		
		// CONTRAINTE :
		// Utilisez l'algorithme d'ajout IMPOSE.
		// Celui-ci est explique dans le document DrapeauBelge
	
	
	/**
	 * supprime l ecolier dont le nom est passe en parametre
	 * @param nom le nom de l ecolier a supprimer
	 * @return true si l ecolier a ete supprime, false sinon
	 */
	public boolean supprimer(String nom){
		
		if(nom == null||nom.equals(""))
			throw new IllegalArgumentException();

		// TODO
		// Ex supplementaire
		return false;

		// Pensez a utiliser la methode trouverIndiceEcolier() donnee ci-dessus
		
		// CONTRAINTE :
		// Utilisez l'algorithme de suppression IMPOSE. 
		// Celui-ci est explique dans le document DrapeauBelge
		

	
	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	public NoirJauneRouge(Ecolier[] tableARecopier, int nombreNoirs, int nombreJaunes, int nombreRouges) {
		this.tableTriee = new Ecolier[NOMBRE_MAX_ECOLIERS];
		for (int i = 0; i < tableARecopier.length; i++) {
			tableTriee[i]=tableARecopier[i];
		}
		this.nombreNoirs = nombreNoirs;
		this.nombreJaunes = nombreJaunes;
		this.nombreRouges = nombreRouges;
	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	public String toString() {
		String aRenvoyer="";
		for (int i = 0; i < nombreEcoliers(); i++) {
			aRenvoyer += "\n" + tableTriee[i];
		}
		return aRenvoyer;
	}

	public int getNombreNoirs() {
		return nombreNoirs;
	}

	public int getNombreJaunes() {
		return nombreJaunes;
	}

	public int getNombreRouges() {
		return nombreRouges;
	}

}
