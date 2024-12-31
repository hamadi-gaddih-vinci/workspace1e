import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class EquipeGuerriers {

	private ArrayList<Guerrier> vecteurGuerriers;
	private LinkedList<Guerrier> listeGuerriersEnJeu;
	private int pointsDeVieDeDepart;
	
	
	
	// Attention : seul interet de ce constructeur : les tests!!!
	// A NE PAS MODIFIER
	public EquipeGuerriers(ArrayList<Guerrier> vecteurGuerriers,
			LinkedList<Guerrier> listeGuerriersEnJeu, int pointsDeVieDeDepart) {
		super();
		this.vecteurGuerriers = vecteurGuerriers;
		this.listeGuerriersEnJeu = listeGuerriersEnJeu;
		this.pointsDeVieDeDepart = pointsDeVieDeDepart;
	}

	/**
	 * construit l'equipe 
	 * @param nombreGuerriers nombre de guerriers en vie au debut du jeu
	 * @param pointsDeVieDeDepart nombre de points de vie attribue a chaque guerrier au debut du jeu
	 * @throws IllegalArgumentException il faut au moins 1 guerrier vivant pour combattre la creature du mal
	 */
	public EquipeGuerriers(int nombreGuerriers, int pointsDeVieDeDepart){
		// TODO
		if (nombreGuerriers <= 0)
			throw new IllegalArgumentException();
		this.vecteurGuerriers = new ArrayList<Guerrier>();
		this.listeGuerriersEnJeu = new LinkedList<Guerrier>();
		this.pointsDeVieDeDepart = pointsDeVieDeDepart;
		for (int i = 0; i < nombreGuerriers; i++) {
			Guerrier guerrier = new Guerrier(i+1, pointsDeVieDeDepart);
			vecteurGuerriers.add(guerrier);
			listeGuerriersEnJeu.add(guerrier);
		}
	} 

	/**
	 * renvoie le nombre de guerriers encore en vie
	 * @return le nombre de guerriers encore en vie
	 */
	public int nombreGuerriersEnVie(){
		return listeGuerriersEnJeu.size();
		// TODO
	
	
	}
	
	/**
	 * selectionne un guerrier, lui diminue son nombre de points de vie et le remet en jeu s'il n'est pas mort
	 * @param pointsDeViePerdus le nombre perdu par le guerrier au combat
	 * @return le guerrier qui a combattu
	 * @throws NoSuchElementException si tous les guerriers sont morts
	 * @throws IllegalArgumentException le nombre de points de vie perdus est un nombre <= 0
	 */
	public Guerrier jouer(int pointsDeViePerdus){
		if (nombreGuerriersEnVie() == 0)
			throw new NoSuchElementException();
		if (pointsDeViePerdus <= 0)
			throw new IllegalArgumentException();
		listeGuerriersEnJeu.getFirst().setPointsDeVie(listeGuerriersEnJeu.getFirst().getPointsDeVie() - pointsDeViePerdus);
		Guerrier guerrier = listeGuerriersEnJeu.getFirst();
		listeGuerriersEnJeu.remove();
		if (guerrier.getPointsDeVie() > 0)
			listeGuerriersEnJeu.addLast(guerrier);
		return guerrier;
		// TODO
	}
	
	/**
	 * renvoie le guerrier dont le numero est passe en parametre, meme s'il est mort
	 * @param numero le numero du guerrier demande
	 * @return le guerrier qui a comme numero le numero passe en parametre
	 * @throws IllegalArgumentException le numero n'a pas ete attribue
	 */
	public Guerrier getGuerrier(int numero){
		if (numero <= 0 || numero > vecteurGuerriers.size()-1)
			throw new IllegalArgumentException();
		return vecteurGuerriers.get(numero-1);
		// TODO
		
	}
	
	
	/**
	 * ajoute un nouveau guerrier dans l'equipe
	 * ce guerrier recoit un numero non attribue et le nombre de points de vie de depart
	 * ce guerrier va prendre place au combat en se placant apres le guerrier vivant qui porte le numero juste plus petit que lui
	 * Par exemple : g4 est mort et ordre des combats : g3 g1 g2 , le nouveau guerrier va se placer entre g3 et g1
	 * @return le numero du guerrier ajoute
	 */
	public int ajouterNouveauGuerrier(){
		int numero = vecteurGuerriers.size() +1;
		Guerrier guerrier = new Guerrier(numero, pointsDeVieDeDepart);
		vecteurGuerriers.add(guerrier);

		int indice = 0;
		int numMax = 0;

		for (Guerrier guerrier1: listeGuerriersEnJeu) {
			if (guerrier1.getNumero() > numMax){
				indice++;
				numMax = guerrier1.getNumero();
			}
		}
		listeGuerriersEnJeu.add(indice, guerrier);
		return numero;
		// TODO
	
	}
	
	// Attention : seul interet de ce toString() : les tests!!!
	// A NE PAS MODIFIER
	public String toString(){
		return "vecteur :\n"+vecteurGuerriers.toString()+"\nliste :\n"+listeGuerriersEnJeu.toString();
	}
	
	
}
