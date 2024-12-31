public class ExSuppB6 {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int entierNegatifs = 0;
        int entierPositifs = 0;
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("Ecrivez l'entier n° " + i);
            int entier = scanner.nextInt();
            if (entier >0)
                entierPositifs ++;
            else entierNegatifs ++;
        }
        System.out.println("Le nombre d'entiers positifs est de " + entierPositifs);
        System.out.println("Le nombre d'entiers négatifs est de " + entierNegatifs);
    }
}
