package knnModel;

/**
 * @author Brij Patel 101008373
 * @version 1.0b 
 * Base string metric
 *
 **/

public class MLString extends StringAbstract implements Feature {

	private String value;
	private double indexvalue;
	private MLConstant table;
	private boolean nullValue;

	public MLString(String name, String str) {
		super(name);
		this.value = str;
	}
	
	public MLString(String name) {
		super(name);
		nullValue = true;
	}

	/**
	 * Gets the current value of the string
	 * @return value of current string
	 */
	public String getFeatureName() {
		return this.value;
	}
	
	@Override
	public void setDefault(boolean d) {
		nullValue = d;
	}
	@Override
	public boolean getDefault() {
		return nullValue;
	}
	
	/**
	 * Adds the index value of certain feature to this one
	 **/
	@Override
	public void plus(Feature input) {
		MLString temp = (MLString) input;
		indexvalue = (temp.getFeaturevalue() + this.getFeaturevalue()) / 2;
	}
	/**
	 * Sets the value of the string Metric
	 * @param str string value to be set to
	 **/
	public void setString(String str) {
		this.value = str;
	}
	/**
	 * Returns a string value of current string
	 * @return value of current string
	 **/
	@Override
	public String toString() {
		if(nullValue) {
			return "null";
		}
		return featurename + ": [" + this.value + "] ";
	}

	public void setConstantTable(MLConstant t) {
		this.table = t;
	}
	
	public MLConstant getTable() {
		return this.table;
	}

	public double getFeaturevalue() {
		return indexvalue;
	}

	@Override
	public void divideBy(double m) {
		indexvalue /= m;
	}
	
	
	/**
	 * Retrieves the index of a particular attribute
	 * @param String of attributes
	 * @return The index of a particular attribute
	 */
	public double getIndex() {
		for (int i = 0; i < table.getSize(); i++) {
			if ((table.getFeatureValue().get(i)).equals(this)) {
				return i / (double) table.getSize(); // to normalize
			}
		}
		return -1;
	}

	/**
	 * Checks to see if two objects are equal to each other
	 * @param o Object that is being equated too
	 * @return boolean true if equal and false if not
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof MLString)) {
			return false;
		}
		if (((MLString) o).getFeatureName().equals(this.getFeatureName())) {
			return true;
		}
		return false;
	}

	@Override
	public double delDistance(Feature input) {
		if(!((MLString)input).getDefault()){
			MLString target = (MLString) input;
			return this.getFeaturevalue() - target.getFeaturevalue();
		}
		return 1;
	}

	@Override
	public double getError(Feature exact) {
		double x = (((MLString) exact).getFeaturevalue() - this.getFeaturevalue()); 
		return Math.abs(x / ((MLString) exact).getFeaturevalue());
	}
	
	@Override
	public Feature clone() {
		if(nullValue) {
			MLString temp = new MLString(featurename);
			temp.setConstantTable(table);
			return temp;
		}
		MLString temp = new MLString(featurename,value);
		temp.setConstantTable(table);
		return temp;
	}

}
