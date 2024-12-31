import java.util.ArrayList;
import java.util.Objects;

public class Catalogue {
    private ArrayList<Livre> livres;

    public Catalogue() {
        livres = new ArrayList<Livre>();
    }

    public boolean contient(Livre livre) {
        return livres.contains(livre);

    }

    public boolean ajouter(Livre livre) {
        if (contient(livre)) return false;
        return livres.add(livre);
    }

    public boolean retirer(Livre livre) {
        return livres.remove(livre);
    }


    public int nombreDeLivres() {
        return livres.size();
    }


    public String toString() {
        String texte = "liste des livres : ";
            for (Livre l : livres) {
            texte += "n" + l.toString();
        }
        return texte;

    }

    public boolean vide() {
        if (livres != null) System.out.println("Le catalogue est vide");
        return false;

    }



    public Livre chercherLivre(String isbn) {
        for (Livre livre :livres) {
        if (livre.getIsbn().equals(isbn)) return livre;
        }
        return null;
    }
}

