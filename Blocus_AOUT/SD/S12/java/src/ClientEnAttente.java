public class ClientEnAttente {
    private Client client;
    private static int COMPTEUR;

    private int ordreArrivee;
    public ClientEnAttente(Client client) {
        this.client = client;
        COMPTEUR++;
        this.ordreArrivee = COMPTEUR;
    }

    public Client getClient() {
        return client;
    }

    public int getOrdreArrivee() {
        return ordreArrivee;
    }
    public String toString(){
        return client.getNom();
    }
}
