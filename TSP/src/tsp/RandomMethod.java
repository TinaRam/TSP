package tsp;

import java.util.Random;


public class RandomMethod {
	
	private Random r = new Random();
	private int[] cities;
	
	public int[] RandomMethod(int[][] graph, int nbmOfCities) {
		this.cities = new int[nbmOfCities];
		
		for(int i = 0; i < nbmOfCities; i++) { 
//			cities[i] += graph.  
//			legge 'cities antall' tilfeldig valgte byer i et array "cities"
		}
		
		
		
		return cities;
	}
	
}

/*
public static int[] randMethod(int[,] array, int cities)
{
    Random rnd = new Random();
    int[] visited = Enumerable.Range(0, cities).OrderBy(x => rnd.Next()).Take(cities).ToArray();
    return visited; (route)
}
*/