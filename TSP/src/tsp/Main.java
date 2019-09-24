package tsp;

public class Main {

	public static void main(String[] args) {

		System.out.println("\n5 cities:");
		int[][] five = DistanceGraph.createGraph(5);
		DistanceGraph.printGraph(five);

		System.out.println(five[2][4]);

//		System.out.println("\n50 cities:");
//		int[][] fifty = Graph.createGraph(50);
//		Graph.printGraph(fifty);

//		System.out.println("\n100 cities:");
		int[][] onehundred = DistanceGraph.createGraph(100);
//		Graph.printGraph(onehundred);

//		System.out.println("\n 250 cities:");
		int[][] twofifty = DistanceGraph.createGraph(250);
//		Graph.printGraph(twofifty);

//		System.out.println("\n 500 cities:");
		int[][] fivehundred = DistanceGraph.createGraph(500);
//		Graph.printGraph(fivehundred);

		System.out.println("Done!");
	}

}
