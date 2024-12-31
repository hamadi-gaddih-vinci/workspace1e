public class Cds extends Produit{
    private String titre;
    private String artiste;
    private int nMorceaux;

    public Cds(String reference, double prix, String titre, String artiste, int nMorceaux){
        super(reference, prix);
        if(titre == null || titre.equals("")){
            throw new IllegalArgumentException();
        }
        if(artiste == null || artiste.equals("")){
            throw new IllegalArgumentException();
        }
        if(nMorceaux < 0){
            throw new IllegalArgumentException();
        }
        this.artiste = artiste;
        this.titre = titre;
        this.nMorceaux = nMorceaux;
    }

    public int getnMorceaux() {
        return nMorceaux;
    }

    public String getArtiste() {
        return artiste;
    }

    public String getTitre() {
        return titre;
    }
}
