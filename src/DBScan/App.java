package DBScan;

import java.awt.Frame;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Button;


public class App extends JPanel{
   private static void displayScreen() {
      int rows = 20;
      int cols = 40;
      int cellWidth = 20;
      Grid mainPanel = new Grid(20, cols, cellWidth);

      
      JFrame frame = new JFrame("DBScan");
      
      
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel, BorderLayout.SOUTH);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      
      JMenuBar menuBar = new JMenuBar();
      frame.setJMenuBar(menuBar);
      
      
      
      ManageDots md = new ManageDots();
      
      //Save Button
      Button saveButton = new Button("Save");
      saveButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			md.saveSelectedDots(mainPanel.getSelectedDots());
			System.out.println("Save button Clicked");
		}
      });
      saveButton.setBackground(Color.BLUE);
      menuBar.add(saveButton);
      
      
      //Load Button
      Button loadButton = new Button("Load");
      loadButton.addActionListener(new ActionListener() {
  		@Override
  		public void actionPerformed(ActionEvent e) {
  			// TODO Auto-generated method stubloadSavedDots
  			System.out.println("Load button Clicked");
  			
  			mainPanel.cleanScreen();
  			mainPanel.setSelectedDots(md.loadSavedDots());
  			mainPanel.displaySavedDots();
  		}
        });
      loadButton.setBackground(Color.YELLOW);
      menuBar.add(loadButton);
      
      
      //Start Button
      Button startButton = new Button("Start");
      startButton.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			
    			int[] arr = createPopup(mainPanel.dropDownValues());

    			DBScanImpl db = new DBScanImpl();
    			try {
					db.onStartClick(mainPanel, arr);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
    		}
         });
      startButton.setBackground(Color.GREEN);
      menuBar.add(startButton);
      
      
      //Reset Button
      Button resetButton = new Button("Reset");
      resetButton.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			
    			mainPanel.cleanScreen();
    		}
         });
      resetButton.setBackground(Color.RED);
      menuBar.add(resetButton);
      
      
      //Random Button
      Button randomButton = new Button("Random");
      randomButton.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {

    			mainPanel.cleanScreen();
    			mainPanel.setSelectedDots(md.getRandomDots());
    			mainPanel.displaySavedDots();
    			
    		}
         });
      randomButton.setBackground(Color.CYAN);
      menuBar.add(randomButton);
      
      
      
      
      frame.setVisible(true);
   }
   
   public static int[] createPopup(String str[]) {
	   
	   int[] arr = new int[2];
	   
	   Frame jFrame = new JFrame();
       String dist = JOptionPane.showInputDialog(jFrame, "Enter Distance");
       
       arr[0] = Integer.parseInt(dist);
       
       if(arr[0] < 0) {
    	   JOptionPane.showMessageDialog(jFrame, "Distance Can not be negative");
    	   createPopup(str);
       }
     
       String getFirstDot = (String) JOptionPane.showInputDialog(
               null,
               "Which is the starting dot?",
               "Choose cordinates",
               JOptionPane.QUESTION_MESSAGE,
               null,
               str,
               null);
       
       if(getFirstDot == null || getFirstDot.length() < 1) {
    	   JOptionPane.showMessageDialog(jFrame, "Please select distance and FirstDot");
    	   createPopup(str);
       }
       
       arr[1] = Integer.parseInt(getFirstDot.split("\\)")[0]);
       
       return arr;
       
	}
   
   

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            displayScreen();
         }
      });
   }
}



