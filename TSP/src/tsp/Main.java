package tsp;

import javax.swing.JFrame;
/**
 * @author tinarambo
 * 
 *         Travelling Salesman Problem
 * 
 *         Program creates a graph with distances chosen randomly between 1-10.
 *         Then generates an initial solution using the Random Method and
 *         calculates the routes total distance, incl. return to start position.
 */
import gui.Table;

public class Main {

	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("TSP Results");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		Table newContentPane = new Table();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

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

		test.runTest(5);
//		test.runTest(7);
//		test.runTest(50);
//		test.runTest(100);
//		test.runTest(250);
//		test.runTest(500);
//		test.runTest(1000);
//		test.runTest(2000);
//		test.runTest(3000);
//		test.runTest(5000);

		//
		t.stopTimer();
		System.out.println("\n\n - END - ");
		System.out.println("Execution time: " + t.getElapsedMs() + " ms");
//		System.out.println("Execution time: " + t.getFormattedTimeTot()); // Display elapsed time in hh:mm:ss:ms

		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				createAndShowGUI();
			}
		});
	}

}
