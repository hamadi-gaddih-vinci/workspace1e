
public class Point {
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;

	}

	public double getX() {
		return x;
	}

	public void setX(double nX) {
		x = nX;
	}

	public double getY() {
		return y;
	}

	public void setY(double nY) {
		y = nY;
	}
	
	public String toString() {
		return "("+ x + "," + y + ")";
	}
	
}
