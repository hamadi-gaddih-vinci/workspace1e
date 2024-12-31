/** Classe Relation héritant de RelationDeBase
	 Fournit des outils de manipulation des relations entre sous-ensembles de l'Univers
 */

import java.util.*;

public class Relation extends RelationDeBase {

	/**
	 * Valeur numérique de MAXELT
	 */
	private static final int MAX = Elt.MAXELT.val();

	/**
	 * Construit la Relation vide sur l'ensemble vide
	 */
	public Relation() {
		super();
	}

	/**
	 * Construit la Relation vide de d vers a
	 */
	public Relation(EnsembleAbstrait d, EnsembleAbstrait a) {
		super(d, a);
	}

	/**
	 * Clone
	 */
	public Relation clone() {
		return (Relation) super.clone();
	}

	//Ex1
	//renvoie le domaine de la relation courante
	public EnsembleAbstrait domaine() {
		//TODO
		EnsembleAbstrait dom = new Ensemble();
		for (Couple couple : this) {
			dom.ajouter(couple.getX());
		}
		return dom;
	}

	//renvoie l'image de la relation courante
	public EnsembleAbstrait image() {
		EnsembleAbstrait im = new Ensemble();
		for (Couple couple : this) {
			im.ajouter(couple.getY());
		}
		return im;
	}

	// EX 2
	// renvoie la complémentaire de la relation courante
	public Relation complementaire() {
		//
		Relation comp = new Relation(this.depart(), this.arrivee());

		for (Elt depart : this.depart()) {
			for (Elt arrivee : this.arrivee()) {
				if (!this.contient(depart, arrivee))
					comp.ajouter(depart, arrivee);
			}
		}
		return comp;
	}

	// renvoie la réciproque de la relation courante
	public Relation reciproque() {
		//TODO
		Relation rec = new Relation(this.arrivee(), this.depart());
		for (Couple couple : this) {
			rec.ajouter(couple.getY(), couple.getX());
		}
		return rec;
	}

	// si possible, remplace la relation courante par son union avec r
	//sinon, lance une IllegalArgumentException
	public void ajouter(RelationInterface r) {
		if (r == null || !r.depart().equals(this.depart()) || !r.arrivee().equals(this.arrivee()))
			throw new IllegalArgumentException();
		for (Couple couple : r) {
			this.ajouter(couple.getX(), couple.getY());
		}

	}
	//TODO

	// si possible, remplace this par sa différence avec r
	//sinon, lance une IllegalArgumentException
	public void enlever(RelationInterface r) {
		if (r == null || !r.depart().equals(this.depart()) || !r.arrivee().equals(this.arrivee()))
			throw new IllegalArgumentException();
		if (this == r)
			r = this.clone();
		for (Couple couple : r) {
			this.enlever(couple.getX(), couple.getY());
		}
		//TODO
	}

	// si possible, remplace this par son intersection avec r
	//sinon, lance une IllegalArgumentException
	public void intersecter(RelationInterface r) {
		//TODO
	}

	// si possible, renvoie la composée : this après r
	//sinon, lance une IllegalArgumentException
	public Relation apres(RelationInterface r) {
		//TODO
		return null;
	}



	/*Les exercices 4 et 5 ne concernent que les relations sur un ensemble.
	 * Les méthodes demandées génèreront donc une MathException lorsque l'ensemble de départ
	 * ne coïncide pas avec l'ensemble d'arrivée.
	 */

	/* Ex 4 */

	// Clôture la Relation courante pour la réflexivité
	public void cloReflex() {
		if (!this.depart().equals(this.arrivee()))
			throw new MathException();
		for (Elt x : this.depart()) {
			this.ajouter(x, x);
		}
		//TODO
	}

	// Clôture la Relation courante pour la symétrie
	public void cloSym() {
		//TODO
	}

	// Clôture la Relation courante pour la transitivité (Warshall)
	public void cloTrans() {
		//TODO
		if (!this.depart().equals(this.arrivee()))
			throw new MathException();
		for (Elt x1 : this.depart()) {
			for (Elt x2 : this.depart()) {
				if (this.contient(x2, x1)) {
					for (Elt x3 : this.depart()) {
						if (this.contient(x1, x3))
							this.ajouter(x2, x3);
					}
				}
			}
		}
	}


	//Ex 5
	/*Les questions qui suivent ne concernent que les relations sur un ensemble.
	 * Les méthodes demandées génèreront donc une MathException lorsque l'ensemble de départ
	 * ne coïncide pas avec l'ensemble d'arrivée.
	 */
	// renvoie true ssi this est réflexive
	public boolean reflexive() {
		//TODO
		return false;
	}

	// renvoie true ssi this est antiréflexive
	public boolean antireflexive() {
		//TODO
		return false;
	}

	// renvoie true ssi this est symétrique
	public boolean symetrique() {
		//TODO
		return false;
	}

	// renvoie true ssi this est antisymétrique
	public boolean antisymetrique() {
		//TODO
		if (!this.depart().equals(this.arrivee()))
			throw new MathException();
		for (Elt x : this.depart()) {
			for (Elt y : this.depart()) {
				if (this.contient(x, y) && this.contient(y, x)) {
					Couple couple = new Couple(x, y);
					Couple couple1 = new Couple(y, x);
					if (!couple.equals(couple1))
						return false;
				}
			}
		}
		return true;
	}


	// renvoie true ssi  this est transitive
	public boolean transitive() {
		//TODO
		return false;
	}

	// Ex 6
	//Construit une copie de la relation en paramètre
	//lance une IllegalArgumentException en cas de paramètre invalide
	public Relation(RelationInterface r) {
		//TODO
		this();

	}

	//renvoie l'identité sur e
	//lance une IllegalArgumentException en cas de paramètre invalide
	public static Relation identite(EnsembleAbstrait e) {
		//TODO
		if (e == null)
			throw new IllegalArgumentException();
		Relation identite = new Relation(e,e);
		identite.cloReflex();
		return identite;
	}


	//renvoie le produit cartésien de a et b
	//lance une IllegalArgumentException en cas de paramètre invalide
	public static Relation produitCartesien(EnsembleAbstrait a, EnsembleAbstrait b) {
			//TODO
		return null;
	}

} // class Relation
