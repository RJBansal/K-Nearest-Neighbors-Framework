package knnTest;
import java.util.*;

import distanceStrategy.EculidianDistance;
import junit.framework.TestCase;
/**
 * @author Brij Patel
 * This class tests the Eculidian distance formula used to calculate predictions
 * */
public class EculidianDistanceTest extends TestCase {
	EculidianDistance dist;
	ArrayList<Double> testNum;
/**
 * Sets up the variables needed for the tests
 * */
	@Override
	public void setUp() {
		testNum = new ArrayList<>(Arrays.asList(2.0, 3.0, 4.0));
		dist = new EculidianDistance();
	}
/**
 * calculates the distance between the numbers above and asserts that it is 5
 * */
	public void testCalculateDistance() {
		double sum = dist.calculateDistance(testNum);
		assertTrue(Math.round(sum) == 5);
	}

}
