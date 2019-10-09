
/**
 * @author tinarambo
 * 
 */

import tsp.*;
import java.util.ArrayList;

public class Tester {

	// EDIT STOP CRITERIONS
	private int s = 5; // stop criteria - Iterative Random Method
	private int stop = 1000; // stop criteria - Greedy Improvement
	private double a = 0.9; // acceptance probability - Greedy Random
	private int tries = 1000; // max tries Greedy Random - Greedy Random

	private int cities, runs;
	private int[][] distGraph;
	private Calculator calc;

	// Methods
	private RandomMethod randomMethod;
	private IterativeRandomMethod iterativeRandomMethod;
	private GreedyMethod greedyMethod;
	private GreedyImprovement greedyImprovement;
	private GreedyRandom iGreedyRandom;

	// Storage
	private ArrayList<Integer> iRM = new ArrayList<Integer>();
	private ArrayList<Integer> iIRM = new ArrayList<Integer>();
	private ArrayList<Integer> iGM = new ArrayList<Integer>();

	private ArrayList<Integer> oGIRM = new ArrayList<Integer>();
	private ArrayList<Integer> oGIIRM = new ArrayList<Integer>();
	private ArrayList<Integer> oGIGM = new ArrayList<Integer>();

	private ArrayList<Integer> oGRRM = new ArrayList<Integer>();
	private ArrayList<Integer> oGRIRM = new ArrayList<Integer>();
	private ArrayList<Integer> oGRGM = new ArrayList<Integer>();

	public Tester(int nrOfCities) {
		this.cities = nrOfCities;
		distGraph = new DistanceGraph(cities).getDistGraph();
		calc = new Calculator(distGraph);
	}

	public void testIRMStopCriteria(int stop) {
		this.s = stop;
		iterativeRandomMethod = new IterativeRandomMethod(calc);
		int nrOfRuns = runs;
		TimeTracker t = new TimeTracker();
		t.startTimer();
		while (nrOfRuns > 0) {
			int[] irm = iterativeRandomMethod.generateIterativeRandomRoute(cities, s);
			iIRM.add(calc.getRouteDistance(irm));
			nrOfRuns--;
		}
		System.out.println("s: " + s);
		System.out.println("IRM--> Best: " + calc.bestRoute(iIRM) + " Avg: " + calc.getAverage(iIRM));
		t.stopTimer();
		System.out.println("Execution time: " + t.getElapsedMs() + " ms " + " ( " + t.getFormattedTimeTot() + " )");
		iIRM.clear();
	}

	public void runTests(int nrOfRuns, int itRanStop, int greedyImproStop, int triesGR, double acceptProb) {
		this.runs = nrOfRuns;
		this.s = itRanStop;
		this.stop = greedyImproStop;
		this.tries = triesGR;
		this.a = acceptProb;
		System.out.println("Iterative Random Stop: " + s);
		System.out.println("Greedy Impro Stop: " + stop);
		System.out.println("Greedy Random tries: " + tries);
		System.out.println("acceptance: " + a);
		initiateMethods();

		while (nrOfRuns > 0) {
			runAlgorithms();
			nrOfRuns--;
		}

		printResults();

		// empty array's
		iRM.clear();
		iIRM.clear();
		iGM.clear();
		oGIRM.clear();
		oGIIRM.clear();
		oGIGM.clear();
		oGRRM.clear();
		oGRIRM.clear();
		oGRGM.clear();
	}

	public void runTests(int nrOfRuns) {
		this.runs = nrOfRuns;
		System.out.println("Iterative Random Stop: " + s);
		System.out.println("Greedy Impro Stop: " + stop);
		System.out.println("Greedy Random tries: " + tries);
		System.out.println("acceptance: " + a);
		initiateMethods();

		while (nrOfRuns > 0) {
			runAlgorithms();
			nrOfRuns--;
		}

		printResults();

		// empty array's
		iRM.clear();
		iIRM.clear();
		iGM.clear();
		oGIRM.clear();
		oGIIRM.clear();
		oGIGM.clear();
		oGRRM.clear();
		oGRIRM.clear();
		oGRGM.clear();
	}

