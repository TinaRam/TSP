/**
 * @author tinarambo
 * 
 * Klasse for å generere en 'Weighted Adjacent Matrix' med tilfeldige verdier (weights)
 * 2D-array der x og y representerer byer, og verdiene avstanden mellom byene
 */

package tsp;

import java.util.Random;

public class DistanceGraph {

	public static int[][] createGraph(int cities) {
		Random r = new Random();
		int[][] distGraph = new int[cities][cities];

		for (int i = 0; i < cities; i++) {
			for (int j = 0; j < (i + 1); j++) {
				if (i == j) {
					distGraph[i][j] = 0;
				} else {
					distGraph[j][i] = distGraph[i][j] = 1 + r.nextInt(10); // values between 1 and 10
				}
			}
		}
		return distGraph;
	}

	public static void printGraph(int[][] g) {
		String matrix = "";
		for (int z = 0; z < g.length; z++) {
			for (int y = 0; y < g.length; y++)
				matrix += g[z][y] + " ";
			matrix += "\n";
		}
		System.out.println(matrix);
	}
}
