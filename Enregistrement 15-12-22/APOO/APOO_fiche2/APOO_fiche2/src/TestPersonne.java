public class TestPersonne {

    public static void main(String[] args) {

        Adresse adresse = new Adresse("Rue de la gare", "34", "5000", "Namur");
        Personne personne1 = new Personne("Schmidt", "Paul",
                1968, 2,6, adresse);
        Personne personne2 = new Personne("Gobert","Valérie",
                1970, 3,7,adresse);
        System.out.println(personne1.toString());
        System.out.println(personne2.toString());

    }

}
