package KNNGui;
import knnModel.*;
import predictionStrategy.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import distanceStrategy.*;

 /** @author Rajat Bansal
 * Implements the actual purpose of the button when it is pressed through ActionListener, 
 * which shows dialog in the output panel and asks for input 
 */


public class KNNPredictButtonController implements ActionListener{

	private KNNView kFrame;
	private MLRelation trainingRelation, testingRelation; 
	private Distance disStrat; 
	private predictStrategy predictStrat;
	private List<MLTuple> selectedTesting; 
	private MLPredict prediction; 
	private int selectedAttribute;
	private MLPredictTuple preTup; 
	private Feature result;
	private ErrorCalculation error;
	public KNNPredictButtonController(KNNView p) {
		kFrame = p;
		testingRelation = new MLRelation();
		preTup = new MLPredictTuple(0);
		error = new ErrorCalculation();
	}
/**
 * once the predict button has been clicked this checks to ensure that the predict function has all the information needed to make a successful prediction
 * @param e ActionEvent from the view
 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btnPredict = kFrame.getBtnPredict();
		if(e.getSource() == btnPredict) {

			disStrat = kFrame.getDistanceStrat();
			predictStrat = kFrame.getPredictStrat();	
			trainingRelation = kFrame.getTrainingRelation();		
			selectedTesting = kFrame.getSelectedTestingList().getSelectedValuesList();
			selectedAttribute = kFrame.getPredictionAttribute();
			
			if(kFrame.getTrainingRelation().getSize() == 0) {
				kFrame.showErrorMsg(2);
			}
			if(selectedTesting.size() == 0) {
				kFrame.showErrorMsg(3);
			}
			if(predictStrat == null || disStrat == null) {
				kFrame.showErrorMsg(1);
			}

			if(kFrame.getTrainingRelation().getSize() != 0 && selectedTesting.size() != 0 && predictStrat != null && disStrat != null) {
				predictEXE();
			}
		}

	}
	
	
	public void predictEXE() {
		String kNumber = JOptionPane.showInputDialog("Enter the # of Nearest Neighbors");
		while(true) {
			if(kNumber == null) {
				kNumber = JOptionPane.showInputDialog("Enter the # of Nearest Neighbors");
			}
			else {break;}
		}
		
		int KNum = Integer.parseInt(kNumber);
		prediction = new MLPredict(KNum); 
		MLRelation trainingClone = trainingRelation.clone();
		prediction.addRelation(trainingClone);
		preTup.setDistanceStrategy(disStrat);
		preTup.setPredictStrategy(predictStrat);
		prediction.setPredictiontuple(preTup);
		
		for(MLTuple t: selectedTesting) {
			testingRelation.addTuple(t);
			trainingClone = trainingRelation.clone();
			prediction.addRelation(trainingClone);
			result = prediction.predict(KNum, t, selectedAttribute);
			kFrame.addResultToModel(result.clone().toString());
		}	
		JOptionPane.showMessageDialog(null, error.errorCalculations(trainingClone, testingRelation, selectedAttribute, KNum, preTup) + "% overall error");
		
	}

}
