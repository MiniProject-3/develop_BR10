package dev.customer.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gui_desert {
	private JFrame mf = new JFrame("BR_10");
	   public void desert() {
		  mf.setTitle("디저트");
	      mf.setBounds(600, 10, 600, 1000);
	      mf.setLayout(null);
	      
	      JPanel panel = new JPanel();
	      panel.setLocation(0, 100);
	      panel.setSize(700,750);
	      panel.setBackground(Color.WHITE);
	      
	      JPanel desert = new JPanel();
	      desert.setLocation(100, 200);
	      desert.setSize(400, 500);
	      desert.setLayout(new GridLayout(2,2));
	      
	      
	      String[] size = {"아이스 롤 케이크 체리초코", "아이스 모찌 바나나킥", "아이스 모찌 초코 바닐라", "아이스크림 롤 바닐라"};
	      
	      JButton[] butt = new JButton[size.length];
	      
	      
	      for (int i = 0; i < butt.length; i++) {
	    	  butt[i] = new JButton(size[i]);
			}
	      
	      for (int i = 0; i < butt.length; i++) {

	    	  desert.add(butt[i]);

			}
	      
	      
	      mf.add(desert);
	      
	      
	      mf.add(panel);
	      
	      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      mf.setVisible(true);
	   }
}