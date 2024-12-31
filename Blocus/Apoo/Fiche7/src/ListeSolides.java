import java.util.ArrayList;
import java.util.Iterator;

public class ListeSolides implements Iterable<Solide>{
    private ArrayList <Solide> solides;

    public ListeSolides() {
        this.solides = new ArrayList<Solide>();
    }
    public boolean estVide(){
        return solides.isEmpty();
    }
    public int nombreSolide() {
        return this.solides.size();
    }
    public boolean contient(Solide solide){
        return this.solides.contains(solide);
    }
    public boolean ajouter(Solide solide){
        if (contient(solide))
            return false;
        return this.solides.add(solide);
    }
    public boolean supprimer(Solide solide){
        if (!contient(solide))
            return false;
        return this.solides.remove(solide);
    }
    public ArrayList <Solide> plusGrandVolume(){
        ArrayList <Solide> plusGrand  = new ArrayList<>();
        double maxVolume = 0;
        for (Solide s : solides) {
           double volume = s.calculerVolume();
           if (volume > maxVolume){
               maxVolume = volume;
               plusGrand.clear();
               plusGrand.add(s);
           }
           else if (volume == maxVolume){
               plusGrand.add(s);
           }
        } return plusGrand;
    }

    @Override
    public Iterator<Solide> iterator() {
        return solides.iterator();
    }
    public String toString (){
        String texte = "Listes des solides : " + "\n";
        for (Solide solide: solides) {
            texte += solide;
        } return texte;
    }
}
