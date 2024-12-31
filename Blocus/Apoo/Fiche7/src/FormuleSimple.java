import java.time.LocalDate;

public class FormuleSimple extends FormuleDeVacance{
    private Vol volAller;
    private Vol volRetour;

    public FormuleSimple(LocalDate dateDepart, int duree, Vol volAller, Vol volRetour) {
        super(dateDepart, duree);
        this.volAller = volAller;
        this.volRetour = volRetour;
    }

    @Override
    public double trouverPrix() {
        return volAller.getPrix() + volRetour.getPrix();
    }

    public Vol getVolAller() {
        return volAller;
    }

    public Vol getVolRetour() {
        return volRetour;
    }
    public String toString(){
        return  super.toString() + "Vol aller : " + volAller + "\n" +
                "Vol retour : " + volRetour + "\n" +
                "Prix : " + trouverPrix() + "€" + "\n";
    }
}
