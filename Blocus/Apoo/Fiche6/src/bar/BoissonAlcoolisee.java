package bar;
public class BoissonAlcoolisee extends Boisson{
    private double degreAlcool;

    public BoissonAlcoolisee(String nom, int contenance, double prix, double degreAlcool) {
        super(nom, contenance, prix);
        this.degreAlcool = degreAlcool;
    }

    @Override
    public double getPrix() {
        return super.getPrix();
    }

    @Override
    public String toString() {
        return super.toString() + "(degré d'alcool : " + degreAlcool + "°)" + "\n";
    }
}
