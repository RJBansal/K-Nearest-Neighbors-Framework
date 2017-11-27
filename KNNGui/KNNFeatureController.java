package KNNGui;
import java.awt.event.*;
import javax.swing.*;

/**
 * Author: Shounak Amladi
 * This class is responsible for resizing the frame so that the user no longer had to manually do it
 * */
public class KNNFeatureController implements ActionListener{
  private KNNView myFrame;
  private JScrollPane pnlScroll;
  
  public KNNFeatureController(KNNView frame){
    this.myFrame=frame;
    this.pnlScroll = myFrame.getPnlScroll();
  }
  @Override
public void actionPerformed(ActionEvent e){
    int height, width;
    height = myFrame.getHeight();
    width = myFrame.getWidth();
    FeatureView temp = myFrame.getSelectedItem();
    temp.lockInput(false);
    myFrame.addToScrollPane(temp);
    myFrame.setSize(width, height);
  }

}
