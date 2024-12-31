package bar;
public class Vin extends BoissonAlcoolisee{
    private static final String[] COULEURS_AUTORISEES = {"rouge", "blanc", "rosé"};
    private String cepage;
    private String couleur;
    private String region;
    private String paysDOrigine;

    public Vin(String nom, int contenance, double prix, double degreAlcool, String cepage, String couleur, String region, String paysDOrigine) {
        super(nom, contenance, prix, degreAlcool);
        this.cepage = cepage;
        this.couleur = couleur;
        this.region = region;
        this.paysDOrigine = paysDOrigine;
        if (couleur == null)
            throw new IllegalArgumentException("La couleur doit être choisie parmi les valeurs suivantes : rouge, blanc, rosé");
        if (!couleur.equals("rouge") && !couleur.equals("blanc") && !couleur.equals("rosé"))
            throw new IllegalArgumentException("La couleur doit être choisie parmi les valeurs suivantes : rouge, blanc, rosé");
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
    public String [] getCouleursAutorisees (){
        return COULEURS_AUTORISEES;
    }

    @Override
    public String toString() {
        return "Vin " + couleur + " : " + super.toString() + "\n"+
                "Cepage : " + cepage + "\n"+"Origine : " + region + " - " + paysDOrigine;

    }
}
