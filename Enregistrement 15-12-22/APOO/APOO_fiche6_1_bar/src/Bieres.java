public class Bieres extends BoissonAlcoolisees{
    private boolean pression;

    public Bieres(String nom, String contenance, double prix, String degresAlcool, boolean pression){
        super(nom, contenance, prix, degresAlcool);
        this.pression = pression;
    }

    public boolean isPression() {
          return pression;
    }

    @Override
    public String toString() {
        return super.toString() + "Bieres{" + "pression=" + pression + '}';
    }
}
