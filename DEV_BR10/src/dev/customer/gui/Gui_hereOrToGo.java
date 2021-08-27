package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui_hereOrToGo extends JPanel{
   private JFrame mf = new JFrame("BR_10");
   private JPanel main = null;
   public JPanel Gui_hereOrToGo(MainFrame mainFrame) {
      this.mf = mainFrame;
      JPanel hgPanel = new JPanel();
      hgPanel.setLocation(125, 250);
      hgPanel.setSize(350, 450);
      hgPanel.setLayout(null);

      String[] hg = { "매장", "포장" };
      JButton[] butt = new JButton[hg.length];

      for (int i = 0; i < butt.length; i++) {
         butt[i] = new JButton(hg[i]);
      }

      for (int i = 0; i < butt.length; i++) {
         hgPanel.add(butt[i]);
      }
      
      butt[0].setLocation(60, 150);
      butt[0].setSize(100, 100);
      butt[1].setLocation(190, 150);
      butt[1].setSize(100, 100);
      
      butt[0].addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            Take_In takein = new Take_In();
            changePanel(takein);
         }

         private void changePanel(Take_In takein) {
            
         }
      });
      
      butt[1].addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            Take_Out takeout = new Take_Out();
            changePanel(takeout);
         }

         private void changePanel(Take_Out takeout) {
            
         }
      });
      
      
      
      this.add(hgPanel);
      return hgPanel;

   }
}