public class RecitationTableMultiplication$ {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Entrainement aux multiplications. Voici un chiffre au hasard :");
		System.out.println("Fais la table de multiplication");

		int chiffre = unEntierAuHasardEntre(0, 10);
		int x;
		x = 1;
		int reponse = chiffre*x;
		int calculEleve = scanner.nextInt();
		do {

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
