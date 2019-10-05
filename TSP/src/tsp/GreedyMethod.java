/**
 * @author tinarambo
 * 
 */
package tsp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GreedyMethod {

	private Calculator calc;
	private int nrOfCities;
	private int[] greedyRoute;
	private ArrayList<String> route;
	private Random r;

	public GreedyMethod(Calculator c) {
		this.calc = c;
		this.route = new ArrayList<String>();
		this.r = new Random();
	}

	public int[] generateGreedyRoute(int cit) {
		this.nrOfCities = cit;
		this.greedyRoute = new int[nrOfCities];
		populateArrayList(nrOfCities);

		// lagt en tilfeldig by fra route over i greedyRoute og sletta den fra route.
		int start = r.nextInt(nrOfCities);
		greedyRoute[0] = start; // legger til første by
		route.remove(route.get(start)); // markerer den som besøkt

		int best = 1999999;
		int curr = 0;

		Iterator<String> it;
		int a, b = 0, x = 0;

		for (int i = 0; i < nrOfCities - 1; i++) {

			it = route.iterator();
			while (it.hasNext()) {
				a = greedyRoute[i];
				b = Integer.parseInt((String) it.next());
				curr = calc.getDistanceToCity(a, b);
				if (curr <= best) {
					best = curr;
					x = b;
				}
			}
			greedyRoute[i + 1] = x;
			route.remove(route.indexOf("" + x));
			best = 999;
		}
		return greedyRoute;
	}

	// Fyller en ArrayList med verdier fra 0 til nrOfCities-1
	private void populateArrayList(int n) {
		for (int i = 0; i < n; i++) {
			route.add("" + i);
		}
	}

}
