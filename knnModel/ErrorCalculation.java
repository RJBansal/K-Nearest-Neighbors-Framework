package knnModel;

import java.util.ArrayList;

import distanceStrategy.*;
import knnModel.MLPredict;
import knnModel.MLRelation;
import predictionStrategy.*;
/**@author Brij Patel
 * This class uses the training and testing data set to calculate what the average error is for the prediction
 * */
public class ErrorCalculation {
	public ErrorCalculation() {

	}
	/**
	 * calculates the average error on the prediction
	 * @param training MLRelation training set of data
	 * @param testing MLRelation testing set of data
	 * @param attribute int index of attribute to predict
	 * @param k int k nearest neighbours
	 * @param p MLPredictTuple 
	 * @return error int average error of the prediction
	 * */
	public int errorCalculations(MLRelation training, MLRelation testing ,int attribute, int k, MLPredictTuple p) {
		MLPredict pre = new MLPredict(k);
		pre.setPredictiontuple(p);
		ArrayList<Double> errors = new ArrayList<Double>();
		double sum = 0;
		int count = 0;
		pre.addRelation(training.clone());
		for(MLTuple t : testing.getRelation()) {
			
			Feature temp = pre.predict(k, t, attribute);
			double test = t.getAttribute(attribute).getError(temp);
			errors.add(test);
		}
		
		for(int i = 0; i < errors.size(); i++) {
			sum = sum + errors.get(i);
			count++;
		}
		return (int)Math.round(sum/count * 100);
		
	}
}
