package knnModel;
import java.util.ArrayList;

/**
 *
 *
 * Author: Pragya Singh 100974148 Holds a list of attributes, and keeps an array
 * of index that are in use by the attributes
 *
 */
public class MLConstant {
	private ArrayList<MLString> attributes;
	private int size;
	private String table_name;

	public MLConstant(String name) {
		this.table_name = name;
		attributes = new ArrayList<MLString>();
		size = 0;
	}

	/**
	 * Retrieves the array
	 * 
	 * @param
	 * @return The particular string attribute
	 */
	public ArrayList<MLString> getFeatureValue() {
		return attributes;
	}

	public int getSize() {
		return attributes.size();
	}

	public String getName() {
		return table_name;
	}

	public void setName(String name) {
		this.table_name = name;
	}

	/**
	 * Retrieves a particular string in an array
	 * 
	 * @param An
	 *            int index used to find a particular string
	 * @return The String attribute found at that particular index
	 */
	public MLString getString(int index) {
		return attributes.get(index);
	}

	/**
	 * Adds an attribute to each array, and normalizes the indexCollection
	 * 
	 * @param A
	 *            String of attributes and an index of type int of where that
	 *            attribute is locating in the array
	 * @return
	 */
	public void add(MLString nAttr) {
		attributes.add(nAttr);
	}

	/**
	 * Compares the current array to another array of the same instance
	 * 
	 * @param An
	 *            object o of any type of object
	 * @return returns if the two objects are the same
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof MLConstant)) {
			return false;
		}
		for (int i = 0; i < this.getSize(); i++) {
			if (!(this.getString(i).equals(((MLConstant) o).getString(i)))) {
				return false;
			}

		}
		return true;
	}
}
