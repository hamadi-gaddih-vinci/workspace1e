public class Livre {
    String isbn;
    String titreLivre;
    String nomAuteur;
    String prenomAuteur;
    double prixConseiller;
    int    anneeEdition;
    int    nombrePage;

    Livre (String nIsbn, String nTitreLivre, String nNomAuteur, String nPrenomAuteur, double nPrixConseiller, int nAnneeEdtition, int nNombrePage ){
        isbn = nIsbn;
        titreLivre = nTitreLivre;
        nomAuteur = nNomAuteur;
        prenomAuteur = nPrenomAuteur;
        prixConseiller = nPrixConseiller;
        anneeEdition = nAnneeEdtition;
        nombrePage = nNombrePage;
    }


}


