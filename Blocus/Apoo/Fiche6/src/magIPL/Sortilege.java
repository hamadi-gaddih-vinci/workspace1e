package magIPL;

public class Sortilege extends magIPL.Carte{
    private String nom;
    private String explication;

    public Sortilege(int cout, String nom, String explication) {
        super(cout);
        this.nom = nom;
        this.explication = explication;
    }

    public String getNom() {
        return nom;
    }

    public String getExplication() {
        return explication;
    }
    public String fournirDetail(){
        return "Sortilege - " + super.fournirDetail() + getCout() + " nom : " + nom;
    }
}
