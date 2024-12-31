import javax.swing.*;

public class MultiplicationAuFinish {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Entrainement aux multiplications. Voici une multiplication :");
		System.out.println("Tant que tu n'as pas trouve la bonne reponse, tu dois la recommencer! ");

		int premierNombre = unEntierAuHasardEntre(0, 10);
		int secondNombre = unEntierAuHasardEntre(0, 10);
		System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
		int reponse = premierNombre * secondNombre;
		int calculEleve = scanner.nextInt();
		while (calculEleve!=reponse ) {
			System.out.println("faux");
			int calculEleve2 = scanner.nextInt();
			if (calculEleve2 == reponse){
				break;
			}

		} System.out.println("bravo");

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
