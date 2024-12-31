public class Etudiant {
    private String matricule;

    private String nom;

    private String prenom;

    private Serie serie;

    public Etudiant(String matricule, String nom, String prenom, Serie serie){
    this.matricule = matricule;
    this.nom = nom;
    this.prenom = prenom;
    this.serie = serie;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Serie getSerie() {
        return serie;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", serie=" + serie +
                '}';
    }
    public boolean changerSerie (Serie serie){
        if (this == serie || ) return false;

    }
}
