package knnModel;
import java.util.*;

/**
 * This stores a set of tuples to predict the specified attribute, from a data
 * set.
 * 
 * @author Shounak Amladi
 * @version 0.01b
 * @since 2017-10-30
 */
public class MLRelation {

	private ArrayList<MLTuple> relation;
	private ArrayList<MLConstant> constant_tables;


	/**
	 * Creates a relation, with k being the number of nearest neighbors
	 * 
	 * @param k the number of nearest neighbors
	 */
	public MLRelation() {
		relation = new ArrayList<MLTuple>();
		constant_tables = new ArrayList<MLConstant>();	
	}

	/**
	 * adds tuple to the relation
	 * 
	 * @param tuple
	 *            tuple to be added
	 */
	public void addTuple(MLTuple tuple) {
		relation.add(tuple);
	}

	/**
	 * removes tuple from the relation
	 * 
	 * @param tuple
	 *            tuple to be removed
	 */
	public void removeTuple(MLTuple tuple) {
		relation.remove(tuple);
	}

	/**
	 * gets tuple based on primary key
	 * 
	 * @param uId
	 *            primary key which identifies uid.
	 * @return MLTuple MLTuple that is being queried
	 */
	public MLTuple getTuple(int uId) {

		for (MLTuple tp : relation) {
			if (tp.getPKey() == uId)
				return tp;
		}
		return null;
	}
	
	public int getSize() {
		return relation.size();
	}
	
	@Override
	public MLRelation clone(){
		MLRelation temp = new MLRelation(); 
		for(MLTuple t: relation) {
			temp.addTuple(t.clone());
		}
		return temp;
		//return relation;
	}
	
	public ArrayList<MLTuple> getRelation(){
		return relation;
	}
	

	public void createConstantTable() {
		HashSet<MLString> temp = new HashSet<MLString>();
		for (int i = 0; i < relation.get(0).getLength(); i++) {
			if(relation.get(0).getAttribute(i) instanceof MLString) {
				for(TupleConcrete row: relation) {
					temp.add((MLString)row.getAttribute(i));
				}
				MLConstant ctable = new MLConstant(relation.get(0).getAttribute(i).toString() + "table");
				for(MLString s: temp) {
					ctable.add(s);;
				}
				for(TupleConcrete row: relation) {
					((MLString)(row.getAttribute(i))).setConstantTable(ctable);
				}
			}
		}
	}	
	
	
	
}
