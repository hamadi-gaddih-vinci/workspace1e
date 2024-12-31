public class CalculMoyenne {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        double moyenne = 0;
        char reponse;
        do {
            int nombreDeCote = 0;
            double totalCote = 0;
            System.out.println("Ecrivez une cote : ");
            double cote = scanner.nextDouble();
            nombreDeCote++;
            totalCote += cote;
            moyenne = totalCote / nombreDeCote;
            System.out.println("Y'a-t-il encore une cote?");
            reponse = scanner.next().charAt(0);
        } while (reponse == 'Y' || reponse == 'y' || reponse == 'O' || reponse == 'o');
        System.out.println("La moyenne des côtes est " + moyenne);
    }
}
