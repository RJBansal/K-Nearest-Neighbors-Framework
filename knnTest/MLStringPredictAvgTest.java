package knnTest;
/**
 * @author Brij Patel
 *Tests the predict strategy for strings
 * */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import knnModel.*;
import predictionStrategy.MLStringPredictAvg;

public class MLStringPredictAvgTest {
	ArrayList<Feature> list;
	MLString str1;
	MLString str2;
	MLString str3;
	MLString str4;
	double[] w;
	MLStringPredictAvg pre;
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<Feature>();
		str1 = new MLString("","str1");
		str2 = new MLString("","str1");
		str3 = new MLString("","str1");
		str4 = new MLString("","str2");
		MLConstant table = new MLConstant("");
		table.add(str1);
		table.add(str2);
		table.add(str3);
		table.add(str4);
		str1.setConstantTable(table);
		str2.setConstantTable(table);
		w = new double[] {1,1};
		list.add(str1);
		list.add(str2);
		pre = new MLStringPredictAvg();
	}
/**
 * Tests to see if predict actually works
 * */
	@Test
	public void testPredict() {
		assertTrue(((MLString)pre.predictFeature(list, w)).getFeaturevalue() == str1.getFeaturevalue());
	}

}
