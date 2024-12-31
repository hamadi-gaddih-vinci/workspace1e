public class NombreNegatifsParmi10 {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int nbrNegatif = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Nombre" + " " + i + ":");
            int entier = scanner.nextInt();
            if (entier < 0) {
               nbrNegatif  = nbrNegatif + 1;
            }

        }
        System.out.println("il y a" + " " + nbrNegatif + " " + "nombre négatif");}
}