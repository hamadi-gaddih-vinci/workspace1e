public class TestCerclePlace {

    public static void main(String[] args) {
        Point point1 = new Point(4, 2.5);
        Point point2 = new Point(8, 2.5);
        CerclePlace cercle1 = new CerclePlace(4, point1);
        CerclePlace cercle2 = new CerclePlace(12.5, point2);

        System.out.println(cercle1);
        System.out.println(cercle2);

    }
}
