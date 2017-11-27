package knnModel;


/**
 * @author: Pragya Singh 100974148 
 * Creates a Number
 */
public class MLNumber extends NumberAbstract implements Feature {
	private double number;
	private boolean nullValue;

	public MLNumber(String name, double num) {
		super(name);
		number = num;
	}
	
	public MLNumber(String name) {
		super(name);
		nullValue = true;
	}

	/**
	 * Get the number value
	 * @param
	 * @return Retrieves the number
	 */
	public double getFeatureValue() // Retrieve the number
	{
		return number;
	}
	
	@Override
	public void setDefault(boolean d) {
		nullValue = d;
	}
	
	@Override
	public boolean getDefault() {
		return nullValue;
	}
	
	public String getFeatureName() {
		return featurename;
	}

	/**
	 * Adds feature value to this
	 * @param input Feature to be added to this
	 **/
	@Override
	public void plus(Feature input) {
		MLNumber temp = (MLNumber) input;
		this.setNumber(temp.getFeatureValue() + this.getFeatureValue());
	}

	/**
	 * Sets the new number
	 * @param Has the new number that you want to set the number of type double to
	 * @return
	 */
	public void setNumber(double value) { // Set the number
		number = value;
	}

	/**
	 * Divides the original number by a constant
	 * @param you have to input the number you want to divide by
	 * @return
	 */
	@Override
	public void divideBy(double numbertwo) {
		number = number / numbertwo;
	}


	/**
	 * Compares an instance of the Objects number to the original number
	 * @param Object value of any type
	 * @return a value that returns a value that shows if the two objects are the
	 *         same or not
	 */
	public double compareTo(Object values) {
		if (values != null) {
			if (values instanceof MLNumber) {
				MLNumber number2 = (MLNumber) values;
				if (number2.getFeatureValue() == this.number) {
					return 0;
				}
				if (number2.getFeatureValue() > this.number) {
					return -1;
				} else {
					return 1;
				}
			}
		}
		return 2;
	}

	/**
	 * You have to see if the two objects are equal
	 * @param any type of object
	 * @return A boolean value that shows if the two objects are the same or not
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof MLNumber)) {
			return false;
		}
		if (((MLNumber) o).getFeatureValue() == this.getFeatureValue()) {
			return true;
		}
		return false;
	}

	/**
	 * You get the string of a value
	 */
	@Override
	public String toString() {
		if(nullValue) {
			return "null";
		}
		return featurename + ": " + number;
	}
	
	
	@Override
	public double delDistance(Feature target) {
		if(!((MLNumber) target).getDefault()) {
			return this.number - ((MLNumber) target).getFeatureValue();
		}
		return 1;
	}

	@Override
	public double getError(Feature exact) {
		return Math.abs(((MLNumber) exact).getFeatureValue() - this.getFeatureValue()
				/ ((MLNumber) exact).getFeatureValue());
	}
	
	@Override
	public Feature clone() {
		if(nullValue) {
			return new MLNumber(featurename);
		}
		return new MLNumber(featurename,number);
	}
}
