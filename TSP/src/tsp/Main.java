package tsp;

import java.util.Arrays;

/**
 * @author tinarambo
 * 
 *         Travelling Salesman Problem
 * 
 *         Program creates a graph with distances chosen randomly between 1 and
 *         10. Then generates an initial solution using the Random Method and
 *         calculates the routes total distance, incl. return to start position.
 */
public class Main {

	public static void main(String[] args) {

		// Number of cities in distance graph and in random route
		int n = 10000;

		// Measure elapsed time
		TimeTracker t = new TimeTracker();
		t.startTimer();

		int[][] d = DistanceGraph.createGraph(n);
//		System.out.println(n + " cities:");
//		DistanceGraph.printGraph(d);

		RandomMethod r = new RandomMethod();
		int[] initialRandomMethod = r.generateRandomRoute(n);
		System.out.println("The random route: " + Arrays.toString(initialRandomMethod));

		DistanceCalculator c = new DistanceCalculator(d, initialRandomMethod);
		System.out.println("The total distance is: " + c.getTotalDistance());

		t.stopTimer();
		System.out.println("\n\n - END - ");
		System.out.println("Execution time: " + t.getElapsedMs() + " ms");
//		System.out.println("Execution time: " + t.getFormattedTimeTot()); // Display elapsed time in hh:mm:ss:ms
	}

}
