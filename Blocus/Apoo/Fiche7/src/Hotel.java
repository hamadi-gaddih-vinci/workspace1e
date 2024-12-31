public class Hotel {
    private String nom;
    private double nombreEtoile;
    private double prixParNuit;

    public Hotel(String nom, double nombreEtoile, double prixParNuit) {
        this.nom = nom;
        this.nombreEtoile = nombreEtoile;
        this.prixParNuit = prixParNuit;
    }

    public String getNom() {
        return nom;
    }

    public double getNombreEtoile() {
        return nombreEtoile;
    }

    public double getPrixParNuit() {
        return prixParNuit;
    }
    public String toString(){
        return "Nom : " + nom + "\n" +
                "Nombre d'étoile : " + nombreEtoile + "\n" +
                "Prix pour une nuit : " + prixParNuit;
    }
}
