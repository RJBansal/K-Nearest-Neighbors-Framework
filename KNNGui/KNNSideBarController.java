package KNNGui;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import predictionStrategy.*;
import distanceStrategy.*;

/**
 * @author Rajat Bansal 
 * Controls the side buttons in the main frame like add weights, which feature to predict,and what distance stragety to pick
 * */

public class KNNSideBarController implements ActionListener{
  private KNNView myFrame;
  private ArrayList<Double> myWeights;
  private ArrayList<FeatureView> myFeatureList;
  private JButton btnAddWeight, btnPredictStrat, btnlock, btnDistanceStrat, btnError;
  private predictStrategy predictStrat;
  private Distance distanceStrat;
 
  public KNNSideBarController(KNNView view){
    myFrame = view;
  }
/**
 * Allows the user to choose if they want weights, what prediction strategy they wish to use and what type of distance formula
 * @param e ActionEvent produced by the View
 * */
  @Override
public void actionPerformed(ActionEvent e){
	myWeights = myFrame.getWeights();
    myFeatureList = myFrame.getFeatureList();
    btnAddWeight = myFrame.getBtnAddWeight();
    btnPredictStrat = myFrame.getBtnPredictStrat();
    predictStrat = myFrame.getPredictStrat();
    btnlock = myFrame.getLockbtn();
    btnDistanceStrat = myFrame.getBtnDistanceStrat();
    
    if (e.getSource() == btnAddWeight){
      for (int i=0; i<myFeatureList.size();i++){
        myWeights.add(Double.parseDouble(JOptionPane.showInputDialog("Weight for Feature: "+(myFeatureList).get(i).getFeatureName())));
      }
    }
    else if(e.getSource()== btnPredictStrat){
    	JOptionPane.showMessageDialog(null, "Prediction Selected!");
    	predictStrat = myFrame.getFeatureToPredictSelectedItem();
    	myFrame.setPredictionStrat(predictStrat);
    }

    else if(e.getSource() == btnlock) {
    	if(myFrame.getFeatureList().size() != 0) {
       		boolean check = true;
    		for(FeatureView f: myFrame.getFeatureList()) {
    			check &= f.isName();
    		}
    		if(check == true) {
    			for(FeatureView f: myFrame.getFeatureList()) {
        			f.getNameTextBox().setEnabled(false);
        			f.getCloseButton().setEnabled(false);
        			f.lockInput(true);
        		}
    			myFrame.getBtnAddFeature().setEnabled(false);
    			btnlock.setEnabled(false);
    			myFrame.visiblity(true);
    		}
    		else {
    			myFrame.showErrorMsg(0);
    		}
    	}
    	else {
    		myFrame.showErrorMsg(0);
    	}
    }
    
    else if (e.getSource() == btnDistanceStrat){
      JOptionPane.showMessageDialog(null, "Distance Selected!");
      distanceStrat = myFrame.getBtnDistanceStratCombo();
      myFrame.setDistanceStrat(distanceStrat);
    }
  }
}
