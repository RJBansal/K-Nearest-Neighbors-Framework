package KNNGui;


import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import knnModel.*;
/**
 * @author Rajat Bansal 
 * This view is responsible for being able to edit the tuples
 * */
public class EditView extends JPanel{

	private KNNView myFrame; 
	private JComboBox<FeatureView> cmbViews;
	private JPanel topPanel, bottomPanel;
	private JLabel edit;
	private JButton select;
	private MLTuple tupleEdit;
	
	public EditView(KNNView view, MLTuple t) {
		myFrame = view;
		tupleEdit = t;
		this.setLayout(new BorderLayout());
		topPanel = new JPanel(new BorderLayout());
		bottomPanel = new JPanel(new BorderLayout());
		
		edit = new JLabel("Edit", SwingConstants.CENTER);
		topPanel.add(edit, BorderLayout.PAGE_START);
		
		cmbViews = new JComboBox<FeatureView>();
		populateEdit();
		select = new JButton("Select"); 
		select.addActionListener(new KNNEditController(this));
		bottomPanel.add(cmbViews, BorderLayout.PAGE_START);
		bottomPanel.add(select, BorderLayout.PAGE_END); 
		
		this.add(topPanel, BorderLayout.PAGE_START);
		this.add(bottomPanel, BorderLayout.PAGE_END);
		this.setVisible(true);
		this.setBorder(new EmptyBorder(20,10,20,10));
		
	}
	/**
	 * Populates the edit option with features that have been inputted by the user
	 * */
	public void populateEdit() {
		for(int i = 0; i < myFrame.getFeatureList().size(); i++) {
			cmbViews.addItem(myFrame.getFeatureList().get(i));
		}
	}
	/**
	 * Returns the select button
	 * @return select JButton
	 * */
	public JButton getSelectButton() {
		return select;
	}
	/**
	 * Returns the feature view the user wishes to edit
	 * @return selectedView FeatureView that the user wants to edit
	 * */
	public FeatureView getSelectValue(){
		return (FeatureView)cmbViews.getSelectedItem();
	}
	
	/**
	 * processes the action event triggered by the view and updates the info that the user wished to edit
	 * */
	private class KNNEditController implements ActionListener{

		EditView view;
		public KNNEditController(EditView ev) {
			view = ev;
		}
		/**
		 * Process the event in the view, if the select button is pressed then it opens the view that the user wishs to edit
		 * */
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == select) {
				int index = cmbViews.getSelectedIndex();
				FeatureView tempPane = (FeatureView) cmbViews.getSelectedItem();
				
				JDialog tempFrame = new JDialog(myFrame, Dialog.ModalityType.APPLICATION_MODAL);
				tempPane = tempPane.clonePane();
				Feature delete = tupleEdit.getAttribute(index);
				tempPane.setFeatureName(delete.getName());
				tempFrame.add(tempPane);
				tempFrame.pack();
				tempFrame.setVisible(true);
				
				tupleEdit.addAttributeIndex(tempPane.getController().getFeature(), index);
				tupleEdit.remAttributes(delete);
				
			}
		}

	}

}
