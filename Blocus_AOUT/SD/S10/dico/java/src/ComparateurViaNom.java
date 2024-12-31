import java.util.Comparator;

public class ComparateurViaNom implements Comparator<Etudiant> {
    @Override
    public int compare(Etudiant o1, Etudiant o2) {
        int result = o1.getNom().compareTo(o2.getNom());
        if (result == 0){
            result = o1.getPrenom().compareTo(o2.getPrenom());
        }
        return result;
    }
}
