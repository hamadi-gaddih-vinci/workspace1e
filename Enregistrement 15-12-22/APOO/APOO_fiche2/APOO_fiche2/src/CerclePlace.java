public class CerclePlace {

    private double rayon;
    private Point centre;

    public CerclePlace(double rayon, Point centre){
        this.rayon = rayon;
        this.centre = centre;
    }

    public double getRayon() {
        return rayon;
    }

    public Point getCentre() {
        return centre;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    @Override
    public String toString() {
        return "CerclePlace{" +
                "rayon=" + rayon +
                ", centre=" + centre +
                '}';
    }
}
