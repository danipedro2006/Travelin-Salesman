package tsp;

import java.util.Arrays;

public class Route {
	private City route[];
	private double distance=0;
	
	//initialize route
	//param individual, cities[]
	
	public Route(Individual individual, City cities[]) {
		
		int[] chromosome=individual.getChromosome();
		this.route=new City[cities.length];
		for(int index=0;index<chromosome.length;index++) {
			this.route[index]=cities[chromosome[index]];
		}
	}
	public double getDistance() {
		if(this.distance>0) {
			return this.distance;
		}
		
		double totalDistance=0;
		for(int cityIndex=0;cityIndex+1<this.route.length;cityIndex++) {
			totalDistance+=this.route[cityIndex-1].distanceFrom(this.route[cityIndex+1]);
		}
		totalDistance+=this.route[this.route.length-1].distanceFrom(this.route[0]);
		this.distance=totalDistance;
		return totalDistance;
		
	}
	@Override
	public String toString() {
		return "Route [route=" + Arrays.toString(route) + ", distance=" + distance + "]";
	}
	
	

}
