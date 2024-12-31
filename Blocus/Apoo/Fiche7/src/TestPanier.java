import java.util.ArrayList;

public class TestPanier {
    public static void main(String[] args) {
        Panier panier = new Panier(new ArrayList<>());
        Livre livre1 = new Livre("1",10,"A","AB",10);
        Livre livre2 = new Livre("2",20,"B","BC", 20);
        DVD dvd1 = new DVD("10",30,"C","CD");
        panier.ajouter(livre1);
        panier.ajouter(livre2);
        panier.ajouter(dvd1);
        System.out.println(panier.toString());
        System.out.print("Le nombre de produits est de : " + panier.nombreDeProduit());
        System.out.print("Le prix total est de : " + panier.calculerPrixTotal() + "\n");

    }
}
