
public class TestListeSolides {

	public static void main(String[] args) {
		ListeSolide l = new ListeSolide();
		System.out.println("Liste vide : " + l.listeVide());
		Cube cube1 = new Cube(8);
		System.out.println("Cube de côté 8 ajouté : " + l.ajouterSolide(cube1));
		System.out.println("Liste contient cube1 : " + l.contientSolide(cube1));
		Sphere sphere = new Sphere(6);
		System.out.println("Sphère de rayon 6 ajoutée : " + l.ajouterSolide(sphere));
		System.out.println("Nombre de solides : " + l.nombreSolide());
		Cylindre cylindre = new Cylindre(6,8 );
		System.out.println("Cylindre de rayon 6 et de hauteur 8 ajouté : " + l.ajouterSolide(cylindre));
		System.out.println(l);
		Cube cube2 = new Cube(6);
		System.out.println("Cube de côté 6 ajouté : " + l.ajouterSolide(cube2));
		System.out.println("Nombre de solides : " + l.nombreSolide());
		cube1 = new Cube(7);
		System.out.println("Cube de côté 7 ajouté : " + l.ajouterSolide(cube1));
		System.out.println("Nombre de solides : " + l.nombreSolide());
		System.out.println("Cube de côté 6 supprimé : " + l.retirerSolide(cube2));
		System.out.println(l);
		System.out.println("Plus grand(s) solide(s) de la liste : " );
		for (Solide solide : l.trouverPlusGrandVolume()) {
			System.out.println(solide);
		}
		Cube cube3 = new Cube(24);
		System.out.println("Cube de coté 24 ajouté :" + l.ajouterSolide(cube3));
		Cylindre cylindre1 = new Cylindre(5,9);
		System.out.println("Cylindre de rayon 5 et de hauteur 9 :" + l.ajouterSolide(cylindre1));
		


	}


}
