package DBScan;

import java.awt.Color;

public enum CellStatus {
	
	   BLACK(Color.black), RED(Color.red), BLUE(Color.BLUE);
	   private Color color;
	  

	   private CellStatus(Color color) {
	      this.color = color;     
	   }

	   public CellStatus next() {
	      int index = 0;
	      for (int i = 0; i < CellStatus.values().length; i++) {
	         if (CellStatus.values()[i] == this) {
	            index = (i + 1) % (CellStatus.values().length-1);
	         }
	      }
	      return CellStatus.values()[index];
	   }
	   public Color getColor() {
		      return color;
	   }


}
