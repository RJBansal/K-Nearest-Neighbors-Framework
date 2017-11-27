package KNNGui;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 * @author Rajat Bansal
 * Responsible for the three different tabs, training, testing, and result
 * */
public class KNNRelationListController implements ListSelectionListener{

	private KNNView myFrame;
	public KNNRelationListController(KNNView k) {
		myFrame = k;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == myFrame.getSelectedTestingList()) {
			myFrame.getTupleMenu().setEnabled(true);
		}
		else if(e.getSource() == myFrame.getSelectedTrainingList()) {
			myFrame.getTupleMenu().setEnabled(true);
		}
		else if(e.getSource() == myFrame.getSelectedResultList()) {
			myFrame.getResultMenu().setEnabled(true);
		}
	}
}
