package knnModel;
/**
 * This is the tuple that can hold an N number of attriubtes, known as Metrics.
 * 
 * @author Shounak Amladi
 * @version 0.1b
 * @since 2017-10-28
 */
public class MLTuple extends TupleConcrete {

	/**
	 * Creates an empty MLTuple with a unique primary key.
	 * 
	 * @param uID
	 *            The Unique key to identify the tuple
	 */
	public MLTuple(int uID) {
		super(uID);
	}

	/**
	 * Returns the string representation of the Tuple.
	 * 
	 * @return String The string representation of the tuple
	 */
	@Override
	public String toString() {
		String temp = this.pKey + ": { ";
		temp += features.get(0).toString();
		for(int i = 1; i < features.size(); i++) {
			Feature attr = features.get(i);
			temp += "  ~  " + attr.toString();
		}
		return temp + " }";
	}
	
	/*
	 * Remove for both this and MLList does not work
	 */
	public static void main(String[] args) {
		// MLTuple tp = new MLTuple(1);
		// MLCoord cord = new MLCoord(2);
		// cord.setVal(0,2);
		// cord.setVal(1,3);
		// tp.addAttributes(cord);
		// MLNumber num = new MLNumber(17);
		// tp.addAttributes(num);
		// System.out.println(tp.getAttribute(0).getClass().getName());
		// System.out.println(tp.getPKey());
		// System.out.println(tp.toString());
		// tp.remAttributes(num);
		// //System.out.println(tp.toString());
	}

}
