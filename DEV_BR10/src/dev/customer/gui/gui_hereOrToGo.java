package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gui_hereOrToGo {
	private JFrame mf = new JFrame("BR_10");

	public void hotg() {
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
		
		JPanel controllPanel2 = new JPanel();
		controllPanel2.setLayout(null);
		controllPanel2.setLocation(0, 750);
		controllPanel2.setSize(600, 50);
		controllPanel2.setBackground(Color.WHITE);

		
		String[] controll = { "이전", "장바구니", "결제", "이전" };

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
		butt4[3].setLocation(50, 0);
		butt4[3].setSize(100, 50);
		
		controllPanel2.add(butt4[3]);
		
		JPanel hgPanel = new JPanel();
		hgPanel.setLocation(125, 250);
		hgPanel.setSize(350, 450);
		hgPanel.setLayout(null);
//		hgPanel.setBackground(Color.WHITE);

		String[] hg = { "매장", "포장"};
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

		
		mf.add(homePanel);
		mf.add(hgPanel);
//		mf.add(controllPanel);
		mf.add(controllPanel2);
		mf.add(panel);

		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
}