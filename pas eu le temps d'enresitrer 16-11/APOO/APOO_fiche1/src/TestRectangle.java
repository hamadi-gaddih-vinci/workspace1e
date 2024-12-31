public class TestRectangle {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(10, 5);
        Rectangle rectangle2 = new Rectangle(15, 10);
        Rectangle rectangle3 = new Rectangle(20, 15);
        System.out.println("La valeur de l'Aire est de " + " " + rectangle1.calculerAire() );
        System.out.println("La valeur de l'Aire est de " + " " + rectangle2.calculerAire());
        System.out.println("La valeur de l'Aire est de " + " " + rectangle3.calculerAire());


        System.out.println("La valeur du périmètre est de " + " " + rectangle1.caclculerPerimetre());
        System.out.println("La valeur du périmètre est de " + " " + rectangle2.caclculerPerimetre());
        System.out.println("La valeur du périmètre est de " + " " + rectangle3.caclculerPerimetre());

    }
}
