package tsp;

public class City {
	private int x;
	private int y;
	
	public City(int x, int y) {
		this.x = x;
		this.y = y;
	}
public double distanceFrom(City city) {
	
	double deltaX=Math.pow(city.getX()-this.getX(),2);
	double deltaY=Math.pow(city.getY()-this.getY(),2);
	double distance=Math.sqrt(deltaX+deltaY);
	return distance;
	
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
}
