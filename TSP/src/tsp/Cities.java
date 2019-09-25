/**
 * @author tinarambo
 * 
 */
package tsp;

public class Cities {

	int[] cityArray;
	int cityLimit, nrOfCities;

	public Cities(int[][] distGraph) {
		this.cityLimit = distGraph.length;
	}

	// Populate an int array
	private void populateArray() {
		cityArray = new int[nrOfCities];
		for (int i = 0; i < nrOfCities; i++) {
			cityArray[i] += i;
		}
	}

	public int[] getCityArray(int nrOfCities) {
		this.nrOfCities = nrOfCities;
		if (nrOfCities > cityLimit) {
			throw new IllegalArgumentException(
					"The number of cities can't exceed the number of distances in the DistanceGraph!");
		} else {
			populateArray();
		}
		return cityArray;
	}
}
