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
			shuffleCities();
			cur = calc.getRouteDistance(optimized);

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

	// Select two random cities and shuffle
	private void shuffleCities() {
		int n = initial.length;
		int c1 = 0, c2 = 0;
		Random r = new Random();
		while (c1 == c2) {
			c1 = r.nextInt(n);
			c2 = r.nextInt(n);
		}
		int z = optimized[c1];
		optimized[c1] = optimized[c2];
		optimized[c2] = z;
	}
}
