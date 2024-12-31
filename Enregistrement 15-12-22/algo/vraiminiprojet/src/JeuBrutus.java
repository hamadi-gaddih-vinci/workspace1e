public class JeuBrutus {

    public static void main(String[] args) {

        PlateauJeuBrutus jeu = new PlateauJeuBrutus();
        int positionBrutus = 1;
        jeu.placerBrutus(positionBrutus);
        jeu.afficherInformation("Vas-y !");

        while (positionBrutus <16){
            int lanceDe = jeu.lancerDe();
            jeu.supprimerBrutus();
            jeu.placerBrutus(positionBrutus + lanceDe);
            positionBrutus = positionBrutus + lanceDe;
        }


                }
            }// A COMPLETER






