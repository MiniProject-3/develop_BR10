package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gui_md {
	private JFrame mf = new JFrame("BR_10");

	public void md() {
		mf.setTitle("mini_BR10");
		mf.setBounds(600, 10, 600, 1000);
		mf.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLocation(0, 100);
		panel.setSize(600, 750);
		panel.setBackground(Color.WHITE);

		JPanel homePanel = new JPanel();
		homePanel.setLocation(50, 130);
		homePanel.setSize(50, 50);
		homePanel.setBackground(Color.WHITE);

		JButton butt2 = new JButton("홈버튼");
		butt2.setPreferredSize(new Dimension(50, 50));
		homePanel.add(butt2);


		JPanel controllPanel = new JPanel();
		controllPanel.setLayout(null);
		controllPanel.setLocation(0, 750);
		controllPanel.setSize(600, 50);
		controllPanel.setBackground(Color.WHITE);
		
		
		String[] controll = { "이전", "장바구니", "결제" };

		JButton[] butt4 = new JButton[controll.length];

		for (int i = 0; i < controll.length; i++) {
			butt4[i] = new JButton(controll[i]);
		}
		

		for (int i = 0; i < controll.length; i++) {

			controllPanel.add(butt4[i]);
		}
		butt4[0].setLocation(50, 0);
		butt4[0].setSize(100, 50);
		butt4[1].setLocation(275, 0);
		butt4[1].setSize(50, 50);
		butt4[2].setLocation(450, 0);
		butt4[2].setSize(100, 50);
		
		JPanel mdGoods = new JPanel();
		mdGoods.setLocation(125, 250);
		mdGoods.setSize(350, 450);
		mdGoods.setLayout(null);
		mdGoods.setBackground(Color.WHITE);

		String[] md_butt = { "핑크", "블루", "건너뛰기", "추가하기","md상품 취소" };
		JButton[] butt = new JButton[md_butt.length];

		for (int i = 0; i < butt.length; i++) {
			butt[i] = new JButton(md_butt[i]);
		}

		for (int i = 0; i < butt.length; i++) {
			mdGoods.add(butt[i]);
		}
		butt[0].setLocation(50, 200);
		butt[0].setSize(100, 100);
		butt[1].setLocation(200, 200);
		butt[1].setSize(100, 100);
		butt[2].setLocation(25, 350);
		butt[2].setSize(125, 30);
		butt[3].setLocation(200, 350);
		butt[3].setSize(125, 30);
		butt[4].setLocation(310, 15);
		butt[4].setSize(25, 25);
		
		mf.add(homePanel);
		mf.add(mdGoods);
		mf.add(controllPanel);
		mf.add(panel);

		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
}