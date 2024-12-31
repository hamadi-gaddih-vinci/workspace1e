import java.time.LocalDate;
import java.util.Objects;

public abstract class Vehicule{
    private String immatriculation;
    private LocalDate dateMiseEnCirculation;
    private LocalDate dateDernierControleTechnique;
    private double kilometrage;

    public Vehicule(String immatriculation, LocalDate dateMiseEnCirculation){
        this.immatriculation = immatriculation;
        this.dateMiseEnCirculation = dateMiseEnCirculation;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public LocalDate getDateMiseEnCirculation() {
        return dateMiseEnCirculation;
    }

    public LocalDate getDateDernierControleTechnique() {
        return dateDernierControleTechnique;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setDateDernierControleTechnique(LocalDate dateDernierControleTechnique) {
        this.dateDernierControleTechnique = dateDernierControleTechnique;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public abstract boolean EstEnOrdre();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return Objects.equals(immatriculation, vehicule.immatriculation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(immatriculation);
    }
}