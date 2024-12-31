public class LireEntierPositif {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int entier;
        do{
            System.out.print("Entrez un entier positif");
            entier = scanner.nextInt();
        }while(entier <= 0);
        System.out.println(entier);
    }

}
