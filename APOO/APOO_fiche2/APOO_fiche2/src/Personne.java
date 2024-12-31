public class Personne {
    private String nom;
    private String prenom;
    private int anneeNaissance;
    private int moisNaissance;
    private int jourNaissance;
    private Adresse domicile;

    public Personne(String nom, String prenom, int anneeNaissance, int moisNaissance, int jourNaissance,
                    Adresse domicile){
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
        this.moisNaissance = moisNaissance;
        this.jourNaissance = jourNaissance;
        this.domicile = domicile;
    }

    public int calculerAge(){
        return 2022 - anneeNaissance;
    }

    public int calculerAgeEn(int an) {
        return an - anneeNaissance;
    }
    public Adresse fournirDomicile() {
        return domicile;
    }
    public String fournirDateNaissance(){
        return jourNaissance + "/" + moisNaissance + "/" + anneeNaissance;
    }
    public String toString(){
        return prenom + " " + nom + " né le " + fournirDateNaissance() + " domicilié à " + fournirDomicile();
    }






















}
