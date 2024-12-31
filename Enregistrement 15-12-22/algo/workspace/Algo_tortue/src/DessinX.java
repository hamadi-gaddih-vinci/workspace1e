public class DessinX {
    public static Tortue tortue = new Tortue();
    public static void main(String args[]){
        tortue.definirCouleur("Bleu");
        tortue.tournerADroite(60);
        tortue.avancer(200);
        tortue.avancer(-100);
        tortue.tournerADroite(60);
        tortue.avancer(100);
        tortue.tournerAGauche(180);
        tortue.avancer(200);
    }
}
