public class DuelGuerriers {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		int lancerDe = unEntierAuHasardEntre(1, 6);

		int pointDeVieCogneDur = unEntierAuHasardEntre(1, 6);
		int pointDeVieFrappeFort = unEntierAuHasardEntre(1, 6);
		System.out.println("Les point De Vie Cogne Dur" + " " + pointDeVieCogneDur);
		System.out.println("Les point De Vie Frappe Fort" + " " + pointDeVieFrappeFort);
		int forceDeFrappe = unEntierAuHasardEntre(1, 6);
		System.out.println("La force de frappe de Cogne Dur" + " " +forceDeFrappe);
		System.out.println("La force de frappe de Frappe Dur" + " " +forceDeFrappe);



	}
	
	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
	
	
	
}
