package KNNGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import knnModel.Feature;
import knnModel.MLNumber;
import predictionStrategy.MLNumberPredictAvg;
import predictionStrategy.predictStrategy;
public class MLNumberView extends FeatureView{
private JTextField txtNum;
private JPanel pnlNum;
private JLabel lblTxt;
private MLNumberController ctrl;
private KNNView frame;
/**
 * @author Brij Patel
 * This view is responsible for taking in the user input if the user decides to use a number as a feature in the data set
 * 
 * **/
public MLNumberView(KNNView view) {
	super();
	frame = view;
	txtNum = new JTextField();
	txtNum.setToolTipText("Enter a Number Value");
	pnlNum = new JPanel();
	lblTxt = new JLabel("Number:");
	ctrl = new MLNumberController(this, view);
	txtNum.addActionListener(ctrl);
	txtNum.setColumns(5);
	pnlNum.add(lblTxt);
	pnlNum.add(txtNum);
	pnlNum.setBorder(new EmptyBorder(0,0,0,30));
	closeButton.addActionListener(ctrl);
	pnlSubSouth.add(pnlNum, BorderLayout.CENTER);
}
/**
 * toString to get the name of the view
 * @return String representation of feature name
 * */
public JTextField getTxtNum() {
	return this.txtNum;
}
/**
 * sets the number the user wishes to store
 * @param str String number the user wishes to store
 * */
public void setTxtNum(String str) {
	txtNum.setText(str);
}
/**
 * toString to get the name of the view
 * @return String representation of feature name
 * */
@Override
public String toString() {
	if(txtViewName.getText().equals("")) {
		return "Number";
	}
	return txtViewName.getText();
	
}
/**
 * clones the current number pane and makes a new one
 * @return f FeatureView that is cloned
 * */
@Override
public FeatureView clonePane() {
	return new MLNumberView(frame);
}
/**
 * gets the controller for this view
 * @return contr FeatureController 
 * */
@Override
public FeatureController getController() {
	return ctrl;
}
/**
 * resets the current view
 * */
@Override
public void resetView() {
	txtNum.setText("");
	txtNum.setBackground(Color.WHITE);
	featureValue = null;
}
/**
 * Checks if number has been entered or not
 * @return boolean true if there has been a number entered, false if not
 * */
@Override
public boolean isValue() {
	if(txtNum.getText().equals("") || txtNum == null || featureValue == null) {
		return false;
	}
	return true;
}
/**
 * prediction strategy used for this feature
 * @return p predictStrategy to be used
 * */
@Override
public predictStrategy getStrategy() {
	return new MLNumberPredictAvg();
}
/**
 * Locks/unlocks the view 
 * @param lock boolean to lock/unlock the view
 * */
@Override
public void lockInput(boolean lock) {
	  txtNum.setEnabled(lock);
}
/**
 * This controller takes in the action event produced by the view and either creates a new number or checks the view 
 * to ensure that the information being entered is legitmate 
 * */
private class MLNumberController implements FeatureController{
	private MLNumberView numView;
	private KNNView frame; 
	public MLNumberController(MLNumberView view, KNNView viewMain) {
		numView = view;
		this.frame = viewMain;
	}
	/**
	 * Checks to see if number has a valid value, has a name, and is not empty
	 * @param e ActionEvent triggered by the view
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == txtNum) {
    		if(txtViewName.getText().equals("")) {
    			JOptionPane.showMessageDialog(null, "Please enter name");
    		}
    		else if(txtNum.getText().equals("") || txtNum.getText() == null) {
    			featureValue = new MLNumber(txtViewName.getText());
    			txtNum.setBackground(Color.GRAY);
    		} else {
    			try {
	    			featureValue = new MLNumber(txtViewName.getText(), Double.parseDouble(getTxtNum().getText()));
	    			txtNum.setBackground(Color.GRAY);
    			} catch (Exception ex) {
    				JOptionPane.showMessageDialog(null, "Please enter in a number");
    			}
    		}
    	}
		else if(e.getSource() == closeButton) {
  			frame.removeToScrollPane(MLNumberView.this);	
  		}
	}

	@Override
	public Feature getFeature() {
		return featureValue;
	}	
}


public static void main(String []args) {

	JFrame jf = new JFrame("testy");
	FeatureView f = new MLNumberView((KNNView)jf);
	jf.add(f);
	jf.pack();
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jf.setVisible(true);
}


}
