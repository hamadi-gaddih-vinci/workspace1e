public class DessinCarresEmboites {
    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 50; j < 54; j++) {
                System.out.println(j*2);
                tortue.avancer(j);
                tortue.tournerADroite(90);
            } System.out.println(i*2);
        }
    }
}