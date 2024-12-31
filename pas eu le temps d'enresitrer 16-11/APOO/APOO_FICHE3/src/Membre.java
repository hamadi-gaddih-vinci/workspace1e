
public class Membre {

    //Ajoutez un attribut pour garder le nom du membre.
    private String nom;

    //Ajoutez un attribut pour garder le prénom du membre.
    private String prenom;

    //Ajoutez un attribut pour garder le numéro de téléphone du membre.
    private String numeroDeTelephone;

    //Ajoutez un attribut pour garder, s'il y en a un, le membre qui a parrainé le membre courant.
    private Membre parrain;


    //Ajoutez un constructeur initialisant le nom, le prénom et le numéro de téléphone du membre.
    public Membre(String nom, String prenom, String numeroDeTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDeTelephone = numeroDeTelephone;
    }

	//Ajoutez des getters pour tous les attributs

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    public Membre getParrain() {
        return parrain;
    }
    //Ajouter un setter pour le numéro de téléphone.

    public void setNumeroDeTelephone(String numeroDeTelephone) {
        this.numeroDeTelephone = numeroDeTelephone;
    }


    //Ajoutez une méthode permettant d'initialiser le parrain.
    //Cette méthode renvoie false si le membre a déjà un parrain ou si le membre passé en paramètre est le membre lui-même.
    //Sinon, elle initialise le parrain et renvoie true.
    public boolean InitialiserParrain(Membre parrain) {
        if (this.parrain != null || parrain== this) return false;
        this.parrain = parrain;
        return true;
    }
	//Ajoutez une méthode toString qui renverra toutes les informations du membre sous forme textuelle. 
	//Si le membre a un parrain, il faut uniquement reprendre le prénom et le nom du parrain. Sinon, il faut dire que le membre n'a pas de parrain.


    @Override
    public String toString() {
        return "Membre{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numeroDeTelephone='" + numeroDeTelephone + '\'' +
                ", parrain=" + parrain+
                '}';
    }
}
