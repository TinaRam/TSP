package tsp;

import java.util.Random;

public class RandomMethod {

	private int[] randRoute;
	private int[][] dist;

	public RandomMethod(int[][] cities) {
		randRoute = new int[cities.length];
		dist = cities;
	}

	private void generateRandomRoute() {
		Random r = new Random();

	}

//	public int[] RandomMethod(int[][] distGraph) {
//		Random r = new Random();
//		int[] randRoute = new int[distGraph.length + 1];
//
//		for (int i = distGraph.length - 1; i > 0; i--) {
//
//		}
//
//		return randRoute;
//	}

}

///*
// * public static int[] randMethod(int[,] array, int cities) { 
// * Random rnd = new Random(); 
// * int[] visited = Enumerable.Range(0, cities).OrderBy(x => rnd.Next()).Take(cities).ToArray(); 
// * return visited; (route) }
// */