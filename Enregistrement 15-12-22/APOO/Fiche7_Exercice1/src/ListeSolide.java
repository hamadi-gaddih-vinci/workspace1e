import java.util.ArrayList;
import java.util.Iterator;

public class ListeSolide implements Iterable<Solide>{
    private ArrayList<Solide> solides = new ArrayList<>();


    public ListeSolide(){

    }
    public boolean listeVide(){
        return solides.isEmpty();

    }
    public int nombreSolide(){
        return solides.size();
    }
    public boolean contientSolide(Solide solide){
       return solides.contains(solide);
    }
    public boolean ajouterSolide(Solide solide){
        if (contientSolide(solide)) return false;
        return solides.add(solide);
    }
    public boolean retirerSolide(Solide solide){
        return solides.remove(solide);
    }
    public ArrayList <Solide> trouverPlusGrandVolume(){
        ArrayList<Solide> plusGrand = new ArrayList<>();
        double maxVolme = 0;
        for (Solide solide: solides) {
            double volume = solide.donnerVolume();
            if (volume > maxVolme){
                maxVolme = volume;
                plusGrand.clear();
                plusGrand.add(solide);
            }
            else if (volume == maxVolme){
                plusGrand.add(solide);
            }
        } return plusGrand;
    }


    @Override
    public Iterator<Solide> iterator() {
        return solides.iterator();
    }

    @Override
    public String toString() {
        return "ListeSolide :" + solides ;
    }

}
