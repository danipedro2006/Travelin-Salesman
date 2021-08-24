package tsp;

public class Individual {

	public int chromosome[];
	private double fitness = -1;
	

	// constructor for individual with specific chromosome

	public Individual(int[] chromosome) {

		this.chromosome = chromosome;
		
	}

	// constructor for random individual

	public Individual(int chromosomeLength) {

		// create random individual
		int chromosome[]=new int[chromosomeLength];

		for (int gene = 0; gene < chromosomeLength; gene++) {

			chromosome[gene] = gene;
		}

	// shufle genes

		for (int geneIndex = 0; geneIndex < chromosomeLength; geneIndex++) {

			int newGeneIndex = (int) (Math.random() * chromosomeLength);
			// swap individuals

			int tempIndividual = chromosome[newGeneIndex];
			chromosome[newGeneIndex] = chromosome[geneIndex];
			chromosome[geneIndex] = tempIndividual;

		}

		this.chromosome = chromosome;

	}

	public int[] getChromosome() {

		return this.chromosome;
	}

	public int getChromosomeLength() {

		return this.chromosome.length;
	}
	
	
	// check if gene is contained in this individual

	public boolean containsGene(int gene) {

		for (int i = 0; i < this.getChromosomeLength(); i++) {
			if (this.getGene(i) == gene) {
				return true;
			}
		}

		return false;

	}

	public int getGene(int offset) {

		return this.chromosome[offset];
	}

	public void setGene(int gene, int offset) {

		this.chromosome[offset] = gene;
	}

	public void setFitness(double fitness) {

		this.fitness = fitness;
	}

	public  double getFitness() {

		return this.fitness;
	}
}
