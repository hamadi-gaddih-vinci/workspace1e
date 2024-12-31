public class Livre extends Produit {
    private String titre;
    private String auteur;
    private int nombrePage;

    public Livre(String reference, double prix, String titre, String auteur, int nombrePage) {
        super(reference, prix);
        this.titre = titre;
        this.auteur = auteur;
        this.nombrePage = nombrePage;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getNombrePage() {
        return nombrePage;
    }
    public String toString(){
        return "Produit : livre" + "\n" +
                "Titre : " + getTitre() + "\n" +
                "Auteur : " + getAuteur() + "\n" +
                "Référence : " + getReference() + "\n" +
                "Nombre de page : " + getNombrePage() + "\n" +
                "Prix : " + getPrix() + "€";

    }
}
