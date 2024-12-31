import java.util.HashMap;

/**
 * @author Lankhorst Paul
 */

public class Entrepot {

    private int nombreHangarsLibres = 0;
    private int nombreHangars = 0;
    private Hangar[] tableHangars;
    private HashMap<Integer, Societe> dictionary;


    /**
     * Construit un entrepot contenant nombreHangars
     *
     * @param nombreHangars le nombre de hangars
     * @throws IllegalArgumentException si le nombre de hangars est négatif ou nul
     */
    public Entrepot(int nombreHangars) {
        if (nombreHangars <= 0)
            throw new IllegalArgumentException();

        this.nombreHangars = nombreHangars;
        nombreHangarsLibres = nombreHangars;
        tableHangars = new Hangar[nombreHangars];

        for (int i = 0; i < nombreHangars; i++) {
            tableHangars[i] = new Hangar(i);
        }

        dictionary = new HashMap<>();
    }

    /**
     * Renvoie le nombre de hangars libres
     *
     * @return le nombre de hangars libres
     */
    public int nombreHangarsLibres() {

        return nombreHangarsLibres;
    }


    /**
     * Renvoie le nombre de societes presentes
     *
     * @return le nombre de societes presentes
     */
    public int nombreSocietesPresentes() {

        return dictionary.size();
    }

    /**
     * Renvoie la societe dont le numero est passe en parametre
     *
     * @param numeroSociete le numero de la societe
     * @return la societe recherchee ou null si aucune societe presente ne possede ce numero
     */
    public Societe getSociete(int numeroSociete) {

        return dictionary.get(numeroSociete);
    }

    /**
     * Attribue un hangar a la societe passée en paramètre
     * Si l'attribution a pu se faire :
     * la societe est enregistrée comme présente (si pas encore présente)
     * le hangar lui est ajouté
     *
     * @param numeroSociete le numéro de la societe
     * @param nomSociete    le no	m de la societe
     * @return le numéro du hangar attribue ou -1 s'il n'y en a plus de libre
     */
    public int attribuerHangar(int numeroSociete, String nomSociete) {
        if (nombreHangarsLibres == 0)
            return -1;

        Societe societe = dictionary.get(numeroSociete);

        if (societe == null) {
            societe = new Societe(numeroSociete, nomSociete);
            dictionary.put(numeroSociete, societe);
        }

        int numSoc = numeroSociete % nombreHangars;

        if (nombreHangarsLibres > 0) {
            for (int i = numSoc; i < tableHangars.length; i++) {
                if (tableHangars[i].getSociete() == null) {
                    societe.ajouterHangar(i);
                    tableHangars[i].setSociete(societe);
                    nombreHangarsLibres--;
                    return i;
                }
            }
            for (int i = 0; i < numSoc; i++) {
                if (tableHangars[i].getSociete() == null) {
                    societe.ajouterHangar(i);
                    tableHangars[i].setSociete(societe);
                    nombreHangarsLibres--;
                    return i;
                }
            }
        }

        return -1;
    }

    public boolean libererHangar(int numeroHangar) {
        if (numeroHangar < 0 || numeroHangar > tableHangars.length) {
            System.out.println("numero de hangar incorrect");
            return false;
        }
        if (tableHangars[numeroHangar].getSociete() == null) return false;
        int numeroSociete = tableHangars[numeroHangar].getSociete().getNumeroSociete();
        dictionary.get(numeroSociete).enleverHangar(numeroHangar);
        tableHangars[numeroHangar].setSociete(null);
        return true;
    }
}
