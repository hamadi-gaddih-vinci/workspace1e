import java.time.LocalDate;

public class Utilitaire extends Vehicule {

    public static final int KM_ENTRE_DEUX_CONTROLE_TECHNIQUE_PAR_DEFAUT = 50000;
    private int kmEntreCT;
    private double kmAuDernierCT;

    public Utilitaire(String immatriculation, LocalDate dateMiseEnCirculation){
        super(immatriculation, dateMiseEnCirculation);
    }
    public Utilitaire(String immatriculation, LocalDate dateMiseEnCirculation, int kmEntreCT, double kmAuDernierCT){
        super(immatriculation, dateMiseEnCirculation);
    }

    public int getKmEntreCT() {
        return kmEntreCT;
    }

    public double getKmAuDernierCT() {
        return kmAuDernierCT;
    }

    public void setKmAuDernierCT(double kmAuDernierCT) {
        this.kmAuDernierCT = kmAuDernierCT;
    }

    @Override
    public boolean EstEnOrdre() {
        if (kmEntreCT>KM_ENTRE_DEUX_CONTROLE_TECHNIQUE_PAR_DEFAUT)
            return false;
        return true;
    }
}
