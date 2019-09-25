package tsp;

/**
 * @author tinarambo Class for
 */
public class DistanceCalculator {

	private int totalDist;
	private int[][] distances;
	private int[] route;

	public DistanceCalculator(int[][] distGraph, int[] route) {
		this.distances = distGraph;
		this.route = route;
		calcRouteWithReturnToStart();
	}

	// Method for calculating the total distance of a route
	// including the distance returning to the start position
	private void calcRouteWithReturnToStart() {
		for (int i = 0; i < route.length; i++) {
			if (i < route.length - 1) {
				totalDist += distances[route[i]][route[i + 1]];
			} else {
				totalDist += distances[route[i]][route[i - i]];
			}
		}
	}

	public int getTotalDistance() {
		return totalDist;
	}

}
