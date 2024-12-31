public class TestCercle {
    public static void main(String[] args) {
        Cercle cercle1 = new Cercle(10.4);
        Cercle cercle2 = new Cercle(25.0);
        Cercle cercle3 = new Cercle(125.63);
        System.out.print("Rayon du cercle1 :" + cercle1.rayon);
        System.out.print("Aire du cercle2 : " + cercle2.calculerAire());
        System.out.print(cercle3);


    }

}
