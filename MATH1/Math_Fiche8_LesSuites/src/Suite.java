/** Classe Suite

*/
import java.util.*;
import java.io.*;

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


	/** Renvoie la longueur de la Suite courante */
   public int longueur() {
       if (this.estVide()) return 0;
       return 1 + this.corps().longueur();
   }
  
  

	/** renvoie TRUE si e a au moins une occurrence dans la Suite courante
	 * @throws IllegalArgumentException en cas de paramètre invalide*/
   public boolean contient(Elt e){
       if (e == null) throw new IllegalArgumentException();
       else if (this.estVide()) return false;
       else if (this.tete().equals(e)) return true;
       return this.corps().contient(e);
   }


	/** renvoie le nombre d'occurrences de e dans la Suite courante
	 * @throws IllegalArgumentException en cas de paramètre invalide*/
   public int nombreOccur(Elt e) {
       if (e == null) throw new IllegalArgumentException();
       if (this.estVide()) return 0;
       if (this.tete().equals(e)) return this.corps().nombreOccur(e) + 1;
       else return this.corps().nombreOccur(e);
   }
	
	
	/** renvoie la position de la première occurrence de e dans la Suite courante ; 
	 * renvoie 0 si e n'a pas d'occurrence dans la Suite courante 
	 * @throws IllegalArgumentException en cas de paramètre invalide*/
   public int position(Elt e) {
       if (e == null) throw new IllegalArgumentException();
       return positionBis(e);

   }

    private int positionBis(Elt e) {
        if (this.estVide()) return 0;
        if (this.tete().equals(e)) return 1;
        int pos = this.corps().positionBis(e);
        if (pos ==0) return 0;
        return pos + 1;
    }

    /** renvoie le i-ème élément de la Suite courante s'il existe ;
	 * @throws IllegalArgumentException s'il n'exite pas de i-ème élément*/
   public Elt iEme(int i){
       if (i <= 0) throw new IllegalArgumentException();
       if (this.estVide()) throw new IllegalArgumentException();
       if (i == 1) return this.tete();
       return this.corps().iEme(i-1);
   }
	
	
	/** renvoie le dernier élément de la Suite courante si elle est non vide, 
	 * @throws MathException si elle est vide*/
   public Elt dernier(){
       if (this.estVide()) throw new MathException();
       if (corps().estVide()) return this.tete();
       return this.corps().dernier();
   }

   @Override
   /** renvoie true si la Suite courante est égale à s*/
   public boolean equals(Object o){
       if (this == o) return true;
       if (o == null) return false;
       if (this.getClass() != o.getClass()) return false;
       Suite suite = (Suite) o;
       if (this.estVide() && !suite.estVide() || !this.estVide() && suite.estVide())
           return false;
       if (this.estVide() && suite.estVide()) return true;
       if (this.tete().equals(suite.tete()) && this.corps().equals(suite.corps())) return true;
       return false;
   }


	/** renvoie true si la Suite courante est un préfixe de s
	 * @throws IllegalArgumentException en cas de paramètre invalide*/
   public boolean prefixe(Suite s){
       if (s == null) throw new IllegalArgumentException();
       return prefixeBis(s);
   } private boolean prefixeBis(Suite s){
        if (this.estVide() && s.estVide() || this.estVide() && !s.estVide()) return true;
        if (!this.estVide() && s.estVide()) return false;
        if (this.tete().equals(s.tete()) && this.corps().prefixeBis(s.corps())) return true;
        return false;
   }

	
	/** renvoie true si la Suite courante est une sous-suite de s
	 * @throws IllegalArgumentException en cas de paramètre invalide*/
   public boolean sousSuite(Suite s){
       if (s == null) throw new IllegalArgumentException();
       return sousSuiteBis(s);
   } private boolean sousSuiteBis(Suite s){
       if (this.estVide() && s.estVide() || this.estVide() && !s.estVide()) return true;
       if (!this.estVide() && s.estVide()) return false;
       if (this.tete().equals(s.tete()) && this.corps().sousSuiteBis(s.corps())) return true;
       return this.sousSuite(s.corps());
   }

	
	/** ajoute s à gauche de la Suite courante
	 * @throws IllegalArgumentException en cas de paramètre invalide*/
   public void ajouter(Suite s){
   
   }

	
	/** ajoute s à l'envers et à gauche de la Suite courante
	 * @throws IllegalArgumentException en cas de paramètre invalide*/
   public void ajouterALEnvers(Suite s){
   
   }


	/** renvoie la Suite courante inversée*/
   public Suite inverse(){
      return null;
   }


	
	/** renvoie une Suite contenant, une et une seule fois, tous les éléments de la Suite courante*/
   public Suite reduite(){
      return null;
   }
	
	
	 /**Renvoie la Suite courante de laquelle on a supprimé tous les éléments à partir du k-ième 
	  * Si la suite n'a pas k éléments, elle renvoie une copie de la suite.
	  * @throws IllegalArgumentException en cas de paramètre invalide
	  * */
   public Suite tronquee(int k){
      return null;
   }

	
	/** renvoie une copie de la Suite courante dans laquelle on a supprimé la première occurrence (éventuelle) de x
	 * @throws IllegalArgumentException en cas de paramètre invalide*/	
   public Suite moinsPremOcc(Elt x){
      return null;
      
   }


	/** renvoie une copie de la Suite courante dans laquelle on a supprimé toutes les occurrences de x
	 * @throws IllegalArgumentException en cas de paramètre invalide*/
   public Suite moinsToutesOcc(Elt x){
      return null;
   }

   
   /** renvoie une Suite constituee de tous les Elt ayant plus d'une occurrence dans la Suite courante */
   public Suite doublons(){
      return null;
   }
   
   /** renvoie true ssi la Suite courante contient au moins k Elt distincts 
    * @throws IllegalArgumentException en cas de paramètre invalide*/
   public boolean auMoinsK(int k){
      return false;
   }
  
   /** renvoie true ssi tous les element de la Suite sont distincts */
   public boolean tousDistincts(){
      return false;
   }
   
	/** renvoie une copie de la Suite courante dans laquelle toutes les occurrences de x ont été remplacées par y
	 * @throws IllegalArgumentException en cas de paramètre invalide*/
   public Suite substitut(Elt x, Elt y){
      return null;
   }
   
	/** renvoie true si la Suite courante est strictement croissante*/
   public boolean estTriee(){
      return false;
   }
	

} // class Suite

