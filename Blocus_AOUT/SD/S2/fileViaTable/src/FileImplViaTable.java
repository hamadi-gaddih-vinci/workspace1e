import java.util.Arrays;

// implementation de l'interface File via une table circulaire

/**
 * @author 
 *
 */

public class FileImplViaTable<E> implements File<E>{

	private Object[] table;  // ne modifiez pas cet identifiant, la classe test l'utilise					
	private int indiceTete;  // ne modifiez pas cet identifiant, la classe test l'utilise			
	private int taille;		// ne modifiez pas cet identifiant, la classe test l'utilise	
	// N'ajoutez pas d'autres attributs, la classe test risquerait de ne pas fonctionner
	

	public FileImplViaTable(){
		table = new Object[4];
		taille = 0;
		indiceTete = 0;
	}
	

	public boolean estVide(){
		return taille == 0;
	}


	public int taille(){
		return taille;
	}

	/**
	 * renvoie l'element qui se trouve en tete de file sans l'enlever de la file
	 * @return l'element en tete
	 * @throws FileVideException si la file est vide
	 */
	public E premier()throws FileVideException{
		if (estVide())
			throw new FileVideException();
		return (E) table[indiceTete];
		//TODO
	}

	/**
	 * renvoie l'element qui se trouve en tete de file et l'enleve de la file
	 * @return l'element en tete
	 * @throws FileVideException si la file est vide
	 */
	public E defile() throws FileVideException{
		if (estVide())
			throw new FileVideException();
		E e = premier();
		indiceTete = indiceTete +1;
		if (indiceTete == table.length)
			indiceTete = 0;
		taille--;
		return e;
		//TODO
	}

	/**
	 * ajoute un element en fin de file (queue)
	 * @param element l'element a ajouter
	 */
	public void enfile(E element){
		//TODO
		if (taille == table.length){
			Object[] tableBis = new Object[table.length*2];
			for (int i = 0; i < table.length; i++) {
				tableBis[i] = table[indiceTete%taille];
				indiceTete++;
			}
			indiceTete = 0;
			table = tableBis;

		}
		table[(indiceTete+taille)% table.length] = element;
		taille++;
	}

} 
