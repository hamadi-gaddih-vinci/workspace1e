/** Classe Suite

*/
import java.util.*;
import java.io.*;

public class Suite extends SuiteDeBase {

	// valeur num�rique de MAXELT
   private static final int MAX = Elt.MAXELT.val();

	/** Constructeur vide */
   public Suite() {
      super();
   }

	/** Constructeur par recopie */
   public Suite(SuiteDeBase s) {
      super(s);
   }

	/** Constructeur � partir d'une String */
   public Suite(String st) {
      super(st);
   }

	/** Constructeur � partir d'un Elt et d'une Suite */
   public Suite(Elt t, Suite c) {
      super(t, c);
   }

	/** Construit la Suite r�duite � (x) */
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
	 * @throws IllegalArgumentException en cas de param�tre invalide*/
   public boolean contient(Elt e){
       if (e == null) throw new IllegalArgumentException();
       else if (this.estVide()) return false;
       else if (this.tete().equals(e)) return true;
       return this.corps().contient(e);
   }


	/** renvoie le nombre d'occurrences de e dans la Suite courante
	 * @throws IllegalArgumentException en cas de param�tre invalide*/
   public int nombreOccur(Elt e) {
       if (e == null) throw new IllegalArgumentException();
       if (this.estVide()) return 0;
       if (this.tete().equals(e)) return this.corps().nombreOccur(e) + 1;
       else return this.corps().nombreOccur(e);
   }
	
	
	/** renvoie la position de la premi�re occurrence de e dans la Suite courante ; 
	 * renvoie 0 si e n'a pas d'occurrence dans la Suite courante 
	 * @throws IllegalArgumentException en cas de param�tre invalide*/
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

    /** renvoie le i-�me �l�ment de la Suite courante s'il existe ;
	 * @throws IllegalArgumentException s'il n'exite pas de i-�me �l�ment*/
   public Elt iEme(int i){
       if (i <= 0) throw new IllegalArgumentException();
       if (this.estVide()) throw new IllegalArgumentException();
       if (i == 1) return this.tete();
       return this.corps().iEme(i-1);
   }
	
	
	/** renvoie le dernier �l�ment de la Suite courante si elle est non vide, 
	 * @throws MathException si elle est vide*/
   public Elt dernier(){
       if (this.estVide()) throw new MathException();
       if (corps().estVide()) return this.tete();
       return this.corps().dernier();
   }

   @Override
   /** renvoie true si la Suite courante est �gale � s*/
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


	/** renvoie true si la Suite courante est un pr�fixe de s
	 * @throws IllegalArgumentException en cas de param�tre invalide*/
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
	 * @throws IllegalArgumentException en cas de param�tre invalide*/
   public boolean sousSuite(Suite s){
       if (s == null) throw new IllegalArgumentException();
       return sousSuiteBis(s);
   } private boolean sousSuiteBis(Suite s){
       if (this.estVide() && s.estVide() || this.estVide() && !s.estVide()) return true;
       if (!this.estVide() && s.estVide()) return false;
       if (this.tete().equals(s.tete()) && this.corps().sousSuiteBis(s.corps())) return true;
       return this.sousSuite(s.corps());
   }

	
	/** ajoute s � gauche de la Suite courante
	 * @throws IllegalArgumentException en cas de param�tre invalide*/
   public void ajouter(Suite s){
   
   }

	
	/** ajoute s � l'envers et � gauche de la Suite courante
	 * @throws IllegalArgumentException en cas de param�tre invalide*/
   public void ajouterALEnvers(Suite s){
   
   }


	/** renvoie la Suite courante invers�e*/
   public Suite inverse(){
      return null;
   }


	
	/** renvoie une Suite contenant, une et une seule fois, tous les �l�ments de la Suite courante*/
   public Suite reduite(){
      return null;
   }
	
	
	 /**Renvoie la Suite courante de laquelle on a supprim� tous les �l�ments � partir du k-i�me 
	  * Si la suite n'a pas k �l�ments, elle renvoie une copie de la suite.
	  * @throws IllegalArgumentException en cas de param�tre invalide
	  * */
   public Suite tronquee(int k){
      return null;
   }

	
	/** renvoie une copie de la Suite courante dans laquelle on a supprim� la premi�re occurrence (�ventuelle) de x
	 * @throws IllegalArgumentException en cas de param�tre invalide*/	
   public Suite moinsPremOcc(Elt x){
      return null;
      
   }


	/** renvoie une copie de la Suite courante dans laquelle on a supprim� toutes les occurrences de x
	 * @throws IllegalArgumentException en cas de param�tre invalide*/
   public Suite moinsToutesOcc(Elt x){
      return null;
   }

   
   /** renvoie une Suite constituee de tous les Elt ayant plus d'une occurrence dans la Suite courante */
   public Suite doublons(){
      return null;
   }
   
   /** renvoie true ssi la Suite courante contient au moins k Elt distincts 
    * @throws IllegalArgumentException en cas de param�tre invalide*/
   public boolean auMoinsK(int k){
      return false;
   }
  
   /** renvoie true ssi tous les element de la Suite sont distincts */
   public boolean tousDistincts(){
      return false;
   }
   
	/** renvoie une copie de la Suite courante dans laquelle toutes les occurrences de x ont �t� remplac�es par y
	 * @throws IllegalArgumentException en cas de param�tre invalide*/
   public Suite substitut(Elt x, Elt y){
      return null;
   }
   
	/** renvoie true si la Suite courante est strictement croissante*/
   public boolean estTriee(){
      return false;
   }
	

} // class Suite

