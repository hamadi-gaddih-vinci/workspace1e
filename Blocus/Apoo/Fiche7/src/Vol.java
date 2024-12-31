import java.time.LocalDateTime;

public class Vol {
    private LocalDateTime dateHeureVol;
    private double prix;
    private String numero;
    private String aeroportDepart;
    private String aeroportArrive;

    public Vol(LocalDateTime dateHeureVol, double prix, String numero, String aeroportDepart, String aeroportArrive) {
        this.dateHeureVol = dateHeureVol;
        this.prix = prix;
        this.numero = numero;
        this.aeroportDepart = aeroportDepart;
        this.aeroportArrive = aeroportArrive;
    }

    public LocalDateTime getDateHeureVol() {
        return dateHeureVol;
    }

    public double getPrix() {
        return prix;
    }

    public String getNumero() {
        return numero;
    }

    public String getAeroportDepart() {
        return aeroportDepart;
    }

    public String getAeroportArrive() {
        return aeroportArrive;
    }
    public String toString(){
        return "Date et heure de vol : " + dateHeureVol + "\n" +
                "Prix : " + prix + "\n" +
                "Numéro de vol : " + numero + "\n" +
                "Aéroport de départ : " + aeroportDepart + "\n" +
                "Aéro^port d'arrivés : " + aeroportArrive;
    }
}
