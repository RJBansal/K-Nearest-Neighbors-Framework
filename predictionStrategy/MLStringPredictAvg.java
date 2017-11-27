package predictionStrategy;
import java.util.ArrayList;

import knnModel.Feature;
import knnModel.MLString;

public class MLStringPredictAvg implements predictStrategy {

	@Override
	public Feature predictFeature(ArrayList<Feature> feature, double[] w) {
		double sum = 0;
		int count = 0;
		for (Feature m : feature) {
			sum += w[count] * ((MLString) m).getFeaturevalue();
			count++;
		}
		return new MLString("",
				(((MLString) (feature.get(0))).getTable()).getString((int) Math.round(sum / count)).toString());
	}

}
