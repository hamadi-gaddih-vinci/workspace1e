package bar;
import java.util.ArrayList;
public class CarteBoisson {
    private ArrayList <Boisson> boissons;

    public CarteBoisson() {
        this.boissons = new ArrayList<Boisson>();
    }
    public boolean estPresent(Boisson boisson){
        return boissons.contains(boisson);
    }
    public boolean ajouter(Boisson boisson){
        if (estPresent(boisson))
            return false;
        return boissons.add(boisson);

    }
    public boolean retirer(Boisson boisson){
        if (!estPresent(boisson))
            return false;
        return boissons.remove(boisson);
    }
    public int nombreBoisson(){
       return boissons.size();
    }

    @Override
    public String toString() {
        String texte = "Carte :" + "\n";
        for (Boisson boisson: boissons) {
            texte += boisson.toString();
        } return texte;
    }
}