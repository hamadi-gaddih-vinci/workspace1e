import java.util.ArrayList;
import java.util.Scanner;

public class TestABRDEntiers {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 *
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
			System.exit(0);
		}
	}



	public static void main(String[] args) {

		System.out.println("***************************");
		System.out.println("Programme Test ABRDEntiers ");
		System.out.println("***************************");

		int choix;
		do {
			System.out.println();
			System.out.println("1 ->  Tester la methode nombrePositifs()");
			System.out.println("2 ->  Tester la methode nombrePairs");
			System.out.println("3 ->  Tester la methode nombreOccurrences()");
			System.out.println("4 ->  Tester la methode contient()");
			System.out.println("5 ->  Tester la methode tousPositifs()");
			System.out.println("6 ->  Tester la methode auMoins1Pair()");
			System.out.println("7 ->  Tester la methode tousPlusGrands()");
			System.out.println("8 ->  Tester la methode somme()");
			System.out.println("9 ->  Tester la methode max()");
			System.out.println("10 ->  Tester la methode toArrayList()");
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix=scanner.nextInt();
			switch (choix) {
				case 1:
					testNombrePositifs();
					break;
				case 2:
					testNombrePairs();
					break;
				case 3:
					testNombreOcc();
					break;
				case 4:
					testContient();
					break;
				case 5:
					testTousPositif();
					break;
				case 6:
					testAuMoins1Pair();
					break;
				case 7:
					testTousPlusGrands();
					break;
				case 8:
					testSomme();
					break;
				case 9:
					testMax();
					break;
				case 10:
					testToArrayList();
					break;
				default:
					break;
			}
		} while (choix >= 1 && choix <= 10);

	}

	private static void testNombrePositifs() {
		System.out.println("le document CodeRunnerABRTestes contient une visualisation de chaque arbre teste");
		ABRDEntiers a;
		a = ABR.ABR4();
		System.out.println("arbre teste : arbre 4");
		assertEquals("test ko",5,a.nombrePositifs());
		a = ABR.ABR5();
		System.out.println("arbre teste : arbre 5");
		assertEquals("test ko",1,a.nombrePositifs());
		a = ABR.ABR6();
		System.out.println("arbre teste : arbre 6");
		assertEquals("test ko",0,a.nombrePositifs());
		a = ABR.ABR1();
		System.out.println("arbre teste : arbre 1");
		assertEquals("test ko",0,a.nombrePositifs());
		System.out.println("tous les tests ont reussi");
	}

	private static void testNombrePairs() {
		System.out.println("le document CodeRunnerABRTestes contient une visualisation de chaque arbre teste");
		ABRDEntiers a;
		a = ABR.ABR3();
		System.out.println("arbre teste : arbre 3");
		assertEquals("test ko",6,a.nombrePairs());
		a = ABR.ABR2();
		System.out.println("arbre teste : arbre 2");
		assertEquals("test ko",9,a.nombrePairs());
		a = ABR.ABR1();
		System.out.println("arbre teste : arbre 1");
		assertEquals("test ko",0,a.nombrePairs());
		System.out.println("tous les tests ont reussi");
	}

	private static void testNombreOcc() {
		System.out.println("le document CodeRunnerABRTestes contient une visualisation de chaque arbre teste");
		ABRDEntiers a;
		int entier;
		a = ABR.ABR2();
		entier = 8;
		System.out.println("arbre teste : arbre 2");
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",1,a.nombreOccurrences(entier));
		entier = 12;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",3,a.nombreOccurrences(entier));
		entier = 6;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",2,a.nombreOccurrences(entier));
		entier = 15;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",0,a.nombreOccurrences(entier));
		a = ABR.ABR1();
		entier = 3;
		System.out.println("arbre teste : arbre 1");
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",0,a.nombreOccurrences(entier));
		System.out.println("tous les tests ont reussi");
	}

	private static void testContient() {
		System.out.println("le document CodeRunnerABRTestes contient une visualisation de chaque arbre teste");
		ABRDEntiers a;
		int entier;
		a = ABR.ABR3();
		entier = 10;
		System.out.println("arbre teste : arbre 3");
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",true,a.contient(entier));
		entier = 15;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",true,a.contient(entier));
		entier = 9;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",false,a.contient(entier));
		a = ABR.ABR1();
		entier = 3;
		System.out.println("arbre teste : arbre 1");
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",false,a.contient(entier));
		System.out.println("tous les tests ont reussi");
	}

	private static void testTousPositif() {
		System.out.println("le document CodeRunnerABRTestes contient une visualisation de chaque arbre teste");
		ABRDEntiers a;
		a = ABR.ABR2();
		System.out.println("arbre teste : arbre 2");
		assertEquals("test ko",true,a.tousPositifs());
		a = ABR.ABR4();
		System.out.println("arbre teste : arbre 4");
		assertEquals("test ko",false,a.tousPositifs());
		a = ABR.ABR1();
		System.out.println("arbre teste : arbre 1");
		assertEquals("test ko",true,a.tousPositifs());
		System.out.println("tous les tests ont reussi");
	}

	private static void testAuMoins1Pair() {
		System.out.println("le document CodeRunnerABRTestes contient une visualisation de chaque arbre teste");
		ABRDEntiers a;
		a = ABR.ABR4();
		System.out.println("arbre teste : arbre 4");
		assertEquals("test ko",true,a.auMoins1Pair());
		a = ABR.ABR1();
		System.out.println("arbre teste : arbre 1");
		assertEquals("test ko",false,a.auMoins1Pair());

		System.out.println("tous les tests ont reussi");
	}

	private static void testTousPlusGrands() {
		System.out.println("le document CodeRunnerABRTestes contient une visualisation de chaque arbre teste");
		ABRDEntiers a;
		int entier;
		a = ABR.ABR3();
		System.out.println("arbre teste : arbre 3");
		entier = 3;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",true,a.tousPlusGrands(entier));
		entier = 9;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",false,a.tousPlusGrands(entier));
		a = ABR.ABR1();
		System.out.println("arbre teste : arbre 1");
		entier = 5;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",true,a.tousPlusGrands(entier));
		System.out.println("tous les tests ont reussi");
	}

	private static void testSomme() {
		System.out.println("le document CodeRunnerABRTestes contient une visualisation de chaque arbre teste");
		ABRDEntiers a;
		a = ABR.ABR3();
		System.out.println("arbre teste : arbre 10");
		assertEquals("test ko",93,a.somme());
		a = ABR.ABR1();
		System.out.println("arbre teste : arbre 1");
		assertEquals("test ko",0,a.somme());
		System.out.println("tous les tests ont reussi");
	}

	private static void testMax() {
		System.out.println("le document CodeRunnerABRTestes contient une visualisation de chaque arbre teste");
		ABRDEntiers a;
		a = ABR.ABR4();
		System.out.println("arbre teste : arbre 4");
		assertEquals("test ko",18,a.max());
		a = ABR.ABR7();
		System.out.println("arbre teste : arbre 7");
		assertEquals("test ko",25,a.max());

		System.out.println("tous les tests ont reussi");
	}

	private static void testToArrayList() {
		System.out.println("le document CodeRunnerABRTestes contient une visualisation de chaque arbre teste");
		ABRDEntiers a;
		ArrayList<Integer> arrayList;
		a = ABR.ABR3();
		System.out.println("arbre teste : arbre 4");
		arrayList = new ArrayList<>();
		arrayList.add(4);
		arrayList.add(6);
		arrayList.add(7);
		arrayList.add(8);
		arrayList.add(10);
		arrayList.add(12);
		arrayList.add(13);
		arrayList.add(15);
		arrayList.add(18);
		assertEquals("test ko",arrayList,a.toArrayList());
		a = ABR.ABR1();
		System.out.println("arbre teste : arbre 1");
		arrayList = new ArrayList<>();
		assertEquals("test ko",arrayList,a.toArrayList());

		System.out.println("tous les tests ont reussi");
	}

}
