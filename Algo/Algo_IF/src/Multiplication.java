public class Multiplication{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
		System.out.println("Entrainement aux multiplications. Voici un exercice :");
		
		int nombre1 = unEntierAuHasardEntre (0, 10);
		int nombre2 = unEntierAuHasardEntre (0, 10);
		int nombre3 = unEntierAuHasardEntre(0, 10);
		System.out.println("Calculez : " + nombre1 + " x " + nombre2 + " x " + nombre3 +" = ");
		
		int resultat = nombre1*nombre2*nombre3;
		int answer = scanner.nextInt();
		if (answer==resultat) {
			System.out.println("Bravo!");

		}
		else {
			System.out.println(resultat);
		}
	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}