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
			System.out.println("3 -> La temperature minimal");
			System.out.println("4 -> Nombre  jour de gèle");
			System.out.println("5 -> jour de gèle ");
			System.out.println("6 -> Temperature toutes positives ?");
			System.out.println("7 -> Contient au moins un jour de gel ?");
			System.out.println();
			System.out.print("Entrez votre choix : ");	
			choix=scanner.nextInt();
			switch(choix){	
			case 1: afficherTout();   
			break;
			case 2: afficherMoyenne();   
			break;
			case 3: temperatureMin();
			break;
			case 4: nombrejourDeGele();
			break;
			case 5: jourDeGele();
			break;
			case 6: toutesPositives();
			break;
			case 7:contientAuMoinsUnjourDeGel();
			}
		}while(choix >=1 && choix<=7);
	}
	
	private static void afficherTout() {
		System.out.println(temperatures.toString());
	}

	private static void afficherMoyenne() {

		System.out.println("La moyenne du mois de janvier est de "+temperatures.moyenne());
	}

	private static void temperatureMin() {
		System.out.println("La temperature minimum est de : "+temperatures.temperatureMin());
	}

	private static void	nombrejourDeGele(){
		System.out.println("Il y a "+temperatures.nombreJoursDeGel()+" jours de gèles");
	}
	private static void jourDeGele(){
		afficherTable(temperatures.joursDeGel());
	}

	private static void toutesPositives(){
		System.out.println(temperatures.toutesPositives());
	}

	private static void contientAuMoinsUnjourDeGel(){
		System.out.println(temperatures.contientAuMoinsUnJourDeGel());
	}


	public static void chargerTemperatures(){
		double[]tableTemperatures = {-1,1,0,1,-1,-3,-3,-2,0,-1,0,1,1,3,5,4,2,0,1,1,5,3,2,0,-1,0,1,1,3,4,5};
		temperatures = new Temperatures("janvier",tableTemperatures);
	}
	
	public static void afficherTable(int[]table){
		System.out.println(Arrays.toString(table));
	}
	
}
