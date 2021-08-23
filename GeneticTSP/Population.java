package tsp;

import java.util.Arrays;
import java.util.Comparator;

public class Population {
	private Individual population[];
	private double avgFitness = -1;

	public Population(int populationSize) {
		this.population = new Individual[populationSize];
	}

	public Population(int populationSize, int chromosomeLength) {
		this.population = new Individual[populationSize];
		for (int indivCount = 0; indivCount < populationSize; indivCount++) {
			Individual individual = new Individual(chromosomeLength);
			this.population[indivCount] = individual;

		}
	}

	public Individual[] getIndividuals() {
		return this.population;
	}

	public Individual getFittest(int offset) {
		Arrays.sort(this.population, new Comparator<Individual>() {
			public int compare(Individual o1, Individual o2) {
				if (o1.getFitness() > o2.getFitness()) {
					return -1;
				} else if (o1.getFitness() < o2.getFitness()) {
					return 1;
				}
				return 0;
			}
		});
		return this.population[offset];
	}

	public void shuffle() {
		for (int individualIndex = 0; this.size() > individualIndex; individualIndex++) {
			int index = (int) (Math.random() * this.size());
			Individual tempIndividual=this.population[index];
			this.population[index]=this.population[individualIndex];
			this.population[individualIndex]=tempIndividual;
		}
	}

	int size() {
		// TODO Auto-generated method stub
		return population.length;
	}
	
	public Individual setIndividual(Individual individual, int offset) {
		return population[offset]=individual;
	}
	public Individual getIndividual(int offset) {
		return population[offset];
	}
	public double setAverageFitness(double fitness) {
		return this.avgFitness=fitness;
	}
	
	public void setPopulationFitness(int fitness) {
		this.avgFitness=fitness;
	}
	public double getPopulationFitness() {
		return this.avgFitness;
	}
	
}
