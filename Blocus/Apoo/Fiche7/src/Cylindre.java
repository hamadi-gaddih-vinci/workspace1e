import java.util.Objects;

public class Cylindre implements Solide {
    private double hauteur;
    private double rayon;

    public Cylindre(double hauteur, double rayon) {
        if (hauteur <= 0)
            throw new IllegalArgumentException("Hauteur invalide");
        if (rayon <= 0)
            throw new IllegalArgumentException("Rayon invalide");
        this.hauteur = hauteur;
        this.rayon = rayon;
    }

    public double getHauteur() {
        return hauteur;
    }

    public double getRayon() {
        return rayon;
    }

    @Override
    public double calculerVolume() {
        return Math.PI*(Math.pow(rayon,2)*hauteur);
    }

    @Override
    public double calculerSurface() {

        return ((2*Math.PI) * Math.pow(rayon,2)) + ((2*Math.PI)*rayon*hauteur);
    }
    public String toString(){
        return "Cylindre de rayon " + rayon + " et de hauteur " + hauteur +"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cylindre cylindre = (Cylindre) o;
        return Double.compare(cylindre.hauteur, hauteur) == 0 && Double.compare(cylindre.rayon, rayon) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hauteur, rayon);
    }
}
