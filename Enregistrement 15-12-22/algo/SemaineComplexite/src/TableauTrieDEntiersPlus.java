public class TableauTrieDEntiersPlus {

    private int [] tableDEntiers;  // table d'entiers triee par ordre croissant
    private int nombreDEntiers;    // nombre d'entiers dans tableDEntiers
    private static final int TAILLE = 10;

    public TableauTrieDEntiersPlus(){
        this.tableDEntiers = new int[TAILLE];
        this.nombreDEntiers = 0;
    }


    public int getNombreDEntiers(){
        return this.nombreDEntiers;
    }


    /**
     * methode qui recherche l'indice correspondant a une occurrence
     * de l'entier passe en parametre
     * si l’entier se trouve plusieurs fois, l’indice correspond a une
     * occurrence quelconque (pas necessairement la premiere)
     * @param entier l'entier recherche
     * @return indice correspondant a entier, -1 s'il n'est pas dans la table
     */
    private int trouverIndiceDicho(int entier){
        //recherche dichotomique cout O(logN)
        int indiceMin = 0;
        int indiceMax = nombreDEntiers-1;

        while (indiceMin <= indiceMax){
            int indiceMilieu = (indiceMin + indiceMax)/2;
            if (tableDEntiers[indiceMilieu] == entier)
                return indiceMilieu;
            if (tableDEntiers[indiceMilieu] < entier)
                indiceMin = indiceMilieu +1;
            else
                indiceMax = indiceMilieu -1;

        }
        return -1;


        // TODO


        // Pour tester cette methode, testez la methode contient() qui l'utilise

        // Si cela ne va pas, refaites la demo su site
        // https://www.infoforall.fr/art/algo/animation-de-la-recherche-dichotomique/
        // et/ou refaites le test moovin recherche dichotomique

    }



    /**
     * methode qui verifie si la table contient l'entier passe en parametre
     * @param entier l'entier recherche
     * @return boolean true si l'entier est present dans la table, false sinon
     */
    public boolean contient(int entier){
        return trouverIndiceDicho(entier)!=-1;
    }


    /**
     * methode qui supprime toutes les occurrences d'un entier
     * @param entier l'entier a supprimer
     * @return int le nombre de suppressions effectuees
     */
    public int supprimerToutesLesOccurrences(int entier){
        int i =0;
        for( ; i < nombreDEntiers; i++)
            if (tableDEntiers[i] == entier)
                break;
        for( ; i < nombreDEntiers; i++)
            if (tableDEntiers[i] != entier)
            break;

        for( ; i < nombreDEntiers; i++)


            // TODO

            return 0;


        // cout O(N)

        // Si votre methode appelle la methode supprimerUneOccurrence()
        // ou si votre methode contient une instruction du style :
        // tableDEntiers[i-1] = tableDEntiers[i];
        // ou
        // tableDEntiers[i] = tableDEntiers[i+1];

        // Votre methode est en O(Ncarre) !

        // Piste :
        // Votre methode devrait contenir une instruction du style :
        // tableDEntiers[i-nombreSuppressions] = tableDEntiers[i];
        // nombreSuppressions correspond au nombre d'occurrences de l'entier a supprimer
        // Ex :
        // 1 1 2 3 3 3 3 7 9 9 11
        // la table a obtenir apres suppression de tous les 3 :
        // 1 1 2 7 9 9 11
        // Au moment de traiter l'entier 7, on a denombre 4 x 3
        // --> l'entier 7 devra etre deplace de 4 cases avant lui

        // En fait : tous les entiers qui suivent 3 doivent etre deplaces de 4 cases avant

        // 3 phases :
        // passer tous les entiers < entier a supprimer
        // denombrer le nombre de l'occurrence de l'entier a supprimer
        // decaler tous les entiers qui suivent l'entier a supprimer

        // En java ces 3 phases peuvent s'ecrire avec 3 boucles for successives et des "break"
        // int i = 0;
        // for( ; i < nombreDEntiers; i++)
        //    break;
        // for( ; i < nombreDEntiers; i++)
        //    break;
        // for( ; i < nombreDEntiers; i++)

    }


    /**
     * supprime tous les entiers compris entre borneInf et borneSup (bornes comprises)
     * precondition (a ne pas verifier) : borneInf <= borneSup
     * @param borneInf l'entier le plus petit a supprimer
     * @param borneSup l'entier le plus grand a supprimer
     * @return le nombre de suppressions effectuees
     */
    public int supprimerEntre(int borneInf, int borneSup) {

        //TODO

        return 0 ;

        // Si votre methode appelle la methode supprimerUneOccurrence()
        // ou si votre methode contient une instruction du style :
        // tableDEntiers[i-1] = tableDEntiers[i];
        // ou
        // tableDEntiers[i] = tableDEntiers[i+1];

        // Votre methode est en O(Ncarre) !

        // Piste :
        // algorithme assez similaire a l'algorithme supprimerToutesLesOccurrences()


    }



    /**
     * methode qui supprime tous les ex-aequos
     * (en cas d'ex-aequo, un seul entier est conserve)
     * @return int le nombre de suppressions effectuees
     */
    public int supprimerTousLesExAequos(){

        // TODO

        return 0;

        // cout O(N)

        // Si votre methode appelle la methode supprimerUneOccurrence()
        // ou si votre methode contient une instruction du style :
        // tableDEntiers[i-1] = tableDEntiers[i];
        // (ou tableDEntiers[i] = tableDEntiers[i+1];)
        // Votre methode est en O(Ncarre) !

        // Piste :
        // Votre methode devrait contenir une instruction du style :
        // tableDEntiers[i-nombreSuppressions] = tableDEntiers[i];
        // nombreSuppressions correspond au nombre d'ex-aequos rencontres avant de "traiter" tableDEntiers[i]
        // Ex :
        // 1 1 1 3 3 3 3 4 7 9 9 11
        // la table a obtenir
        // 1 3 4 7 9 11
        // Au moment de traiter le premier entier 3, on a deja rencontre 2 entiers a supprimer (2 x 1)  --> l'entier 3 devra etre ramene de 2 cases avant
        // Au moment de traiter l'entier 4, on a deja rencontre 5 entiers a supprimer ( 2 x 1 et 3 x 3) --> l'entier 4 devra etre ramene de 5 cases avant
        // ...

    }

    public String toString(){
        if(nombreDEntiers==0)
            return "[]";
        String aRenvoyer = "["+tableDEntiers[0];
        for (int i = 1; i < nombreDEntiers; i++)
            aRenvoyer = aRenvoyer + ", " + this.tableDEntiers[i];
        return aRenvoyer+"]";
    }

    // A NE PAS MODIFIER !
    // VA SERVIR POUR LES TESTS
    public TableauTrieDEntiersPlus(int[] tableARecopier){
        if (tableARecopier.length>TAILLE)
            throw new IllegalArgumentException();
        this.nombreDEntiers = tableARecopier.length;
        tableDEntiers= new int[TAILLE];
        if(tableARecopier.length!=0)
            tableDEntiers[0] = tableARecopier[0];
        for (int i = 1; i<nombreDEntiers; i++){
            if(tableARecopier[i]<tableARecopier[i-1]){
                throw new IllegalArgumentException();
            }
            tableDEntiers[i] = tableARecopier[i];
        }
    }

}
