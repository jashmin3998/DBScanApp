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
   
  
   
   

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            displayScreen();
         }
      });
   }
}



