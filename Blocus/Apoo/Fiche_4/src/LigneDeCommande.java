public class LigneDeCommande {
    private Article article;
    private int quantite;

    public LigneDeCommande(Article article) {
        this.article = article;
        quantite = 1;
    }

    public LigneDeCommande(Article article, int quantite) {
        this.article = article;
        setQuantite(quantite);
    }

    public Article getArticle() {
        return article;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public double caluculerPrixTotalTVAC(){
       return this.article.calculerPrixTVAComprise()*this.quantite;
    }

    @Override
    public String toString() {
        return "Quantité : " + this.quantite + "\n" + this.article.toString() + "\n" + "Le prix est de : " + this.caluculerPrixTotalTVAC() + "€" + "\n";
    }
}