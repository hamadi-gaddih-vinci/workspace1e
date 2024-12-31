import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Concours {

    private Candidat[] tableCandidats;
    private HashMap<String,Candidat> mapCandidats; //nom --> candidat
    private HashMap<String,Integer> mapVotants; //numero de telephone --> nombre de votes
    private int nombreMaxVotes;

    /**
     * debute un concours
     * @param tableNomsCandidats la table avec les noms des candidats
     * @param nombreMaxVotes le nombre maximal de votes qu'un spectateur peut faire
     * @throws IllegalArgumentException
     *           s'il n'y a pas au moins un vote possible par spectateur
     *           si la table des noms des candidats est null ou est vide
     *           s'il y a des homonymes
     */
    public Concours(String[]tableNomsCandidats,int nombreMaxVotes){
        //TODO
        if (nombreMaxVotes <= 0  || tableNomsCandidats == null ||  tableNomsCandidats.length == 0)
            throw new IllegalArgumentException();
        tableCandidats = new Candidat[tableNomsCandidats.length];
        mapCandidats = new HashMap<>();
        mapVotants = new HashMap<>();
        this.nombreMaxVotes = nombreMaxVotes;
        for (int i = 0; i < tableNomsCandidats.length; i++) {
            Candidat candidat = new Candidat(tableNomsCandidats[i], i+1);
            if (mapCandidats.containsKey(candidat.getNom()))
                throw new IllegalArgumentException();
            mapCandidats.put(candidat.getNom(), candidat);
        }
    }

    public int getNombreMaxVotes() {
        return nombreMaxVotes;
    }

    /**
     * ajoute 1 vote au candidat dont le nom est passe en parametre
     * a condition que le candidat existe
     * et a condition que le nombre max de votes n'est pas atteint pour le numero de telephone passe en parametre
     * @param numeroTelephone le numero de telephone qui fait le vote
     * @param nomCandidat le nom du candidat qui fait l'objet du vote
     * @return true si le vote a ete fait, false sinon
     * @throws IllegalArgumentException
     *              si le numero de telephone est null
     *              si le nom du candidat est null
     */
    public boolean voterViaNom(String numeroTelephone, String nomCandidat) {
        //TODO
        if (numeroTelephone == null || nomCandidat == null)
            throw new IllegalArgumentException();
        if (!mapVotants.containsKey(numeroTelephone)){
            mapVotants.put(numeroTelephone, 0);
        }
        if (!mapCandidats.containsKey(nomCandidat) || mapVotants.get(numeroTelephone) >= nombreMaxVotes)
            return false;
        mapCandidats.get(nomCandidat).ajouter1Vote();
        mapVotants.put(numeroTelephone, mapVotants.get(numeroTelephone) +1);
        return true;
    }

    /**
     * ajoute 1 vote au candidat dont le numero est passe en parametre
     * a condition que le candidat existe
     * et a condition que le nombre max de votes n'est pas atteint pour le numero de telephone passe en parametre
     * @param numeroTelephone le numero de telephone qui fait le vote
     * @param numeroCandidat le numero du candidat qui fait l'objet du vote
     * @return true si le vote a ete fait, false sinon
     * @throws IllegalArgumentException si le numero de telephone est null
     */
    public boolean voterViaNumero(String numeroTelephone, int numeroCandidat) {
        //TODO
        if (numeroTelephone == null)
            throw new IllegalArgumentException();
        if (!mapVotants.containsKey(numeroTelephone))
            mapVotants.put(numeroTelephone, 0);
        if (numeroCandidat <= 0 || numeroCandidat >= tableCandidats.length || mapVotants.get(numeroTelephone) >= nombreMaxVotes)
            return false;
        if (tableCandidats[numeroCandidat-1] == null)
            return false;
        String candidat = tableCandidats[numeroCandidat-1].getNom();
        mapCandidats.get(candidat).ajouter1Vote();
        mapVotants.put(numeroTelephone, mapVotants.get(numeroTelephone)+1);
        return true;
    }

    /**
     * construit une table dans laquelle les candidats apparaissent tries selon l'ordre decroissant des nombres de vote
     * @return la table dans laquelle les candidats apparaissent tries selon l'ordre decroissant des nombres de vote
     */
    public Candidat[] classement(){
        // Utilisez les methodes copyOf() et sort() de la classe Arrays !
        // cfr enonce
        //TODO
        Candidat[] table = new Candidat[mapCandidats.size()];
        for (String str: mapCandidats.keySet()) {
            Candidat candidat = mapCandidats.get(str);
            table[candidat.getNumero()] =  candidat;
        }
        Arrays.copyOf(table, mapCandidats.size());
        Arrays.sort(table);
        return table;
    }

    @Override
    // A NE PAS MODIFIER
    public String toString() {
        return "maxVotes=" + nombreMaxVotes +
                "\ntableCandidats=" + Arrays.toString(tableCandidats) +
                "\nmapCandidats=" + mapCandidats +
                "\nmapVotants=" + mapVotants;
    }

}

