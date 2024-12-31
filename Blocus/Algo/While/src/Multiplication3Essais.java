
public class Multiplication3Essais {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrainement aux multiplications. Voici une multiplication :");
        System.out.println("Tu as droit a 3 essais");
        int premierNombre = unEntierAuHasardEntre(0, 10);
        int secondNombre = unEntierAuHasardEntre(0, 10);
        System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");

        int reponse = premierNombre * secondNombre;
        int user = scanner.nextInt();
        int nombreEssais = 3;
        while (reponse != user && nombreEssais != 1) {
            nombreEssais--;
            System.out.println("C'est faux, recommence plus que" + " " + nombreEssais + " " + "essais");
            System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
            user = scanner.nextInt();
        }
        if (nombreEssais == 1 && user != reponse)
            System.out.println("La réponse est : " + reponse);
        else System.out.println("bravo");
        // A COMPLETER
    }

    // A NE PAS MODIFIER
    public static int unEntierAuHasardEntre(int valeurMinimale, int valeurMaximale) {
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }

}
