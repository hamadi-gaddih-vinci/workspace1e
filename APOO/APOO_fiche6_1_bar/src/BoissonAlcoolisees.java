public class BoissonAlcoolisees extends Boisson {
    private double degresAlcool;

    public BoissonAlcoolisees(String nom, int contenance, double prix, double degresAlcool){
        super(nom, contenance, prix);
        this.degresAlcool = degresAlcool;
    }

    public double getDegresAlcool() {
        return degresAlcool;
    }


    @Override
    public String toString() {
        return super.toString() + "(degresAlcool : " + degresAlcool + '°' + ")";
    }
}

