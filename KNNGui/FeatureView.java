package KNNGui;
/**
 * @author: Shounak Amladi
 * This abstract class that all the views implement, it holds each feature's name
 * */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import knnModel.*;
import predictionStrategy.predictStrategy;
public abstract class FeatureView extends JPanel{

    //protected JButton btnApply, btnNull;
    protected JPanel pnlNorth, pnlSubNorth, pnlSubSouth, pnlButtonSouth;
    protected JLabel lblName, lblEntry;
    protected JTextField txtViewName;
    protected Feature featureValue;
    protected JButton closeButton;
    public FeatureView(){
      super();
      pnlNorth = new JPanel(new BorderLayout());
      pnlSubNorth = new JPanel(new BorderLayout());
      pnlSubSouth = new JPanel(new BorderLayout());
      pnlButtonSouth = new JPanel(new BorderLayout());
      
      
      txtViewName = new JTextField();
      txtViewName.setColumns(6);
      lblName = new JLabel(toString(), SwingConstants.CENTER );
      lblEntry = new JLabel("Name:");
   
     
      closeButton = new JButton("x");
      closeButton.setPreferredSize(new Dimension(20,20));
      closeButton.setMargin(new Insets(0,0,0,0));
      JPanel closePanel = new JPanel(new BorderLayout());
      closePanel.add(closeButton, BorderLayout.PAGE_START);
      pnlNorth.add(closePanel, BorderLayout.EAST);
      

      this.setLayout(new BorderLayout());

      pnlSubNorth.add(lblName, BorderLayout.NORTH);
      JPanel input = new JPanel();
      input.add(lblEntry);
      input.add(txtViewName);
      pnlSubNorth.add(input, BorderLayout.CENTER);
      pnlNorth.add(pnlSubNorth, BorderLayout.CENTER);
      add(pnlNorth, BorderLayout.PAGE_START);
      add(pnlSubSouth);
      add(pnlButtonSouth, BorderLayout.PAGE_END);
      this.setBorder(new EmptyBorder(20,10,20,10));
    }
    /**
     * Returns the name of the feature
     * @return featureName String representation of the name of the feature	
     * */
    public String getFeatureName() {
    	return this.txtViewName.getText();
    }
    /**
     * Sets the feature name 
     * @param s String value of name that the feature name must be set to
     * */
    public void setFeatureName(String s) {
    	txtViewName.setText(s);
    	txtViewName.setEnabled(false);
    }
    /**
     * Returns the textbox that hold the name of the Feature
     * @return name JTextField that holds the name
     * */
    public JTextField getNameTextBox() {
    	return this.txtViewName;
    }
    /**
     * Returns the close button that cancels any features the user may not want anymore
     * @return closeButton JButton used to delete features
     * */
    public JButton getCloseButton() {
    	return closeButton;
    }
    /**
     * Checks to see if the feature has a name or not
     * @return boolean true if name set and false if not
     * */
    public boolean isName() {
    	if(txtViewName.getText().equals("")) {
    		return false;
    	}
    	return true;
    }
    /**
     * Checks to see if the feature has a value or not
     * @return boolean true if feature has a value and false if not
     * */
    public boolean isFeatureValue() {
    	if(featureValue == null) {
    		return false;
    	}
    	return true;
    }

    @Override
    /**
     * toString method to return the name of the view
     * @return String value of view name
     * */
	public abstract String toString();
    /**
     * Clones the pane to create a new one
     * @return cloned FeatureView of the original
     * */
    public abstract FeatureView clonePane();
    /**
     * Returns the controller for the specific view
     * @return FeatureController for the view
     * */
    public abstract FeatureController getController();
    /**
     * Resets the view 
     * */
    public abstract void resetView();
    /**
     * 
     * */
    public abstract boolean isValue();
    /**
     * Gets the predict strategy being used
     * @return predictStrategy being used
     * */
    public abstract predictStrategy getStrategy();
    /**
     * locks the panel
     * @param lock true if you want to lock the panel, false to unlock
     *
     * */
    public abstract void lockInput(boolean lock);
}
