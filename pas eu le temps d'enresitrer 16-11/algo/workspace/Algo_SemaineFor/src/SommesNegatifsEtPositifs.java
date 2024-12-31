public class SommesNegatifsEtPositifs {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int nbrNegatif = 0;
        int somme = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println("Nombre" + " " + i + ":");
            int entier = scanner.nextInt();

            if (entier < 0) {
                nbrNegatif = nbrNegatif + entier;
            } else if (entier >= 0) {
                somme = somme + entier;

            }
        }


        System.out.println
                ("La somme des nombres négatifs est :" + " " + nbrNegatif + "," +
                        "La somme des nombres positifs est :" + " " + somme);
    }
}

