public class Livre extends Produit{
    private String titre;
    private String auteur;
    private int nPage;

    public Livre(String reference, double prix, String titre, String auteur, int nPage){
        super(reference, prix);
        if(titre == null || titre.equals("")){
            throw new IllegalArgumentException();
        }
        if(auteur == null || auteur.equals("")){
            throw new IllegalArgumentException();
        }
        if(nPage <= 0){
            throw new IllegalArgumentException();
        }
        this.titre = titre;
        this.auteur = auteur;
        this.nPage = nPage;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getnPage() {
        return nPage;
    }
}
