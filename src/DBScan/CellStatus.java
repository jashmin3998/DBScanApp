package DBScan;

import java.awt.Color;

public enum CellStatus {
	
	   BLACK(Color.black), RED(Color.red);
	   private Color color;
	  

	   private CellStatus(Color color) {
	      this.color = color;     
	   }

	   public CellStatus next() {
	      int index = 0;
	      for (int i = 0; i < CellStatus.values().length; i++) {
	         if (CellStatus.values()[i] == this) {
	            index = (i + 1) % CellStatus.values().length;
	         }
	      }
	      return CellStatus.values()[index];
	   }
	   public Color getColor() {
		      return color;
	   }


}
