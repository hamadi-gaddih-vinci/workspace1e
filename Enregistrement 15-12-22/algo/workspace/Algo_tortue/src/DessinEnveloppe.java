public class DessinEnveloppe {
    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
            tortue.definirCouleur("Bleu");
            tortue.tournerADroite(60);
            tortue.avancer(100);
            tortue.tournerAGauche(120);
            tortue.avancer(100);
            tortue.tournerADroite(150);
            for (int i=0; i<4; i++){
                tortue.avancer(100);
                tortue.tournerADroite(90);
            }


        }
    }

