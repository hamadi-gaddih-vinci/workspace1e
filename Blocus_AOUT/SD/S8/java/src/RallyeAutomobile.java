import java.util.NoSuchElementException;

public class RallyeAutomobile {
    private ListeSDImpl<String> listesPilotes;

    public RallyeAutomobile(String[] lesPilotes) {
        listesPilotes = new ListeSDImpl<String>();
        for (int i = 0; i < lesPilotes.length; i++) {
            if (lesPilotes[i] == null)
                throw new IllegalArgumentException();
            listesPilotes.insererEnQueue(lesPilotes[i]);
        }
    }
    public String donnerPiloteEnTete(){
        if (listesPilotes.estVide())
            throw new NoSuchElementException();
        return listesPilotes.premier();
    }
    public boolean supprimer(String pilote){
        if (pilote == null)
            throw new IllegalArgumentException();
        if (listesPilotes.contient(pilote)){
            listesPilotes.supprimer(pilote);
            return true;
        }
        return false;
    }
    public String afficherTouteLaCourse(){
        if (listesPilotes.estVide())
            throw new NoSuchElementException();
        String texte = "";
        int i = 1;
        for (String pilotes: listesPilotes) {
            texte = texte + i + ": " + listesPilotes+"\n";
            i++;
        }
        return texte;
    }
    public boolean enregistrerDoublement(String pilote){
        if (listesPilotes.premier() == pilote)
            return false;
        return listesPilotes.permuter(listesPilotes.donnerPrecedent(pilote), pilote);
    }
    public int donnerPositionPilote(String pilote){
        return -1;
    }
    public String franchirLigneArrive(String pilote){
        return null;
    }
}
