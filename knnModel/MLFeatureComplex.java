package knnModel;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Rajat Bansal and Shounak Amladi and Brij Patel
 * This feature can hold a list of different features like Strings and Numbers.
 * */
public class MLFeatureComplex implements Feature {
	
	private List<Feature> mList;
	private String featurename;

	public MLFeatureComplex(String name) {
		this.featurename = name;
		mList = new ArrayList<Feature>();
	}

	/**
	 * Returns a feature name
	 * @return value of name
	 **/
	public String getName() {
		return this.featurename;
	}

	/**
	 * Adds given metric to list of Metrics
	 * @param Feature
	 * @return
	 */
	public void addFeature(Feature m) {
		mList.add(m);
	}

	@Override
	public void plus(Feature l) {
		for (int i = 0; i < this.getSize(); i++) {
			this.getFeature(i).plus(((MLFeatureComplex) l).getFeature(i));
		}
	}

	@Override
	public void divideBy(double m) {
		for (Feature m1 : mList) {
			m1.divideBy(m);
		}
	}

	/**
	 * Deletes given metric from list of Metrics
	 * @param Feature
	 * @return
	 */
	public void delete(Feature m) {
		if (mList != null) {
			mList.remove(m);
		}
	}

	/**
	 * Returns the size of the list
	 * @return size of list
	 **/
	public int getSize() {
		return mList.size();
	}

	/**
	 * returns this
	 * @return this
	 **/
	public List<Feature> getFeatureValue() {
		return this.mList;
	}
	
	
	/**
	 * Returns the Metric at a specified index of the list
	 * @param index of value you wish to get
	 * @return temp Metric at the specified index of the list
	 */
	public Feature getFeature(int index) {
		Feature temp = mList.get(index);
		return temp;
	}

	/**
	 * Checks to see if two MLLists are equal to each other
	 * @param Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Feature)) {
			return false;
		}
		for (int i = 0; i < this.getSize(); i++) {
			if (!(this.getFeature(i).equals(((MLFeatureComplex) o).getFeature(i)))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * toString method to print all Metrics inside the list 
	 * @return str String value of all Metrics inside list
	 */
	@Override
	public String toString() {
		String str = "<" + featurename + ": ";
		for (Feature m : mList) {
			str += " [" + m.toString() + "] ";
		}
		return str + "> ";
	}

	@Override
	public double delDistance(Feature input) {	
			MLFeatureComplex target = (MLFeatureComplex) input;
			double sum = 0;
			for (int i = 0; i < this.getSize(); i++) {
				sum += this.getFeature(i).delDistance(target.getFeature(i));
			}
			return sum / this.getSize();
	}

	@Override
	public double getError(Feature exact) {
		MLFeatureComplex temp = (MLFeatureComplex) exact;
		double sum = 0;
		for (int i = 0; i < this.mList.size(); i++) {
			sum = sum + this.mList.get(i).getError(temp.getFeature(i));
		}
		return sum;
	}
	
	@Override
	public Feature clone() {
		MLFeatureComplex temp = new MLFeatureComplex(featurename);
		for(Feature f: mList) {
			temp.addFeature(f.clone());			
		}
		return temp;
	}
	

	public static void main(String[] args) {
		// MLList list = new MLList();
		// MLCoord cord = new MLCoord(4);
		// list.add(cord);
		// System.out.println(list.toString());
		// MLNumber num = new MLNumber(200);
		// list.add(num);
		// System.out.println(list.toString());
		// list.delete(num);
		// System.out.println(list.toString());
		//// MLList list2 = new MLList();
		//// MLNumber num2 = new MLNumber(200);
		//// list2.add(num2);
		//// System.out.println(list.equals(list2));
	}

}
