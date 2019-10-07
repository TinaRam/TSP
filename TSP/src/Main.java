
/**
 * @author tinarambo
 * 
 *         Travelling Salesman Problem
 * 
 *         " Given a list of cities and the distance between each city. What is
 *         the shortest possible route visiting each city once and then
 *         returning to the origin city? "
 */

public class Main {

	public static void main(String[] args) {
		// Measure elapsed time
		TimeTracker t = new TimeTracker();
		t.startTimer();
		// ########################################

		Tester c50 = new Tester(50);
		c50.runTests(100);
//		c50.runTests(nrOfRuns, itRanStop, greedyImproStop, triesGR, acceptProb);
		c50.runTests(100, 500, 1000, 1000, 0.90);

		Tester c100 = new Tester(100);
		c100.runTests(100);
		c100.runTests(100, 500, 1000, 1000, 0.90);

		Tester c250 = new Tester(250);
		c250.runTests(100);
		c250.runTests(100, 500, 1000, 1000, 0.90);

		Tester c500 = new Tester(500);
		c500.runTests(100);
		c500.runTests(100, 500, 1000, 1000, 0.90);

		// ########################################
		t.stopTimer();
		System.out.println("\n\n - END - ");
		System.out.println("Execution time: " + t.getElapsedMs() + " ms " + " ( " + t.getFormattedTimeTot() + " )");
	}

}
