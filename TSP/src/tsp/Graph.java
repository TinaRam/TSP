package tsp;

import java.util.Random;

public class Graph {

	public static int[][] createGraph(int cities)// Metode for å generere matrise
	// metode for å generere graf. Initieres med integer som angir antall byer
	{
		Random rnd = new Random();
		// oppretter variabel av typen random
		int[][] graph = new int[cities][cities];
		// Graf for Random distance between cities

		for (int i = 0; i < cities; i++) {
			for (int j = 0; j < (i + 1); j++) {
				if (i == j) {
					graph[i][j] = 0;
				} else {
					graph[j][i] = graph[i][j] = 1 + rnd.nextInt(9);
					// verdier mellom 1-9
				}
			}
		}
		return graph;
	}

	public static void printGraph(int[][] array) {
		String matrix = "";
		for (int z = 0; z < array.length; z++) {
			for (int y = 0; y < array.length; y++)
				matrix += array[z][y] + " ";
			matrix += "\n";
		}
		System.out.println(matrix);
	}
}
