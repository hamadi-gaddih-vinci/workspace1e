public class NombreMystere {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
     int nombreAuHasard = unEntierAuHasardEntre(0,100);
     int nombreTentive = 0;
     int user;
        System.out.println("La réponse est : " + nombreAuHasard);
     do {
         nombreTentive ++;
         System.out.println("Nombre de tentative : " + nombreTentive);
         System.out.println("Entrez un chiffre : ");
         user = scanner.nextInt();
         if (user > nombreAuHasard) System.out.println("Réessaye le chiffre est trop grand");
         if (user < nombreAuHasard) System.out.println("Réessaye le chiffre est trop petit");
     } while (user != nombreAuHasard);
         System.out.println("\n" + "Bravo vous avez réussi avec : " + nombreTentive + " tentatives.");
    }
    public static int unEntierAuHasardEntre(int valeurMinimale, int valeurMaximale) {
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}
