public class Serie {

    private char nom;

    private Etudiant deleguer;

    public Serie(char nom, Etudiant deleguer){
        this.nom = nom;
        this.deleguer = deleguer;
    }

    public char getNom() {
        return nom;
    }

    public Etudiant getDeleguer() {
        return deleguer;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nom=" + nom +
                ", deleguer=" + deleguer +
                '}';
    }
    public boolean elireDeleguer (Etudiant deleguer){
        if (deleguer.getSerie() != this || this.deleguer != null) return false;
       this.deleguer = deleguer;
       return true;

    }
}
