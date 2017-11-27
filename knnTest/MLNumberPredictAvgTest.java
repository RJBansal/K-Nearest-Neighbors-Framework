package knnTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import knnModel.*;
import predictionStrategy.MLNumberPredictAvg;

/**
 * @author Brij Patel
 * Test the prediction for numbers 
 * */
public class MLNumberPredictAvgTest {
	ArrayList<Feature> list;
	MLNumber n1;
	MLNumber n2;
	double[] w;
	MLNumberPredictAvg pre;
	@Before
	public void setUp() throws Exception {
		n1 = new MLNumber("",20);
		n2 = new MLNumber("",10);
		list = new ArrayList<Feature>();
		w = new double[] {1,1};
		pre = new MLNumberPredictAvg();
		list.add(n1);
		list.add(n2);
	}
/**
 * Checks to see if the value of prediction is right
 * */
	@Test
	public void testPredictFeature() {
		assertTrue(((MLNumber)pre.predictFeature(list, w)).getFeatureValue() == 15); 
	}
/**
 * Tests to see if the prediction can handle null values
 * */	
	@Test
	public void testHandleNullValues() {
		list.remove(n1);
		n1 = new MLNumber("");
		list.add(n1);
		assertTrue(((MLNumber)pre.predictFeature(list, w)).getFeatureValue() == 5); 
	}

}
