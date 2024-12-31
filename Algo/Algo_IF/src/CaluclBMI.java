import java.util.Scanner;

public class CaluclBMI {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrer valeurHumain : ");
        int valeurHumain = scanner.nextInt();

        if (valeurHumain<20){
            System.out.println("Vous êtes mince");
        } else if (valeurHumain>25 && valeurHumain<=30) {
            System.out.println("Vous êtes embonpoint");

            
        } else if (valeurHumain>30) {
            System.out.println("Vous êtes obèse");

        }
        else {
            System.out.println("Vous êtes normal");
        }


    }
}







