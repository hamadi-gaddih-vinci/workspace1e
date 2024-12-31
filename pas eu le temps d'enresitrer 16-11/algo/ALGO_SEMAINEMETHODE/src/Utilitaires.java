public class Utilitaires {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * genere un entier compris entre les 2 valeurs passees en parametre
     *
     * @param valeurMinimale la valeur minimale de l'entier genere
     * @param valeurMaximale la valeur maximale de l'entier genere
     * @return l'entier genere
     */
    public static int unEntierAuHasardEntre(int valeurMinimale, int valeurMaximale) {
        return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
    }

    /**
     * lit un nombre reel positif ou nul
     *
     * @return un nombre reel positif
     */
    public static double lireReelPositif() {
        double x = scanner.nextDouble();
        while (x < 0) {
            System.out.println("Attention le reel doit etre positif");
            System.out.print("Recommencez : ");
            x = scanner.nextDouble();
        }
        return x;
    }


    /**
     * lit un nombre reel compris entre les 2 valeurs passees en parametre
     *
     * @param min le plus petit reel accepte
     * @param max le plus grand reel accepte
     * @return un nombre reel compris entre 2 bornes
     */
    public static double lireReelComprisEntre(double min, double max) {
        double x = scanner.nextDouble();
        while (x < min || x > max) {
            System.out.println("Recommencez");
            x = scanner.nextDouble();
        }
        return x;
        // TODO
    }


    /**
     * lit le caractere o ou n
     *
     * @return le caractere o un n
     */
    public static char lireOouN() {
        char x = scanner.next().charAt(0);
        while (x != 'o' && x != 'n') {
            System.out.println("Recommencez");
            x = scanner.next().charAt(0);
        }
        return x;
        // TODO
    }

    public static int lireEntierNonNul() {
        int x = scanner.nextInt();
        while (x <= 0) {
            System.out.println("Recommencez");
            x = scanner.nextInt();

        }
        return x;
    }

}


