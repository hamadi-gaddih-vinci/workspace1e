import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class VoyageOrganiser extends FormuleDeVacance implements Iterable<Etape>{
    private double prix;
    private String nom;
    private ArrayList <Etape> listeEtapes;

    public VoyageOrganiser(LocalDate dateDepart, int duree, double prix, String nom, ArrayList<Etape> listeEtapes) {
        super(dateDepart, duree);
        this.prix = prix;
        this.nom = nom;
        this.listeEtapes = new ArrayList<>();
    }
    public boolean ajouter(Etape etape){
        return this.listeEtapes.add(etape);
    }
    public boolean supprimer(Etape etape){
        return this.listeEtapes.remove(etape);
    }


    public double getPrix() {
        return prix;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public Iterator<Etape> iterator() {
        return listeEtapes.iterator();
    }

    @Override
    public double trouverPrix() {
        return prix;
    }
    public String toString(){
        return super.toString() + "Nom : " + nom + "\n" +
                "Prix : " + prix + "Liste d'étape : " +
                listeEtapes.toString();
    }
}
