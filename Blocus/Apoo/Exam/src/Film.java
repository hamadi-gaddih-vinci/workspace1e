public class Film extends ContenuVideo{
    private int duree;
    private long recettes;

    public Film(String titre, String categorie, int duree, long recettes) {
        super(titre, categorie);
        setDuree(duree);
        setRecettes(recettes);
    }

    public Film(String titre, String categorie, int duree) {
        this(titre,categorie,duree,0);
    }

    public void setDuree(int duree) {
        if (duree <= 0)
            throw new IllegalArgumentException("Durée invalide");
        this.duree = duree;
    }

    public void setRecettes(long recettes) {
        if (recettes < 0)
            throw new IllegalArgumentException("Recette invalide");
        this.recettes = recettes;
    }

    @Override
    public String toString() {
        return "Film " + super.toString() + ", durée=" + duree +
                ", recettes=" + recettes + ']' + "\n";
    }
}
