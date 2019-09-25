package tsp;

import java.util.Random;

public class RandomMethod {

	private int[] cities;

	public int[] getRandomRoute(int[] c) {
		this.cities = c;
		shuffleCities();
		return cities;
	}

	// Shuffle the array using the Fisher-Yates Shuffle-algorithm
	// (complexity O(n))
	private void shuffleCities() {
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