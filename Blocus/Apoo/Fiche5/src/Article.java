import java.util.Objects;

public class Article {
	private String reference;
	private String nom;
	private String description;
	private double prixHTVA;
	private double tauxTVA;
	private static final double TAUX_TVA_PAR_DEFAUT = 21;
	private static int nombreArticle =0;

	public Article(String reference, String nom, String description, double prixHTVA, double tauxTVA)  {
		setTauxTVA(tauxTVA);
		setDescription(description);
		setPrixHTVA(prixHTVA);
		if (reference == null || reference.equals(""))
			throw new IllegalArgumentException("Référence invalide");
		this.reference = reference;
		if (nom == null || nom.equals(""))
			throw new IllegalArgumentException("Nom invalide");
		this.nom = nom;
		nombreArticle ++;
	}
	
	public Article(String reference, String nom, String description,
			double prixHTVA) throws IllegalAccessException {
		this(reference,nom,description,prixHTVA, TAUX_TVA_PAR_DEFAUT);

	}

	public String getReference() {
		return reference;
	}

	public String getNom() {
		return nom;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrixHTVA() {
		return prixHTVA;
	}
	
	public void setPrixHTVA(double prixHTVA) {
		if (prixHTVA <=0)
			throw new IllegalArgumentException("Prix invalide");
		this.prixHTVA = prixHTVA;
	}

	public double getTauxTVA() {
		return tauxTVA;
	}

	public void setTauxTVA(double tauxTVA) {
		if (tauxTVA < 0 || tauxTVA > 100)
			throw new IllegalArgumentException("Taux de Tva invalide");
		this.tauxTVA = tauxTVA;
	}


	public double calculerPrixTVAComprise() {
		return prixHTVA * (1+ tauxTVA/100);
	}

	public double calculerPrixTVAComprise(int reduction){
		if (reduction <=0 || reduction >= 100)
			throw new IllegalArgumentException("Reduction invalide");
		return calculerPrixTVAComprise() * (1-reduction/100.0);
	}


	public String toString() {
		return "Nombre d'article crée " + nombreArticle + "\n" + "Référence : " + reference + "\nNom : " + nom + " (prix HTVA : " + prixHTVA + "€" + ", taux de TVA : " + tauxTVA +"%)" + "\n";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Article article = (Article) o;
		return Objects.equals(reference, article.reference);
	}

	@Override
	public int hashCode() {
		return Objects.hash(reference);
	}
}
