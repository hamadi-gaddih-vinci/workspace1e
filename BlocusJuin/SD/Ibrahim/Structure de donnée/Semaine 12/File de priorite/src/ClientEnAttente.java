public class ClientEnAttente {

    private Client client;

    private static int COMPTEUR;

    private int ordreArrive;

    public ClientEnAttente (Client client) {
        this.client = client;
        COMPTEUR++;
        this.ordreArrive = COMPTEUR;
    }

    public Client getClient() {
        return client;
    }

    public int getOrdreArrive() {
        return ordreArrive;
    }

    @Override
    public String toString() {
        return client.getNom();
    }
}
