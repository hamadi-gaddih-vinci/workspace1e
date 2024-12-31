public class Personne3 {
    private String nom;
    private String prenom;

    private Date dateDeNaissance;
    private Adresse domicile;

    public Personne3(String nom, String prenom, Date dateDeNaissance, Adresse domicile){

        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.domicile = domicile;
    }
    public void demenager(String rue, String numero, String codePostal, String ville){
        domicile = new Adresse(rue, numero, codePostal, ville);
    }

    public Adresse getDomicile() {
        return domicile;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

}






















