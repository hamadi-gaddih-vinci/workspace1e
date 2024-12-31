public class BoissonAlcoolisees extends Boisson {
    private String degresAlcool;

    public BoissonAlcoolisees(String nom, String contenance, double prix, String degresAlcool){
        super(nom, contenance, prix);
        this.degresAlcool = degresAlcool;
    }

    public String getDegresAlcool() {
        return degresAlcool;
    }


    @Override
    public String toString() {
        return super.toString() + "degresAlcool=" + degresAlcool + '°' + '\'' +
                '}';
    }
}

