package DBScan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageDots {
	
	public void saveSelectedDots(ArrayList<Integer[]> list) {
		try {
		      File myObj = new File("selectedDots.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		      
		      FileWriter myWriter = new FileWriter("selectedDots.txt");
		      
		      for(int i = 0 ; i < list.size(); i++) {
		    	  myWriter.write(list.get(i)[0] + "," + (list.get(i)[1] + "\n"));
		      }
		     
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}


	
}
