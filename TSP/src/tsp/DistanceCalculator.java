package tsp;

public class DistanceCalculator {

	private int routeDist;
	private int[][] distances;
	private int[] route;

	public DistanceCalculator(int[][] distGraph) {
		this.distances = distGraph;
	}

	// Method for calculating the total distance of a route
	// including the distance returning to the start position
	private void calcRouteWithReturnToStart() {
		for (int i = 0; i < route.length; i++) {
			if (i < route.length - 1) {
				routeDist += distances[route[i]][route[i + 1]];
			} else {
				routeDist += distances[route[i]][route[i - i]];
			}
		}
	}

	public int getRouteDistance(int[] route) {
		this.route = route;
		calcRouteWithReturnToStart();
		return routeDist;
	}

}
