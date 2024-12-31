public class SommeNegatifsEtPositif {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int sommePositif = 0;
        int sommeNegatif = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println("Entrez l'entier n°" + i + ":");
            int entier = scanner.nextInt();
            if (entier >= 0) sommePositif += entier;
            else sommeNegatif += entier;
        }
        System.out.println("La somme des entiers Positifs = " + sommePositif);
        System.out.println("La somme des entiers Negatifs = " + sommeNegatif);
    }
}
