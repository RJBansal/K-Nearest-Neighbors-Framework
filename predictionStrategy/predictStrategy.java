package predictionStrategy;
import java.util.ArrayList;

import knnModel.Feature;

public interface predictStrategy {

	public Feature predictFeature(ArrayList<Feature> feature, double[] weights);

}
