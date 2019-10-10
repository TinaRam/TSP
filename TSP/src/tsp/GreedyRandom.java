/**
 * @author tinarambo
 * 
 */
package tsp;

import java.util.Random;

public class GreedyRandom {

	Calculator calc;
	private int[] optimized, initial, optimal;
	private double accept, rnd;
	private int tries, pre, cur, best;
	private Random r = new Random();

	public GreedyRandom(Calculator c) {
		this.calc = c;
	}

	public int[] getIGreedyRandomRoute(int[] route, int iterations, double acceptProbability) {
		this.initial = route.clone();
		this.optimized = route.clone();
		this.optimal = route.clone();
		this.accept = acceptProbability;
		this.tries = iterations;
		this.pre = calc.getRouteDistance(initial);
		this.best = pre;
		this.cur = 0;

		do {
			while (tries > 0) {
				shuffleCities(); // "Perturb the current solution"
				cur = calc.getRouteDistance(optimized); // find new cost (cur)

				if (cur < pre) { // Hvis distansen er kortere enn tidligere...
					pre = cur; // tidligere distanse = denne distansen
					initial = optimized.clone(); // initial rute = denne ruta

					if (cur < best) { // Hvis distansen er kortere enn korteste...
						best = cur; // korteste = enda kortere
						optimal = optimized.clone(); // beste rute = denne ruta
					}

				} else { // Ny distanse er større enn eller lik tidligere...
					rnd = r.nextDouble();
					if (rnd > accept) {
						pre = cur; // tidligere distanse = denne distansen
						initial = optimized.clone(); // initial rute = denne ruta
					} else {
						optimized = initial.clone(); // forkaster denne ruta
					}
				}
				tries--;
			}
			accept = accept * accept; // beregner ny 'acceptProbability'
			tries = iterations; // resetter tries

		} while (accept > 0.000001); // kjør loop inntil 'acceptProbability' er bitteliten

		return optimal;
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
