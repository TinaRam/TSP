/**
 * @author tinarambo
 * 
 */
package tsp;

import java.util.ArrayList;
import java.util.Arrays;

public class TestMultiplier {

	// Methods
	RandomMethod randomMethod;
	IterativeRandomMethod iterativeRandomMethod;
	GreedyMethod greedyMethod;
	GreedyImprovement greedyImprovement;
	GreedyRandom iGreedyRandom;

	// Kjøre program mange ganger for å finne gjennomsnitt
	ArrayList<Integer> iRM = new ArrayList<Integer>();
	ArrayList<Integer> iIRM = new ArrayList<Integer>();
	ArrayList<Integer> iGM = new ArrayList<Integer>();

	ArrayList<Integer> oGIRM = new ArrayList<Integer>();
	ArrayList<Integer> oGIIRM = new ArrayList<Integer>();
	ArrayList<Integer> oGIGM = new ArrayList<Integer>();

	ArrayList<Integer> oGRRM = new ArrayList<Integer>();
	ArrayList<Integer> oGRIRM = new ArrayList<Integer>();
	ArrayList<Integer> oGRGM = new ArrayList<Integer>();

	private int[][] distGraph;
	private Calculator calc;
	private int n;

	// EDIT STOP CRITERIONS
	private int s = 5; // stop criteria - Iterative Random Method
	private int stop = 10; // stop criteria - Greedy Improvement
	private double a = 0.9; // acceptance probability - Greedy Random
	private int tries = 10; // max tries Greedy Random - Greedy Random

	public void runTests(int cities, int runs) {
		this.n = cities;
		distGraph = new DistanceGraph().getDistGraph(n);
		calc = new Calculator(distGraph);
		initiateMethods();
		int z = runs;
		while (runs > 0) {

			// initial
			int[] rm = randomMethod.generateRandomRoute(n);
			iRM.add(calc.getRouteDistance(rm));
			int[] irm = iterativeRandomMethod.generateIterativeRandomRoute(n, s);
			iIRM.add(calc.getRouteDistance(irm));
			int[] gm = greedyMethod.generateGreedyRoute(n);
			iGM.add(calc.getRouteDistance(gm));

			// optimized
			oGIRM.add(calc.getRouteDistance(greedyImprovement.getGreedyImprovedRoute(rm, stop)));
			oGIIRM.add(calc.getRouteDistance(greedyImprovement.getGreedyImprovedRoute(irm, stop)));
			oGIGM.add(calc.getRouteDistance(greedyImprovement.getGreedyImprovedRoute(gm, stop)));

			oGRRM.add(calc.getRouteDistance(iGreedyRandom.getIGreedyRandomRoute(rm, tries, a)));
			oGRIRM.add(calc.getRouteDistance(iGreedyRandom.getIGreedyRandomRoute(irm, tries, a)));
			oGRGM.add(calc.getRouteDistance(iGreedyRandom.getIGreedyRandomRoute(gm, tries, a)));

			runs--;
		}
		System.out.println();

		// LAGE TABELLVISNING
		// Initial Method GI GR
		// best - -
		// avg - -
		// SD - -

		System.out.println("TEST WITH " + cities + " cities and " + z + " runs:\n");
		System.out.println("Random Method");
		System.out.println("Best: " + calc.bestRoute(iRM));

		System.out.println("Average: " + calc.getAverage(iRM));
		System.out.format("SD: %.2f", calc.getSD(iRM));
		System.out.println();
		System.out.println();

		System.out.println("Iterative Random Method");
		System.out.println("Best: " + calc.bestRoute(iIRM));

		System.out.println("Average: " + calc.getAverage(iIRM));
		System.out.format("SD: %.2f", calc.getSD(iIRM));
		System.out.println();
		System.out.println();

		System.out.println("Greedy Method");
		System.out.println("Best: " + calc.bestRoute(iGM));

		System.out.println("Average: " + calc.getAverage(iGM));
		System.out.format("SD: %.2f", calc.getSD(iGM));
		System.out.println();
		System.out.println();
	}

	private void initiateMethods() {
		randomMethod = new RandomMethod();
		iterativeRandomMethod = new IterativeRandomMethod(calc);
		greedyMethod = new GreedyMethod(calc);
		greedyImprovement = new GreedyImprovement(calc);
		iGreedyRandom = new GreedyRandom(calc);
	}

//	public void printSampleGraph(int c) {
//
//		String matrix = "";
//		for (int z = 0; z < c; z++) {
//			for (int y = 0; y < c; y++)
//				matrix += distGraph[z][y] + " ";
//			matrix += "\n";
//		}
//		System.out.println("Matrix with " + c + " cities: \n");
//		System.out.println(matrix);
//		System.out.println();
//	}
}
