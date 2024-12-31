public class DessinEtoile {
    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerer();
        tortue.definirCouleur("rouge");
        tortue.avancer(200);
        for (int i = 0; i < 2; i++) {
            tortue.tournerADroite(120);
            tortue.avancer(200);
        }
        tortue.avancer(-75);
        tortue.tournerAGauche(125);
        tortue.definirCouleur("bleu");
        tortue.avancer(75);
        tortue.tournerADroite(90);

    }
}