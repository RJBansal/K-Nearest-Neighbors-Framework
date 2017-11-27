package KNNGui;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/**
 * Author:
 * Holds the action listeners that are related to the menus, which can reset application, or delete a certain set 
 * */
public class KNNMenuController implements ActionListener{

	private KNNView myFrame;
	private JMenuItem training_delete, newPrediction, resultClear, edit;
	public KNNMenuController(KNNView k) {
		myFrame = k;
	}
	/**
	 * Processes the user input with regards to the menu, like starting a new prediction, clearing the result, editing a tuple, or deleting the training data
	 * @param e ActionEvent raised by the View
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		training_delete = myFrame.getDeleteMenuItem();
		newPrediction = myFrame.getRelationMenuItem();
		resultClear = myFrame.getResultClearMenuItem();
		edit = myFrame.getEditMenuItem();
		
		if(e.getSource() == training_delete) {
			if(myFrame.getSelectedTrainingList().isSelectionEmpty()) {
				myFrame.removeTestingTuple(myFrame.getSelectedTestingList().getSelectedValue());
			}
			else{
				myFrame.removeTrainingTuple(myFrame.getSelectedTrainingList().getSelectedValue());
			}
			myFrame.getTupleMenu().setEnabled(false);
		}
		if(e.getSource() == newPrediction) {
			new KNNView();
		}
		else if(e.getSource() == resultClear) {
			myFrame.clearResultTab();
			myFrame.getResultMenu().setEnabled(false);
		}
		else if(e.getSource() == edit) {
			if(myFrame.getSelectedTrainingList().isSelectionEmpty()) {
				JDialog tempFrame = new JDialog(myFrame, Dialog.ModalityType.APPLICATION_MODAL);
				EditView edit = new EditView(myFrame, myFrame.getSelectedTestingList().getSelectedValue());
	            tempFrame.add(edit);
	            tempFrame.pack();
	            tempFrame.setVisible(true);
			}
			else{
				JDialog tempFrame = new JDialog(myFrame, Dialog.ModalityType.APPLICATION_MODAL);
				EditView edit = new EditView(myFrame, myFrame.getSelectedTrainingList().getSelectedValue());
	            tempFrame.add(edit);
	            tempFrame.pack();
	            tempFrame.setVisible(true);
			}
			myFrame.getTupleMenu().setEnabled(false);
		}
		
	}

}
 