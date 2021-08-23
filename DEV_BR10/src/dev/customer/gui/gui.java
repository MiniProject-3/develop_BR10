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

	public gui(MainFrame mainFrame) {
		this.mf = mainFrame;
		mf.setTitle("mini_BR10");
		mf.setBounds(600, 10, 600, 1000);
		mf.setLayout(null);
		
		this.orderPanel();
		
		mf.add(this);
		
	}
		
		public void orderPanel () {
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

		butt[0].setIcon(kb.ImageKickButton("BR10_images/a_single.png", 150, 150));

		mf.add(menuSize);
		mf.add(categoryPanel);

	}}

