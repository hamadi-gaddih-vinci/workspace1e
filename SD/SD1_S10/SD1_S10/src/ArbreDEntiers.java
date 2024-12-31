import java.util.ArrayDeque;
import java.util.Iterator;

public class ArbreDEntiers implements Iterable<Integer>{
	protected NoeudEntier racine; 
	protected int taille;
	
	public ArbreDEntiers () {
		this.racine=null ;
		this.taille=0;
	}

	public ArbreDEntiers (int entier) {
		this.racine=new NoeudEntier(entier) ;
		this.taille=1;
	}
	
	public ArbreDEntiers (ArbreDEntiers gauche, int entier, ArbreDEntiers droit) {
		this.racine=new NoeudEntier(gauche.racine,entier,droit.racine) ;
		this.taille= 1 + gauche.taille + droit.taille;
	}

	public boolean estVide () {
		return  this.racine == null;
	}

	public int taille () {
		return taille;
	}

	public Iterator<Integer> preIterateur () {
		return new PreIterateur();
	}
	
	public Iterator<Integer> postIterateur () {
		return new postIterateur();
		//Cet 2 iterateur s’implemente de façon similaire à l’iterateur en pre-ordre.
		//TODO

	}

	// iterateur in ordre
	// Cet iterateur a ete selectionne comme iterateur par defaut
	public Iterator<Integer> iterator () {
		return new iterator();
		//Cet 2 iterateur s’implemente de façon similaire à l’iterateur en pre-ordre.
		//TODO
	}
	
	public Iterator<Integer> iterateurParNiveau () {
		return new iterateurParNiveau();
		//Cet iterateur s'implemente en utilisant une file de Noeud
		//Lisez bien l'enonce
		//TODO
	}
	
	
	protected class NoeudEntier {
		protected int entier; 
		protected NoeudEntier gauche;
		protected NoeudEntier droit;

		private NoeudEntier (int entier) {
			this.entier = entier;
			this.gauche = null;
			this.droit = null;
		}
		
		private NoeudEntier (NoeudEntier g,int entier,NoeudEntier d) {
			this.entier = entier;
			this.gauche = g;
			this.droit = d;
		}
	}
	
	private class PreIterateur implements Iterator<Integer> {

		private ArrayDeque<Integer> fileDEntiers;

		public PreIterateur () {
			fileDEntiers = new ArrayDeque<Integer>(taille);
			remplirFile(racine);
			//La classe PreIterator possede un attribut : une file d’entiers (ArrayDeque<Integer>).
			//Le constructeur de la classe va s’occuper de remplir cette file avec tous les entiers contenus dans l’arbre.
			//Il construit la file et appelle la methode recursive remplirFile()
		}

		private void remplirFile (NoeudEntier n) {
			// TODO
			//C’est la methode remplirFile() qui se charge de remplir la file.
			//Il s’agit d’une methode recursive !
			//Le but de cet iterateur est de parcourir l’arbre en pre-ordre !
			//Il faut donc « enfiler » les objets dans la file de façon a respecter ce parcours.
			if (n == null)
				return;
			fileDEntiers.add(n.entier);
			remplirFile(n.gauche);
			remplirFile(n.droit);
		}

		public boolean hasNext () {
			return !fileDEntiers.isEmpty();
			// TODO
			//cette methode verifie si la file est non vide.
		}

		public Integer next () {
			return fileDEntiers.removeFirst();
			// TODO
			//cette methode "defile"
		}
	}

	private class postIterateur implements Iterator<Integer> {

		private ArrayDeque<Integer> fileDEntiers;

		public postIterateur () {
			fileDEntiers = new ArrayDeque<Integer>(taille);
			remplirFile(racine);
			//La classe PreIterator possede un attribut : une file d’entiers (ArrayDeque<Integer>).
			//Le constructeur de la classe va s’occuper de remplir cette file avec tous les entiers contenus dans l’arbre.
			//Il construit la file et appelle la methode recursive remplirFile()
		}

		private void remplirFile (NoeudEntier n) {
			// TODO
			//C’est la methode remplirFile() qui se charge de remplir la file.
			//Il s’agit d’une methode recursive !
			//Le but de cet iterateur est de parcourir l’arbre en pre-ordre !
			//Il faut donc « enfiler » les objets dans la file de façon a respecter ce parcours.
			if (n == null)
				return;
			remplirFile(n.gauche);
			remplirFile(n.droit);
			fileDEntiers.add(n.entier);
		}

		public boolean hasNext () {
			return !fileDEntiers.isEmpty();
			// TODO
			//cette methode verifie si la file est non vide.
		}

		public Integer next () {
			return fileDEntiers.removeFirst();
			// TODO
			//cette methode "defile"
		}
	}

	private class iterator implements Iterator<Integer> {

		private ArrayDeque<Integer> fileDEntiers;

		public iterator () {
			fileDEntiers = new ArrayDeque<Integer>(taille);
			remplirFile(racine);
			//La classe PreIterator possede un attribut : une file d’entiers (ArrayDeque<Integer>).
			//Le constructeur de la classe va s’occuper de remplir cette file avec tous les entiers contenus dans l’arbre.
			//Il construit la file et appelle la methode recursive remplirFile()
		}

		private void remplirFile (NoeudEntier n) {
			// TODO
			//C’est la methode remplirFile() qui se charge de remplir la file.
			//Il s’agit d’une methode recursive !
			//Le but de cet iterateur est de parcourir l’arbre en pre-ordre !
			//Il faut donc « enfiler » les objets dans la file de façon a respecter ce parcours.
			if (n == null)
				return;
			remplirFile(n.gauche);
			fileDEntiers.add(n.entier);
			remplirFile(n.droit);
		}

		public boolean hasNext () {
			return !fileDEntiers.isEmpty();
			// TODO
			//cette methode verifie si la file est non vide.
		}

		public Integer next () {
			return fileDEntiers.removeFirst();
			// TODO
			//cette methode "defile"
		}
	}

	private class iterateurParNiveau implements Iterator<Integer> {

		private ArrayDeque<NoeudEntier> fileDeNoeud;

		public iterateurParNiveau () {
			fileDeNoeud = new ArrayDeque<NoeudEntier>(taille);
			if (racine != null)
				fileDeNoeud.add(racine);
		}


		public boolean hasNext () {
			return !fileDeNoeud.isEmpty();
			// TODO
		}

		public Integer next () {
			NoeudEntier noeud = fileDeNoeud.removeFirst();
			NoeudEntier noeudGauche = noeud.gauche;
			NoeudEntier noeudDroit = noeud.droit;
			if (noeudGauche != null)
				fileDeNoeud.add(noeudGauche);
			if (noeudDroit != null)
				fileDeNoeud.add(noeudDroit);
			return noeud.entier;
			// TODO
			//cette methode "defile"
		}
	}
}
