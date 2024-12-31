import java.util.Arrays;

public class StatistiquesTemperatures {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static Temperatures temperatures;
	
	public static void main(String[] args) {
		
		chargerTemperatures();
		System.out.println(temperatures.toString());
		
		System.out.println("*****************************");
		System.out.println("Temperatures : statistiques :");
		System.out.println("*****************************");
		int choix;
		do{
			System.out.println();
			System.out.println("1 -> afficher toutes les temperatures");	
			System.out.println("2 -> calculer la moyenne");	
			System.out.println("3 -> température min");
			System.out.println("4 -> nombre jours de gel");
			System.out.println("5 -> Jour de gel");
			System.out.println("6 -> Toutes Positives?");
			System.out.println("7 -> Contient ou moins 1 jour de gel");
			System.out.print("Entrez votre choix : ");	
			choix=scanner.nextInt();
			switch(choix){	
			case 1: afficherTout();   
			break;
			case 2: afficherMoyenne();   
			break;
			case 3 :
			}
		}while(choix >=1 && choix<=2);
	}
	
	private static void afficherTout() {
		System.out.println(temperatures.toString());
	}

	private static void afficherMoyenne() {
		// TODO
		System.out.println("cette methode et la classe doivent etre completees");
	}
	private static void temperatureMin(){
		System.out.println("La température minimum est : " + temperatures.temperatureMin()+"°");
	}
	private static void nbJourGeler(){
		System.out.println("Le nombre de jour gelé est de : " + temperatures.nombreJoursDeGel());
	}
	private static void jourDeGel(){
		System.out.println("Les jours de gel sont : " + temperatures.joursDeGel());
	}

	public static void chargerTemperatures(){
		double[]tableTemperatures = {-1,1,0,1,-1,-3,-3,-2,0,-1,0,1,1,3,5,4,2,0,1,1,5,3,2,0,-1,0,1,1,3,4,5};
		temperatures = new Temperatures("janvier",tableTemperatures);
	}
	
	public static void afficherTable(int[]table){
		System.out.println(Arrays.toString(table));
	}
	
}
