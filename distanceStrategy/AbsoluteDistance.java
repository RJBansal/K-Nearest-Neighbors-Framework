
package distanceStrategy;
import java.util.ArrayList;
/**
 * Author: Rajat Bansal
 * This class is responsible for calculating the distance between features using the
 * absolute distance formula 
 * */
public class AbsoluteDistance implements Distance {
	@Override
	/**
	 * Calculates the distance between to points using the absolute distance formula
	 * @param tuple ArrayList of type double that holds the tuples being calculated
	 * @return distance between all tuples being passed in
	 * **/
	public double calculateDistance(ArrayList<Double> tuple) {
		double sum = 0;
		int count = 0;
		for (double d : tuple) {
			sum = Math.abs(sum - d);
			count = count + 1;
		}
		return sum / count;
	}
	/**
	 * toString method to display the type of calculation
	 * @return title of class
	 * */
	@Override
	public String toString() {
		return "Absolute Distance";
	}
}
