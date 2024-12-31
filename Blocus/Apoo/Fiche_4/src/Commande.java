import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
public class Commande {
	private ArrayList <LigneDeCommande> ligneDeCommandes;
	private LocalDate date;

	public Commande(){
		date = LocalDate.now();
		this.ligneDeCommandes = new ArrayList<LigneDeCommande>();
		//TODO initialiser l'arraylist
	}
	public void ajouter(Article article, int quantite){
		LigneDeCommande ligne = new LigneDeCommande(article, quantite);
		this.ligneDeCommandes.add(ligne);
	}
	public void ajouter(Article article){
		ajouter(article,1);
	}
	public void supprimer(Article article){
		for (LigneDeCommande ligneDeCommande: ligneDeCommandes) {
			if (ligneDeCommande.getArticle().equals(article)){
				ligneDeCommandes.remove(ligneDeCommande);
			break;
			}
		}
	}
	public void modifierQuantite(Article article, int quantite){
		for (LigneDeCommande ligneDeCommande: ligneDeCommandes) {
			if (ligneDeCommande.getArticle().equals(article)){
				ligneDeCommande.setQuantite(quantite);
				break;
			}
		}
	}
	public boolean dejaCommande(Article article){
		for (LigneDeCommande ligneDeCommande: ligneDeCommandes) {
			if (ligneDeCommande.getArticle().equals(article)){
				return true;
			}
		} return false;
	}
	public int trouverQuantite(Article article){
		for (LigneDeCommande ligneDeCommande: ligneDeCommandes) {
			if (ligneDeCommande.getArticle().equals(article))
				return ligneDeCommande.getQuantite();
		} return 0;
	}

	public ArrayList<Article> articles(){
		ArrayList<Article> articles = new ArrayList<>();
		for (LigneDeCommande ligneDeCommande :ligneDeCommandes) {
			articles.add(ligneDeCommande.getArticle());
		} return articles;
	}
	public double calculerPrixTotal(){
		double somme = 0;
		for (LigneDeCommande ligneDeCommande:this.ligneDeCommandes) {
			somme += ligneDeCommande.caluculerPrixTotalTVAC();
		} return somme;
	}


	public String toString(){
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		String infosCommande = date.format(formatter)+" \n";

		for (LigneDeCommande ligneDeCommande : this.ligneDeCommandes) {
			infosCommande += "\n" + ligneDeCommande.toString();
		}
		infosCommande += "\nLe prix total est de : " + calculerPrixTotal() + "€" + "\n";

		//TODO ajouter la liste des articles à la chaîne (avec un passeage à la ligne entre chaque article) de caractères infosCommande.
		//TODO ajouter le prix total à la chaîne de caractères infosCommande après la liste des articles.

		return infosCommande ;

	}
}
