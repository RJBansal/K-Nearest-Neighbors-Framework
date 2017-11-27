package knnModel;

/**
 * This is the main interface clustering all types of attributes, known as
 * Metrics.
 * 
 * @author Shounak Amladi
 * @version 0.1b
 * @since 2017-10-28
 */

public interface Feature {
/**
 * provides toString for each feature
 * @return String representation of values the feature holds
 * */
	@Override
	public String toString();
	/**
	 * Checks to see if one feature is equal to another
	 * @param o Object to be compared with
	 * @return boolean if equal or not
	 * */
	@Override
	public boolean equals(Object o);
/**
 * gets the name of feature
 * @return String name of feature
 * */
	public String getName();
	/**
	 * calculates the distance between itself and another feature
	 * @param target Feature to calculate distance from
	 * @return dist Double distance apart
	 * */
	public double delDistance(Feature target);
/**
 * Adds current feature with another one
 * @param feature Feature to be added with
 * 
 * */
	public void plus(Feature feature);
/**
 * gets the error between itself and another given feature
 * @param exact Feature to be calcuated from
 * @return error Double error between current feature and given
 * */
	public double getError(Feature exact);
/**
 * divided the current feature by a number
 * @param m double number to be divided with
 * */
	public void divideBy(double m);
/**
 * makes a clone of the current feature
 * @return f Feature cloned feature
 * */
	public Feature clone();		

}
