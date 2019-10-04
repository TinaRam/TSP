/**
 * @author tinarambo
 * 
 */
package tsp;

import java.util.ArrayList;

public class Calculator {

	private int[][] distGraph;
	private int[] route;
	private int routeDist;

	public Calculator(int[][] distances) {
		this.distGraph = distances;
	}

	// Method returning the distance between 'city a' and 'city b'
	public int getDistanceToCity(int a, int b) {
		return distGraph[a][b];
	}

	// Method for calculating the total distance of a route
	// including the distance for returning to start position
	private void calcRouteWithReturnToStart() {
		for (int i = 0; i < route.length; i++) {
			if (i < route.length - 1) {
				routeDist += distGraph[route[i]][route[i + 1]];
			} else {
				routeDist += distGraph[route[i]][route[i - i]];
			}
		}
	}

	public int getRouteDistance(int[] route) {
		this.route = route;
		routeDist = 0;
		calcRouteWithReturnToStart();
		return routeDist;
	}

	public double getAverage(ArrayList<Integer> l) {
		int sum = 0;
		for (Integer i : l) {
			sum += i;
		}
		return sum / l.size();
	}

	public int bestRoute(ArrayList<Integer> l) {
		int best = 99999;
		for (Integer i : l) {
			if (i < best) {
				best = i;
			}
		}
		return best;
	}

	public int worstRoute(ArrayList<Integer> l) {
		int worst = 0;
		for (Integer i : l) {
			if (i > worst) {
				worst = i;
			}
		}
		return worst;
	}

	public double getSD(ArrayList<Integer> l) {
		int length = l.size();
		double mean = getAverage(l);
		double sd = 0.0;
		for (Integer i : l) {
			sd += Math.pow(i - mean, 2);
		}
		return Math.sqrt(sd / length);
	}

}
