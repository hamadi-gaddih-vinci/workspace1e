import java.util.ArrayList;

public class Catalogue {
    private ArrayList<Livre> livres;

    public Catalogue() {
        this.livres = new ArrayList<>();
    }
    public boolean contient(Livre livre) {
        return livres.contains(livre);
    }
    public boolean ajouter(Livre livre){
        if (!contient(livre))
            return livres.add(livre);
        return false;
    }
    public boolean retirer(Livre livre){
        if (contient(livre))
            return livres.remove(livre);
        return false;
    }
    public int nombreDeLivres(){
        return livres.size();
    }
    public boolean estVide(){
        return nombreDeLivres() == 0;

    }
    public Livre chercherLivre(String isbn){
        for (Livre livre:livres) {
            if (livre.getIsbn().equals(isbn))
                return livre;
        }
        return null;
    }

    @Override
    public String toString() {
        String texte = "Liste des livres : ";
        for (Livre l: livres) {
            texte += "\n" + l.toString();
        }
        return texte;
    }
}
