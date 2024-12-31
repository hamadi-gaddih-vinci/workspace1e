public class TestCompteEnBanque {

    public static void main(String[] args) {
        Adresse adresse = new Adresse("Rue Schimdt", "10", "1000", "Bruxelles");
        Personne personne = new Personne("Lecomte", "Benoit", 1987, 02, 20, adresse);
        Date dateDeValidationID = new Date(2023, 04, 20);
        Date dateDOuverture = new Date(2007, 12, 12);
        CompteEnBanque compteEnBanque = new CompteEnBanque(personne, dateDeValidationID, "000-000000089-89", dateDOuverture, 1800.22);


    }
}
