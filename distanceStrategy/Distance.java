package distanceStrategy;
import java.util.ArrayList;

/**
 * Interface to calculate all the different types of distances for all the
 * Features
 **/
public interface Distance {
	/**
	 * This method calculates the distance between given tuples
	 * @param tuple ArrayList of type double of the tuples being ussed
	 * @return distance double between tuples
	 * **/
	public double calculateDistance(ArrayList<Double> tuple);
	/**
	 * toString to know which type of calculation is being performed
	 * @return string name of calculation
	 * */
	
	@Override
	public String toString();
}
