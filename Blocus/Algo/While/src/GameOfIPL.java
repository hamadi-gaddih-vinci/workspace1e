import javax.swing.text.Utilities;

public class GameOfIPL {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int cogneDur = 25;
        int frappeFort = 25;
        System.out.println("Bienvenue au combat entre Cognedur et Frappefort." + '\n');
        while (cogneDur > 0 || frappeFort > 0) {
            int coupeEpee = unEntierAuHasardEntre(1, 6);
            System.out.println("CogneDur inflige " + " " + coupeEpee + " " + "points de dégats à FrappeFort");
            frappeFort -= coupeEpee;
            System.out.println("Il reste" + " " + frappeFort + " " + "points de vie à FrappeFort");
            if (frappeFort <= 0)
                break;
            coupeEpee = unEntierAuHasardEntre(1, 6);
            System.out.println("FrappeFort inflige " + " " + coupeEpee + " " + "points de dégats à CogneDur");
            cogneDur -= coupeEpee;
            System.out.println("Il reste" + " " + cogneDur + " " + "points de vie à CogneDur" + '\n');
            if (cogneDur <= 0)
                break;
        }
        if (frappeFort <= 0)
            System.out.println("CogneDur a gagné");
        else System.out.println("FrappeFort a gagné");

        
    }

    public static int unEntierAuHasardEntre(int valeurMinimale, int valeurMaximale) {
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}
