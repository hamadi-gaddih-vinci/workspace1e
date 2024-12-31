import java.util.ArrayList;

public class TestCommande {
	public static void main(String[] args) {
		// Création des articles
		Article article1 = new Article("Lad700", "lapierre tecnic 700 lady", "Géométrie adaptée, composants et design spécifiques ont guidé la conception de notre gamme de VTT femme", 899);
		Article article2 = new Article("TandFit", "lapierre tandem route 2 race fit", "le vélo tandem, ludique, convivial et performant", 1785, 23);

		// Création de la première commande
		Commande commande1 = new Commande();
		commande1.ajouter(article1, 1); // Ajout d'un vélo de femme à la commande
		commande1.ajouter(article2, 1); // Ajout d'un tandem à la commande
		commande1.ajouter(article1, 2); // Ajout de deux autres vélos de femme à la commande

		// Création de la deuxième commande
		Commande commande2 = new Commande();
		commande2.ajouter(article2, 1); // Ajout d'un tandem à la commande

		// Affichage des commandes
		System.out.println(commande1.toString());
		System.out.println(commande2.toString());

		// Test de la méthode supprimer
		commande1.supprimer(article1); // Suppression de tous les vélos de femme de la commande
		System.out.println(commande1.toString()); // La commande ne doit plus contenir de vélos de femme

		// Test de la méthode modifierQuantite
		commande2.modifierQuantite(article2, 2); // Modification de la quantité de tandem dans la commande à 2
		System.out.println(commande2.toString()); // La commande doit contenir 2 tandems

		// Test de la méthode articles
		ArrayList<Article> articlesCommande1 = commande1.articles();
		System.out.println(articlesCommande1.toString()); // La liste doit contenir uniquement le tandem
	}
}
