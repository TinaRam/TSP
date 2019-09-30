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

		// Antall cities som skal testes til slutt...
//		int c50 = 50;
//		int c100 = 100;
//		int c250 = 250;
//		int c500 = 500;

		// kun for testing
		int c = 5;

		// Initiate the distance graph. (holds distances 500 cities)
		DistanceGraph g = DistanceGraph.getInstance();
//		g.printGraph();
		int[][] distGraph = g.getDistGraph();
		String matrix = "";
		for (int z = 0; z < c; z++) {
			for (int y = 0; y < 5; y++)
				matrix += distGraph[z][y] + " ";
			matrix += "\n";
		}
		System.out.println("Matrix with " + c + " cities: \n");
		System.out.println(matrix);
		System.out.println();

		// Initiate the calculator for calculation of distances
		Calculator calc = new Calculator(distGraph);

		// PHASE ONE
		System.out.println("PHASE ONE");

		// Random Method
		RandomMethod rm = new RandomMethod();
		int[] rr = rm.generateRandomRoute(c);
		int drr = calc.getRouteDistance(rr);
		System.out.println(c + " Random Method: " + Arrays.toString(rr));
		System.out.println(c + " Random route distance: " + drr);

		System.out.println();

		// Iterative Random Method
		IterativeRandomMethod irm = new IterativeRandomMethod(calc);
		int[] irr = irm.generateIterativeRandomRoute(c, 5); // 5 byer, 5 iterasjoner
		int dirr = irm.getIRMDistance();
		System.out.println(c + " Iterative Random Method: " + Arrays.toString(irr));
		System.out.println(c + " Iterative Random route distance: " + dirr);

		System.out.println();

		// Greedy Method (GM)
		GreedyMethod gm = new GreedyMethod(calc);
		int[] gr = gm.generateGreedyRoute(c);
		int dgr = calc.getRouteDistance(gr);
		System.out.println(c + " Greedy Method: " + Arrays.toString(gr));
		System.out.println(c + " Greedy route distance: " + dgr);

		System.out.println();
		System.out.println();

		// PHASE TWO
		System.out.println("PHASE TWO");
		// Greedy Improvement (GI)
		GreedyImprovement gi = new GreedyImprovement(calc);

		// GI on Random Method
		int[] gir = gi.getGreedyImprovedRoute(rr, 5);
		int dgir = calc.getRouteDistance(gir);
		System.out.println(c + " Greedy Improvement (Random Method): " + Arrays.toString(gir));
		System.out.println(c + " Greedy Improvement (Random Method) route distance: " + dgir);

		System.out.println();

		// GI on Iterative Random Method
		int[] giir = gi.getGreedyImprovedRoute(irr, 5);
		int dgiir = calc.getRouteDistance(giir);
		System.out.println(c + " Greedy Improvement (Iterative Random Method): " + Arrays.toString(giir));
		System.out.println(c + " Greedy Improvement (Iterative Random Method) route distance: " + dgiir);

		System.out.println();

		// GI on Greedy Method
		int[] gigr = gi.getGreedyImprovedRoute(gr, 5);
		int dgigr = calc.getRouteDistance(gigr);
		System.out.println(c + " Greedy Improvement (Greedy Method): " + Arrays.toString(gigr));
		System.out.println(c + " Greedy Improvement (Greedy Method) route distance: " + dgigr);

		//
		System.out.println();
		System.out.println();
		//
		t.stopTimer();
		System.out.println("\n\n - END - ");
		System.out.println("Execution time: " + t.getElapsedMs() + " ms");
//		System.out.println("Execution time: " + t.getFormattedTimeTot()); // Display elapsed time in hh:mm:ss:ms
	}

}
