package DBScan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

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
	
	public ArrayList<Integer[]> loadSavedDots(){
		
		ArrayList<Integer[]> list = new ArrayList<>();
		try {
		      File myObj = new File("selectedDots.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        String[] str = data.split(",");
		        Integer[] temp = {Integer.parseInt(str[0]), Integer.parseInt(str[1])};
		        list.add(temp);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		return list;
	}
	
	public ArrayList<Integer[]> getRandomDots(){
		ArrayList<Integer[]> list = new ArrayList<>();
		Set<Integer[]> set = new HashSet<>();
		Random rand = new Random();
		
		
		for(int i = 0 ; i < 10; i++) {
			//int x = rand.nextInt(39);
			Integer[] arr = {rand.nextInt(19), rand.nextInt(39)};
			set.add(arr);
		}
		
		for(Integer[] temp : set) {
			list.add(temp);
		}
		return list;
		
	}
}