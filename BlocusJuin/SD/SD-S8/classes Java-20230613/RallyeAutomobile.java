import java.util.NoSuchElementException;
public class RallyeAutomobile {
    private ListeSDImpl <String> pilotes;
    public RallyeAutomobile(String[] lespilotes){
        pilotes = new ListeSDImpl<String>();
        for (int i = 0; i < lespilotes.length; i++) {
            if (lespilotes[i] == null)
                throw new IllegalArgumentException();
            pilotes.insererEnQueue(lespilotes[i]);
        }
    }
    public String donnerPiloteEnTete(){
        return pilotes.premier();
    }

    public boolean supprimer(String pilote){
        return pilotes.supprimer(pilote);
    }

    public String afficherTouteLacourse(){
        if (pilotes.estVide())
            throw new IllegalArgumentException();
        String texte = "";
        int i = -1;
        for (String pilotes: pilotes) {
            texte = texte + i + " " + pilotes +"\n";
            i++;
        }
        return texte;
    }
    public boolean enregistrerDepassement(String pilote){
        if (pilotes.premier().equals(pilote))
            return false;
        return pilotes.permuter(pilotes.donnerPrecedent(pilote), pilote);
    }
    public int donnerPositionPilote(String pilote){
        return -1;
    }
    public
}
