public class ClientEnAttente {

    private static int numeroSuivant = 0;
    private Client client;

    private int numeroOrdre;

    public ClientEnAttente(Client client) {
        this.client = client;
        numeroSuivant++;
        this.numeroOrdre = numeroSuivant;
    }

    public static int getNumeroSuivant() {
        return numeroSuivant;
    }

    public Client getClient() {
        return client;
    }

    public int getNumeroOrdre() {
        return numeroOrdre;
    }
}
