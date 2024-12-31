import java.time.LocalDate;

public class Utilitaire extends Vehicule {
    private static final int KM_PAR_DEFAUT = 5000;
    private int kmEntreCt;
    private double kmAuDernierCt;

    public Utilitaire(String immatriculation, LocalDate dateMiseEnCircut, int kmEntreCt) {
        super(immatriculation, dateMiseEnCircut);
    }

    public Utilitaire(String immatriculation, LocalDate dateMiseEnCircut) {
        super(immatriculation, dateMiseEnCircut);
    }

    public int getKmEntreCt() {
        return kmEntreCt;
    }

    public double getKmAuDernierCt() {
        return kmAuDernierCt;
    }

    public void setKmAuDernierCt(double kmAuDernierCt) {
        this.kmAuDernierCt = kmAuDernierCt;
    }

    @Override
    public boolean enOrdre() {
        if (getKm()>KM_PAR_DEFAUT)
            return false;
        return true;
    }
}
