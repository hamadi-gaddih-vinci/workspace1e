import java.util.ArrayList;
import java.util.Iterator;

public class Panier implements Iterable<Produit>{
    private ArrayList<Produit> listeProduits;

    public Panier(ArrayList<Produit> listeProduits) {
        this.listeProduits = new ArrayList<>();
    }
    public boolean contient (Produit produit){
        return this.listeProduits.contains(produit);
    }
    public boolean ajouter(Produit produit){
        if (contient(produit))
            return false;
        return this.listeProduits.add(produit);
    }
    public boolean supprimer(Produit produit){
        if (!contient(produit))
            return false;
        return this.listeProduits.remove(produit);
    }
    public int nombreDeProduit(){
        return this.listeProduits.size();
    }
    public double calculerPrixTotal(){
        double somme = 0;
        for (Produit p: listeProduits) {
            somme += p.getPrix();
        } return somme;
    }
    public String toString(){
        String texte = "Liste des produits : " + "\n";
        for (Produit p: listeProduits) {
            texte += p.toString() + "\n";
        } return texte;
    }
    public boolean trouverProduit(String reference){
        for (Produit p: listeProduits) {
            if (p.getReference().equals(reference))
                return true;
            break;
        } return false;
    }

    @Override
    public Iterator<Produit> iterator() {
        return listeProduits.iterator();
    }
}
