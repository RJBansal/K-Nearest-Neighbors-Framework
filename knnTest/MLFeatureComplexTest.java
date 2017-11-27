package knnTest;
import knnModel.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the MLFeatureComplex class, where it can hold a list of Features like a list of strings or coordinates
 * */
public class MLFeatureComplexTest {
	MLFeatureComplex comp1;
	MLNumber num1;
	MLString str1;
	MLNumber num2;
	MLString str2;
	
	@Before
	public void setUp() throws Exception {
		comp1 = new MLFeatureComplex("comp1");
		str1 = new MLString("str1", "test1");
		num1 = new MLNumber("num1",2);
		str2 = new MLString("str2", "test2");
		num2 = new MLNumber("num2", 400);
		comp1.addFeature(str1);
		comp1.addFeature(num1);
		comp1.addFeature(str2);
		comp1.addFeature(num2);
		
		
	}
/**
 * Ensures that Features are getting added to the list
 * */
	@Test
	public void testSize() {
		assertTrue(comp1.getSize() == 4);
	}
/**
 * Ensures that you can divide any feature in the list
 * */
	@Test
	public void testDivideBy() {
		comp1.divideBy(2);
		assertTrue(((MLNumber)comp1.getFeature(3)).getFeatureValue() ==  200);
	}

}
