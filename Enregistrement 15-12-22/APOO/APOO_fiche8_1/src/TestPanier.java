public class TestPanier {
    public static void main(String[] args)  {
        Panier panier = new Panier();
        Livre livre1 = new Livre("123", 10, "null","null", 12);
        try {
            System.out.println("Suppression livre1 du panier:" + panier.supprimer(livre1));
        } catch (ProduitNonPresentException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("Supression 'Nul' du panier:" + panier.supprimer(null));
        } catch (ProduitNonPresentException e) {
            throw new RuntimeException(e);
        }
          catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
          }

        try {
            System.out.println("Chercher le produit de référence 123 dans le panier:" + panier.chercherProduit("123"));
        } catch (ProduitNonPresentException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("Chercer produit de reference null dans le panier:" + panier.chercherProduit(null));
        } catch (ProduitNonPresentException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

        try {
            System.out.println("Ajouter nul au panier:" + panier.ajouter(null));
        } catch (PanierPleinException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

        try {
            System.out.println("Ajout du livre1 au panier:" + panier.ajouter(livre1));
        } catch (PanierPleinException e) {
            throw new RuntimeException(e);
        }



    }
}
