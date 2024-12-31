import java.util.Scanner;

public class TestArbreDEntiers {
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

		System.out.println("*****************************");
		System.out.println("Programme Test ArbreDEntiers ");
		System.out.println("*****************************");

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
			System.out.println("10 ->  Tester la methode contientExAequo()");
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
					testContientExAequo();
					break;
				default:
					break;
			}
		} while (choix >= 1 && choix <= 10);

	}

	private static void testNombrePositifs() {
		System.out.println("le document CodeRunnerArbresTestes contient une visualisation de chaque arbre teste");
		ArbreDEntiers a;
		a = A.arbre7();
		System.out.println("arbre teste : arbre 7");
		assertEquals("test ko",7,a.nombrePositifs());
		a = A.arbre6();
		System.out.println("arbre teste : arbre 6");
		assertEquals("test ko",0,a.nombrePositifs());
		a = A.arbre10();
		System.out.println("arbre teste : arbre 10");
		assertEquals("test ko",8,a.nombrePositifs());
		a = A.arbre1();
		System.out.println("arbre teste : arbre 1");
		assertEquals("test ko",0,a.nombrePositifs());
		System.out.println("tous les tests ont reussi");
	}

	private static void testNombrePairs() {
		System.out.println("le document CodeRunnerArbresTestes contient une visualisation de chaque arbre teste");
		ArbreDEntiers a;
		a = A.arbre4();
		System.out.println("arbre teste : arbre 4");
		assertEquals("test ko",2,a.nombrePairs());
		a = A.arbre5();
		System.out.println("arbre teste : arbre 5");
		assertEquals("test ko",9,a.nombrePairs());
		a = A.arbre2();
		System.out.println("arbre teste : arbre 2");
		assertEquals("test ko",0,a.nombrePairs());
		a = A.arbre1();
		System.out.println("arbre teste : arbre 1");
		assertEquals("test ko",0,a.nombrePairs());
		System.out.println("tous les tests ont reussi");
	}

	private static void testNombreOcc() {
		System.out.println("le document CodeRunnerArbresTestes contient une visualisation de chaque arbre teste");
		ArbreDEntiers a;
		int entier;
		a = A.arbre3();
		entier = 9;
		System.out.println("arbre teste : arbre 3");
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",1,a.nombreOccurrences(entier));
		entier = 11;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",2,a.nombreOccurrences(entier));
		entier = 8;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",0,a.nombreOccurrences(entier));
		a = A.arbre1();
		entier = 3;
		System.out.println("arbre teste : arbre 1");
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",0,a.nombreOccurrences(entier));
		System.out.println("tous les tests ont reussi");
	}

	private static void testContient() {
		System.out.println("le document CodeRunnerArbresTestes contient une visualisation de chaque arbre teste");
		ArbreDEntiers a;
		int entier;
		a = A.arbre3();
		entier = 9;
		System.out.println("arbre teste : arbre 3");
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",true,a.contient(entier));
		entier = 11;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",true,a.contient(entier));
		entier = 8;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",false,a.contient(entier));
		a = A.arbre1();
		entier = 3;
		System.out.println("arbre teste : arbre 1");
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",false,a.contient(entier));
		System.out.println("tous les tests ont reussi");
	}

	private static void testTousPositif() {
		System.out.println("le document CodeRunnerArbresTestes contient une visualisation de chaque arbre teste");
		ArbreDEntiers a;
		a = A.arbre7();
		System.out.println("arbre teste : arbre 7");
		assertEquals("test ko",false,a.tousPositifs());
		a = A.arbre8();
		System.out.println("arbre teste : arbre 8");
		assertEquals("test ko",false,a.tousPositifs());
		a = A.arbre6();
		System.out.println("arbre teste : arbre 6");
		assertEquals("test ko",false,a.tousPositifs());
		a = A.arbre10();
		System.out.println("arbre teste : arbre 10");
		assertEquals("test ko",true,a.tousPositifs());
		a = A.arbre1();
		System.out.println("arbre teste : arbre 1");
		assertEquals("test ko",true,a.tousPositifs());
		System.out.println("tous les tests ont reussi");
	}

	private static void testAuMoins1Pair() {
		System.out.println("le document CodeRunnerArbresTestes contient une visualisation de chaque arbre teste");
		ArbreDEntiers a;
		a = A.arbre4();
		System.out.println("arbre teste : arbre 4");
		assertEquals("test ko",true,a.auMoins1Pair());
		a = A.arbre2();
		System.out.println("arbre teste : arbre 2");
		assertEquals("test ko",false,a.auMoins1Pair());
		a = A.arbre9();
		System.out.println("arbre teste : arbre 9");
		assertEquals("test ko",true,a.auMoins1Pair());
		a = A.arbre1();
		System.out.println("arbre teste : arbre 1");
		assertEquals("test ko",false,a.auMoins1Pair());

		System.out.println("tous les tests ont reussi");
	}

	private static void testTousPlusGrands() {
		System.out.println("le document CodeRunnerArbresTestes contient une visualisation de chaque arbre teste");
		ArbreDEntiers a;
		int entier;
		a = A.arbre3();
		System.out.println("arbre teste : arbre 3");
		entier = 2;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",true,a.tousPlusGrands(entier));
		entier = 4;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",false,a.tousPlusGrands(entier));
		a = A.arbre1();
		System.out.println("arbre teste : arbre 1");
		entier = 5;
		System.out.println("entier teste : "+entier);
		assertEquals("test ko",true,a.tousPlusGrands(entier));
		System.out.println("tous les tests ont reussi");
	}

	private static void testSomme() {
		System.out.println("le document CodeRunnerArbresTestes contient une visualisation de chaque arbre teste");
		ArbreDEntiers a;
		a = A.arbre10();
		System.out.println("arbre teste : arbre 10");
		assertEquals("test ko",68,a.somme());
		a = A.arbre1();
		System.out.println("arbre teste : arbre 1");
		assertEquals("test ko",0,a.somme());
		System.out.println("tous les tests ont reussi");
	}

	private static void testMax() {
		System.out.println("le document CodeRunnerArbresTestes contient une visualisation de chaque arbre teste");
		ArbreDEntiers a;
		a = A.arbre4();
		System.out.println("arbre teste : arbre 4");
		assertEquals("test ko",17,a.max());
		a = A.arbre6();
		System.out.println("arbre teste : arbre 6");
		assertEquals("test ko",-2,a.max());

		System.out.println("tous les tests ont reussi");
	}

	private static void testContientExAequo() {
		System.out.println("le document CodeRunnerArbresTestes contient une visualisation de chaque arbre teste");
		ArbreDEntiers a;
		a = A.arbre4();
		System.out.println("arbre teste : arbre 4");
		assertEquals("test ko",false,a.contientExAequo());
		a = A.arbre3();
		System.out.println("arbre teste : arbre 3");
		assertEquals("test ko",true,a.contientExAequo());
		a = A.arbre1();
		System.out.println("arbre teste : arbre 1");
		assertEquals("test ko",false,a.contientExAequo());
		System.out.println("tous les tests ont reussi");
	}

}
