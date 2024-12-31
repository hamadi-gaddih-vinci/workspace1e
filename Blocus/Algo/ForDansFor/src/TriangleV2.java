import java.util.Scanner;

public class TriangleV2 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez la taille (n) : ");
        int n = scanner.nextInt();
        for (int i = n; i >= 1 ; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print('X');
            }
            System.out.println();
        }
    }
}
