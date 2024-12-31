import java.util.Scanner;

public class Pyramide {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez la taille (n) : ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {

            // Imprimer le nombre approprié d'espaces pour la première ligne
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // Imprimer le nombre approprié de caractères X pour la première ligne
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("X");
            }
            // Passer à la ligne suivante
            System.out.println();
        }

    }

}
