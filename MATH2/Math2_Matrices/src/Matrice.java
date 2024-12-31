 public class Matrice {
    private final int nbLignes;              // nombre de lignes
    private final int nbColonnes;            // nombre de colonnes
    private final double[][] data;           // matrice (nbLignes,nbColonnes)

    // ce constructeur cree la matrice nulle de genre (a,b)
    public Matrice(int a, int b) throws IllegalArgumentException { 
    	//TODO : Les lignes ci-dessous sont là uniquement pour qu'il n'y ait pas d'erreur. Elles doivent être modifiées
        if (a <= 0 || b <= 0)
            throw new IllegalArgumentException();
        this.nbLignes = a;
        this.nbColonnes = b;
        this.data = new double[nbLignes][nbColonnes];
    }

    //  Ce constructeur permet de construire la matrice correspondant 
    //  au tableau en parametre. 
    public Matrice(double[][] tab)  throws IllegalArgumentException {
        //TODO : La ligne suivante est là uniquement pour qu'il n'y ait pas d'erreur. Elle doit être modifiée ou supprimée
        if (tab == null || tab.length <= 0)
            throw new IllegalArgumentException();
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == null || tab[i].length <= 0)
                throw new IllegalArgumentException();
        }
        this.nbLignes = tab.length;
        this.nbColonnes = tab[0].length;
        this.data = new double[nbLignes][nbColonnes];
        for (int i = 0; i < nbLignes; i++) {
            if (tab[i].length != nbColonnes)
                throw new IllegalArgumentException();
            System.arraycopy(tab[i], 0, this.data[i], 0, nbColonnes);
        }

    }
    // constructeur par recopie
    public Matrice(Matrice a)  throws IllegalArgumentException {
        //TODO : La ligne suivante est là uniquement pour qu'il n'y ait pas d'erreur. Elle doit être modifiée ou supprimée
    	this(1,1);
	}

    // cree la matrice identite d'ordre a
    public static Matrice identite(int a)  throws IllegalArgumentException {
    	//TODO
    	return null;
    }
    
    //Cette methode renvoie l'element de la ligne numLigne et de la 
    //colonne numColonne de la matrice. Si cet element n'existe pas, la 
    //methode lance une IllegalArgumentException 
	public double getElement(int numLigne, int numColonne)
			throws IllegalArgumentException {
		//TODO
		return 0;
	 }
    
    // ajoute b a la matrice courante si c'est possible
    public Matrice somme(Matrice b)  throws IllegalArgumentException {
    	//TODO
    	return null;
    }

    // calcule le produit scalaire.this de la matrice courante avec scalaire
    public Matrice produitParScalaire(double scalaire){
    	//TODO
    	return null;
    }

    // calcule le produit this*b de la matrice courante avec b si possible
    public Matrice produitAGauche(Matrice b)  throws IllegalArgumentException {
    	//TODO
    	return null;
    }
    
	// calcule le produit b*this de b avec la matrice courante si possible
    public Matrice produitADroite(Matrice b)  throws IllegalArgumentException {
    	//TODO
    	return null;
    }
	 
   // renvoie true si la matrice courante est carrée
	 public boolean carree(){
		//TODO
		 return false;
    }
    
    // Calcule this^n. Lance une Mathexception si this n'est pas carrée
    public Matrice puissance(int n) throws  IllegalArgumentException {
    	//TODO
    	return null;
    }
    
	//Calcule this^T : la tranposée de this
	public Matrice transposee() {
		//TODO
		return null ;
	}
	 
    // affiche la matrice en format standard
    public String toString(){
    	//TODO
    	return null;
    }

    public Matrice pageRank() {
        // A FAIRE QUAND MARKOV AURA ÉTÉ VU

        for (int i = 0; i < nbColonnes; i++) {
            for (int j = 0; j < this.nbLignes; j++) {
                if (this.data[i][j] != 0 && this.data[i][j] != 1)
                    throw new MathException();
            }
        }
        int cmp = 0;
        Matrice transition = new Matrice(nbLignes,nbColonnes);
        for (int colonne = 0; colonne < nbColonnes; colonne++) {
            for (int ligne = 0; ligne < this.nbLignes; ligne++) {
                if (this.data[ligne][colonne] == 1 )
                    cmp++;
            }
            if (cmp == 0){
            for (int ligne = 0; ligne < this.nbLignes; ligne++) {
                    transition.data[ligne][colonne]=1.0/nbLignes;
            }

            }
        }
    }
  }   
