import java.time.LocalDate;
import java.util.ArrayList;

public class Croisiere extends VoyageOrganiser{
    private Bateau bateau;

    public Croisiere(LocalDate dateDepart, int duree, double prix, String nom, ArrayList<Etape> listeEtapes, Bateau bateau) {
        super(dateDepart, duree, prix, nom, listeEtapes);
        this.bateau = bateau;
    }

    public Bateau getBateau() {
        return bateau;
    }
    public String toString(){
        return super.toString() + "Bateau : " + bateau;
    }
}
