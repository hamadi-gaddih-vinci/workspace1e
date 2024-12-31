import java.util.ArrayList;

public class Bateau {
    private String nom;
    private int nombreCabine;
    private ArrayList<String> activites;

    public Bateau(String nom, int nombreCabine, ArrayList<String> activites) {
        this.nom = nom;
        this.nombreCabine = nombreCabine;
        this.activites = new ArrayList<>();
    }
    public boolean ajouter(String activite){
        return this.activites.add(activite);
    }
    public boolean supprimer(String activite){
        return this.activites.remove(activite);
    }

    public String getNom() {
        return nom;
    }

    public int getNombreCabine() {
        return nombreCabine;
    }
    public String toString (){
        return "Nom : " + nom + "\n" + "Nombre cabines : " + nombreCabine + "\n" +
                "Liste d'activitées : " + activites.toString();
    }
}
