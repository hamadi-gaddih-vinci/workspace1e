
public class TestListeSolides {

	public static void main(String[] args) {
		ListeSolides l = new ListeSolides();
		System.out.println("Liste vide : " + l.estVide());
		Cube cube1 = new Cube(8);
		System.out.println("Cube de côté 8 ajouté : " + l.ajouter(cube1));
		System.out.println("Liste contient cube1 : " + l.contient(cube1));
		Sphere sphere = new Sphere(6);
		System.out.println("Sphère de rayon 6 ajoutée : " + l.ajouter(sphere));
		System.out.println("Nombre de solides : " + l.nombreSolide());
		Cylindre cylindre = new Cylindre(8,6 );
		System.out.print("Cylindre de rayon 6 et de hauteur 8 ajouté : " + l.ajouter(cylindre));
		System.out.print(l);
		Cube cube2 = new Cube(6);
		System.out.println("Cube de côté 6 ajouté : " + l.ajouter(cube2));
		System.out.println("Nombre de solides : " + l.nombreSolide());
		cube1 = new Cube(7);
		System.out.print("Cube de côté 7 ajouté : " + l.ajouter(cube1));
		System.out.println("Nombre de solides : " + l.nombreSolide());
		System.out.print("Cube de côté 6 supprimé : " + l.supprimer(cube2));
		System.out.print(l);
		System.out.print("Plus grand(s) solide(s) de la liste : " );
		for (Solide solide : l.plusGrandVolume()) {
			System.out.print(solide);
		}
	}

}
