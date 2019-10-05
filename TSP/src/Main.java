
/**
 * @author tinarambo
 * 
 *         Travelling Salesman Problem
 * 
 *         " Given a list of cities and the distance between each city. What is
 *         the shortest possible route visiting each city once and then
 *         returning to the origin city? "
 */
import tsp.*;

public class Main {

	public static void main(String[] args) {
		// Measure elapsed time
		TimeTracker t = new TimeTracker();
		t.startTimer();
		// ########################################

		Tester run = new Tester();
		run.runTests(100, 1000);

		// ########################################
		t.stopTimer();
		System.out.println("\n\n - END - ");
		System.out.println("Execution time: " + t.getElapsedMs() + " ms " + " ( " + t.getFormattedTimeTot() + " )");
	}

}
