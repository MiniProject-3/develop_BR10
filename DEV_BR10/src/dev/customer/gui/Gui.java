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

public class Gui extends JPanel {
	private JFrame mf = new JFrame("BR_10");
	private ImageKick kb = new ImageKick();

	public Gui(MainFrame mainFrame) {
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

		for (int i = 0; i < butt.length; i++) {
			butt[i].setText("");
			butt[i].setBackground(Color.WHITE);
		}
		
		butt[0].setIcon(kb.ImageKickButton("BR10_images/gui_order/Size_39.jpg", 100, 150));
		butt[1].setIcon(kb.ImageKickButton("BR10_images/gui_order/Size_40.jpg", 100, 150));
		butt[2].setIcon(kb.ImageKickButton("BR10_images/gui_order/Size_41.jpg", 150, 150));
		butt[3].setIcon(kb.ImageKickButton("BR10_images/gui_order/Size_42.jpg", 150, 150));
		butt[4].setIcon(kb.ImageKickButton("BR10_images/gui_order/Size_43.jpg", 150, 150));
		butt[5].setIcon(kb.ImageKickButton("BR10_images/gui_order/Size_44.jpg", 150, 150));
		
		butt3[0].addActionListener(new ActionListener() {                     // 카테고리 아이스크림

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_icecream icecream = new Gui_icecream();
				changePanel(icecream.gui_icecream());
			}

			private void changePanel(JPanel icecream) {
				mf.remove(menuSize);
				mf.add(icecream);
				mf.repaint();
			}
		});

		butt3[1].addActionListener(new ActionListener() {                        //  카테고리 아이스크림

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_cake cake = new Gui_cake();
				changePanel(cake);
			}

			private void changePanel(JPanel cake) {
				mf.remove(mf);
				mf.add(cake);
				mf.repaint();

			}
		});
		
		butt3[2].addActionListener(new ActionListener() {                        // 카테고리 아이스크림

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_cake cake = new Gui_cake();
				changePanel(cake);
			}

			private void changePanel(JPanel cake) {
				mf.remove(mf);
				mf.add(cake);
				mf.repaint();

			}
		});
		
		butt3[3].addActionListener(new ActionListener() {                        // 카테고리 아이스크림

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_cake cake = new Gui_cake();
				changePanel(cake);
			}

			private void changePanel(JPanel cake) {
				mf.remove(mf);
				mf.add(cake);
				mf.repaint();

			}
		});
		

		mf.add(menuSize);
		mf.add(categoryPanel);

	}}

