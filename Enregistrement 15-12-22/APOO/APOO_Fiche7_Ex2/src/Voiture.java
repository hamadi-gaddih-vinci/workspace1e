import java.time.LocalDate;

public class Voiture extends Vehicule {

    public static final int ANNEE_AVANT_CONTROLE_TECHNIQUE = 4;
    public static final int ANNEE_ENTRE_CONTROLE_TECHNIQUE = 1;

    public Voiture(String immatriculation, LocalDate dateMiseEnCirculation){
        super(immatriculation, dateMiseEnCirculation);
    }

    @Override
    public boolean EstEnOrdre() {
        if (getDateMiseEnCirculation().plusYears(ANNEE_AVANT_CONTROLE_TECHNIQUE).isAfter(LocalDate.now())
                && getDateDernierControleTechnique().plusYears(ANNEE_ENTRE_CONTROLE_TECHNIQUE).isAfter(LocalDate.now()))
            return true;
        return false;
    }
}
