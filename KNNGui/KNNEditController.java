package KNNGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * @author Rajat Bansal
 * Process the event raised by the editView, which allows the user to edit a tuple that they entered
 * */
public class KNNEditController implements ActionListener{

	EditView view;
	JButton edit; 
	public KNNEditController(EditView ev) {
		view = ev;
	}
	/**
	 * If user changes tuple information, this processes the info they want to change and updates the tuple with the new info
	 * @param e ActionEvent raised by the View
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		edit = view.getSelectButton();
		if(e.getSource() == edit) {
			
		}
	}

}
