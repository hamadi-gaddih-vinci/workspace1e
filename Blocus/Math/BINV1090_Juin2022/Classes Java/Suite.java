public class Suite extends SuiteDeBase {

	// valeur numérique de MAXELT
	private static final int MAX = Elt.MAXELT.val();

	/** Constructeur vide */
	public Suite() {
		super();
	}

	/** Constructeur par recopie */
	public Suite(SuiteDeBase s) {
		super(s);
	}

	/** Constructeur à partir d'une String */
	public Suite(String st) {
		super(st);
	}

	/** Constructeur à partir d'un Elt et d'une Suite */
	public Suite(Elt t, Suite c) {
		super(t, c);
	}

	/** Construit la Suite réduite à (x) */
	public Suite(Elt x) {
		this();
		this.ajouter(x);
	}

	public Suite corps() {
		return (Suite) super.corps();
	}
	
	@Override
	public int hashCode(){
		int prime = 31;
		int result = 1;
		for (Elt e : this){
			result = result *prime + e.hashCode();
		}
		return result;
	}

	/* Renvoie la somme des éléments de la suite plus grands ou égaux à x
	 * Exemples :
	 * ----------
	 * this = (3,9,6,3,10) et x=9  alors sommeDesPlusGrandsQue(x) --> 19 = 9+10
	 * this = (4,9,2,12,6) et x=5  alors sommeDesPlusGrandsQue(x) --> 9+12+6 = 27
	 * this = ()           et x=-1 alors sommeDesPlusGrandsQue(x) --> 0
	 * this = (11,3,9)     et x=12 alors sommeDesPlusGrandsQue(x) --> 0
	 * @param int x : minimum des nombres à sommer
	 * @return la somme des éléments de la suite plus grands ou égaux à x
	 */

	public int sommeDesPlusGrandsQue(int x) {
		//TODO
		if (this.estVide())
			return 0;
		int somme = 0;
		if (this.tete().val() >= x)
			somme = this.tete().val();
		return somme+this.corps().sommeDesPlusGrandsQue(x);

	}

	/*  Renvoie true si la suite contient au moins n éléments et false sinon
	 *  Exemples :
	 *  ----------
	 *  this = (3,7,5,12,2) et n=4  alors contientAuMoinsNElements(n) --> true
	 *  this = (3,7,5,12,2) et n=5  alors contientAuMoinsNElements(n) --> true
	 *  this = (3,7,5,12,2) et n=6  alors contientAuMoinsNElements(n) --> false
	 *  this = ()           et n=1  alors contientAuMoinsNElements(n) --> false
	 *  this = ()           et n=0  alors contientAuMoinsNElements(n) --> true
	 *  this = (3,7,5,12,2) et n=-1 alors contientAuMoinsNElements(n) --> IllegalArgumentException
	 * @param int n : nombre minimal d'éléments
	 * @return true  si la suite à au moins n éléments
	 *         false sinon
	 * @throw IllegalArgumentException si n<0
	 */
	public boolean contientAuMoinsNElements(int n) {
		//TODO
		//IL EST INTERDIT D'UTILISER LA MÉTHODE longueur OU TOUT AUTRE MÉTHODE CALCULANT LA LONGUEUR DE LA SUITE !!!
		if (n < 0)
			throw new IllegalArgumentException();
		return contientAuMoinsNElementsBis(n);
	}

	private boolean contientAuMoinsNElementsBis(int n){
		if (n == 0)
			return true;
		if (this.estVide())
			return false;
		return this.corps().contientAuMoinsNElementsBis(n-1);
	}

} 

