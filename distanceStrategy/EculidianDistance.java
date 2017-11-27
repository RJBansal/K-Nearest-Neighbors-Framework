package distanceStrategy;
import java.util.ArrayList;

public class EculidianDistance implements Distance {

	/**
	 * finds the euclidian average from a given ArrayList
	 * 
	 * @param distances
	 *            list of values
	 * @return the average euclidian of the values
	 */
	@Override
	public double calculateDistance(ArrayList<Double> tuple) {
		double sum = 0;
		for (double d : tuple) {
			sum = sum + Math.pow(d, 2);
		}
		return Math.sqrt(sum);
	}
	
	/**
	 * Returns name of calculation being performed
	 * @return string name of calculation
	 * */
	@Override
	public String toString() {
		return "Eculidian Distance";
	}

}
