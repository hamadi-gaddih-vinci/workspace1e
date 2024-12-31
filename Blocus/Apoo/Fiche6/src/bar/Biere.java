package bar;
public class Biere extends bar.BoissonAlcoolisee{
    private boolean pression;

    public Biere(String nom, int contenance, double prix, double degreAlcool, boolean pression) {
        super(nom, contenance, prix, degreAlcool);
        this.pression = pression;
    }

    public boolean isPression() {
        return pression;
    }

    public String toString(){
        String texte = "Bière ";
        if (pression) {
            texte += "pression : ";
        }
        else {
            texte += "en bouteille : ";
        }
        texte += super.toString();

        return texte;
    }
}
