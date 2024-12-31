public class JeuBrutus {

    public static void main(String[] args) {

        PlateauJeuBrutus jeu = new PlateauJeuBrutus();
        int positionBrutus = 1;
        jeu.placerBrutus(positionBrutus);
        jeu.afficherInformation("Vas-y !");

        // A COMPLETER

        int lanceDe = jeu.lancerDe();

    }
}
