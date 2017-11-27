package knnModel;
import java.util.ArrayList;
import java.util.List;

import distanceStrategy.Distance;
import predictionStrategy.predictStrategy;


/**
 * @author Rajat Bansal
 * Creates an empty MLTuple with a unique primary key.
 * 
 * @param uID
 *            The Unique key to identify the tuple
 */
public class MLPredictTuple extends TupleConcrete implements Distance {

	
	predictStrategy strat;
	public MLPredictTuple(int uID) {
		super(uID);
	}

	/**
	 * Returns the string representation of the Tuple.
	 * 
	 * @return String The string representation of the tuple
	 */
	@Override
	public String toString() {
		String temp = this.pKey + ": ";
		for (Feature atrr : this.features) {
			temp += atrr.toString() + " | ";
		}
		return temp;
	}

	public void setDistanceStrategy(Distance strategy) {
		this.distanceCalcultor = strategy;
	}

	public void setPredictStrategy(predictStrategy strategy) {
		this.strat = strategy;
	}

	public List<Feature> getAttributes() {
		return this.features;
	}

	@Override
	public double calculateDistance(ArrayList<Double> tuple) {
		return distanceCalcultor.calculateDistance(tuple);
	}

	public Feature predict(ArrayList<Feature> neighbors, double[] weights) {
		return strat.predictFeature(neighbors, weights);

	}

	/*
	 * Remove for both this and MLList does not work
	 */
	public static void main(String[] args) {
		// MLTuple tp = new MLTuple(1);
		// MLCoord cord = new MLCoord(2);
		// cord.setVal(0,2);
		// cord.setVal(1,3);
		// tp.addAttributes(cord);
		// MLNumber num = new MLNumber(17);
		// tp.addAttributes(num);
		// System.out.println(tp.getAttribute(0).getClass().getName());
		// System.out.println(tp.getPKey());
		// System.out.println(tp.toString());
		// tp.remAttributes(num);
		// //System.out.println(tp.toString());
	}

}
