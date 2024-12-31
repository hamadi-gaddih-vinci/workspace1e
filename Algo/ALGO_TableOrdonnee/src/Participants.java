import java.util.Objects;

public class Participants {
	private String[] tableParticipants;
	private int nombreInscrits; 	// taille logique

	// Les nombreInscrits participants occupent les nombreInscrits premieres
	// cases du tableau!

	// Dans cette table, l'ordre des ajouts est respecte

	public Participants(int nombreMaxParticipants) {
		if (nombreMaxParticipants < 1)
			throw new IllegalArgumentException();
		this.tableParticipants = new String[nombreMaxParticipants];
		this.nombreInscrits = 0;
	}

	/**
	 * renvoie le nombre de participants actuellement inscrits
	 * @return le nombre de participants actuellement inscrits
	 */
	public int getNombreInscrits() {
		return this.nombreInscrits;
	}

	/**
	 * recherche l'indice de la case de la table qui contient le participant passe en parametre
	 * @param participant le participant recherche
	 * @return l'indice du participant ou -1 si le participant n'est pas dans la table
	 */
	public int donnerIndex(String participant) {
		//TODO
		for (int i = 0; i < tableParticipants.length; i++) {
			if (tableParticipants[donnerIndex(participant)].equals(tableParticipants[i]))
				return i;
			return -1;

		}
	}
	/**
	 * verifie l'existence du participant passe en parametre
	 * @param participant le participant recherche
	 * @return true si le participant est present dans la table, false sinon
	 */
	public boolean contientParticipant(String participant){
		//TODO
		if (donnerIndex(participant) != -1) return true;
		// Utilisez la methode donnerIndex !

		return false;

	}

	/**
	 * ajoute (insere) un participant a l'index passe en parametre
	 * a condition qu'il ne soit pas deja present
	 * et a condition que le nombre maximum de participants ne soit pas atteint
	 * @param index l'indice de la table ou il faut ajouter le participant
	 * @param participant le participant a ajouter
	 * @return true si l'ajout a pu se faire, false sinon
	 * @throws IllegalArgumentException si l'index est invalide
	 */
	public boolean ajouterParticipant(int index,String participant) {
		//TODO
		if (index < 0 || index>nombreInscrits)
			throw new IllegalArgumentException();
		if (contientParticipant(participant)) return false;
		if (nombreInscrits == tableParticipants.length) return false;
		for (int i = nombreInscrits-1; i>= index; i--) {
			tableParticipants[i+1] = tableParticipants[i];
		}
		tableParticipants[index] = participant;
		nombreInscrits++;
		// Si cela ne va pas, refaites le QCM classe ParticipantsV2 sur moovin
		// et/ou visionnez le diaporama AnimationInsertion presente au cours theorique

		return true;

	}

	/**
	 * ajoute un participant en "fin" de table
	 * a condition qu'il ne soit pas deja present
	 * et a condition que le nombre maximum de participants ne soit pas atteint
	 * @param participant le participant a ajouter
	 * @return true si l'ajout a pu se faire, false sinon
	 */
	public boolean ajouterParticipant(String participant) {
		// TODO
		if (contientParticipant(participant)) return false;
		if (nombreInscrits >= tableParticipants.length) return false;
		return ajouterParticipant(nombreInscrits, participant);
		//a corriger car marche pas

		// Utilisez la methode ajouterParticipant via index !



	}

	/**
	 * supprime le participant qui se trouve dans la table a l'indice passe en parametre
	 * @param index l'index du participant a supprimer
	 * @throws IllegalArgumentException si l'index est invalide
	 * @return le participant supprime
	 */
	public String supprimerParticipant(int index) {
		// TODO
		if (index < 0 || index > nombreInscrits)
			throw new IllegalArgumentException();
		for (int i = 0; i < nombreInscrits; i++) {
			tableParticipants[i] = tableParticipants[i+1];
		} nombreInscrits--;
		// Si cela ne va pas, refaites le QCM classe ParticipantsV2 sur moovin
		// et/ou visionnez le diaporama AnimationSuppression presente au cours theorique

		return null;

	}

	/**
	 * supprime le participant passe en parametre
	 * @param participant Le participant a supprimer
	 * @return false si la suppression n'a pas pu etre faite car la table ne
	 *         contient pas le participant, true sinon
	 */
	public boolean supprimerParticipant(String participant) {
		// TODO

		// Utilisez les methodes donnerIndex et supprimerParticipant (via index) !
		return false;

	}


	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	/**
	 * Construit un objet Participants en copiant tous les participants a partir
	 * de la table passee en parametre.
	 * @param tableARecopier table contenant les participants a ajouter
	 */
	public Participants(int nombreParticipants, String[] tableARecopier) {

		if (tableARecopier == null)
			throw new IllegalArgumentException();
		if (nombreParticipants < 1)
			throw new IllegalArgumentException();
		if (nombreParticipants < tableARecopier.length)
			throw new IllegalArgumentException();
		this.tableParticipants = new String[nombreParticipants];
		this.nombreInscrits = tableARecopier.length;
		for (int i = 0; i < nombreInscrits; i++)
			this.tableParticipants[i] = tableARecopier[i];
	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	public String toString() {
		if(nombreInscrits==0)
			return "[]";
		String aRenvoyer = "["+tableParticipants[0];
		for (int i = 1; i < nombreInscrits; i++)
			aRenvoyer = aRenvoyer + ", " + this.tableParticipants[i];
		return aRenvoyer+"]";
	}



}