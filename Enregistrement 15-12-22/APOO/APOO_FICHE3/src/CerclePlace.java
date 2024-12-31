
public class CerclePlace {
	private double rayon;
	private Point centre;
	
	public CerclePlace(double rayon, Point centre) {
		this.rayon = rayon;
		this.centre = centre;
	}
	public CerclePlace(Point centre){

		this(1,centre);
	}
	public CerclePlace(){
		this(1,new Point(0,0));
	}



	public double getRayon() {
		return rayon;
	}

	public void setRayon(double nRayon) {
		rayon = nRayon;
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point nCentre) {
		centre = nCentre;
	}
	
	public String toString() {
		return "Cercle de rayon : " + rayon + " de centre " + centre;
	}
	

}
