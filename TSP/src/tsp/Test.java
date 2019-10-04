/**
 * @author tinarambo
 * 
 */
package tsp;

import java.util.Arrays;

public class Test {

	private int[][] distGraph;
	private Calculator calc;
	private int n = 0, drm, dirm, dgm, dgirm, dgiirm, dgigm, digrrm, digrirm, digrgm;
	private int[] rm, irm, gm, girm, giirm, gigm, igrrm, igrirm, igrgm;

	// EDIT STOP CRITERIONS
	private int s = 5; // stop criteria - Iterative Random Method
	private int stop = 10; // stop criteria - Greedy Improvement
	private double a = 0.9; // acceptance probability - Greedy Random
	private int tries = 6; // max tries Greedy Random - Greedy Random

	public void runTest(int nrOfCities) {
		n = nrOfCities;
		distGraph = new DistanceGraph().getDistGraph(n);
		calc = new Calculator(distGraph);
		iniPhaseOne();
		iniPhaseTwo();
		printResults();
	}

	private void iniPhaseOne() {
		// Random Method
		RandomMethod randomMethod = new RandomMethod();
		rm = randomMethod.generateRandomRoute(n);
		drm = calc.getRouteDistance(rm);

		// Iterative Random Method
		IterativeRandomMethod iterativeRandomMethod = new IterativeRandomMethod(calc);
		irm = iterativeRandomMethod.generateIterativeRandomRoute(n, s); // byer, iterasjoner
		dirm = iterativeRandomMethod.getIRMDistance();

		// Greedy Method (GM)
		GreedyMethod greedyMethod = new GreedyMethod(calc);
		gm = greedyMethod.generateGreedyRoute(n);
		dgm = calc.getRouteDistance(gm);
	}

	private void iniPhaseTwo() {
		// Greedy Improvement (GI)
		GreedyImprovement greedyImprovement = new GreedyImprovement(calc);

		// GI on Random Method
		girm = greedyImprovement.getGreedyImprovedRoute(rm, stop);
		dgirm = calc.getRouteDistance(girm);

		// GI on Iterative Random Method
		giirm = greedyImprovement.getGreedyImprovedRoute(irm, stop);
		dgiirm = calc.getRouteDistance(giirm);

		// GI on Greedy Method
		gigm = greedyImprovement.getGreedyImprovedRoute(gm, stop);
		dgigm = calc.getRouteDistance(gigm);

		// Greedy Random (GR)
		GreedyRandom iGreedyRandom = new GreedyRandom(calc);

		// iGR on Random Method
		igrrm = iGreedyRandom.getIGreedyRandomRoute(rm, tries, a);
		digrrm = calc.getRouteDistance(igrrm);

		// iGR on Iterative Random Method
		igrirm = iGreedyRandom.getIGreedyRandomRoute(irm, tries, a);
		digrirm = calc.getRouteDistance(igrirm);

		// iGR on Greedy Method
		igrgm = iGreedyRandom.getIGreedyRandomRoute(gm, tries, a);
		digrgm = calc.getRouteDistance(igrgm);
	}

	public void printSampleGraph(int c) {

		String matrix = "";
		for (int z = 0; z < c; z++) {
			for (int y = 0; y < c; y++)
				matrix += distGraph[z][y] + " ";
			matrix += "\n";
		}
		System.out.println("Matrix with " + c + " cities: \n");
		System.out.println(matrix);
		System.out.println();
	}

	private void printResults() {
		System.out.println();
		System.out.println("### " + n + " cities: ###");
		System.out.println("-----------------------------------------");

		System.out.println("Random Method: " + drm);
		System.out.println("GI: " + dgirm);
		System.out.println("GR: " + digrrm);

		System.out.println();

		System.out.println("Iterative Random Method: " + dirm);
		System.out.println("GI: " + dgiirm);
		System.out.println("GR: " + digrirm);

		System.out.println();

		System.out.println("Greedy Method: " + dgm);
		System.out.println("GI: " + dgigm);
		System.out.println("GR: " + digrgm);

		System.out.println();

	}

}
