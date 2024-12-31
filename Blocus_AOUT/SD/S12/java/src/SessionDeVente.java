import java.util.*;

public class SessionDeVente {

    private PriorityQueue<ClientEnAttente> filePriorite;
    private HashSet<Client> ensembleClientsActuellementDansFile;
    private HashMap<Client, Commande> mapClientCommande;
    private ArrayList<Commande> listeCommandes;
    private int nombreCasiersRestants;
    public final static int MAX_CASIERS_CLIENT=3;


    /**
     * debute une session de vente
     * @param nombreCasiersMisEnVente le nombre de casiers mis en vente
     * @throws IllegalArgumentException s'il n'y a pas au moins un casier a vendre
     */
    public SessionDeVente(int nombreCasiersMisEnVente) {
        if(nombreCasiersMisEnVente<=0)
            throw new IllegalArgumentException();
        this.nombreCasiersRestants = nombreCasiersMisEnVente;
        filePriorite = new PriorityQueue<ClientEnAttente>(new ComparateurClient());
        ensembleClientsActuellementDansFile = new HashSet<Client>();
        mapClientCommande = new HashMap<Client, Commande>();
        listeCommandes = new ArrayList<Commande>();
    }


    public int getNombreCasiersRestants() {
        return nombreCasiersRestants;
    }

    /**
     * ajoute, si possible, le client dans la file d'attente
     * le client ne peut pas deja y etre
     * si client a deja une commande lors de cette session de vente, le max de casiers autorise n'est pas deja atteint
     * s'il reste encore des casiers a vendre
     * @param client le client a ajouter
     * @return true si l'ajout a pu se faire, false sinon
     * @throws IllegalArgumentException si le client est null ou vide
     */
    public boolean placerDansFileAttente(Client client){
        //TODO
        if (client == null){throw new IllegalArgumentException();}
        ClientEnAttente clientEnAttente = new ClientEnAttente(client);
        if (ensembleClientsActuellementDansFile.contains(client)){return false;}
        if (mapClientCommande.containsKey(client)){
            if (mapClientCommande.get(client).getNombreCasiersDemandes()==MAX_CASIERS_CLIENT){return false;}
        }
        if (nombreCasiersRestants<=0){return false;}
        filePriorite.add(clientEnAttente);
        ensembleClientsActuellementDansFile.add(client);
        return true;
    }

    /**
     * retire de la file d'attente le client de tete
     * @return le client de tete ou null si la file est vide
     */
    public Client selectionnerClientSuivant(){
        //TODO
        if (filePriorite.size() == 0 ){return null;}
        Client clientRetirer = filePriorite.remove().getClient();
        ensembleClientsActuellementDansFile.remove(clientRetirer);
        return clientRetirer;
    }

    /**
     * ajoute, si possible, une nouvelle commande
     * le nombre de casiers restants doit etre suffisant pour satisfaire completement la commande
     * (il n'y a pas de commande partielle)
     * le nombre de casiers demandes ne peut depasser le max autorise
     * @param client le client qui fait la demande
     * @param nombreCasiersDemandes le nombre de casiers demandes
     * @return true si la commande a pu etre faite, false sinon
     * @throws IllegalArgumentException si le client est null ou vide
     *  	ou si le nombre de casiers demandés est <=0
     * @throws IllegalStateException si le client a deja fait une commande
     */
    public boolean passerNouvelleCommande(Client client, int nombreCasiersDemandes){
        //TODO
        if (client == null ){throw new IllegalArgumentException();}
        if (nombreCasiersDemandes<=0){throw new IllegalArgumentException();}
        if (mapClientCommande.containsKey(client)){throw new IllegalStateException();}
        if (nombreCasiersRestants==0){return false;}
        if (nombreCasiersDemandes>MAX_CASIERS_CLIENT){return false;}
        Commande commande = new Commande(client,nombreCasiersDemandes);
        if (nombreCasiersRestants>=nombreCasiersDemandes){
            listeCommandes.add(commande);
            mapClientCommande.put(client,commande);
            nombreCasiersRestants = nombreCasiersRestants - nombreCasiersDemandes;
            return true;
        }
        return false;
    }


    /**
     * modifie, si possible, une commande existante
     * le nombre de casiers restants doit etre suffisant
     * (il n'y a pas de commande partielle)
     * le nombre total de casiers apres ajout de ce nombre de casiers supplementaires ne peut depasser le max autorise
     * @param client le client qui veut modifier sa commande
     * @param nombreCasiersDemandesEnPlus le nombre de casiers a ajouter au nombre de casiers deja commande
     * @return true si la commande a pu etre modifiee, false sinon
     * @throws IllegalArgumentException si le client est null ou vide
     *  	ou si le nombre de casiers demandes est <= 0
     * @throws IllegalStateException si le client n'a pas encore fait de commande lors de cette session de commande
     */
    public boolean modifierCommande(Client client,int nombreCasiersDemandesEnPlus){
        //TODO
        if (client == null){throw new IllegalArgumentException();}
        if (nombreCasiersDemandesEnPlus<=0){throw new IllegalArgumentException();}
        if (!mapClientCommande.containsKey(client)){throw new IllegalStateException();}
        if (nombreCasiersRestants == 0){return false;}

        if (nombreCasiersRestants>= nombreCasiersDemandesEnPlus){
            if (mapClientCommande.get(client).getNombreCasiersDemandes() + nombreCasiersDemandesEnPlus<=3){
                int nbrCasier = mapClientCommande.get(client).getNombreCasiersDemandes();
                mapClientCommande.get(client).setNombreCasiersDemandes(nbrCasier+nombreCasiersDemandesEnPlus);
                nombreCasiersRestants = nombreCasiersRestants - nombreCasiersDemandesEnPlus;
                return true;
            }
        }
        return false;
    }

    public void cloturerSession(){
        for (ClientEnAttente clientEnAttente : filePriorite) {
            int priorite = clientEnAttente.getClient().getPriorite();
            clientEnAttente.getClient().setPriorite(priorite + 1);
        }
    }


    public String toString(){
        // cette methode ne sera pas evaluee
        // elle peut-etre interessante a appeler en cas de bug
        // n'hesitez pas a la completer
        return "le nombre de casiers restants : "+ nombreCasiersRestants
                + "\nla file d'attente : "+ filePriorite +  "\nles commandes " + listeCommandes;
    }

}








