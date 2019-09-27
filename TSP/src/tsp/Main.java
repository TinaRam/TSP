package tsp;

import java.util.Arrays;

/**
 * @author tinarambo
 * 
 *         Travelling Salesman Problem
 * 
 *         Program creates a graph with distances chosen randomly between 1-10.
 *         Then generates an initial solution using the Random Method and
 *         calculates the routes total distance, incl. return to start position.
 */
public class Main {

	public static void main(String[] args) {

		// Measure elapsed time
		TimeTracker t = new TimeTracker();
		t.startTimer();

		// Initiate the distance graph. (holds distances 500 cities)
		DistanceGraph g = DistanceGraph.getInstance();
//		g.printGraph();
		int[][] distGraph = g.getDistGraph();
		String matrix = "";
		for (int z = 0; z < 5; z++) {
			for (int y = 0; y < 5; y++)
				matrix += distGraph[z][y] + " ";
			matrix += "\n";
		}
		System.out.println(matrix);

		// Initiate the calculator for calculation of distances
		Calculator calc = new Calculator(distGraph);

		// Initiate Random Method
		RandomMethod rm = new RandomMethod();
		rm.generateRandomRoute(5);
		int[] c5 = rm.getRandomRoute();
		int distC5 = calc.getRouteDistance(c5);
		System.out.println("5 cities Random Method: " + Arrays.toString(c5));
		System.out.println("5 cities Random route distance: " + distC5);

		System.out.println();
		System.out.println();
		rm.generateRandomRoute(3);
		int[] c3 = rm.getRandomRoute();
		int distC3 = calc.getRouteDistance(c3);
		System.out.println("3 cities Random Method: " + Arrays.toString(c3));
		System.out.println("3 cities Random route distance: " + distC3);

		//
		t.stopTimer();
		System.out.println("\n\n - END - ");
		System.out.println("Execution time: " + t.getElapsedMs() + " ms");
//		System.out.println("Execution time: " + t.getFormattedTimeTot()); // Display elapsed time in hh:mm:ss:ms
	}

}
