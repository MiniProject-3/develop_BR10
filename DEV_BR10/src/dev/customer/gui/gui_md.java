package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class gui_md {
	private ImageKick kb = new ImageKick();
	
	public JPanel md() {

		ImageKickPanel mdPanel = new ImageKickPanel(new ImageIcon("BR10_images/gui_order/bg_04.png").getImage()
				.getScaledInstance(585, 750, 3));
		mdPanel.setLocation(0, 0);
		mdPanel.setSize(600, 1000);
		mdPanel.setBackground(Color.WHITE);

		JPanel mdGoods = new JPanel();
		mdGoods.setLocation(0, 100);
		mdGoods.setSize(600, 700);
		mdGoods.setLayout(null);
		mdGoods.setBackground(new Color(255, 0, 0, 0));

		String[] md_butt = { "핑크", "블루", "건너뛰기", "추가하기", "md상품 취소"};
		JButton[] butt = new JButton[md_butt.length];

		for (int i = 0; i < butt.length; i++) {
			butt[i] = new JButton(md_butt[i]);
		}

		for (int i = 0; i < butt.length; i++) {
			mdGoods.add(butt[i]);
		}
		for (int i = 0; i < butt.length; i++) {
			butt[i].setText("");
		}
		
		butt[0].setLocation(175, 350);
		butt[0].setSize(100, 100);
		butt[0].setIcon(kb.ImageKickButton("BR10_images/gui_order/md2.jpg", 100, 100));
		butt[1].setLocation(325, 350);
		butt[1].setSize(100, 100);
		butt[1].setIcon(kb.ImageKickButton("BR10_images/gui_order/md1.jpg", 100, 100));
		butt[2].setLocation(150, 550);
		butt[2].setSize(125, 30);
		butt[2].setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_17.jpg", butt[2].getWidth() , butt[2].getHeight()));
		butt[3].setLocation(325, 550);
		butt[3].setSize(125, 30);
		butt[3].setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_18.jpg", butt[3].getWidth() , butt[3].getHeight()));
		butt[4].setLocation(490, 120);
		butt[4].setSize(25, 25);
		butt[4].setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_15.png", 25, 25));
		butt[4].setText("");
		butt[4].setBackground(new Color(255, 0, 0, 0));
		
		return mdPanel;
	}
}