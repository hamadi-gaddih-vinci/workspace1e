public class NombreMystereInverse {
        public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrez un nombre à deviner entre 1 et 100 : ");
        int nombreADeviner = scanner.nextInt();
        int ordinateur = unEntierAuHasardEntre(0,100);
        int min = 0;
        int max = 100;
        int nombreEssais = 0;
        while (ordinateur != nombreADeviner) {
            ordinateur = unEntierAuHasardEntre(min,max);
            nombreEssais++;
            System.out.println("Essais n°: " + nombreEssais);
            System.out.println(ordinateur);
            if (ordinateur == nombreADeviner)
                break;
            System.out.println("Est-ce que votre chiffre est plus grand (+) ou plus petit (-)");
            char reponse = scanner.next().charAt(0);
            if (reponse == '+') {
                System.out.println("Le nombre à deviner est plus grand");
                min = ordinateur+1;
            } else if (reponse == '-') {
                System.out.println("Le nombre à deviner est plus petit");
                max = ordinateur -1;
            }
            if (ordinateur < 0)
                ordinateur = 0;
            if (ordinateur > 100)
                ordinateur = 100;
        }
        System.out.println("Bravo il vous a fallu : " + nombreEssais + " d'essais");
    }
        public static int unEntierAuHasardEntre(int valeurMinimale, int valeurMaximale) {
            double nombreReel;
            int resultat;
            nombreReel = Math.random();
            resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
            return resultat;
        }
    }

