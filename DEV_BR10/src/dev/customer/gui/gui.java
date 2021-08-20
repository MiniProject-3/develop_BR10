package dev.customer.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gui {
	   private JFrame mf = new JFrame("BR_10");
	   public void OrderSize() {
		  mf.setTitle("mini_BR10");
	      mf.setBounds(600, 10, 600, 1000);
	      mf.setLayout(null);
	      
	      JPanel panel = new JPanel();
	      panel.setLocation(0, 100);
	      panel.setSize(700,750);
	      panel.setBackground(Color.WHITE);
	      
	      JPanel menuSize = new JPanel();
	      menuSize.setLocation(100, 200);
	      menuSize.setSize(400, 500);
	      menuSize.setLayout(new GridLayout(3,2));
	      
	      
	      String[] size = { "싱글콘", "더블콘", "파인트", "쿼터", "패밀리", "하프갤런"};
	      
	      JButton[] butt = new JButton[size.length];
	      
	      
	      for (int i = 0; i < butt.length; i++) {
	    	  butt[i] = new JButton(size[i]);
			}
	      
	      for (int i = 0; i < butt.length; i++) {

	    	  menuSize.add(butt[i]);

			}
	      
	      
	      mf.add(menuSize);
	      
	      
	      mf.add(panel);
	      
	      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      mf.setVisible(true);
}
}