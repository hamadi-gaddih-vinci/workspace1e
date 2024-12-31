import java.util.Objects;

public class Cylindre implements Solide{
    private double rayon;
    private double hauteur;

public Cylindre(double rayon, double hauteur){
    this.rayon = rayon;
    this.hauteur = hauteur;
    if (rayon<=0)
        throw new IllegalArgumentException("Rayon invalide");
    if (hauteur<=0)
        throw new IllegalArgumentException("Hauteur invalide");

}

    public double getRayon() {
        return rayon;
    }

    public double getHauteur() {
        return hauteur;
    }

    @Override
    public double donnerVolume() {
        return Math.PI*(Math.pow(rayon,2)*hauteur);
    }

    @Override
    public double donnerSurface() {
        return (2*Math.PI)*(Math.pow(rayon,2) + (2*Math.PI)*rayon*hauteur);
    }

    @Override
    public String toString() {
        return "Cylindre de rayon :" + rayon + "hauteur :" + hauteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cylindre cylindre = (Cylindre) o;
        return Double.compare(cylindre.rayon, rayon) == 0 && Double.compare(cylindre.hauteur, hauteur) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rayon, hauteur);
    }
}
