public class Bal1 implements Bal{

    /**
     * Cette classe retient les etudiants inscrits au bal
     * Une liste chainee contient d abord les hommes, ensuite les femmes
     * Dans chacune des sous-listes, l'ordre suit l'ordre des inscription
     *
     * @author
     *
     */

    private NoeudEtudiant tete;
    private NoeudEtudiant derM;
    private NoeudEtudiant derF;

    /**
     * construit un bal avec aucun participant
     */
    public Bal1(){
        // TODO
        // construit une liste avec 2 noeuds bidons
        // les elements de ces noeuds bidons sont a null

    }


    /**
     * ajoute l etudiant dans la liste en tenant compte de l'ordre prevu
     * @param etudiant l etudiant a ajouter
     * @throws IllegalArgumentException si l etudiant est null
     */
    public void ajouterEtudiant(Etudiant etudiant){
        if(etudiant==null)
            throw new IllegalArgumentException("etudiant null");
        //TODO
    }

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    public String toString(){

        NoeudEtudiant baladeur = tete.suivant;
        if(baladeur==derF){
            return "[]";
        }
        String aRenvoyer = "["+baladeur.etudiant;
        baladeur = baladeur.suivant;
        while(baladeur!=derF){
            aRenvoyer += ", " + baladeur.etudiant;
            baladeur = baladeur.suivant;
        }
        return aRenvoyer+"]";
    }

    // classe interne
    private class NoeudEtudiant{

        private Etudiant etudiant;
        private NoeudEtudiant suivant;

        public NoeudEtudiant(){
            this.etudiant = null;
            this.suivant = null;
        }

        public NoeudEtudiant(Etudiant etudiant){
            this.etudiant = etudiant;
            this.suivant = null;
        }

        public NoeudEtudiant(Etudiant etudiant, NoeudEtudiant suivant){
            this.etudiant = etudiant;
            this.suivant = suivant;
        }

    }
}


