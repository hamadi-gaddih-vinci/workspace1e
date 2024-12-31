public class RallyeAutomobile{
    private ListeSDImpl<String> listePilotes;
    private String [] lesPilotes;

    public RallyeAutomobile(String [] lesPilotes) {
        this.listePilotes = new ListeSDImpl<String>();
        this.lesPilotes = lesPilotes;

        listePilotes.insererEnTete(lesPilotes[0]);

        String pilote = listePilotes.premier();

        for (int i = 1; i < lesPilotes.length; i++) {
            listePilotes.insererApres(pilote, lesPilotes[i]);
            pilote = lesPilotes[i];
        }
    }
    public String afficherTouteLaCourse(){
        return listePilotes.toString();
    }
    public String donnerPiloteEnTete(){
        return listePilotes.premier();
    }
    public boolean enregistrerDepassement(String pilote){
        return listePilotes.permuter(pilote, listePilotes.donnerSuivant(pilote));
    }
    public boolean supprimer(String pilote){
        return listePilotes.supprimer(pilote);
    }
    public String donnerPositionPilote(){
        return
    }

}
