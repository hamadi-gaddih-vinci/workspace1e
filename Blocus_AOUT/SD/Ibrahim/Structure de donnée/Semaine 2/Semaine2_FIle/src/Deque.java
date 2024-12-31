public interface Deque<E> {


        /**
         * renvoie le nombre d'élément qui se trouve dans la Queue
         * return le nombre d'élément
         */
        public int taille();

        /**
         * verifie si la queue est vide
         *
         * @return true si la queue est vide, false sinon
         */
        public boolean estVide();

        /**
         * ajoute un élément à la fin ou au début de la table
         *
         * @param element a ajouter
         */
        public void enfile(E element);

    /**
     * renvoie l'element qui se trouve en tete ou en fin de file et l'enleve
     * @return l'element enlever
     * @throws FileVideException si la file est vide
     */
    public E defile() throws FileVideException;

    /**
     * renvoie l'element qui se trouve en tete ou en fin de Deque de file sans l'enlever
     * @return l'element en debut ou fin de Deque
     * @throws FileVideException si la file est vide
     */
    public E premierDernier()throws FileVideException;



}
