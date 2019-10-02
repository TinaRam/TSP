/**
 * @author tinarambo
 * 
 */
package tsp;

import java.util.Arrays;

public class Test {

	private int[][] distGraph;
	private Calculator calc;
	private int n = 0, drm, dirm, dgm;
	private int[] rm, irm, gm;

	// EDIT STOP CRITERIONS
	private int s = 5; // stop criteria - Iterative Random Method
	private int stop = 100; // stop criteria - Greedy Improvement
	private double a = 0.99; // acceptance probability - Greedy Random
	private int tries = 100; // max tries Greedy Random - Greedy Random

	public Test() {
		// Initiate the distance graph. (holds distances 500 cities)
		distGraph = DistanceGraph.getInstance().getDistGraph();
		// Initiate the calculator for calculation of distances
		calc = new Calculator(distGraph);
	}

	public void runTest(int nrOfCities) {
		n = nrOfCities;
		iniPhaseOne();
		iniPhaseTwo();
	}

	private void iniPhaseOne() {
		// Random Method
		RandomMethod randomMethod = new RandomMethod();
		rm = randomMethod.generateRandomRoute(n);
		drm = calc.getRouteDistance(rm);
//		System.out.println(n + " Random Method: " + Arrays.toString(rm));
		System.out.println(n + " Random Method: " + drm);

		// Iterative Random Method
		IterativeRandomMethod iterativeRandomMethod = new IterativeRandomMethod(calc);
		irm = iterativeRandomMethod.generateIterativeRandomRoute(n, s); // byer, iterasjoner
		dirm = iterativeRandomMethod.getIRMDistance();
//		System.out.println(n + " Iterative Random Method: " + Arrays.toString(irm));
		System.out.println(n + " Iterative Random Method: " + dirm);

		// Greedy Method (GM)
		GreedyMethod greedyMethod = new GreedyMethod(calc);
		gm = greedyMethod.generateGreedyRoute(n);
		dgm = calc.getRouteDistance(gm);
//		System.out.println(n + " Greedy Method: " + Arrays.toString(gm));
		System.out.println(n + " Greedy Method: " + dgm);

		System.out.println();
	}

	private void iniPhaseTwo() {
		// Greedy Improvement (GI)
		GreedyImprovement greedyImprovement = new GreedyImprovement(calc);

		// GI on Random Method
		int[] girm = greedyImprovement.getGreedyImprovedRoute(rm, stop);
		int dgirm = calc.getRouteDistance(girm);
//		System.out.println(n + " Greedy Improvement (Random Method): " + Arrays.toString(girm));
		System.out.println(n + " Greedy Improvement (Random Method): " + dgirm);

		// GI on Iterative Random Method
		int[] giirm = greedyImprovement.getGreedyImprovedRoute(irm, stop);
		int dgiirm = calc.getRouteDistance(giirm);
//		System.out.println(n + " Greedy Improvement (Iterative Random Method): " + Arrays.toString(giirm));
		System.out.println(n + " Greedy Improvement (Iterative Random Method): " + dgiirm);

		// GI on Greedy Method
		int[] gigm = greedyImprovement.getGreedyImprovedRoute(gm, stop);
		int dgigm = calc.getRouteDistance(gigm);
//		System.out.println(n + " Greedy Improvement (Greedy Method): " + Arrays.toString(gigm));
		System.out.println(n + " Greedy Improvement (Greedy Method): " + dgigm);

		System.out.println();

		// Greedy Random (GR)
		GreedyRandom iGreedyRandom = new GreedyRandom(calc);

		// iGR on Random Method
		int[] igrrm = iGreedyRandom.getIGreedyRandomRoute(rm, tries, a);
		int digrrm = calc.getRouteDistance(igrrm);
//		System.out.println(n + " Greedy Random (Random Method): " + Arrays.toString(igrrm));
		System.out.println(n + " Greedy Random (Random Method): " + digrrm);

		// iGR on Iterative Random Method
		int[] igrirm = iGreedyRandom.getIGreedyRandomRoute(irm, tries, a);
		int digrirm = calc.getRouteDistance(igrirm);
//		System.out.println(n + " Greedy Random (Iterative Random Method): " + Arrays.toString(igrirm));
		System.out.println(n + " Greedy Random (Iterative Random Method): " + digrirm);

		// iGR on Greedy Method
		int[] igrgm = iGreedyRandom.getIGreedyRandomRoute(gm, tries, a);
		int digrgm = calc.getRouteDistance(igrgm);
//		System.out.println(n + " Greedy Random (Greedy Method): " + Arrays.toString(igrgm));
		System.out.println(n + " Greedy Random (Greedy Method): " + digrgm);

		System.out.println();
		System.out.println();
		System.out.println();

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

}
