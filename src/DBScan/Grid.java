package DBScan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Grid extends JPanel {
   private CellStatus[][] cells;
   private JLabel[][] myLabels;
   private ArrayList<Integer[]> selectedDots = new ArrayList<Integer[]>();

public ArrayList<Integer[]> getSelectedDots() {
	return selectedDots;
}
public void setSelectedDots(ArrayList<Integer[]> selectedDots) {
	this.selectedDots = selectedDots;
}
public Grid(int rows, int cols, int cellWidth) {
      cells = new CellStatus[rows][cols];
      myLabels = new JLabel[rows][cols];

      ClickListener myListener = new ClickListener(this);
      Dimension labelPrefSize = new Dimension(cellWidth, cellWidth);
      setLayout(new GridLayout(rows, cols));
      for (int row = 0; row < myLabels.length; row++) {
         for (int col = 0; col < myLabels[row].length; col++) {
            JLabel myLabel = new JLabel();
            myLabel = new JLabel();
            myLabel.setOpaque(true);
            CellStatus myColor = CellStatus.BLACK;
            cells[row][col] = myColor;
            myLabel.setBackground(myColor.getColor());
            myLabel.addMouseListener(myListener);
            myLabel.setPreferredSize(labelPrefSize);
            add(myLabel);
            myLabels[row][col] = myLabel;
         }
      }
      
      
   }
   public CellStatus[][] getCells() {
	      return cells;
	   }

   public void labelPressed(JLabel label) {
	   for (int row = 0; row < myLabels.length; row++) {
	       for (int col = 0; col < myLabels[row].length; col++) {
	    	   
	    	   
	           if (label == myLabels[row][col]) {
	        	   System.out.println(row + "   "+ col );
	               CellStatus myColor = cells[row][col].next();
	               cells[row][col] = myColor;
	               myLabels[row][col].setBackground(myColor.getColor());
	               
	               if(label.getBackground() == Color.RED) {
	            	   Integer[] arr = {row, col};
		               this.selectedDots.add(arr);
	               }
	               else {
	            	  for(int i = 0 ; i < this.selectedDots.size(); i++) {
	     		    	if(this.selectedDots.get(i)[0] == row && this.selectedDots.get(i)[1] == col) {
	     		    		this.selectedDots.remove(i);
	     		    	}
	     		      }
	               }
	               
	            }
	         }
	      }
	   
	      
   }
   
   
   
   
}