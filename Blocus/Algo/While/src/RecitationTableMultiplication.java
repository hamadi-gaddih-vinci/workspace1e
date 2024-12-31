public class RecitationTableMultiplication {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
     int premierNombre = unEntierAuHasardEntre(1,10);
     int secondNombre = 1;
     int reponse;
     int user;
     do {
         System.out.println("Faite la table de multiplication de : " + premierNombre);
         System.out.println(premierNombre + "x" + secondNombre + ":");
         reponse = premierNombre*secondNombre;
         user = scanner.nextInt();
         secondNombre++;
     } while (reponse==user && secondNombre <= 10);
     if (reponse != user)
        System.out.println("Non c'est faux la bonne réponse était : " + reponse);
     else System.out.println("Félicitation");
    }
    public static int unEntierAuHasardEntre(int valeurMinimale, int valeurMaximale) {
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}
