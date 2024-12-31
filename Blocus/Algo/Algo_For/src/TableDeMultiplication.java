import java.util.Scanner;

public class TableDeMultiplication {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Faite la table de multiplication de : ");
        int choixUtilisateur = scanner.nextInt();
        for (int i = 1; i <= 10 ; i++) {
            System.out.println(i + "x" + choixUtilisateur + "=" + i*choixUtilisateur);
        }
    }
}
