/**
 * @author tinarambo
 * 
 */
package tsp;

import java.util.Arrays;

public class IterativeRandomMethod {

	private int stop, distance;
	private int[] best, current, cities;
	private int[][] dist;

	public IterativeRandomMethod(int[][] dist, int[] cities) {
		this.cities = cities;
		this.dist = dist;
		this.stop = 5;
	}

	public IterativeRandomMethod(int[][] dist, int[] cities, int iterations) {
		this.cities = cities;
		this.dist = dist;
		this.stop = iterations;
	}

	private void iterativeRndRoute() {
		RandomMethod rm = new RandomMethod();
		DistanceCalculator calc = new DistanceCalculator(dist);
		best = rm.getRandomRoute(cities);
		distance = calc.getRouteDistance(cities);
		while (stop > 0) {
			System.out.println("\nOriginal cities: " + Arrays.toString(cities));
			current = rm.getRandomRoute(cities);
			System.out.println("Current: " + Arrays.toString(cities));
			System.out.println(distance);
			if (distance > calc.getRouteDistance(best)) {
				best = current;
			}
			stop--;
		}
		System.out.println("WHILE ENDED!");
	}

	public int[] getIterativeRndRoute() {
		iterativeRndRoute();
		return best;
	}
}
