public class Utilitaires {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * genere un entier compris entre les 2 valeurs passees en parametre
     * @param valeurMinimale la valeur minimale de l'entier genere
     * @param valeurMaximale la valeur maximale de l'entier genere
     * @return l'entier genere
     */
    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
    }

    /**
     * lit un nombre reel positif ou nul
     * @return un nombre reel positif
     */
    public static double lireReelPositif(){
        double x = scanner.nextDouble();
        while(x < 0){
            System.out.println("Attention le reel doit etre positif");
            System.out.print("Recommencez : ");
            x = scanner.nextDouble();
        }
        return x;
    }


    /**
     * lit un nombre reel compris entre les 2 valeurs passees en parametre
     * @param min le plus petit reel accepte
     * @param max le plus grand reel accepte
     * @return un nombre reel compris entre 2 bornes
     */
    public static double lireReelComprisEntre(double min, double max ){
       double x = scanner.nextDouble();
       while(x > max || x < min){
           System.out.println("Attention le reel doit être compris entre " + min +
                   " et " + max);
           System.out.println("Reccomencez : " );
           x = scanner.nextDouble();
       }
       return x;
        // TODO
    }


    /**
     * lit le caractere o ou n
     * @return le caractere o un n
     */
    public static char lireOouN(){
        char p = scanner.next().charAt(0);
        while (p != 'o' && p != 'n'){
            System.out.println("Veuillez choisir une lettre entre o ou n");
            System.out.print("Recommencez : ");
            p = scanner.next().charAt(0);
        // TODO
    } return p;

}
    public static int lireEntierNonNul(){
        int x = scanner.nextInt();
        while (x == 0){
            System.out.println("Veuillez ecrire un entier non-nul");
            System.out.print("Recommencez : ");
            x = scanner.nextInt();
        } return x;

    }
    public static final int max3(int x, int y, int z){
        if (x>y && x>z)
            return x;
        if (y>x && y>z)
            return y;
        return z;
    }
    public static final int donnerCommentaire(){
        int cote = scanner.nextInt();
        if (cote < 10) {
            System.out.println("L'etudiant n'a pas valide l'UE.");
        } else if (cote < 14) {
            System.out.println("L'etudiant a valide l'UE.");
        } else if (cote < 16) {
            System.out.println("L'etudiant a valide l'UE avec une belle cote.");
        } else {  // cote >= 16
            System.out.println("L'etudiant a valide l'UE avec une tres belle cote.");
        } return cote;
    }
    public static final int nbCote(){
        int cote = scanner.nextInt();
        for (int i = 1; i <= 25; i++) {
            for (int j = 1; j <= 10 ; j++) {
                System.out.println("Entre la côte n° " + j + " de l'élève n° " + i);
                cote = scanner.nextInt();
            }
        } return cote;
    }
}
