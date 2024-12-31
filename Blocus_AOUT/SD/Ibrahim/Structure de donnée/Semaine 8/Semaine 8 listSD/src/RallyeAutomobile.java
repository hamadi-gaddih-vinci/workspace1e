import java.util.NoSuchElementException;

public class RallyeAutomobile {
    private ListeSDImpl <String> pilotes;

    public RallyeAutomobile (String [] lesPilotes){


        pilotes = new ListeSDImpl<String>();

        for (int i =0; i<lesPilotes.length; i++){
            if (lesPilotes[i]==null){throw new IllegalArgumentException();}
            pilotes.insererEnQueue(lesPilotes[i]);
        }
    }

    public String donnerPiloteEnTete(){
        if (pilotes.estVide()){throw new NoSuchElementException();}
        return pilotes.premier();
    }

    public boolean supprimer (String pilote){
        if (pilote== null){throw new IllegalArgumentException();}

        if (pilotes.contient(pilote)) {
            pilotes.supprimer(pilote);
            return true;
        }
        return false;

    }

    public String afficherTouteLaCourse (){
        if (pilotes.estVide()){throw new NoSuchElementException();}
        String text = "";
        int i =1;
        for (String pilote : pilotes) {
            text = text + i +": "+ pilote+"\n";
            i++;
        }
        return text;
    }

    public boolean enregistrerDepassement(String pilote){
        if (pilotes.premier() == pilote){return false;}
        return pilotes.permuter(pilotes.donnerPrecedent(pilote),pilote);
    }

    public int donnerPositionPilote(){
        return -1;
    }

    public String franchirLigneArrive(String pilote){
        return null;
    }

}
