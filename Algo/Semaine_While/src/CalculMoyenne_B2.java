public class CalculMoyenne_B2 {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        double cote;
        char reponse;
        double moyenne;
        moyenne = 0;
        double total;
        total = 0;
        do {
            System.out.println("Entrer une côte");
            cote = scanner.nextInt();
            System.out.println("Est-ce qu'il y a une autre côte?");
            reponse = scanner.next().charAt(0);
            moyenne ++;
            total = total + cote;
        } while (reponse =='Y' || reponse == 'y' || reponse == 'O' || reponse == 'o');
        System.out.println("La moyenne est" + " " + (total/moyenne));

}

}








