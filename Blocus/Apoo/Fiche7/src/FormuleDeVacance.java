import java.time.LocalDate;

public abstract class FormuleDeVacance {
    private LocalDate dateDepart;
    private int duree;

    public FormuleDeVacance(LocalDate dateDepart, int duree) {
        this.dateDepart = dateDepart;
        this.duree = duree;
    }
    abstract public double trouverPrix();
    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public int getDuree() {
        return duree;
    }
    public String toString(){
        return "Date de départ : " + dateDepart + "\n" + "Durée : " + duree + "\n";
    }
}
