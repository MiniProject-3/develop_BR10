package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class gui_md {
	private JFrame mf = new JFrame("BR_10");
	private ImageKick kb = new ImageKick();
	
	public void md() {
		mf.setTitle("mini_BR10");
		mf.setBounds(600, 10, 600, 1000);
		mf.setLayout(null);

		ImageKickPanel panel = new ImageKickPanel(new ImageIcon("BR10_images/gui_order/bg_04.png").getImage()
				.getScaledInstance(585, 750, 3));
		panel.setLocation(0, 100);
		panel.setSize(600, 750);
		panel.setBackground(Color.WHITE);

		JPanel homePanel = new JPanel();
		homePanel.setLocation(50, 130);
		homePanel.setSize(50, 50);
		homePanel.setBackground(Color.WHITE);

		JButton butt2 = new JButton();
		butt2.setPreferredSize(new Dimension(50, 50));
		homePanel.add(butt2);
		butt2.setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_14.jpg", 45	, 45));
		butt2.setBackground(Color.WHITE);
		
		JPanel controllPanel = new JPanel();
		controllPanel.setLayout(null);
		controllPanel.setLocation(0, 750);
		controllPanel.setSize(600, 50);
		controllPanel.setBackground(new Color(255, 0, 0, 0));
		
		String[] controll = { "이전", "장바구니", "결제" };

		JButton[] butt4 = new JButton[controll.length];

		for (int i = 0; i < controll.length; i++) {
			butt4[i] = new JButton(controll[i]);
		}
		

		for (int i = 0; i < controll.length; i++) {

			controllPanel.add(butt4[i]);
		}
		
		for (int i = 0; i < butt4.length; i++) {
			butt4[i].setText("");
		}
		butt4[0].setLocation(50, 0);
		butt4[0].setSize(100, 50);
		butt4[0].setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_16.jpg", butt4[0].getWidth() , butt4[0].getHeight()));
		butt4[0].setBackground(Color.WHITE);
		butt4[1].setLocation(275, 0);
		butt4[1].setSize(50, 50);
		butt4[1].setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_19.jpg", butt4[1].getWidth() , butt4[1].getHeight()));
		butt4[1].setBackground(Color.WHITE);
		butt4[2].setLocation(450, 0);
		butt4[2].setSize(100, 50);
		butt4[2].setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_09.jpg", butt4[2].getWidth() , butt4[2].getHeight()));
		
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
		
		mf.add(homePanel);
		mf.add(mdGoods);
		mf.add(controllPanel);
		mf.add(panel);

		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
}