package knnModel;

public abstract class NumberAbstract implements Feature {

	protected String featurename;

	public NumberAbstract(String n) {
		featurename = n;
	}
	/**
	 * Gets the name of the feature
	 * @return featureName String name of feature
	 * */
	public String getName() {
		return featurename;
	}
	/**
	 * sets the name of the feature 
	 * @param featureName String new name of feature
	 * */
	public void setName(String name) {
		this.featurename = name;
	}
	/**
	 * if true then sets the default value to null if not then feature must have a value
	 * @param d Boolean dictates if feature has a default value or not
	 * */
	public abstract void setDefault(boolean d);
	/**
	 * Gets if the feature has a default value or not
	 * @return boolean depicts if feature has a default value or not
	 * */
	public abstract boolean getDefault();
	/**
	 * Clones current feature to make a duplicate one 
	 * @return f Feature duplicated feature
	 * */
	@Override
	public abstract Feature clone();
}
