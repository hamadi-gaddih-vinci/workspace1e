public class DVD extends Produit{
    private String titre;
    private String realisateur;

    public DVD(String reference, double prix, String titre, String realisateur) {
        super(reference, prix);
        this.titre = titre;
        this.realisateur = realisateur;
    }

    public String getTitre() {
        return titre;
    }

    public String getRealisateur() {
        return realisateur;
    }
    public String toString(){
        return "Produit : DVD" + "\n" +
                "Titre : " + getTitre() + "\n" +
                "Réalisateur : " + getRealisateur() + "\n" +
                "Référence : " + getReference() + "\n" +
                "Prix : " + getPrix() + "€";
    }
}
