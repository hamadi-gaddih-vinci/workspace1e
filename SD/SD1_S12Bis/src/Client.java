public class Client {

    private String nom;

    private static int priorite = 3;

    public Client(String nom, int priorite) {
        this.nom = nom;
        this.priorite = priorite;

    }

    public String getNom() {
        return nom;
    }

    public static int getPriorite() {
        return priorite;
    }
}
