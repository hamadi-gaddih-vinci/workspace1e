public class NombreNegatifsParmi10 {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int nombreDEntierNegatif = 0;
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("Ecrivez l'entier n°" + i + ":");
            int entier = scanner.nextInt();
            if (entier < 0)
                nombreDEntierNegatif ++;
        }
        System.out.println("Le nombre d'entiers négatifs est de :" + nombreDEntierNegatif);
    }
}
