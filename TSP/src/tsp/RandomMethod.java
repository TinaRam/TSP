package tsp;

import java.util.Random;

/**
 * @author tinarambo
 *
 *         Klasse for å generere en tilfeldig rute.
 */

public class RandomMethod {

	private int[] randRoute;

	public int[] generateRandomRoute(int nrOfCities) {
		populateAnArray(nrOfCities);
		shuffleCities(randRoute);
		return randRoute;
	}

	// Populate an int array
	private void populateAnArray(int nrOfCities) {
		this.randRoute = new int[nrOfCities];
		for (int i = 0; i < nrOfCities; i++) {
			randRoute[i] += i;
		}
	}

	// Shuffle the array using the Fisher-Yates Shuffle-algorithm
	private void shuffleCities(int[] cities) {
		int n = cities.length;
		Random r = new Random();

		for (int i = n - 1; i > 0; i--) {
			int j = r.nextInt(i + 1); // Pick a random index from 0 to i

			// Swap cities[i] with the random index
			int z = cities[i];
			cities[i] = cities[j];
			cities[j] = z;
		}
	}
}