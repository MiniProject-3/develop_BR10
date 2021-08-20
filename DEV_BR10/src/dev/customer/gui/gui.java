package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
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
		panel.setSize(600, 750);
		panel.setBackground(Color.WHITE);

		JPanel homePanel = new JPanel();
		homePanel.setLocation(50, 130);
		homePanel.setSize(50, 50);
		homePanel.setBackground(Color.WHITE);

		JButton butt2 = new JButton("홈버튼");
		butt2.setPreferredSize(new Dimension(50, 50));
		homePanel.add(butt2);

		JPanel categoryPanel = new JPanel();
		categoryPanel.setLocation(0, 200);
		categoryPanel.setSize(600, 50);
		categoryPanel.setBackground(Color.WHITE);

		String[] category = { "아이스크림", "케이크", "디저트", "음료" };

		JButton[] butt3 = new JButton[category.length];

		for (int i = 0; i < butt3.length; i++) {
			butt3[i] = new JButton(category[i]);
		}

		for (int i = 0; i < butt3.length; i++) {

			categoryPanel.add(butt3[i]);

		}

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
		
		JPanel menuSize = new JPanel();
		menuSize.setLocation(125, 250);
		menuSize.setSize(350, 450);
		menuSize.setLayout(new GridLayout(3, 2));

		String[] size = { "싱글콘", "더블콘", "파인트", "쿼터", "패밀리", "하프갤런" };
		JButton[] butt = new JButton[size.length];

		for (int i = 0; i < butt.length; i++) {
			butt[i] = new JButton(size[i]);
		}

		for (int i = 0; i < butt.length; i++) {
			menuSize.add(butt[i]);
		}

		mf.add(categoryPanel);
		mf.add(homePanel);
		mf.add(menuSize);
		mf.add(controllPanel);
		mf.add(panel);

		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
}