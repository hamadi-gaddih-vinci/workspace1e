import java.util.Scanner;

public class GestionRallyeAutomobile {
    private static Scanner scanner = new Scanner(System.in);

    private static RallyeAutomobile course;

    public static void main(String[] args) {
        System.out.println("*******************************************");
        System.out.println("Programme de gestion d'un Rallye Automobile");
        System.out.println("*******************************************");
        System.out.println();
        System.out.print("Entrez le nombre de pilotes ");


        int nbPiole = scanner.nextInt();
        String [] tableauPilotes = new String[nbPiole];

        for (int i = 0; i<nbPiole; i++){
            String nom;
            System.out.print("Entrez le nom du pilote  " + (i+1) + " : ");
            nom = scanner.next();
            tableauPilotes[i] = nom;
        }
        course = new RallyeAutomobile(tableauPilotes);



        int choix = 0;
        do {
            System.out.println();
            System.out.println("1 -> Afficher toute la course");
            System.out.println("2 -> Afficher le pilote en tête");
            System.out.println("3 -> Enregister un dépassement");
            System.out.println("4 -> Retirer un piolte de la course");
            System.out.println("5 -> Donner la position d'un piolte");
            System.out.println("6 -> Faire franchir la ligne d'arrivée à un pilote");
            choix = scanner.nextInt();
            switch (choix){
                case 1:
                    afficherTouteLaCourse();
                    break;
                case 2:
                    afficherPiloteTete();
                    break;
                case 3:
                    enregistrerDepassement();
                    break;
                case 4:
                    retirerPilote();
                    break;
                case 5:
                    donnerPositionPilote();
                    break;
                case 6:
                    franchirLigneArrive();
                    break;
            }
        }while (choix>=1 && choix<=6);
    }

    private static void afficherTouteLaCourse(){
        System.out.println(course.afficherTouteLaCourse());
    }

    private static void afficherPiloteTete(){
        System.out.println(course.donnerPiloteEnTete());
    }
    private static void enregistrerDepassement(){
        System.out.println("Entrez le pilote qui dépasse");
        String pilote = scanner.next();
        System.out.println(course.enregistrerDoublement(pilote));
    }
    private static void retirerPilote(){
        System.out.println("Entrez le pilote à supprimer");
        String pilote = scanner.next();
        System.out.println(course.supprimer(pilote));
    }
    private static void donnerPositionPilote(){
        System.out.println(course.donnerPiloteEnTete());
    }
    private static void franchirLigneArrive(){
        System.out.println("Entrez le pilote qui a franchit la ligne d'arrivée");
        String pilote = scanner.next();
        System.out.println(course.franchirLigneArrive(pilote));
    }


}
