import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
public class Commande {
	private ArrayList<Article> articles;
	private LocalDate date;
	
	public Commande(){
		date = LocalDate.now();
		//TODO initialiser l'arraylist
		articles = new ArrayList<Article>();
	}
	public void ajouter(Article article){
		articles.add(article);
	}
	public double calculerPrixTotal(){
	double somme = 0;
		for (Article article : articles) {
			somme += article.calculerPrixTVAComprise();
		} return somme;
	}


	public String toString(){
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		String infosCommande = date.format(formatter)+ " \n";
		//TODO ajouter la liste des articles à la chaîne (avec un passeage à la ligne entre chaque article) de caractères infosCommande.

		//TODO ajouter le prix total à la chaîne de caractères infosCommande après la liste des articles.
		for (Article article: articles) {

		}
		return infosCommande;
	}
}
