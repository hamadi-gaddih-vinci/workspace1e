import java.util.HashSet;

public class FileSDImpl<E> implements FileSD<E>{
    private Noeud tete;
    private Noeud queue;
    private HashSet<E> ensemble;

    public FileSDImpl(){
        tete=null;
        queue=null;
        ensemble = new HashSet<E>();
    }

    @Override
    public boolean estVide() {
        return ensemble.isEmpty();
    }

    @Override
    public int taille() {
        return ensemble.size();
    }

    @Override
    public E premier(){
        if(tete==null)
            return null;
        return tete.element;
    }

    @Override
    public E dernier(){
        if(queue==null)
            return null;
        return queue.element;
    }

    /**
     * verifie la presence d'un element dans la file
     * @param element l'element recherche
     * @return true si l'element est present, false sinon
     */
    @Override
    public boolean contient(E element) {
        //TODO
        Noeud baladeur = tete;
        while (baladeur != null){
            if (baladeur.element.equals(element))
                return true;
            baladeur = baladeur.suivant;
        }
        return false;
    }

    /**
     * ajoute un element en fin de file (queue) a condition qu'il n'y etait pas
     * (les doublons sont refuses)
     * @param element l'element a ajouter
     * @return true si l'ajout a pu se faire, false sinon
     */
    @Override
    public boolean enfile(E element) {
        //TODO
       if (contient(element))
           return false;
       Noeud noeud = new Noeud(element);
       if (estVide()){
           tete = noeud;
           queue =tete;
       }
       else {
           queue.suivant = noeud;
           queue = noeud;
       }
        ensemble.add(element);
        return true;
    }

    /**
     * renvoie l'element qui se trouve en tete de file et l'enleve de la file
     * @return l'element en tete ou null si la file est vide
     */
    @Override
    public E defile() {
        //TODO
        if (estVide())
            return null;
       E el = tete.element;
       ensemble.remove(tete.element);
       if (tete == queue)
           queue = null;
       tete = tete.suivant;
       return el;
    }

    /**
     * donne la position d'un element dans la file
     * (le 1er element se trouve en position 1, le 2eme en position 2, et ainsi de suite
     * @param element l'element recherche
     * @return la position de l'element ou -1 si cet element ne se trouve pas dans la file
     */
    @Override
    public int position(E element) {
        //TODO
        if (!contient(element))
            return -1;
        Noeud baladeur = tete;
        int cmpt = 1;
        if (tete.element.equals(element))
            return 1;
        while (baladeur != null){
            if (baladeur.element.equals(element))
                return cmpt;
            cmpt++;
            baladeur = baladeur.suivant;
        }
        return -1;
    }

    // classe interne
    private class Noeud{
        private E element;
        private Noeud suivant;

        private Noeud(E element, Noeud suivant){
            this.element = element;
            this.suivant = suivant;
        }

        private Noeud(E element){
            this.element = element;
            this.suivant = null;
        }

    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    // ["d1","d2","d3"] --> tete "d1" "d2" "d3" queue
    public FileSDImpl(Object[] table) {
        if(table==null)
            throw new IllegalArgumentException("table null");
        if(table.length<1)
            throw new IllegalArgumentException("table vide");
        ensemble = new HashSet<>();
        queue = new Noeud((E)table[table.length-1],null);
        ensemble.add((E)table[table.length-1]);
        Noeud noeud = queue;
        for (int i = table.length-2; i>=0;i--) {
            noeud = new Noeud((E)table[i],noeud);
            ensemble.add((E)table[i]);
        }
        this.tete=noeud;
    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public String toString(){
        if(tete==null)
            return "";
        return tete.element + toString(tete.suivant,1);
    }

    private String toString(Noeud noeud, int cpt) {
        if(cpt==10)
            return "boucle infinie";
        if(noeud==null)
            return "";
        cpt++;
        return " "+noeud.element+toString(noeud.suivant,cpt);
    }


}
