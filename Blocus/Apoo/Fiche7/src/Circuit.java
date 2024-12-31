import java.time.LocalDate;
import java.util.ArrayList;

public class Circuit extends VoyageOrganiser{
    private String description;

    public Circuit(LocalDate dateDepart, int duree, double prix, String nom, ArrayList<Etape> listeEtapes, String description) {
        super(dateDepart, duree, prix, nom, listeEtapes);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    public String toString(){
        return super.toString() + "\n" + "Descripition : " + description;
    }
}
