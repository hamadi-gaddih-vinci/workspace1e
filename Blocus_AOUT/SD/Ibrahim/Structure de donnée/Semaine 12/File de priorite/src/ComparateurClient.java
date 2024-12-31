import java.util.Comparator;

public class ComparateurClient implements Comparator<ClientEnAttente> {

    @Override
    public int compare(ClientEnAttente o1, ClientEnAttente o2) {
        if (o1.getClient().getPriorite() == o2.getClient().getPriorite()){
            int a = o1.getOrdreArrive()-o2.getOrdreArrive();
            return a;
        }
        return o2.getClient().getPriorite()-o1.getClient().getPriorite();
    }
}
