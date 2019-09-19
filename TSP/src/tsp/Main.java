package tsp;

public class Main {

	public static void main(String[] args) {

		System.out.println("50 cities: \n");
		int[][] fifty = Graph.createGraph(50);
		Graph.printGraph(fifty);

		System.out.println("100 cities: \n");
		int[][] onehundred = Graph.createGraph(100);
		Graph.printGraph(onehundred);

		System.out.println("250 cities: \n");
		int[][] twofifty = Graph.createGraph(250);
		Graph.printGraph(twofifty);

		System.out.println("500 cities: \n");
		int[][] fivehundred = Graph.createGraph(500);
		Graph.printGraph(fivehundred);

	}

}
