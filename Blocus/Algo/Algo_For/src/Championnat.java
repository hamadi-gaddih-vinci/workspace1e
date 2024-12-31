public class Championnat {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        double jury = 8;
        double coteMax = 0;
        double coteMin = 10;
        double totalCote = 0;
        double moyenne = 0;
        for (int i = 1; i <= jury ; i++) {
            System.out.println("Entrez la cote du jury n°" + i);
            double cote = scanner.nextInt();
            if (cote > coteMax)
                coteMax = cote;
            if (cote < coteMin)
                coteMin = cote;
            totalCote += cote;
        }
        totalCote -= coteMax;
        totalCote -= coteMin;
        moyenne = totalCote/(jury-2);
        System.out.println("Le resultat du concurent est " + moyenne);
        if (moyenne >= 8) {
            System.out.println("Le concurrent est en final");
        }
        else {
            System.out.println("Le concurrent n'est pas en final");
        }
    }
}
