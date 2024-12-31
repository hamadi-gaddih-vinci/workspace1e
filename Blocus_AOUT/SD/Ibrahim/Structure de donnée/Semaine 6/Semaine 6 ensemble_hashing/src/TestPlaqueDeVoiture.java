public class TestPlaqueDeVoiture {

	public final static int NBRE_LISTES =500;
	
	public static void main (String args[]) {
		// Attention, la methode hashCode() renvoie un entier
		// Cet entier pourrait etre negatif --> Math.abs()		
		// Cet entier doit correspondre a une liste --> %NBRE_LISTES
		int table [] = new int[NBRE_LISTES];
		for (char i ='A'; i <= 'Z'; i++){
			for (char o = 'A'; o <='Z'; o++){
				for (char j = 'A'; j <= 'Z' ; j++) {
					for (int k = 0; k <= 9 ; k++) {
						for (int l = 0; l <=9; l++) {
							for (int m = 0; m <= 9; m++) {
								String plaque = "1"+ i + o + j + k + l + m;
								Voiture voiture = new Voiture(plaque,"");
								int index = Math.abs(voiture.hashCode())%NBRE_LISTES;
								table[index]++;
							}
						}
					}
				}
			}
		}
		for (int i =0; i< NBRE_LISTES; i++){
			System.out.println(table[i]);
		}
	}
}