
public class TableauJeuDeLaVie {

	private boolean[][] table;
	private int longueur; 	// nb colonnes
	private int largeur; 	// nb lignes

	/**
	 * Cree un tableau sans aucune cellule vivante.
	 * @param longueur
	 * @param largeur
	 */
	public TableauJeuDeLaVie(int largeur, int longueur) {
		table = new boolean[largeur][longueur];
		this.largeur = largeur;
		this.longueur = longueur;
	}

	public void setXY(int x, int y, boolean enVie){
		table[x][y] = enVie;
	}

	public boolean getXY(int x, int y){
		return table[x][y];
	}

	/**
	 * Calcule le nombre de voisines vivantes de la cellule x, y
	 * @param x
	 * @return Le nombre de voisines vivantes
	 */
	public int nbVoisines(int x, int y){
			int nombreVoisin = 0;
			// Parcourt toutes les positions autour de la cellule (x, y)
			for (int i = x - 1; i <= x + 1; i++) {
				for (int j = y - 1; j <= y + 1; j++) {
					// Vérifie que la position actuelle n'est pas la cellule (x, y) elle-même
					// et qu'elle se trouve dans les limites du tableau
					if (i != x || j != y) {
						if (i >= 0 && i < largeur && j >= 0 && j < longueur && table[i][j]) {
							nombreVoisin++;
						}
					}
				}
			}
			return nombreVoisin;
		}

		//Ma formule
		//int nombreVoisin = 0;
		//if (x-1 >= 0 && y-1 >=0 && table[x-1][y-1]) nombreVoisin ++;
		//if (x-1 >= 0 && table[x-1][y]) nombreVoisin ++;
		//if (x-1 >= 0 && y+1 < longueur  && table[x-1][y+1]) nombreVoisin ++;
		//if (y-1>= 0 && table[x][y-1]) nombreVoisin ++;
		//if (y+1 < longueur && table[x][y+1]) nombreVoisin ++;
		//if (x+1 < largeur && y-1 >= 0 && table[x+1][y-1]) nombreVoisin ++;
		//if (x+1 < largeur && table[x+1][y]) nombreVoisin ++;
		//if (x+1 < largeur && y+1 < largeur && table[x+1][y+1]) nombreVoisin ++;
		// TODO
		//return nombreVoisin;


	/**
	 * Calcule l'etat d'une cellule a la generation suivante.
	 * Les regles suivantes sont appliquees:
	 * - Une cellule morte possedant exactement trois voisines vivantes devient vivante (elle nait).
	 * - Une cellule vivante possedant deux ou trois voisines vivantes le reste, sinon elle meurt.
	 * @param x
	 * @param y
	 * @return true si la cellule en x, y sera en vie a la generation suivante
	 */
	private boolean enVieGenerationSuivante(int x, int y) {
		int nombreVoisin = nbVoisines(x, y); //récupère le nombre de voisines vivantes

		if (table[x][y]) { //<--Signifie si la cellule est vivante
			// Si la cellule est vivante, elle meurt si elle
			// a moins de 2 ou plus de 3 voisines vivantes
			if (nombreVoisin == 2 || nombreVoisin == 3)
				return true;
		}
			else if (nombreVoisin == 3) {
				return true;
				//Signfie Si la cellule est morte,
				// elle naît si elle a exactement 3 voisines vivantes
			}
			// TODO
		return false;
	}


	/**
	 * Calcule le tableau de jeu a la generation suivante
	 * en faisant vivre, mourir et naitre des cellules.
	 */
	public void generationSuivante(){
		boolean [][] tableBis = new boolean[largeur][longueur];
		// création d'une copie du tableau
		// tableau pour la génération suivante

		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {

				// Détermine si la cellule en position (i, j)
				// doit être vivante ou morte à la génération suivante
				boolean enVie = enVieGenerationSuivante(i, j);

				// Met à jour l'état de la cellule dans le nouveau tableau
				tableBis[i][j] = enVie;
			}

		}
		// remplace le tableau courant par le nouveau tableau (tableBis)
		table = tableBis;
		// TODO
		// Il est indispensable de travailler avec une copie de la table
	}
	
}