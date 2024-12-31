public class DVDs extends Produit{
    private String titre;
    public String realisateur;

    public DVDs(String reference, double prix, String titre, String realisateur){
        super(reference, prix);
        if(titre == null || titre.equals("")){
            throw new IllegalArgumentException();
        }
        if(reference == null || realisateur.equals("")){
            throw new IllegalArgumentException();
        }
        this.realisateur = realisateur;
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public String getRealisateur() {
        return realisateur;
    }
}
