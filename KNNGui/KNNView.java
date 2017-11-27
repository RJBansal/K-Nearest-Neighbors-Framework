package KNNGui;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import distanceStrategy.*;
import knnModel.*;
import predictionStrategy.*;
import java.awt.*;
import java.util.*;

/**
 * @author Rajat Bansal and Shounak Amladi
 * This class instantiates the whole view and sets up the whole application
 * */
public class KNNView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JList<MLTuple> lstTuples, lstTestingTuples;
    private DefaultListModel<MLTuple> tuplesListModel, tuplesListTestingModel;   
    private JList<String> resultList;
    private DefaultListModel<String> resultListModel;   
    private JPanel pnlFeatureGroup, pnlPredictNearest;
    private JPanel sideMenuOption, listoffeaturepanel, pnlCombobox, pnlScrollChild;
    private JPanel predictGroup, distanceGroup;
    private JButton btnPredict, btnAdd, kbtn, btnAddWeight, btnPredictTuple, btnDistanceStrat, btnPredictStrat, add, btnAddAttr, btnlock, distanceBtn;
    private MLRelation training_set;
    private JMenuBar menubar;
    private JMenu relation, tuple, resultMenu;
    private JMenuItem newrelation, tuple_edit, tuple_delete, result_clear;
    private JScrollPane tupleScroll, pnlFeatureViewScroll, pnlTestingList;
    private MLTuple tupletopredict;
    private int attributetopredict, trainiguid, testinguid, height, width, k;
    private JComboBox<FeatureView> cmbFeatureType;
    private Vector<FeatureView> lstFeatureView;
    private JComboBox<FeatureView> featureToPredict;
    private Vector<FeatureView> featureToPredictList;
    private JComboBox<Distance> distanceStrategy;
    private Vector<Distance> distanceStrategyList;
    private JScrollPane pnlResultScroll;
    private KNNFeatureController ctrl;
    private KNNSideBarController ctrlWeight;
    private ArrayList<FeatureView> featureList;
    private ArrayList<Double> weights;
    private JTabbedPane pnlTrainingnTesting;
    private predictStrategy predictStrat;
    private Distance distanceStrat;
    private boolean testIsPressed, trainIsPressed;
    private MLRelation trainingRelation, testingRelation;
    
    public KNNView (){	
  	  testIsPressed = false;
	  trainIsPressed = false;
  	  trainingRelation = new MLRelation(); 
  	  testingRelation = new MLRelation();
  	  featureList = new ArrayList<FeatureView>();
      weights = new ArrayList<Double>();
      height = 550;
      width = 750;
      testinguid = 0;
      trainiguid = 1;
  	  
      tuplesListModel = new DefaultListModel<MLTuple>();
      tuplesListTestingModel = new DefaultListModel<MLTuple>();
      lstTuples = new JList<MLTuple>(tuplesListModel);
      lstTestingTuples = new JList<MLTuple>(tuplesListTestingModel);
      
      resultListModel = new DefaultListModel<String>();
      resultList = new JList<String>(resultListModel);
      
      lstTestingTuples.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      tupleScroll = new JScrollPane(lstTuples);
      pnlTestingList = new JScrollPane(lstTestingTuples);
      pnlResultScroll = new JScrollPane(resultList);
      
      pnlFeatureGroup = new JPanel(new BorderLayout());
      pnlFeatureGroup.setBorder(new EmptyBorder(10,10,0,10));
      pnlPredictNearest = new JPanel();
      pnlTrainingnTesting = new JTabbedPane();
      pnlTrainingnTesting.setBorder(new EmptyBorder(10,0,10,10));
      
      setMenu();
      setPredictComboBox();
      setSidePanel();
      setFeatureListPanel();
      setCombobox();
      setScrollPane();

      this.pnlFeatureGroup.add(pnlFeatureViewScroll, BorderLayout.CENTER);
      btnPredict = new JButton("Predict");
      btnPredict.setPreferredSize(new Dimension(80,25));
      pnlPredictNearest.add(btnPredict);
      pnlPredictNearest.setBorder(new EmptyBorder(5,10,5,10));
      pnlTrainingnTesting.add("Training", tupleScroll);
      pnlTrainingnTesting.add("Testing", pnlTestingList);
      pnlTrainingnTesting.add("Results", pnlResultScroll);
      
      setLayout(new BorderLayout());
      add(pnlFeatureGroup, BorderLayout.PAGE_START); //TOP PANEL FOR LIST
      add(pnlPredictNearest, BorderLayout.PAGE_END); //BOTTOM PREDICT BUTTON
      add(sideMenuOption, BorderLayout.LINE_START); //SIDE BAR CONTAINS ALL THE BUTTONS
      add(pnlTrainingnTesting, BorderLayout.CENTER); // CENTER WHITE BOX
      ctrl = new KNNFeatureController(this);
      ctrlWeight = new KNNSideBarController(this);
      
      
      setSize(width,height);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      btnlock.addActionListener(new KNNSideBarController(this));
      btnAdd.addActionListener(new DataController(this));
      btnPredictTuple.addActionListener(new DataController(this)); 
      btnDistanceStrat.addActionListener(new KNNSideBarController(this));
      btnPredictStrat.addActionListener(new KNNSideBarController(this));
      distanceBtn.addActionListener(new KNNSideBarController(this));
      btnAddWeight.addActionListener(ctrlWeight);
      btnAddAttr.addActionListener(ctrl);
      lstTuples.addListSelectionListener(new KNNRelationListController(this));
      lstTestingTuples.addListSelectionListener(new KNNRelationListController(this));
      resultList.addListSelectionListener(new KNNRelationListController(this));
      tuple_delete.addActionListener(new KNNMenuController(this));
      newrelation.addActionListener(new KNNMenuController(this));
      result_clear.addActionListener(new KNNMenuController(this));
      tuple_edit.addActionListener(new KNNMenuController(this));
      btnPredict.addActionListener(new KNNPredictButtonController(this));
      visiblity(false);
      setVisible(true);

    }
    /**
     * Controls the visibility of the elements in this frame
     * @param flag of type boolean that determines if the elements are turns on of off
     */
    public void visiblity(Boolean flag) {
    	btnPredictTuple.setEnabled(flag);
    	btnDistanceStrat.setEnabled(flag);
    	btnPredictStrat.setEnabled(flag);
    	distanceBtn.setEnabled(flag); 
    	btnAddWeight.setEnabled(flag);
    	btnPredict.setEnabled(flag);
    	btnAdd.setEnabled(flag);
    	featureToPredict.setEnabled(flag); 
    	distanceStrategy.setEnabled(flag);
    	pnlTrainingnTesting.setEnabled(flag);
    	cmbFeatureType.setEnabled(!flag);
    	
  }
    /**
     * Set the menu in the frame that the user will interact with
     */
    public void setMenu() {
    	menubar = new JMenuBar();

    	relation = new JMenu("Predict");
		newrelation = new JMenuItem("New Prediction Set");
		relation.add(newrelation);
		
		tuple = new JMenu("Tuple");
		tuple_delete = new JMenuItem("Delete");
		tuple_edit = new JMenuItem("Edit");
		tuple.add(tuple_delete);
		tuple.add(tuple_edit);
		tuple.setEnabled(false);
		
		resultMenu = new JMenu("Results");
		result_clear = new JMenuItem("Clear All");
		resultMenu.add(result_clear);
		resultMenu.setEnabled(false);
		
		menubar.add(relation);
		menubar.add(tuple);
		menubar.add(resultMenu);

		setJMenuBar(menubar);
    }
    /**
     * Sets the combobox that the user will interact with
     * */
    public void setPredictComboBox() {
    	featureToPredictList = new Vector<FeatureView>();
    	for(FeatureView f: featureList) {
    		featureToPredictList.add(f);
    	}
    	featureToPredict = new JComboBox<FeatureView>(featureToPredictList);
    	featureToPredict.setToolTipText("Select Feature to Predict");
    }

    /**
   * Sets the sidePanel that the user will interact with that has many elements that they can choose from
   */
    public void setCombobox(){
      btnlock = new JButton("Lock");
      btnlock.setToolTipText("Locking the Tuple Prevents Adding of Additonal Features");
      
      lstFeatureView = new Vector<FeatureView>();
      lstFeatureView.add(new MLNumberView(this));
      lstFeatureView.add(new MLStringView(this));
      lstFeatureView.add(new MLListView(this));
      cmbFeatureType = new JComboBox<FeatureView>(lstFeatureView);
      pnlCombobox = new JPanel(new BorderLayout());
      btnAddAttr = new JButton("Add Feature");
      JPanel btnholder = new JPanel(new BorderLayout());
      pnlCombobox.add(cmbFeatureType, BorderLayout.PAGE_START);
      btnholder.add(btnAddAttr, BorderLayout.PAGE_START);
      btnholder.add(btnlock, BorderLayout.PAGE_END);
      pnlCombobox.add(btnholder, BorderLayout.PAGE_END);
      pnlCombobox.setPreferredSize(new Dimension(135,100));
      pnlCombobox.setBorder(new EmptyBorder(10,10,10,10));
      pnlFeatureGroup.add(pnlCombobox, BorderLayout.LINE_START);

    }
