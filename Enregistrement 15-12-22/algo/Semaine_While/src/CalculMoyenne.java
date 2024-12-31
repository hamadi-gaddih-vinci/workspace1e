public class CalculMoyenne {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int cote;
        char reponse;
        int moyenne;
        moyenne = 0;
        int total;
        total = 0;
        do {
            System.out.println("Entrer une côte");
            cote = scanner.nextInt();
            System.out.println("Est-ce qu'il y a une autre côte?");
            reponse = scanner.next().charAt(0);
            moyenne ++;
            total = total + cote;
        } while (reponse =='Y' || reponse == 'y');
        System.out.println("La moyenne est" + " " + (total/moyenne));

}

}








