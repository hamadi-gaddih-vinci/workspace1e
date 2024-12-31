import java.util.Objects;

public abstract class ContenuVideo {
    private int id;
    private String titre;
    private String categorie;
    private static int idSuivant = 1;
    private static final String [] CATEGORIE_POSSIBLE = {"action","science-fiction","drame","comédie",
            "horreur","thriller","documentaire", "animation"};

    public ContenuVideo(String titre, String categorie) {
        setTitre(titre);
        setCategorie(categorie);
        this.id = idSuivant;
        idSuivant++;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setTitre(String titre) {
        if (titre == null)
            throw new IllegalArgumentException("Titre invalide");
        this.titre = titre;
    }

    public void setCategorie(String categorie) {
        if (categorie == null)
            throw new IllegalArgumentException();
        for (String catePossible: CATEGORIE_POSSIBLE) {
            if (catePossible.equals(categorie)) {
                this.categorie = categorie;
                return;
            }
        } throw new IllegalArgumentException("Catégorie inexistante");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContenuVideo that = (ContenuVideo) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "[id=" + id + ", titre=" + titre + ", catégorie=" + categorie;
    }
}
