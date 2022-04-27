package DBScan;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Button;


public class App {
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



