package tsp;

/**
 * @author Rambo Klasse for å regne ut kostnaden til av de ulike rutene
 * 
 */

public class DistanceCalculator {

	private int totalDist;
	private int[][] distance;
	private int[] route;

	public DistanceCalculator(int[][] distGraph, int[] visitedCities) {
		this.distance = distGraph;
		this.route = visitedCities;
		this.totalDist = 0;
	}

	private int calcRouteDist() {

		return 0;
	}

}
