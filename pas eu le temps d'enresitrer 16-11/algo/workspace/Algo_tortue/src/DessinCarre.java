public class DessinCarre {
    public static Tortue tortue = new Tortue();
    public static void main(String args[]){
        for (int i=0; i<4; i++){
            tortue.definirCouleur("Rouge");
            tortue.avancer(200);
            tortue.tournerADroite(90);
        }
    }
}
