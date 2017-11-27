package knnModel;
import java.util.*;

import distanceStrategy.*;
import predictionStrategy.*;

/**
 * This stores a set of tuples to predict the specified attribute, from a data
 * set. PREDICT TUPLE ALWAYS HAS UID OF 0!
 * 
 * @author Rajat Bansal
 * @version 0.01b
 * @since 2017-10-30
 */
public class MLPredict {

	private MLRelation tupleModel;
	private static MLPredictTuple predictionTuple;
	private int k;
	private double[] rowWeights;
	private double[] userWeights;
	private boolean isUserWeight = false;

	/**
	 * Creates a relation, with k being the number of nearest neighbors
	 * 
	 * @param k the number of nearest neighbors
	 */
	public MLPredict(int k) {
		tupleModel = new MLRelation();
		predictionTuple = new MLPredictTuple(-1);
		this.k = k;
		
		
	}

	public void addRelation(MLRelation newModel) {
		tupleModel = newModel;
	}
	
	public void setUserWeights(double[] weights) {
		userWeights = weights;
		isUserWeight = true;
	}
	
	public void setPredictiontuple(MLPredictTuple tp) {
		this.predictionTuple = tp;
	}

	/**
	 * Calculates the distances from the target to all the training data, except for
	 * the attribute specified
	 * 
	 * @param target
	 *            is the target tuple
	 * @param attribute
	 *            the attribute to be predicted
	 * @return HashMap<Double, Integer> returns a list of distance associated with
	 *         the pkey of tuples.
	 */
	public HashMap<Double, Integer> calcDistances(TupleConcrete target, int attribute) {

		HashMap<Double, Integer> distances = new HashMap<Double, Integer>();
		ArrayList<Double> delDistance;

		for (MLTuple tp: tupleModel.getRelation()) {
			
			if (tp.getPKey() == target.getPKey())
				continue;
			delDistance = new ArrayList<Double>();

			for (int i = 0; i < tp.getLength(); i++) {

				if (i == attribute)
					continue;

				else {
					Feature target_attr = target.getAttribute(i);
					Feature training_attr = tp.getAttribute(i);
					
					if(isUserWeight) {
						delDistance.add(userWeights[i] * target_attr.delDistance(training_attr));
					}
					else {
					delDistance.add(target_attr.delDistance(training_attr));
					}
				}
			}
			distances.put(predictionTuple.calculateDistance(delDistance), tp.getPKey());
		}
		return distances;
	}

	/**
	 * Predicts the specified attribute based on the given training data.
	 * 
	 * @param k
	 *            the number of nearest neighbors to use
	 * @param target
	 *            the target tuple
	 * @param attribute
	 *            the attribute to be predicted
	 * @return Metric returns a the predicted value in the form of a Metric
	 */
	public Feature predict(int kN, TupleConcrete target, int attribute) {

		double sum = 0;
		int count = 0;
		
		normalize(attribute);
		tupleModel.createConstantTable();
		HashMap<Double, Integer> distances = calcDistances(target, attribute);
		Map<Double, Integer> distanceSorted = new TreeMap<Double, Integer>(distances);
		ArrayList<Feature> nearestTuples = new ArrayList<Feature>();
		ArrayList<Double> keys = new ArrayList<>(kN);
		for (Double key : distanceSorted.keySet().toArray(new Double[0])) {
			keys.add(key);
			sum += key;
		}

		for (Map.Entry<Double, Integer> entry : distanceSorted.entrySet()) {
			count++;
			nearestTuples.add(tupleModel.getTuple(entry.getValue()).getAttribute(attribute));

			if (count == kN)
				break;
		}
		rowWeights = new double[kN];
		Arrays.fill(rowWeights, 1);	
		tupleWeights(keys, sum, kN);
		Feature result = predictionTuple.predict(nearestTuples, rowWeights);
		//Arrays.fill(rowWeights, 1);
		return result;
	}
   
	public void tupleWeights(ArrayList<Double> k, double sum, int kN) {
		for (int i = 0; i < k.size(); i++) {
			if(i == kN) {
				break;
			}
			rowWeights[i] -= Math.abs((k.get(i) / sum));
		}
	}

	
	
	
	/**
	 * normalizes all MLNumber attributes in the tuple
	 * 
	 * @param relation
	 *            the list of tuples in the relation
	 * @param attribute
	 *            the attribute to be predicted
	 */
	public void normalize(int attribute) {
		for (int i = 0; i < tupleModel.getRelation().get(0).getLength(); i++) {
			if (i == attribute)
				continue;
			else if ((tupleModel.getRelation().get(0).getAttribute(i) instanceof MLNumber)) {
				normalizeColumn(tupleModel.getRelation(), i, max(tupleModel.getRelation(), i));
			}
		}
	}
	
	/**
	 * Makes every value of speicified attribute between 0 - 1
	 * 
	 * @param relation
	 *            the list of training data tuples
	 * @param index_attr
	 *            the index within a tuple of the attribute
	 * @param maxval
	 *            the largest value of that attribute within all the training_set
	 */
	public static void normalizeColumn( ArrayList<MLTuple> relation, int index_attr, double maxval) {
		for (MLTuple tp: relation) {
			((MLNumber) tp.getAttribute(index_attr)).divideBy(maxval);
		}
	}
	
