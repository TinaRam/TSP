package tsp;

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

		Test test = new Test();
//		TestMultiplier multi = new TestMultiplier();

		// Print a sample of the graph for reference
//		test.printSampleGraph(5);
//		test.runTest(5);

		// Measure elapsed time
		TimeTracker t = new TimeTracker();
		t.startTimer();
//
//		multi.runTests(50, 1000);
//		multi.runTests(100, 1000);
//		multi.runTests(250, 1000);
//		multi.runTests(500, 1000);

		test.runTest(50);
		test.runTest(100);
		test.runTest(250);
		test.runTest(500);
//		test.runTest(1000);
//		test.runTest(2000);
//		test.runTest(3000);
//		test.runTest(5000);

		//
		t.stopTimer();
		System.out.println("\n\n - END - ");
		System.out.println("Execution time: " + t.getElapsedMs() + " ms");
//		System.out.println("Execution time: " + t.getFormattedTimeTot()); // Display elapsed time in hh:mm:ss:ms
	}

}
