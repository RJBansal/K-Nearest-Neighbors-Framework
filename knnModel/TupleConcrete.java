package knnModel;
import java.util.ArrayList;
import java.util.List;

import distanceStrategy.Distance;

public abstract class TupleConcrete {

	protected List<Feature> features;
	protected int length;
	protected int pKey;
	protected Distance distanceCalcultor;

	/**
	 * Creates an empty MLTuple with a unique primary key.
	 * 
	 * @param uID
	 *            The Unique key to identify the tuple
	 */
	public TupleConcrete(int uID) {
		this.features = new ArrayList<Feature>();
		this.length = 0;
		this.pKey = uID;
	}

	/**
	 * Adds attributes to the tuple.
	 * 
	 * @param value
	 *            This is the value to be appended to the tuple.
	 */
	public void addAttributes(Feature value) {
		features.add(value);
		this.length = features.size();
	}
	
	public void addAttributeIndex(Feature value, int index) {
		features.add(index, value);
		this.length = features.size();
	}

	/**
	 * Removes attributes from the tuple
	 * 
	 * @param value
	 *            The value to be removed from the tuple.
	 */
	public void remAttributes(Feature value) {
		features.remove(value);
		this.length = features.size();
	}

	/**
	 * Returns the metric specified by the index in which it was added.
	 * 
	 * @param index
	 *            the index of the metric to be removed.
	 * @return Metric returns a copy of the specified object.
	 */
	public Feature getAttribute(int index) {
		Feature temp = features.get(index);
		return temp;
	}

	/**
	 * Returns the primary key of the tuple
	 * 
	 * @return int the unique identifier of the tuple.
	 */
	public int getPKey() {
		return this.pKey;
	}

	/**
	 * This return the number of attributes attched to this tuple.
	 * 
	 * @return int number of metric values in the tuple
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * This checks if the current tuple is equal to the given tuple.
	 * 
	 * @param o
	 *            Object in question to be checked
	 * @return boolean true if equal, false if not same size, not same object, or
	 *         not same values.
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof MLTuple))
			return false;
		if (this.length != ((MLTuple) o).getLength())
			return false;

		for (int i = 0; i < this.getLength(); i++) {
			if (!(this.getAttribute(i)).equals(((MLTuple) o).getAttribute(i))) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public MLTuple clone() {
		MLTuple temp = new MLTuple(getPKey());
		for(Feature f: features) {
			temp.addAttributes(f.clone());
		}
		return temp;
	}
}
