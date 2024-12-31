public class SommeCentsEntiers {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int somme = 0;
        for (int i = 1; i <= 100; i++) {
            System.out.println("Entrez l'entier n°" + i + " " + ':');
            int entier = scanner.nextInt();
            somme += entier;
        }
        System.out.println("La somme des cinqs entiers est de : " + somme);
    }
}
