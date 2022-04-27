package DBScan;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class ClickListener extends MouseAdapter {
	   private Grid grid;

	   public ClickListener(Grid grid) {
	      this.grid = grid;
	   }

	   @Override
	   public void mousePressed(MouseEvent e) {
	      if (e.getButton() == MouseEvent.BUTTON1) {
	    	  grid.labelPressed((JLabel)e.getSource());
	      } 
	      
	   }
}