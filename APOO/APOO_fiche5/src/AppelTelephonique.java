import java.time.Duration;
import java.time.LocalDateTime;

public class AppelTelephonique {
    public static double tarifParDefaut = 0.15;
    private LocalDateTime dateHeure;
    private String numero;
    private Duration duree;
    private double tarif;

    public AppelTelephonique(LocalDateTime dateHeure, String numero, Duration duree, double tarif) {
        if (dateHeure == null)
            throw new IllegalArgumentException("La date et/ou l'heure de l'appel ne peuvent pas être null");
        if (dateHeure.isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException("La date et/ou l'heure de l'appel doivent être passées");
        if (numero == null || numero.isEmpty())
            throw new IllegalArgumentException("Le numéro ne peut pas être null ou vide");
        if (duree == null)
            throw new IllegalArgumentException("La durée ne peut pas être null");
        if (duree.isNegative() || duree.isZero())
            throw new IllegalArgumentException("La durée ne peut pas être inférieur ou égal à zéro");
        if (tarif <= 0)
            throw new IllegalArgumentException("Le tarif ne peut pas être inférieur ou égal à zéro");
        this.dateHeure = dateHeure;
        this.numero = numero;
        this.duree = duree;
        this.tarif = tarif;
    }

    public AppelTelephonique(LocalDateTime dateHeure, String numero, Duration duree) {
       this(dateHeure,numero,duree,tarifParDefaut);
    }


    public static double getTarifParDefaut() {
        return tarifParDefaut;
    }

    public static void setTarifParDefaut(double tarifParDefaut) {

        AppelTelephonique.tarifParDefaut = tarifParDefaut;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public String getNumero() {
        return numero;
    }

    public Duration getDuree() {
        return duree;
    }

    public double getTarif() {
        return tarif;
    }

}
