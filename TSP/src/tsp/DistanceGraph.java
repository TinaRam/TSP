/**
 * @author tinarambo
 * 
 * Klasse for å generere en 'Weighted Adjacent Matrix' med tilfeldige verdier (weights)
 * 2D-array der x og y representerer byer, og verdiene avstanden mellom byene.
 */

package tsp;

import java.util.Random;

public class DistanceGraph {

	private int nrOfCities;
	private int[][] distGraph;

	public DistanceGraph() {
		this.nrOfCities = 500;
		populateGraph();
	}

	public DistanceGraph(int n) {
		this.nrOfCities = n;
	}

	private void populateGraph() {
		Random r = new Random();
		this.distGraph = new int[nrOfCities][nrOfCities];

		for (int i = 0; i < nrOfCities; i++) {
			for (int j = 0; j < (i + 1); j++) {
				if (i == j) {
					distGraph[i][j] = 0;
				} else {
					distGraph[j][i] = distGraph[i][j] = 1 + r.nextInt(10); // values between 1 and 10
				}
			}
		}
	}

	public int[][] getDistGraph() {
		return distGraph;
	}

	// For testing puposes only
	public void printGraph() {
		String matrix = "";
		for (int z = 0; z < distGraph.length; z++) {
			for (int y = 0; y < distGraph.length; y++)
				matrix += distGraph[z][y] + " ";
			matrix += "\n";
		}
		System.out.println(matrix);
	}
}
