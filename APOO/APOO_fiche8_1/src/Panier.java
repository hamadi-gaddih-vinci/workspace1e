import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Panier {
    private ArrayList<Produit> produits;
    private static int nombreDeProduit;
    public static final int MAX_PRODUIT = 10;

    public Panier(){

        produits = new ArrayList<Produit>();
    }

    public int nombreProduit(){

        return this.produits.size();
    }

    public boolean ajouter(Produit produit) throws PanierPleinException{
        if (this.produits.size() == MAX_PRODUIT )
            throw new PanierPleinException();

        if(this.produits.contains(produit)){
            return false;
        }

        return this.produits.add(produit);
    }

    public boolean supprimer(Produit produit)throws ProduitNonPresentException{
        if ((!this.produits.contains(produit)))
            throw new ProduitNonPresentException();
        if (produit == null)
            throw new IllegalArgumentException();
        return this.produits.remove(produit);
    }

    public double calculerPrixTotal(){
        double total = 0;
        for (Produit p: produits) {
            if (p.getPrix() <0) throw new IllegalArgumentException();
            total += p.getPrix();
        }
        return total;

    }

    public Produit chercherProduit(String reference) throws ProduitNonPresentException{
        Produit produit = null;
        for (Produit p:produits) {
            if(Objects.equals(reference, p.getReference())){
                produit = p;
                return produit;
            }
        }
        throw new ProduitNonPresentException();

    }

    @Override
    public String toString() {
        String txt = "";
        for (Produit p : produits) {
            txt += p + "\n";
        }
        return txt;
    }
    public Iterator<Produit> iterator() {
        return produits.iterator();
    }
}
