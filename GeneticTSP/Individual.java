package tsp;

public class Individual {
	
	public int chromosome[];
	private double fitness=-1;
	
	public Individual(int[] chromosome, double fitness) {
		this.chromosome = chromosome;
		this.fitness = fitness;
	}

	public int[] getChromosome() {
		return chromosome;
	}

	public double getFitness() {
		return fitness;
	}

}
