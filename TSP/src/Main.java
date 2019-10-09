
/**
 * @author tinarambo
 * 
 *         Traveling Salesman Problem
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
		c50.testIRMStopCriteria(50);
		c50.testIRMStopCriteria(500);
		c50.testIRMStopCriteria(5000);
		c50.testIRMStopCriteria(50000);
		c50.testIRMStopCriteria(500000);
		c50.testIRMStopCriteria(5000000);
		System.out.println();
		System.out.println();
		System.out.println();

		Tester c100 = new Tester(100);
		c100.runTests(100);
		c100.testIRMStopCriteria(50);
		c100.testIRMStopCriteria(500);
		c100.testIRMStopCriteria(5000);
		c100.testIRMStopCriteria(50000);
		c100.testIRMStopCriteria(500000);
		c100.testIRMStopCriteria(5000000);
		System.out.println();
		System.out.println();
		System.out.println();

		Tester c250 = new Tester(250);
		c250.runTests(100);
		c250.testIRMStopCriteria(50);
		c250.testIRMStopCriteria(500);
		c250.testIRMStopCriteria(5000);
		c250.testIRMStopCriteria(50000);
		c250.testIRMStopCriteria(500000);
		c250.testIRMStopCriteria(5000000);
		System.out.println();
		System.out.println();
		System.out.println("-------------------------------------------");

		Tester c500 = new Tester(500);
		c500.runTests(100);
		c500.testIRMStopCriteria(50);
		c500.testIRMStopCriteria(500);
		c500.testIRMStopCriteria(5000);
		c500.testIRMStopCriteria(50000);
		c500.testIRMStopCriteria(500000);
		c500.testIRMStopCriteria(5000000);
		System.out.println();
		System.out.println();
		System.out.println();

		// ########################################
		t.stopTimer();
		System.out.println("\n\n - END - ");
		System.out.println("Execution time: " + t.getElapsedMs() + " ms " + " ( " + t.getFormattedTimeTot() + " )");
	}

}
