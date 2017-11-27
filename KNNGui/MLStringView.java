package KNNGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import knnModel.Feature;
import knnModel.MLString;
import predictionStrategy.MLStringPredictAvg;
import predictionStrategy.predictStrategy;
/**
 * @author Shounak Amladi 
 * This view is responsible for taking in the user input if the user decides to use a number as a feature in the data set
 * 
 * */
public class MLStringView extends FeatureView{
	private JTextField txtStr;
	private JPanel pnlStr;
	private JLabel lblTxt;
	private MLStringController ctrl;
	private KNNView frame;
	 
	  public MLStringView(JFrame view){
	    super();
	    frame = (KNNView)view;
	    pnlStr = new JPanel();
	    txtStr = new JTextField();
	    txtStr.setToolTipText("Enter a String Value");
	    lblTxt = new JLabel("String:");
	    ctrl = new MLStringController(this, frame);
	    txtStr.addActionListener(ctrl);
	    txtStr.setColumns(6);
	    pnlStr.add(lblTxt);
	    pnlStr.add(txtStr);
	    pnlStr.setBorder(new EmptyBorder(0,0,0,30));
	    closeButton.addActionListener(ctrl);
	    pnlSubSouth.add(pnlStr, BorderLayout.CENTER);
	  }
	  /**
	   * gets the textfield that contains string that the user wishes to add
	   * @return txtStr JTextField with the information
	   * */
	  public JTextField getTxtStr(){
	    return txtStr;
	  }
	  /**
	   * sets the textfield that contains string that the user wishes to add
	   * param string String with the information
	   * */
	  public void setTxtStr(String string){
	    txtStr.setText(string);
	  }
	/**
	 * returns the view name 
	 * @return viewName String representaion of name 
	 * */
	  @Override
	public String toString(){
		  if(txtViewName.getText().equals("")) {
				return "String";
			}
			return txtViewName.getText();
	  }
	  /**
	   * clones the current string pane and makes a new one
	   * @return f FeatureView that is cloned
	   * */
	  @Override
	  public FeatureView clonePane() {
	  	return new MLStringView(frame);
	  }
	  /**
	   * gets the controller for this view
	   * @return contr FeatureController 
	   * */
	  @Override
	public MLStringController getController() {
		  return this.ctrl;
	  }
	  /**
	   * resets the view
	   * */
	  @Override
    public void resetView() {
	      txtStr.setText("");
		  txtStr.setBackground(Color.WHITE);
		  featureValue = null;
		}
	  /**
	   * Checks if number has been entered or not
	   * @return boolean true if there has been a number entered, false if not
	   * */
	  @Override
	public boolean isValue() {
		if(txtStr.getText().equals("") || txtStr == null || featureValue == null) {
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
		return new MLStringPredictAvg();
	}
	  /**
	   * Locks/unlocks the view 
	   * @param lock boolean to lock/unlock the view
	   * */
	 @Override
	public void lockInput(boolean lock) {
	    txtStr.setEnabled(lock);
	}
	 
/**
 * This controller takes in the action event produced by the view and either creates a new string or checks the view 
 * to ensure that the information being entered is legitmate
 * */
private class MLStringController implements FeatureController{
    private MLStringView strView;
    private KNNView frame;
    public MLStringController(MLStringView viewStr, KNNView view){
        strView = viewStr;
        frame =view;
    }
    /**
     * gets the feature value that is stored in the view
     * @return featureValue Feature m
     * */
    @Override
	public Feature getFeature() {
    		return featureValue;
    }
    /**
	 * Checks to see if string has a valid value, has a name, and is not empty
	 * @param e ActionEvent triggered by the view
	 * */
    @Override
	public void actionPerformed(ActionEvent e){
    	if(e.getSource() == txtStr) {
    		if(txtViewName.getText().equals("")) {
    			JOptionPane.showMessageDialog(null, "Please enter name");
    		}
    		else if(txtStr.getText().equals("") || txtStr.getText() == null) {
    			featureValue = new MLString(txtViewName.getText());
    			txtStr.setBackground(Color.GRAY);
    		} else {
    			try {
	    			featureValue = new MLString(txtViewName.getText(), getTxtStr().getText());
	    			txtStr.setBackground(Color.GRAY);
    			} catch (Exception ex) {
    				JOptionPane.showMessageDialog(null, "Please enter in a valid string");
    			}
    		}
    	}
    	else if(e.getSource() == closeButton) {
  			frame.removeToScrollPane(MLStringView.this);	
  		}
    }
  }
	
	public static void main(String []args) {
		JFrame jf = new JFrame("testy");
		FeatureView f = new MLStringView(jf);
		jf.add(f);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}


}
