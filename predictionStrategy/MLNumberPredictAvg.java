package predictionStrategy;
import java.util.ArrayList;

import knnModel.Feature;
import knnModel.MLNumber;

public class MLNumberPredictAvg implements predictStrategy {

	@Override
	public Feature predictFeature(ArrayList<Feature> feature, double[] w) {
		double sum = 0;
		int count = 0;
		for (Feature m : feature) {
			sum += w[count] * ((MLNumber) m).getFeatureValue();
			count++;
		}
		return new MLNumber("", sum / count);
	}

}
