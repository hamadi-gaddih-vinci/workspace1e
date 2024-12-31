package magIPL;

public class Creature extends magIPL.Carte{
    private static int pointDeDegatParDefaut = 0;
    private static int pointDeVieParDefaut = 0;
    private String nom;
    private int pointDeVie;
    private int pointDeDegat;

    public Creature(int cout, String nom, int pointDeVie, int pointDeDegat) {
        super(cout);
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.pointDeDegat = pointDeDegat;
    }

    public Creature(int cout, String nom) {
        super(cout);
        this.nom = nom;
    }

    public static int getPointDeDegatParDefaut() {
        return pointDeDegatParDefaut;
    }

    public static int getPointDeVieParDefaut() {
        return pointDeVieParDefaut;
    }

    public String getNom() {
        return nom;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public int getPointDeDegat() {
        return pointDeDegat;
    }
    public String fournirDetail(){
        return "Créature - " + super.fournirDetail() + getCout() + " nom : " + nom + '(' + pointDeDegat + '/' + pointDeVie + ')';
    }
}
