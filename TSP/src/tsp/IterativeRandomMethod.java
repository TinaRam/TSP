/**
 * @author tinarambo
 * Class for generating a Random Route by generating a random route a selected number of times and returning the shortest route.
 * Class needs a Calculator instance for distance calculations (in constructor parameter).
 * Method generateIterativeRandomRoute takes nr of cities to visit and number of iterations to run the loop
 * and returning an int array with the shortest route.
 * 
 */
package tsp;

import java.util.Random;

public class IterativeRandomMethod {

	private int[] randomRoute, iterativeRandomRoute;
	private int distance;
	private Calculator c;

	public IterativeRandomMethod(Calculator calc) {
		this.c = calc;
	}

	public int[] generateIterativeRandomRoute(int nrOfCities, int nrOfIterations) {
		populateArray(nrOfCities);
		iterativeRandomRoute = shuffleCities(iterativeRandomRoute);
		this.distance = c.getRouteDistance(iterativeRandomRoute);
		findMostOptimalRandomRoute(nrOfIterations);
		return iterativeRandomRoute;
	}

	public int getIRMDistance() {
		return distance;
	}

	private void findMostOptimalRandomRoute(int iterations) {
		int newDistance = 0;
		for (int i = 0; i < iterations; i++) {
			randomRoute = shuffleCities(iterativeRandomRoute);
			newDistance = c.getRouteDistance(randomRoute);

			if (distance >= newDistance) {
				iterativeRandomRoute = randomRoute;
				distance = newDistance;
			}
		}
	}

	// Populate an int array
	private void populateArray(int c) {
		iterativeRandomRoute = new int[c];
		for (int i = 0; i < c; i++) {
			iterativeRandomRoute[i] += i;
		}
	}

	// Shuffle the array using the Fisher-Yates Shuffle-algorithm
	// (complexity O(n))
	private int[] shuffleCities(int[] arr) {

		int[] array = arr.clone();
		int n = array.length;
		Random r = new Random();

		for (int i = n - 1; i > 0; i--) {
			int j = r.nextInt(i + 1); // Pick a random index from 0 to i

			// Swap cities[i] with the random index
			int z = array[i];
			array[i] = array[j];
			array[j] = z;
		}
		return array;
	}
}
