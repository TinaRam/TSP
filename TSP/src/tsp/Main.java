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

		// Initiate the distance graph. (holds 500 cities if nothing else is specified)
		DistanceGraph g = new DistanceGraph();
		int[][] d = g.getDistGraph();
//		g.printGraph();

		DistanceCalculator dc = new DistanceCalculator(d);

		// Initiate array's of cities to visit
		Cities c = new Cities(d);
		int[] c5 = c.getCityArray(5);
//		int[] c50 = c.getCityArray(50);
//		int[] c100 = c.getCityArray(100);
//		int[] c250 = c.getCityArray(250);
//		int[] c500 = c.getCityArray(500);
		System.out.println("Original city array: " + Arrays.toString(c5));

		RandomMethod r = new RandomMethod();
		int[] initialRandomMethod = r.getRandomRoute(c5);
		System.out.println("\nThe random route: " + Arrays.toString(initialRandomMethod));
		System.out.println("Random Method total distance: " + dc.getRouteDistance(initialRandomMethod));

		IterativeRandomMethod ir = new IterativeRandomMethod(d, c5);
		int[] initialRndIterativeRoute = ir.getIterativeRndRoute();
		System.out.println("The Iterative Random route: " + Arrays.toString(initialRndIterativeRoute));
		System.out.println("Iterative Random Method total distance: " + dc.getRouteDistance(initialRndIterativeRoute));

		t.stopTimer();
		System.out.println("\n\n - END - ");
		System.out.println("Execution time: " + t.getElapsedMs() + " ms");
//		System.out.println("Execution time: " + t.getFormattedTimeTot()); // Display elapsed time in hh:mm:ss:ms
	}

}
