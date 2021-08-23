package tsp;

public class GeneticTSP {
	private int populationSize;
	private double mutationRate;
	private double crossoverRate;
	private int tournamentSize;
	private int elitismCount;

	public GeneticTSP(int population, double mutationRate, double crossoverRate, int tournamentSize, int elitismCount) {
		this.populationSize = population;
		this.mutationRate = mutationRate;
		this.crossoverRate = crossoverRate;
		this.tournamentSize = tournamentSize;
		this.elitismCount = elitismCount;
	}

	public Population initPopulation(int chromosomeLength) {
		Population population = new Population(this.populationSize, chromosomeLength);
		return population;
	}

	public double calcFitness(Individual individual, City cities[]) {
		Route route = new Route(individual, cities);
		double fitness = 1 / route.getDistance();
		individual.setFitness(fitness);
		return fitness;

	}

	// Evaluate population
	// Loop over population and sum up fitness values

	public void evalPopulation(Population population, City cities[]) {
		double totalPopulationFitness = 0;
		for (Individual individual : population.getIndividuals()) {
			totalPopulationFitness += this.calcFitness(individual, cities);
		}

		double avgFitness = totalPopulationFitness / population.size();

		population.setAverageFitness(avgFitness);
	}

	public boolean isTerminationConditionmet(int generationsCount, int maxGenerations) {
		return (generationsCount > maxGenerations);

	}

	public Individual tournamentSelection(Population population) {
		Population tournament = new Population(this.tournamentSize);
		population.shuffle();
		for (int i = 0; i < this.tournamentSize; i++) {
			Individual tournamentIndividual = population.getIndividual(i);
			tournament.setIndividual(tournamentIndividual, i);
		}
		return tournament.getFittest(0);

	}

	public Individual selectparent(Population population) {
		Individual individuals[] = population.getIndividuals();

		// Spin roulette wheel

		double populationFitness = population.getPopulationFitness();
		double rouletteWheelPosition = Math.random() * populationFitness;
		double spinWheel = 0;
		for (Individual individual : individuals) {
			spinWheel += individual.getFitness();
			if (spinWheel >= rouletteWheelPosition) {
				return individual;
			}
		}
		return individuals[population.size() - 1];
	}

	public Population singlePointCrossOver(Population population) {
		//Create new population
		Population newPopulation = new Population(population.size());
		// Loop by fitness
		for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
			Individual parent1 = population.getFittest(populationIndex);
			// Apply crossover to this individual
			if (this.crossoverRate > Math.random() && populationIndex > this.elitismCount) {
				int offspringChromosome[] = new int[parent1.getChromosomeLength()];
				// Find second parent
				Individual parent2 = this.tournamentSelection(population);
				// Get random swap point
				int swapPoint = (int) (Math.random() * (parent1.getChromosomeLength() + 1));
				// Loop over genome
				for (int geneIndex = 0; geneIndex < parent1.getChromosomeLength(); geneIndex++) {
					// Use half parent1 and half parent2 genes
					if (geneIndex < swapPoint) {
						offspringChromosome[geneIndex] = parent1.getGene(geneIndex);
					} else {
						offspringChromosome[geneIndex] = parent2.getGene(geneIndex);
					}
				}
				// Add offspring to new population
				newPopulation.setIndividual(new Individual(offspringChromosome), populationIndex);
			} else {
				newPopulation.setIndividual(parent1, populationIndex);
			}
		}
		return newPopulation;
	}
	
	public Population mutatePopulation(Population population) {
		//Initialize new population
		Population newPopulation=new Population(this.populationSize);
		
		//loop over current population by fitness
		for(int populationIndex=0;populationIndex<population.size();populationIndex++) {
			Individual individual=population.getFittest(populationIndex);
			//Skip multation if is elite individual
			
			if(populationIndex>this.elitismCount) {
				//Loop over individual's genes
				for(int geneIndex=0;geneIndex<individual.getChromosomeLength();geneIndex++) {
					//This gene needs mutation?
					if(this.mutationRate>Math.random()) {
						//Get new gene position
						int newGenePos=(int)(Math.random()*individual.getChromosomeLength());
						//Get gene to swap
						int gene1=individual.getGene(newGenePos);
						int gene2=individual.getGene(geneIndex);
						//Swap genes
						individual.setGene(gene1, geneIndex);
						individual.setGene(gene2, newGenePos);
					}
				}
			}
			
			newPopulation.setIndividual(individual, populationIndex);
		}
		return newPopulation;
	}
}
