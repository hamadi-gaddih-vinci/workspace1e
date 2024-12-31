import java.time.LocalDate;
import java.util.Objects;

public abstract class Vehicule {
    private String immatriculation;
    private LocalDate dateMiseEnCircut;
    private LocalDate dateDernierCT;
    private double km;

    public Vehicule(String immatriculation, LocalDate dateMiseEnCircut) {
        this.immatriculation = immatriculation;
        this.dateMiseEnCircut = dateMiseEnCircut;
    }
    abstract public boolean enOrdre();

    public String getImmatriculation() {
        return immatriculation;
    }

    public LocalDate getDateMiseEnCircut() {
        return dateMiseEnCircut;
    }

    public LocalDate getDateDernierCT() {
        return dateDernierCT;
    }

    public double getKm() {
        return km;
    }

    public void setDateDernierCT(LocalDate dateDernierCT) {
        this.dateDernierCT = dateDernierCT;
    }

    public void setKm(double km) {
        this.km = km;
    }

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
