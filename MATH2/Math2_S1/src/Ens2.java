public class Ens2 extends EnsembleAbstrait {

	private Elt[] elements; // contient les elements de l'ensemble. Il ne peut pas y avoir de doublon.
	private int cardinal;

	public Ens2() {
		this.elements = new Elt[MAX];
		this.cardinal = 0;
		//TODO
		
	}

	public boolean estVide() {
		//TODO
		return this.cardinal <=0 ;
	}
	
	public Elt unElement() {
		//TODO
		Elt e = null;
		if (estVide())
			throw new MathException();
		for (int i = 0; i < cardinal ; i++) {
			if (elements[i] != null)
				e = elements[i];
		}
		return e ;
	}

	public boolean contient(Elt e) {
		//TODO
		if (e == null)
			throw new IllegalArgumentException();
		for (int i = 0; i < cardinal ; i++) {
			if (elements[i].equals(e))
				return true;
		}
		return false;
	}

	public void ajouter(Elt e) {
		//TODO
		if (e == null)
			throw new IllegalArgumentException();
		if (contient(e))
			return;
		cardinal++;
		elements[cardinal-1] = e;
	}

	public void enlever(Elt e) {
		//TODO
		if (e == null)
			throw new IllegalArgumentException();
		int c = -1;
		for (int i = 0; i < cardinal; i++) {
			if (elements[i].equals(e)) {
				c = i;
				break;
			}
		}
		if (c != -1){
			elements[c] = elements[cardinal-1];
			cardinal--;
		}
	}

	public int cardinal() {
		//TODO
		return cardinal;
	}

	public void complementer() {
		//TODO;
	}

	public String toString() {
		//TODO
		return null ;
	}

}
