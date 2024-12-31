import java.util.Comparator;

public class ComparateurClient implements Comparator<ClientEnAttente> {

    public int compare(ClientEnAttente o1, ClientEnAttente o2){
        if (o1.getClient().getPriorite() == o2.getClient().getPriorite()){
            int a = o1.getOrdreArrivee()-o2.getOrdreArrivee();
            return a;
        }
        return o2.getClient().getPriorite()-o1.getClient().getPriorite();
    }
}
