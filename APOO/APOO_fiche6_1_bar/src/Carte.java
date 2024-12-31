import java.util.ArrayList;

public class Carte {
    private ArrayList<Boisson> boissons;

    public Carte() {
        boissons = new ArrayList<Boisson>();
    }

    public boolean ajouter(Boisson boisson) {
        if (boissons.contains(boisson)) return false;
        return boissons.add(boisson);

    }
    public boolean retirer(Boisson boisson){
        return boissons.remove(boisson);
    }
    public boolean estPresent(Boisson boisson){
        return boissons.contains(boisson);
    }
    public int nbreBoisson(){
        return boissons.size();
    }
}