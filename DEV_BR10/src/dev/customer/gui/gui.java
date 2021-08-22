package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gui extends JPanel {
	private JFrame mf = new JFrame("BR_10");
	private ImageKick kb = new ImageKick();

	public void OrderSize() {
		mf.setTitle("mini_BR10");
		mf.setBounds(600, 10, 600, 1000);
		mf.setLayout(null);

		ImageKickPanel panel = new ImageKickPanel(new ImageIcon("BR10_images/gui_order/bg_06.jpg").getImage()
				.getScaledInstance(585, 750, 3));
		panel.setLocation(0, 100);
		panel.setSize(600, 750);
		
		
		
		

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
		categoryPanel.setBackground(new Color(255, 0, 0, 0));

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
		controllPanel.setBackground(new Color(255, 0, 0, 0));

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

		butt4[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		}); // 이전

		butt4[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		}); // 장바구니

		butt4[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gui mdPanel = new gui();
				changePanel(mdPanel);
			}

			private void changePanel(JPanel mdPanel) {
				mf.remove(mf);
				mf.add(mdPanel);
				mf.repaint();
			}

		}); // 결제

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

		butt3[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gui_icecream icecream = new gui_icecream(mf);
				changePanel(icecream);
			}
			private void changePanel(JPanel icecream) {
				mf.remove(menuSize);
				mf.add(icecream);
				mf.repaint();
			}
		});

		butt3[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gui_cake cake = new gui_cake();
				changePanel(cake);
			}

			private void changePanel(JPanel cake) {
				mf.remove(mf);
				mf.add(cake);
				mf.repaint();

			}
		});

		butt3[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gui_desert desert = new gui_desert();
			}
		});

		butt3[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gui drink = new gui();
				changePanel(drink);
			}
			
			private void changePanel(JPanel drink) {
				mf.remove(mf);
				mf.add(drink);
				mf.repaint();
			}
		});

		butt[0].setIcon(kb.ImageKickButton("BR10_images/a_single.png", 150, 150));

		mf.add(categoryPanel);
		mf.add(homePanel);
		mf.add(menuSize);
		mf.add(controllPanel);
		mf.add(panel);

		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}

}