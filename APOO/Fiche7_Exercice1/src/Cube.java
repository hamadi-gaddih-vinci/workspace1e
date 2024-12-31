import java.util.Objects;

public class Cube implements Solide{
    private double cote;

    public Cube(double cote){
        this.cote = cote;
        if (cote<0)
            throw new IllegalArgumentException("Cote invalide");

    }

    public double getCote() {
        return cote;
    }

    @Override
    public double donnerVolume() {
        return Math.pow(cote,3);
    }

    @Override
    public double donnerSurface() {
        return 6*(Math.pow(cote, 2));
    }

    @Override
    public String toString() {
        return "Cube de côté " + ":" + cote + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return Double.compare(cube.cote, cote) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cote);
    }
}

