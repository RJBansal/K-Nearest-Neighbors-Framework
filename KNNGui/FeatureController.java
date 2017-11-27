package KNNGui;

import java.awt.event.ActionListener;

import knnModel.Feature;

/**
 * Author: Shounak Amladi
 * This interface extends the action listener class for all the controllers
 * */
public interface FeatureController extends ActionListener {
	
	public Feature getFeature();
	
}
