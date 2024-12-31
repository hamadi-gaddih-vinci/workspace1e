public class DessinMaison {
    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerer();
        for (int i=0; i<4; i++) {
            tortue.avancer(200);
            tortue.tournerADroite(90);
        }
            tortue.tournerAGauche(60);
            tortue.avancer(200);
            tortue.tournerADroite(120);
            tortue.avancer(200);

        }

        }


