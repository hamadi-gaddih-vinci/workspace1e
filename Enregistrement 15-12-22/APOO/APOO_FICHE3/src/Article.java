public class Article {

    private String reference;
    private String nom;

    private String description;
    private double prixHTVA;
    private double tauxTVA;

    public Article(String reference, String nom, String description, double prixHTVA, double tauxTVA){
        this.reference = reference;
        this.nom = nom;
        this.description = description;
        this.prixHTVA = prixHTVA;
        this.tauxTVA = tauxTVA;

    }
    public Article(String reference, String nom, String description, double prixHTVA){
        this.reference = reference;
        this.nom = nom;
        this.description = description;
        this.prixHTVA = prixHTVA;
    }

    public String getReference() {
        return reference;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getPrixHTVA() {
        return prixHTVA;
    }

    public double getTauxTVA() {
        return tauxTVA;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrixHTVA(double prixHTVA) {
        this.prixHTVA = prixHTVA;
    }

    public void setTauxTVA(double tauxTVA) {
        this.tauxTVA = tauxTVA;
    }

    @Override
    public String toString() {
        return "Article{" +
                "reference='" + reference + '\'' +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prixHTVA=" + prixHTVA +
                ", tauxTVA=" + tauxTVA +
                '}';
    }
    public double CalculerPrixTVAComprise(){
        return prixHTVA*1.21;
    }
    public double CalculerPrixTVAComprise(int reduction){
        return (prixHTVA*1.21 - (prixHTVA*1.21)*reduction/100);
    }

}

