public class TestArticle {
    public static void main(String[] args) {
        try {
            Article a1 = new Article(null, "Article 1", "Description 1", 10, 21);  // référence null
            System.out.println("Erreur : référence null acceptée");  // ne doit pas être exécuté
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // affiche "Référence invalide"
        }

        try {
            Article a2 = new Article("", "Article 2", "Description 2", 10, 21);  // référence vide
            System.out.println("Erreur : référence vide acceptée");  // ne doit pas être exécuté
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // affiche "Référence invalide"
        }

        try {
            Article a3 = new Article("ref3", null, "Description 3", 10, 21);  // nom null
            System.out.println("Erreur : nom null accepté");  // ne doit pas être exécuté
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // affiche "Nom invalide"
        }

        try {
            Article a4 = new Article("ref4", "", "Description 4", 10, 21);  // nom vide
            System.out.println("Erreur : nom vide accepté");  // ne doit pas être exécuté
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // affiche "Nom invalide"
        }

        try {
            Article a5 = new Article("ref5", "Article 5", "Description 5", -10, 21);  // prix négatif
            System.out.println("Erreur : prix négatif accepté");  // ne doit pas être exécuté
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // affiche "Prix invalide"
        }

        try {
            Article a6 = new Article("ref6", "Article 6", "Description 6", 10, -21);  // taux de TVA négatif
            System.out.println("Erreur : taux de TVA négatif accepté");  // ne doit pas être exécuté
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // affiche "Taux de Tva invalide"
        }
    }

}