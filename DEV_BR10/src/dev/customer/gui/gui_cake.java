package dev.customer.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gui_cake {
	 private JFrame mf = new JFrame("BR_10");
	   public void cake() {
		  mf.setTitle("케이크");
	      mf.setBounds(600, 10, 600, 1000);
	      mf.setLayout(null);
	      
	      JPanel panel = new JPanel();
	      panel.setLocation(0, 100);
	      panel.setSize(700,750);
	      panel.setBackground(Color.WHITE);
	      
	      JPanel cake = new JPanel();
	      cake.setLocation(100, 200);
	      cake.setSize(400, 500);
	      cake.setLayout(new GridLayout(2,2));
	      
	      
	      String[] size = {"라인언일병파티", "별빛이내린다", "아이스후르츠와츄원NO.6", "해피해피뽀로로친구들"};
	      
	      JButton[] butt = new JButton[size.length];
	      
	      
	      for (int i = 0; i < butt.length; i++) {
	    	  butt[i] = new JButton(size[i]);
			}
	      
	      for (int i = 0; i < butt.length; i++) {

	    	  cake.add(butt[i]);

			}
	      
	      
	      mf.add(cake);
	      
	      
	      mf.add(panel);
	      
	      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      mf.setVisible(true);
	   }
}
