import java.time.LocalDate;

public class Voiture extends Vehicule {
    private static final int DUREE_AVANT_PREMIER_CONTROLE = 4;
    private static final int DUREE_MAX_ENTRE_CT = 1;
    public Voiture(String immatriculation, LocalDate dateMiseEnCircut) {
        super(immatriculation, dateMiseEnCircut);
    }

    @Override
    public boolean enOrdre() {
        if (getDateMiseEnCircut().plusYears(DUREE_AVANT_PREMIER_CONTROLE).isAfter(LocalDate.now()) && getDateDernierCT().plusYears(DUREE_MAX_ENTRE_CT).isAfter(LocalDate.now()))
            return true;
        return false;
    }
}
