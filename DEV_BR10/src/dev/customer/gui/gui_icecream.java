package dev.customer.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gui_icecream {
	 private JFrame mf = new JFrame("BR_10");
	   public void Icecream() {
		  mf.setTitle("아이스크림 맛");
	      mf.setBounds(600, 10, 600, 1000);
	      mf.setLayout(null);
	      
	      JPanel panel = new JPanel();
	      panel.setLocation(0, 100);
	      panel.setSize(700,750);
	      panel.setBackground(Color.WHITE);
	      
	      JPanel icecream = new JPanel();
	      icecream.setLocation(100, 200);
	      icecream.setSize(400, 500);
	      icecream.setLayout(new GridLayout(4,3));
	      
	      
	      String[] size = {"바람과함께보여지다", "민트초코칩", "피스타아몽드", "제주녹차티", "아빠도외계인", "체리마루", "쿠키앤크림", "사과민트", "바나나꿀단지", "자모카모카", "이상한왕국의솜사탕", "베리베리빨간베리"};
	      
	      JButton[] butt = new JButton[size.length];
	      
	      
	      for (int i = 0; i < butt.length; i++) {
	    	  butt[i] = new JButton(size[i]);
			}
	      
	      for (int i = 0; i < butt.length; i++) {

	    	  icecream.add(butt[i]);

			}
	      
	      
	      mf.add(icecream);
	      
	      
	      mf.add(panel);
	      
	      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      mf.setVisible(true);
	   }
}