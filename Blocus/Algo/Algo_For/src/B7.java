public class B7 {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int coteMax = 0;
        int numeroVainquer = 0;
        int numeroVainquerExAequo = 0;
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("Entre le résultat du participant n°" + i + ": ");
            int cote = scanner.nextInt();
            if (cote == coteMax){
                numeroVainquerExAequo = i;
            }
            if (cote > coteMax) {
                coteMax = cote;
                numeroVainquer = i;
            }
        }
        if (numeroVainquerExAequo > 0) {
            System.out.println("Le numero du vainqueur est le numéro " + numeroVainquer + " mais il y a eu ex-Aequo avec le numéro " + numeroVainquerExAequo);
        }
        else System.out.println("Le numero du vainqueur est le numéro " + numeroVainquer);
    }
    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}