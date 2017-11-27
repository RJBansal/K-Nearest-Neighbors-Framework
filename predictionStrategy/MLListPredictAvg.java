package predictionStrategy;
import java.util.ArrayList;

import knnModel.Feature;
import knnModel.MLFeatureComplex;

public class MLListPredictAvg implements predictStrategy {

	@Override
	public Feature predictFeature(ArrayList<Feature> feature, double[] weights) {
		int count = 0;
		MLFeatureComplex temp = (MLFeatureComplex) (feature.get(0));
		temp.divideBy(1 / weights[0]);
		for (int i = 1; i < feature.size(); i++) {
			MLFeatureComplex temp2 = (MLFeatureComplex) feature.get(i);
			temp2.divideBy(1 / weights[i]);
			temp.plus(temp2);
			count++;
		}
		temp.divideBy(count);
		return temp;

	}

}
