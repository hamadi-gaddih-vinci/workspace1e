public class DeuxMeilleursCotes {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        double coteMax = 0;
        double coteMax2 = 0;
        for (int i = 1; i <= 5 ; i++) {
            System.out.println("Ecrivez la cote n° " + i);
            double cote = scanner.nextDouble();
            if (cote > coteMax) {
                coteMax2 = coteMax;
                coteMax = cote;
            } else if (cote > coteMax2) {
                coteMax2 = cote;
            }

        }
        System.out.println("La cote la plus haute est " + coteMax);
        System.out.println("La seconde cote la plus haute est " + coteMax2);
    }
}
