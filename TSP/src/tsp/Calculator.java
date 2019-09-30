/**
 * @author tinarambo
 * 
 */
package tsp;

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

}
