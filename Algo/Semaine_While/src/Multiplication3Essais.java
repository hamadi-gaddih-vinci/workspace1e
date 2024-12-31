
public class Multiplication3Essais {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
		System.out.println("Entrainement aux multiplications. Voici une multiplication :");
		System.out.println("Tu as droit a 3 essais");
		int premierNombre = unEntierAuHasardEntre (0, 10);
		int secondNombre = unEntierAuHasardEntre (0, 10);
		System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");

		// A COMPLETER
		int reponse = premierNombre*secondNombre;
		int calculEleve = scanner.nextInt();
		int x = 0;
		int y = 3;

		if (calculEleve==reponse){
			System.out.println("bravo");
		}

			while (calculEleve != reponse) {

				System.out.println("C'est faux, il te reste" + " " + y);
				int calculeEleve2 = scanner.nextInt();

				if (calculeEleve2 == reponse) {

					System.out.println("brv");
					break;

				} else {
					x++;
					y--;
					if (x >= 3 && y <= 0) {
						System.out.println("ta rater");
						break;

					}
				}

			}








		}


	// A NE PAS MODIFIER
	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
	
}
