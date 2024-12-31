
public class JeuBrutusLola {
	
	public static void main(String[] args){

		PlateauJeuBrutusLola jeu = new PlateauJeuBrutusLola();
		int positionBrutus = 1;
		jeu.placerBrutus(positionBrutus);


		int positionLola = 3;
		jeu.placerLola(positionLola);
		int lanceDe = jeu.lancerDe();
		boolean lolaSupprimer;
		jeu.afficherInformation("vas-y");
		if (positionLola>=16){
			positionLola = 16;
			jeu.supprimerLola();
			jeu.occuperNiche();
		}
		while (positionLola <16 || positionBrutus <= positionLola){
			jeu.supprimerLola();
			jeu.placerLola(positionLola + lanceDe);
			lanceDe = jeu.lancerDe();
			jeu.supprimerBrutus();
			jeu.placerBrutus(positionBrutus + lanceDe);
			positionBrutus = positionBrutus + lanceDe;
			lanceDe = jeu.lancerDe();
			} else if (positionBrutus == positionLola) {
				lolaSupprimer = true;
				jeu.supprimerLola();
				jeu.donnerOsABrutus();
				jeu.afficherInformation("Lola a disparu");

			}
		}



	}




}
