import java.util.Objects;

public class Sphere implements Solide{
    private double rayon;

    public Sphere(double rayon){
        if (rayon<=0)
            throw new IllegalArgumentException("Le rayon est invalide");
        this.rayon = rayon;
    }

    public double getRayon() {
        return rayon;
    }

    @Override
    public double donnerVolume() {
        return (4*Math.PI)*(Math.pow(rayon,3)/3);
    }

    @Override
    public double donnerSurface() {
        return (4*Math.PI)*Math.pow(rayon,2);
    }

    @Override
    public String toString() {
        return "Sphere de rayon" + ":" + rayon + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sphere sphere = (Sphere) o;
        return Double.compare(sphere.rayon, rayon) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rayon);
    }
}