	private void printResults() {
		System.out.println();

		System.out.println("TEST " + cities + " cities and " + runs + " runs:\n");

		System.out.println("RM --> Best: " + calc.bestRoute(iRM) + " Avg: " + calc.getAverage(iRM));
		System.out.println("GI --> Best: " + calc.bestRoute(oGIRM) + " Avg: " + calc.getAverage(oGIRM));
		System.out.println("GR --> Best: " + calc.bestRoute(oGRRM) + " Avg: " + calc.getAverage(oGRRM));
		System.out.println();

		System.out.println("IRM--> Best: " + calc.bestRoute(iIRM) + " Avg: " + calc.getAverage(iIRM));
		System.out.println("GI --> Best: " + calc.bestRoute(oGIIRM) + " Avg: " + calc.getAverage(oGIIRM));
		System.out.println("GR --> Best: " + calc.bestRoute(oGRIRM) + " Avg: " + calc.getAverage(oGRIRM));
		System.out.println();

		System.out.println("GM --> Best: " + calc.bestRoute(iGM) + " Avg: " + calc.getAverage(iGM));
		System.out.println("GI --> Best: " + calc.bestRoute(oGIGM) + " Avg: " + calc.getAverage(oGIGM));
		System.out.println("GR --> Best: " + calc.bestRoute(oGRGM) + " Avg: " + calc.getAverage(oGRGM));

		System.out.println();
		System.out.println("- - - - - - - - - - - - - - - - - - - -");
	}

	private void initiateMethods() {
		randomMethod = new RandomMethod();
		iterativeRandomMethod = new IterativeRandomMethod(calc);
		greedyMethod = new GreedyMethod(calc);
		greedyImprovement = new GreedyImprovement(calc);
		iGreedyRandom = new GreedyRandom(calc);
	}

	private void runAlgorithms() {
		// initial
		int[] rm = randomMethod.generateRandomRoute(cities);
		iRM.add(calc.getRouteDistance(rm));
		int[] irm = iterativeRandomMethod.generateIterativeRandomRoute(cities, s);
		iIRM.add(calc.getRouteDistance(irm));
		int[] gm = greedyMethod.generateGreedyRoute(cities);
		iGM.add(calc.getRouteDistance(gm));

		// optimized
		int[] girm = greedyImprovement.getGreedyImprovedRoute(rm, stop);
		oGIRM.add(calc.getRouteDistance(girm));
		int[] giirm = greedyImprovement.getGreedyImprovedRoute(irm, stop);
		oGIIRM.add(calc.getRouteDistance(giirm));
		int[] gigm = greedyImprovement.getGreedyImprovedRoute(gm, stop);
		oGIGM.add(calc.getRouteDistance(gigm));

		int[] grrm = iGreedyRandom.getIGreedyRandomRoute(rm, tries, a);
		oGRRM.add(calc.getRouteDistance(grrm));
		int[] grirm = iGreedyRandom.getIGreedyRandomRoute(irm, tries, a);
		oGRIRM.add(calc.getRouteDistance(grirm));
		int[] grgm = iGreedyRandom.getIGreedyRandomRoute(gm, tries, a);
		oGRGM.add(calc.getRouteDistance(grgm));

		// TESTING ONLY
//		printSampleGraph(cities);
//		System.out.println("Random: " + Arrays.toString(rm) + " --> " + calc.getRouteDistance(rm));
//		System.out.println("GI: " + Arrays.toString(girm) + " --> " + calc.getRouteDistance(girm));
//		System.out.println("GR: " + Arrays.toString(grrm) + " --> " + calc.getRouteDistance(grrm));
//
//		System.out.println();
//
//		System.out.println("Iterative Random: " + Arrays.toString(irm) + " --> " + calc.getRouteDistance(irm));
//		System.out.println("GI: " + Arrays.toString(giirm) + " --> " + calc.getRouteDistance(giirm));
//		System.out.println("GR: " + Arrays.toString(grirm) + " --> " + calc.getRouteDistance(grirm));
//
//		System.out.println();
//
//		System.out.println("Greedy: " + Arrays.toString(gm) + " --> " + calc.getRouteDistance(gm));
//		System.out.println("GI: " + Arrays.toString(gigm) + " --> " + calc.getRouteDistance(gigm));
//		System.out.println("GR: " + Arrays.toString(grgm) + " --> " + calc.getRouteDistance(grgm));
//
//		System.out.println();
//		System.out.println();
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
