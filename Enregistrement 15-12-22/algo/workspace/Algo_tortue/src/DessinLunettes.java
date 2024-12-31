public class DessinLunettes {
    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            tortue.definirCouleur("Rouge");
            tortue.avancer(200);
            tortue.tournerADroite(90);
        }

        tortue.tournerAGauche(180);
        tortue.avancer(250);
        for (int i = 0; i < 3; i++) {
            tortue.tournerAGauche(90);
            tortue.avancer(200);

        }
    }
}