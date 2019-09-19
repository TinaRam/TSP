package tsp;

public class Main {

	public static void main(String[] args) {

		System.out.println("\n50 cities:");
		int[][] fifty = Graph.createGraph(50);
		Graph.printGraph(fifty);

		System.out.println("\n100 cities:");
		int[][] onehundred = Graph.createGraph(100);
		Graph.printGraph(onehundred);

//		System.out.println("\n 250 cities:");
		int[][] twofifty = Graph.createGraph(250);
//		Graph.printGraph(twofifty);

//		System.out.println("\n 500 cities:");
		int[][] fivehundred = Graph.createGraph(500);
//		Graph.printGraph(fivehundred);

	}

}
