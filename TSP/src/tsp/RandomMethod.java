package tsp;

import java.util.Random;

public class RandomMethod {

	private int[] randomRoute;

	public void generateRandomRoute(int nrOfCities) {
		populateArray(nrOfCities);
		shuffleCities();
	}

	public int[] getRandomRoute() {
		return randomRoute;
	}

	// Populate an int array
	private void populateArray(int c) {
		randomRoute = new int[c];
		for (int i = 0; i < c; i++) {
			randomRoute[i] += i;
		}
	}

	// Shuffle the array using the Fisher-Yates Shuffle-algorithm
	// (complexity O(n))
	private void shuffleCities() {
		int n = randomRoute.length;
		Random r = new Random();

		for (int i = n - 1; i > 0; i--) {
			int j = r.nextInt(i + 1); // Pick a random index from 0 to i

			// Swap cities[i] with the random index
			int z = randomRoute[i];
			randomRoute[i] = randomRoute[j];
			randomRoute[j] = z;
		}
	}
}