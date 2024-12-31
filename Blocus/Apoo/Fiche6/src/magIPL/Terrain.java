package magIPL;

public class Terrain extends magIPL.Carte {
    private static final int COUT = 0;
    private static final char [] COULEUR_AUTORISEE = {'B', 'b', 'n', 'r', 'v'};
    private static final char COULEUR_PAR_DEFAUT = 'i';
    private char couleur;

    public Terrain(int cout, char couleur) {
        super(cout = COUT);
        if (couleur == 'B' || couleur == 'b' || couleur == 'n' || couleur == 'r' || couleur == 'v')
            this.couleur = couleur;
        else this.couleur = 'i';
    }

    public char getCouleur() {
        return couleur;
    }
    public String fournirDetail(){
        return "Terrain - " + super.fournirDetail() + getCout() + "couleur : " + couleur;
    }
}
