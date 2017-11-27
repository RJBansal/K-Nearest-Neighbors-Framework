package knnTest;
import knnModel.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * @author Brij Patel
 * Tests the MLConstant class, which is a look up table that holds strings
 * */
public class MLConstantTest {
	MLConstant con1;
	MLString str1;
	MLString str2;
	MLString str3;
	
	@Before
	public void setUp() throws Exception {
		con1 = new MLConstant("table");
		str1 = new MLString("str1", "string1");
		str2 = new MLString("str2", "string2");
		str3 = new MLString("str3", "string3");
		str1.setConstantTable(con1);
		str2.setConstantTable(con1);
		str3.setConstantTable(con1);
		con1.add(str1);
		con1.add(str2);
		con1.add(str3);
	}
/**
 * checks to see if look up table is working
 * */
	@Test
	public void testLookUp() {
		assertTrue(con1.getFeatureValue().get(0) == str1);
	}
/**
 * Testing the equals method
 * */
	@Test
	public void testEquals() {
		MLConstant c2 = new MLConstant("con2");
		MLString strTemp = new MLString("test", "Test");
		c2.add(strTemp);
		assertFalse(con1.equals(c2));
	}

}
