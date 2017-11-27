package knnTest;
import static org.junit.Assert.*;

import knnModel.MLNumber;
/**
 * @author Brij Patel
 * Tests the number feature 
 * */
public class MLNumberTest {
	private MLNumber num1;
	private MLNumber num2;

	public void setUp() {
		num1 = new MLNumber("num1", 300);
		num2 = new MLNumber("num2", 3);
	}
/**
 * Tests to see if a feature value is returned
 * */
	public void testFeatureValue() {
		assertTrue(num1.getFeatureValue() == 300);
	}
/**
 * Tests to see if two number features can be added properly
 * */
	public void testAdd() {
		MLNumber temp = num1;
		temp.plus(num2);
		assertTrue(temp.getFeatureValue() == 303);
	}
/**
 *  Tests to see if two number features can be divided properly
 * */
	public void testDivideBy() {
		MLNumber temp = num1;
		temp.divideBy(num2.getFeatureValue());
		assertTrue(temp.getFeatureValue() == 100);
	}
/**
 * Test the equals function
 * */
	public void testEquals() {
		assertFalse(num1.equals(num2));
	}
/**
 * Tests to see if a number can calculate the distance between two numbers
 * */
	public void testDelDistance() {
		int distance = (int) num1.delDistance(num2);
		assertTrue(distance == 297);
	}
}
