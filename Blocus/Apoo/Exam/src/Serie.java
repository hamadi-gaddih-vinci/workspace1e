public class Serie extends ContenuVideo{
    private int nombreEpisodes;

    public Serie(String titre, String categorie, int nombreEpisodes) {
        super(titre, categorie);
        setNombreEpisodes(nombreEpisodes);
    }

    public void setNombreEpisodes(int nombreEpisodes) {
        if (nombreEpisodes<=0)
            throw new IllegalArgumentException("Nombre d'épisode invalide");
        this.nombreEpisodes = nombreEpisodes;
    }

    @Override
    public String toString() {
        return "Série " + super.toString() + ", nombre d'épisodes=" + nombreEpisodes + ']' + "\n";
    }
}
