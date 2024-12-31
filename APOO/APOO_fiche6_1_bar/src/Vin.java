public class Vin extends BoissonAlcoolisees {
    private String cepage;
    private String couleur;
    private final static String [] COULEUR_ACCEPTEES = {"Rouge", "Rosé", "Blanc"};
    private String region;
    private String paysDOrigine;

    public Vin(String nom, int contenance, double prix, double degresAlcool,
               String cepage, String couleur, String region, String paysDOrigine){
        super(nom, contenance, prix, degresAlcool);
        this.cepage = cepage;
        this.couleur = couleur;
        this.region = region;
        this.paysDOrigine = paysDOrigine;

        if (couleur == null)
            throw new IllegalArgumentException("Veuillez inscrire une couleur valide");
        for (String couleurAcceptee : COULEUR_ACCEPTEES) {
            if (couleur.equals(couleurAcceptee)) {
                this.couleur = couleur;
                break;
            }

        }
    }

    public String getCepage() {
        return cepage;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getRegion() {
        return region;
    }

    public String getPaysDOrigine() {
        return paysDOrigine;
    }

    public static String[] getCouleurAcceptees() {
        return COULEUR_ACCEPTEES;
    }

    @Override
    public String toString() {
        return super.toString() + "Vin{" +
                "cepage='" + cepage + '\'' +
                ", couleur='" + couleur + '\'' +
                ", region='" + region + '\'' +
                ", paysDOrigine='" + paysDOrigine + '\'' +
                '}';
    }
}