	/**
	 * find the max value of the specified attribute from the list of tuple
	 * 
	 * @param relation
	 *            The list of training data tuples
	 * @param index_attr
	 *            The index within a tuple of the attribute
	 * @return the largest value from all tuples for attribute
	 */
	public static double max(ArrayList<MLTuple> relation, int index_attr) {
		ArrayList<Double> maxval = new ArrayList<Double>();
		for (MLTuple tp: relation) {
			if (tp.getAttribute(index_attr) instanceof MLNumber) {
				maxval.add(((MLNumber) tp.getAttribute(index_attr)).getFeatureValue());
			}
		}
		double max = Integer.MIN_VALUE;
		for (int i = 0; i < maxval.size(); i++) {
			if (maxval.get(i) > max) {
				max = maxval.get(i);
			}
		}
		return max;
	}

	public int errorCalculations(Feature result, MLTuple original, int attribute) {
		double error = result.getError(original.getAttribute(attribute));
		return (int) Math.round(error * 100);

	}
	
	
	
	
	public static void main(String[] args) {
		MLPredict predict = new MLPredict(3);
		MLRelation rel = new MLRelation();
		
		MLTuple t1 = new MLTuple(1);
			MLNumber n1 = new MLNumber("n1", 1000);
			MLFeatureComplex fc1 = new MLFeatureComplex("fc1");
			fc1.addFeature(new MLNumber("", 12));
			fc1.addFeature(new MLNumber("", 25));
			MLNumber n2 = new MLNumber("n2", 500000);
			MLString str1 = new MLString("str1", "new");

		t1.addAttributes(fc1);
		t1.addAttributes(n1);
		t1.addAttributes(str1);
		t1.addAttributes(n2);

		MLTuple t2 = new MLTuple(2);
			MLNumber n3 = new MLNumber("n3", 1200);
			MLFeatureComplex fc2 = new MLFeatureComplex("fc1");
			fc2.addFeature(new MLNumber("", 10));
			fc2.addFeature(new MLNumber("", 50));
			MLNumber n4 = new MLNumber("n4", 300000);
			MLString str2 = new MLString("str2", "old");

		t2.addAttributes(fc2);
		t2.addAttributes(n3);
		t2.addAttributes(str2);
		t2.addAttributes(n4);

		MLTuple t3 = new MLTuple(3);
			MLNumber n5 = new MLNumber("n5", 1500);
			MLFeatureComplex fc3 = new MLFeatureComplex("fc1");
			fc3.addFeature(new MLNumber("", 15));
			fc3.addFeature(new MLNumber("", 20));
			MLNumber n6 = new MLNumber("n6", 400000);
			MLString str3 = new MLString("str3", "new");

		t3.addAttributes(fc3);
		t3.addAttributes(n5);
		t3.addAttributes(str3);
		t3.addAttributes(n6);

		MLTuple t4 = new MLTuple(0);
			MLNumber n7 = new MLNumber("n7", 800);
			MLFeatureComplex fc4 = new MLFeatureComplex("fc1");
			fc4.addFeature(new MLNumber("", 20));
			fc4.addFeature(new MLNumber("", 15));
			MLNumber n8 = new MLNumber("", 600000);
			MLString str4 = new MLString("str4", "old");
		
		t4.addAttributes(fc4);     // CORD
		t4.addAttributes(n7);      // NUMBER SQ
		t4.addAttributes(str4);    // STRING
		t4.addAttributes(n8);      // NUMBER PRICE

		predictionTuple = new MLPredictTuple(0);
		Distance dist = new EculidianDistance();
		predictStrategy pre = new MLListPredictAvg();
		predictionTuple.setDistanceStrategy(dist);
		predictionTuple.setPredictStrategy(pre);
		//double user[] = {1,1,1,1};
		//rel.setUserWeights(user);

		MLRelation testing = new MLRelation();
		testing.addTuple(t4);
		rel.addTuple(t1); 
		rel.addTuple(t2);
		//rel.addTuple(t4);
		rel.addTuple(t3);
		
		rel = rel.clone();
		predict.addRelation(rel);
		Feature result = predict.predict(3, rel.getTuple(1), 0);
		System.out.println(result);
		
		ErrorCalculation error = new ErrorCalculation();
		System.out.println(error.errorCalculations(rel, testing, 0, 3, predictionTuple) + "%");
//		predict.addRelation(rel);
//		Feature result = predict.predict(2 , rel.getTuple(0), 2);
//		System.out.println(result);
//		
  
		predict.addRelation(rel);
		System.out.println(predict.predict(3, t4,0));
		//System.out.println(result);
//		
//		predict.addRelation(clone2);
//		result  = predict.predict(2, t4,0);
//		System.out.println(result);
		//System.out.println(predict.errorCalculations(result, t4,1) + "%");
		 // params is how many nearest neighbours you want, what tuple you want to
									// predict,
									// index of element you want to predict
	}

	
}
