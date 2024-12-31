import java.util.ArrayList;

public class Site {
    private String url;
    private ArrayList <ContenuVideo> contenuVideos;

    public Site(String url) {
        if (url == null)
            throw new IllegalArgumentException("URL invalide");
        this.url = url;
        this.contenuVideos = new ArrayList<>();
    }
    public boolean ajouter(ContenuVideo contenuVideo){
            if (this.contenuVideos.contains(contenuVideo))
                return false;
            return this.contenuVideos.add(contenuVideo);
    }
    public boolean effacer(ContenuVideo contenuVideo){
        if (!this.contenuVideos.contains(contenuVideo))
            return false;
        return this.contenuVideos.remove(contenuVideo);

    }

    @Override
    public String toString() {
        return "Site " +
                "[url=" + url +"]" + "\n" +
                " " + "Liste de contenus vidéos" + "\n" +
                " " + " " + contenuVideos;
    }
}