/**
 * Sets the scroll pane that holds all the features the user wants to add
 * */
    public void setScrollPane() {
    	this.pnlScrollChild = new JPanel(new GridLayout(1,0));
        this.pnlFeatureViewScroll = new JScrollPane(pnlScrollChild,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pnlFeatureViewScroll.setViewportView(pnlScrollChild);
    }
/**
 * Sets up the side panel that allows user to add data as training tuple or testing tuple, and add weights, select distance strategy
 * */
    public void setSidePanel() {
  	  sideMenuOption = new JPanel(new BorderLayout());
  	  sideMenuOption.setBorder(new EmptyBorder(10,10,10,10));
      btnAdd = new JButton("Add Training Data");
      
      btnPredictTuple = new JButton("Add Testing Tuple");
       
      btnAddWeight = new JButton("Add Weights");
      btnAddWeight.setToolTipText("Click to edit weights");
      btnDistanceStrat = new JButton("Choose Distance Calculation");
      
      JPanel topGroup = new JPanel(new BorderLayout());
      JPanel bottomgroup = new JPanel(new BorderLayout());
      JPanel weightErrorGroup = new JPanel(new BorderLayout());
      
      JPanel addDataGroup = new JPanel(new BorderLayout());
      addDataGroup.add(btnAdd, BorderLayout.PAGE_START);
      addDataGroup.add(btnPredictTuple, BorderLayout.CENTER);
      addDataGroup.setBorder(new EmptyBorder(25,0,0,0));
      topGroup.add(addDataGroup, BorderLayout.PAGE_START);

      setPredictFeatureGroup();
      setDistanceFeatureGroup();

      weightErrorGroup.add(btnAddWeight, BorderLayout.PAGE_END);
      topGroup.add(predictGroup, BorderLayout.PAGE_END);
      bottomgroup.add(distanceGroup, BorderLayout.PAGE_START);
      bottomgroup.add(weightErrorGroup, BorderLayout.PAGE_END);
      sideMenuOption.add(topGroup, BorderLayout.PAGE_START);
      sideMenuOption.add(bottomgroup, BorderLayout.PAGE_END);
    }
/**
 * Sets up area where user can select what feature to predict
 * */
    public void setPredictFeatureGroup() {
        predictGroup = new JPanel(new BorderLayout());
        JLabel predictlbl = new JLabel("Prediction Feature", SwingConstants.CENTER);
        btnPredictStrat = new JButton("Select");
        
        predictGroup.add(predictlbl, BorderLayout.PAGE_START);
        predictGroup.add(featureToPredict, BorderLayout.CENTER);
        predictGroup.add(btnPredictStrat, BorderLayout.PAGE_END);
        predictGroup.setBorder(new EmptyBorder(15,0,15,0));
    }
/**
 * user can select what type of distance strategy the user can use
 ***/
    public void setDistanceFeatureGroup() {
    	distanceGroup = new JPanel(new BorderLayout());
    	distanceBtn = new JButton("Select"); 	
    	distanceStrategyList = new Vector<Distance>();
    	distanceStrategyList.add(new AbsoluteDistance());
    	distanceStrategyList.add(new EculidianDistance());
    	distanceStrategy = new JComboBox<Distance>(distanceStrategyList);
    	distanceStrategy.setToolTipText("Choose Distance Strategy");
    	JLabel chooseDistance = new JLabel("Distance Strategy");
    	distanceGroup.add(chooseDistance, BorderLayout.PAGE_START);
    	distanceGroup.add(distanceStrategy, BorderLayout.CENTER);
    	distanceGroup.add(distanceBtn, BorderLayout.PAGE_END);
    	distanceGroup.setBorder(new EmptyBorder(15,0,15,0));

    }
    /**
     * Sets the feature list panel
     * */
    public void setFeatureListPanel() {
      listoffeaturepanel = new JPanel();
      listoffeaturepanel.setLayout(new BorderLayout());
      pnlFeatureGroup.add(listoffeaturepanel, BorderLayout.PAGE_START);
    }
/**
 * Addes feature that user wants to add into the scroll pane so they can see it and input information for it
 * @param pnl FeatureView that needs to be added to the scroll pane
 * */
    public void addToScrollPane(FeatureView pnl){
    	pnlScrollChild.add(pnl);
    	featureList.add(pnl);
    	populatePredictComboBox();
    	pnlScrollChild.revalidate();
    	pnlScrollChild.repaint();
    	pnlFeatureViewScroll.revalidate();
    	pnlFeatureViewScroll.repaint();
    }
/**
 * Removes the feature that user wants deleted from the scroll pane
 * @param pnl FeatureView to be deleted
 * */
    public void removeToScrollPane(FeatureView pnl){
    	pnlScrollChild.remove(pnl);
    	depopulatePredictComboBox();
    	featureList.remove(pnl);
    	pnlScrollChild.revalidate();
    	pnlScrollChild.repaint();
    	pnlFeatureViewScroll.revalidate();
    	pnlFeatureViewScroll.repaint();
    }
    /**
     * populates the combobox with all the types of features a user can use
     * 
     * */
    public void populatePredictComboBox() {
    	FeatureView f = featureList.get(featureList.size()-1);
    	featureToPredict.addItem(f);
    }
/**
 * Empties the combobox 
 * */
    public void depopulatePredictComboBox() {
    	FeatureView f = featureList.get(featureList.size()-1);
    	featureToPredict.removeItem(f);
    }
/**
 * Adds the result tuple to the model 
 * @param s String to be added
 * */
    public void addResultToModel(String s) {
    	resultListModel.addElement(s);
    }
    /**
     * Adds the data the user added into the training set
     * @param t MLTuple to be added into the training set
     * */
    public void addTrainingTuple(MLTuple t) {
    	tuplesListModel.addElement(t);
    	trainingRelation.addTuple(t);
    }
/**
 * Adds the data the user added into the testing set
 * @param t MLTuple to be added into the testing set
 * */
    public void addTestingTuple(MLTuple t) {
    	tuplesListTestingModel.addElement(t);
    	testingRelation.addTuple(t);
    }
    /**
     * Removes the data the user removed from the training set
     * @param t MLTuple to be removed from the training set
     * */ 
    public void removeTrainingTuple(MLTuple t) {
    	tuplesListModel.removeElement(t);
    	trainingRelation.removeTuple(t);
    }
    /**
     * Removes the data the user removed from the testing set
     * @param t MLTuple to be removed from the testing set
     * */
    public void removeTestingTuple(MLTuple t) {
    	tuplesListTestingModel.removeElement(t);
    	testingRelation.removeTuple(t);
    }
    /**
     * Clears the results tabs 
     * */
    public void clearResultTab() {
    	resultListModel.clear();
    }
    /**
     * Gets the training relation
     * @return trainingRelation MLRelation thats the training relation
     * */
    public MLRelation getTrainingRelation() {
    	return trainingRelation; 
    }
    /**
     * Gets the testing relation
     * @return testingRelation MLRelation thats the testing relation
     * */
    public MLRelation getTestingRelation() {
    	return testingRelation; 
    }
    /**
     * gets the tuple menu
     * @return menu JMenu
     * */
    public JMenu getTupleMenu() {
    	return tuple;
    }
    /**
     * gets the result menu
     * @return resultMenu JMenu 
     * */
    public JMenu getResultMenu() {
    	return  resultMenu;
    }
   
    /**
     * gets the delete menu
     * @return delete JMenuItem
     * */
    public JMenuItem getDeleteMenuItem() {
    	return tuple_delete;
    }
    /**
     * gets the relation menu
     * @return relation JMenuItem
     * */
    public JMenuItem getRelationMenuItem() {
    	return newrelation;
    }
    /**
     * gets the clear Results menu item
     * @return resultClear JMenuItem
     * */
    public JMenuItem getResultClearMenuItem() {
    	return result_clear;
    }
    /**
     * gets the edit menu item
     * @return edit JMenuItem
     * */
    public JMenuItem getEditMenuItem() {
    	return tuple_edit;
    }
    /**
     * gets the uid
     * @return an int uid
     */
    public int getTrainingUid() {
  	  return trainiguid++;
    }
/**
 * gets the UID for the testing data
 * @return testingUID int of the new testing tuple
 * */
    public int getTestingUid() {
    	  return testinguid++;
    } 
    /**
     * returns the selected testing tuples
     * @return testingtuples JList of MLTuples that are selected
     * */
    public JList<MLTuple> getSelectedTestingList(){
    	return lstTestingTuples;
    }  
    /**
     * returns the selected training tuples
     * @return trainingtuples JList of MLTuples that are selected
     * */
    public JList<MLTuple> getSelectedTrainingList(){
    	return lstTuples;
    }
    /**
     * returns the selected result tuples
     * @return resulttuples JList of MLTuples that are selected
     * */
    public JList<String> getSelectedResultList(){
    	return resultList;
    }  
    /**
     * sets the distance strategy to be used in the prediction
     * @param d Distance strategy to use
     * */
    public void setDistanceStrat(Distance d) {
    	distanceStrat = d;
    }
    /**
     * sets the prediction strategy to be used in the prediction
     * @param d predictStrategy strategy to use
     * */
    public void setPredictionStrat(predictStrategy d) {
    	predictStrat = d;
    }
    /**
     * Retrieves the new JMenu item
     * @return the a new JMenuiTEM
     */
    public JMenuItem getMenuNewItem() {
  	  return newrelation;
    }
    /**
     * gets the add button 
     * @return btnAdd JButton 
     * */
    public JButton getAddBtn() {
  	  return btnAdd;
    }  
    /**
     * gets the prediction strategy to  be used in the prediction
     * @return int value of the prediction
     * */
    public int getPredictionAttribute() {
    	return featureToPredict.getSelectedIndex();
    }     
    /**
     * Retrieves the predict tuple button
     * @return a button of type JButton that
     */
    public JButton getBtnPredictTuple() {
  	  return btnPredictTuple;
    }
    /**
     * gets the add
     * @return add JButton
     * */
    public JButton getAdd() {
  	  return add;
    }
    /**
     * gets the lock button
     * @return btnLock JButton 
     * */
    public JButton getLockbtn() {
    	  return btnlock;
    }
    /**
     * gets the button that controls the predict button
     * @return btnPredict JButton 
     * */
    public JButton getBtnPredict() {
  	  return btnPredict;
    }
    /**
     * gets the button that adds features that users add
     * @return btnAddAttr JButton 
     * */
    public JButton getBtnAddFeature() {
    	  return btnAddAttr;
    }
    /**
     * Sets the tuple the user wishes to predict
     * @param t MLTuple selected to be predicted
     * */
    public void setTupletoPredict(MLTuple t) {
  	  tupletopredict = t;
    }
    /**
     * gets the tuple that must be predicted
     * @return tupleToPredict MLTuple tuple selected to predict
     * */
    
    public MLTuple getTupletoPredict() {
  	  return this.tupletopredict;
    }
    /**
     * sets the index of the attribute to predict
     * @param i int index of element to predict
     * */
    public void setAttributetoPredict(int i) {
  	  attributetopredict = i;
    }
    /**
     * gets the index of attribute to predict
     * @return attrIndex int index of attribute
     * */
    public int getAttribute() {
  	  return this.attributetopredict;
    }
    /**
     * gets the relation
     * @return MLRelation relation
     * */
    public MLRelation getRel() {
  	  return this.training_set;
    }
    /**
     * Gets the selected item from the combobox
     * @return view FeatureView that was selected from the combobox
     * */
    public FeatureView getSelectedItem(){
      return ((FeatureView)cmbFeatureType.getSelectedItem()).clonePane();
    }
    /**
     * Gets the scroll pane where the features the user wants to be stored
     * @return JScrollPane pane that holds all the features
     * */
    public JScrollPane getPnlScroll(){
      return pnlFeatureViewScroll;
    }
    /**
     * Gets the weights entered by the user
     * @return ArrayList<Double> list of all user weights
     * */
    public ArrayList<Double> getWeights(){
      return weights;
    }
    /**
     * Gets a list of features the user has 
     * @return ArrayList<FeatureView> list of features that the user has picked
     * */
    public ArrayList<FeatureView> getFeatureList(){
      return featureList;
    }
    /**
     * Gets the predict strategy
     * @return p predictStrategy that the user wishes to use
     * */
    public predictStrategy getPredictStrat(){
      return predictStrat;
    }
    /**
     * Gets the button that the user presses to add weights
     * @return btnAddWeight JButton button used to add weights
     * */
    public JButton getBtnAddWeight(){
      return btnAddWeight;
    }
    /**
     * gets the button that sets the predict stragety 
     * @return btnPredictStrat JButton used to select predict strategy
     * */
    public JButton getBtnPredictStrat(){
      return btnPredictStrat;
    }
    /**
     * gets the button that sets the distance stragety 
     * @return btnDistanceStrat JButton used to select distance strategy
     * */
    public JButton getBtnDistanceStrat(){
      return distanceBtn;
    }
    /**
     * gets the strategy to be used for the distance  
     * @return distanceStrat Distance to be used
     * */
    public Distance getBtnDistanceStratCombo(){
      return (Distance)distanceStrategy.getSelectedItem();
    }
    /**
     * gets the strategy to be used for the prediction  
     * @return predictStrat predictStrategy to be used
     * */
    public predictStrategy getFeatureToPredictSelectedItem(){
      return ((FeatureView)featureToPredict.getSelectedItem()).getStrategy();
    }
    public Distance getDistanceStrat(){
      return distanceStrat;
    }
    /**
     * 
     * */
    public void testOrTrainIsPressed() {
    	testIsPressed=!testIsPressed;
    }
    /**
     * 
     * */
    public boolean getTestOrTrainIsPressed() {
    	return testIsPressed;
    }
    /**
     * All the errors that the user can encounter like not selecting a distance or prediction strategy, not entering in training data
     * not selecting testing tuples to predict, or not entering in information on a feature
     * @param error int of type of error
     * */
    public void showErrorMsg(int error) {
    	if(error == 1) {
    		JOptionPane.showMessageDialog(null, "Select Distance and Feature to Predict");
    	}
    	else if(error == 2) {
    		JOptionPane.showMessageDialog(null, "Enter Training Data");
    	}
    	else if(error == 3) {
    		JOptionPane.showMessageDialog(null, "Select a Testing Tuple(s) to Predict");
    	}
    	else if (error == 4) {
    		JOptionPane.showMessageDialog(null, "Select Only One Testing Tuple to Delete");
    	}
    	else {
    		JOptionPane.showMessageDialog(null, "Add Atleast 1 Piece of Data! Must Click Enter on ALL Features");
    	}
    }
    public static void main(String[] args) {
       new KNNView();
       
    }
}
