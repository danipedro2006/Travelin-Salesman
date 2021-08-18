package tsp;

import java.util.ArrayList;
import java.util.List;

// Travelling Salesman Problem - Greedy approach

public class TSP {

	private static void findMinRoute(int[][] tsp) {
		int sum=0;
		int counter=0;
		int min=Integer.MAX_VALUE;
		List<Integer> visited=new ArrayList<Integer>();
		int[] route=new int[tsp.length];

		//add start vertex
		visited.add(0);

		//traverse adjacency matrix
		int i=0;
		int j=0;

		while(i<tsp.length && j<tsp[i].length){
			if(counter>=tsp[i].length-1) {
				break;
			}


			//if this path is unvisited and the cost is less then update the cost

			if(!(visited.contains(j)) && !(i==j)) {
				if (tsp[i][j]<min) {
					min=tsp[i][j];
					route[counter]=j+1;
				}
			}
			j++;
			
			//check all paths from i-th index
			
			if(j==tsp[i].length) {
				sum+=min;
				min=Integer.MAX_VALUE;
				visited.add(route[counter]-1);
				j=0;
				i=route[counter]-1;
				counter++;
			}
		}
		
		//update the ending city from last visited city
		
		i=route[counter-1]-1;
		for(j=0;j<tsp.length;j++) {
			if((i!=j) && tsp[i][j]<min) {
				min=tsp[i][j];
				route[counter]=j+1;
			}
		}
		sum+=min;
		System.out.println("Minimum cost is: "+sum);
	}

	public static void main(String[] args) {
		//input matrix
		//graph represented by adjacency matrix

		int[][] tsp= {
				{-1,10,15,20},
				{10,-1,35,25},
				{15,35,-1,30},
				{20,25,30,-1}
		};

		findMinRoute(tsp);
	}


}