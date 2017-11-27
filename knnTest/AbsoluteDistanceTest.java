package knnTest;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import distanceStrategy.AbsoluteDistance;
import junit.framework.TestCase;
/***
 * @author Brij Patel
 *This class tests the absolute distance formula used to calculate predictions
 */
public class AbsoluteDistanceTest extends TestCase {
	AbsoluteDistance dist;
	ArrayList<Double> testNum;
/**
 * Sets up all variables needed to test
 * */
	@Override
	@Before
	public void setUp() {
		testNum = new ArrayList<>(Arrays.asList(5.0, 6.0, 7.0));
		dist = new AbsoluteDistance();
	}
/**
 * caluclates the distance between the numbers above and ensures that the average distance is 2
 * */
	public void testCalculateDistance() {
		double result = dist.calculateDistance(testNum);
		assertTrue(result == 2);
	}

}
