import javax.swing.*;
import java.util.Arrays;

public class Ens1 extends EnsembleAbstrait {

	private boolean[] tabB; // e appartient à l'ensemble courant ssi tabE[e.val()] est à true.
	private int cardinal;

	public Ens1() {
		this.tabB = new boolean[MAX+1];
		this.cardinal = 0;
	}

	public boolean estVide() {
		//TODO
		return cardinal == 0;
	}
	
	public Elt unElement() {
		//TODO
		Elt element = null;
		if (estVide())
			throw new MathException();
		for (int i = 1; i < tabB.length; i++) {
			if (tabB[i])
				element = new Elt(i);

		}	return element;

	}

	public boolean contient(Elt e) {
		//TODO
		if (e == null)
			throw new IllegalArgumentException();
		for (int i = 1; i < tabB.length ; i++) {
			if (tabB[i] && e.val() == i){
					return true;
			}
		} return false;
	}

	public void ajouter(Elt e) {
		if (e == null)
			throw new IllegalArgumentException();
		if (contient(e))
			return;
		cardinal ++;
		tabB[e.val()] = true;
		//TODO
		
	}

	public void enlever(Elt e) {
		//TODO
		if (e == null)
			throw new IllegalArgumentException();
		if (!contient(e))
			return;
		cardinal --;
		tabB[e.val()] = false;
	}

	public int cardinal() {
		//TODO
		return cardinal ;
	}

	public void complementer() {
		//TODO
		for (int i = 1; i < tabB.length; i++) {
			if (tabB[i]) {
				cardinal--;
				tabB[i] = false;
			}
			else {
				cardinal++;
				tabB[i] = true;
			}
		}
	}

	@Override
	public String toString() {
		return "Ens1: " + "tabB=" + Arrays.toString(tabB) +
				", cardinal=" + cardinal;
	}

}
