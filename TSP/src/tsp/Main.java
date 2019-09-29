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
		int[] rm5 = rm.generateRandomRoute(5);
		int drm5 = calc.getRouteDistance(rm5);
		System.out.println("5 Random Method: " + Arrays.toString(rm5));
		System.out.println("5 Random route distance: " + drm5);

		System.out.println();

		int[] rm3 = rm.generateRandomRoute(3);
		int drm3 = calc.getRouteDistance(rm3);
		System.out.println("3 Random Method: " + Arrays.toString(rm3));
		System.out.println("3 Random route distance: " + drm3);

		System.out.println();
		System.out.println();

		// Initiate Iterative Random Method
		IterativeRandomMethod irm = new IterativeRandomMethod(calc);
		int[] irm5 = irm.generateIterativeRandomRoute(5, 5); // 5 byer, 5 iterasjoner
		int dirm5 = irm.getIRMDistance();
		System.out.println("5 Iterative Random Method: " + Arrays.toString(irm5));
		System.out.println("5 Iterative Random route distance: " + dirm5);

		System.out.println();

		int[] irm3 = irm.generateIterativeRandomRoute(3, 5); // 3 byer, 5 iterasjoner
		int dirm3 = irm.getIRMDistance();
		System.out.println("3 Iterative Random Method: " + Arrays.toString(irm3));
		System.out.println("3 Iterative Random route distance: " + dirm3);

		System.out.println();
		System.out.println();
		//
		t.stopTimer();
		System.out.println("\n\n - END - ");
		System.out.println("Execution time: " + t.getElapsedMs() + " ms");
//		System.out.println("Execution time: " + t.getFormattedTimeTot()); // Display elapsed time in hh:mm:ss:ms
	}

}
