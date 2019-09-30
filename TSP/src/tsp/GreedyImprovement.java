/**
 * @author tinarambo
 * 
 */
package tsp;

import java.util.Arrays;
import java.util.Random;

public class GreedyImprovement {

	private Calculator calc;
	private int[] optimized, initial;

	public GreedyImprovement(Calculator c) {
		this.calc = c;
	}

	public int[] getGreedyImprovedRoute(int[] route, int stop) {
		this.initial = route.clone();
		this.optimized = route.clone();
		improveInitial(stop);

		return optimized;
	}

	private void improveInitial(int stop) {
		int cur = 0, pre = calc.getRouteDistance(initial);

		while (stop > 0) {
			System.out.println("optimized FØR shuffle: " + Arrays.toString(optimized));
			shuffleCities();
			cur = calc.getRouteDistance(optimized);

			System.out.println("initial: " + Arrays.toString(initial));
			System.out.println("pre: " + pre);
			System.out.println("optimized ETTER shuffle: " + Arrays.toString(optimized));
			System.out.println("cur: " + cur);
			System.out.println();

			if (pre < cur) { // hvis den nye ruta er dårligere enn den gamle...
				optimized = initial.clone(); // så tilbakestilles ruta
				cur = 0;
			} else {
				initial = optimized.clone(); // ellers; så klones den nye ruta over initial
				pre = cur; // pre får den nye distansen
			}
			stop--;
		}
	}

	// Shuffle the array using the Fisher-Yates Shuffle-algorithm
	// (complexity O(n))
	private void shuffleCities() {
		int n = initial.length;
		Random r = new Random();

		for (int i = n - 1; i > 0; i--) {
			int j = r.nextInt(i + 1); // Pick a random index from 0 to i

			// Swap cities[i] with the random index
			int z = optimized[i];
			optimized[i] = optimized[j];
			optimized[j] = z;
		}
	}

}
