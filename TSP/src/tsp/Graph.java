package tsp;

import java.util.Random;

public class Graph {

	public static int[][] createGraph(int cities) {
		Random rnd = new Random();
		int[][] graph = new int[cities][cities];

		for (int i = 0; i < cities; i++) {
			for (int j = 0; j < (i + 1); j++) {
				if (i == j) {
					graph[i][j] = 0;
				} else {
					graph[j][i] = graph[i][j] = 1 + rnd.nextInt(9); // verdier mellom 1-9
				}
			}
		}
		return graph;
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
