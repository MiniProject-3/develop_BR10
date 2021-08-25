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
	private JPanel main = null;
	public Gui(MainFrame mainFrame) {
		this.mf = mainFrame;
		mf.setTitle("mini_BR10");
		mf.setBounds(600, 10, 600, 1000);
		mf.setLayout(null);
		
		this.orderPanel();
		
		mf.add(this);
		revalidate();
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

		main = new JPanel();
		main.setLocation(125, 250);
		main.setSize(350, 450);
		main.setLayout(new GridLayout(3, 2));

		String[] size = { "싱글콘", "더블콘", "파인트", "쿼터", "패밀리", "하프갤런" };
		JButton[] butt = new JButton[size.length];

		for (int i = 0; i < butt.length; i++) {
			butt[i] = new JButton(size[i]);
		}

		for (int i = 0; i < butt.length; i++) {
			main.add(butt[i]);
		}

		for (int i = 0; i < butt.length; i++) {
			butt[i].setText("");
			butt[i].setBackground(Color.WHITE);
		}
		
		butt[0].setIcon(kb.ImageKickButton(
				"BR10_images/gui_order/Size_39.jpg", 100, 150));
		butt[1].setIcon(kb.ImageKickButton(
				"BR10_images/gui_order/Size_40.jpg", 100, 150));
		butt[2].setIcon(kb.ImageKickButton(
				"BR10_images/gui_order/Size_41.jpg", 150, 150));
		butt[3].setIcon(kb.ImageKickButton(
				"BR10_images/gui_order/Size_42.jpg", 150, 150));
		butt[4].setIcon(kb.ImageKickButton(
				"BR10_images/gui_order/Size_43.jpg", 150, 150));
		butt[5].setIcon(kb.ImageKickButton(
				"BR10_images/gui_order/Size_44.jpg", 150, 150));
		
		/*아이스크림 사이즈 선택 시 아이스크림 맛 선택으로 이동 */
		butt[0].addActionListener(new ActionListener() {                        

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_icecream icecream = new Gui_icecream();
				changePanel(icecream.gui_icecream());
			}

			private void changePanel(JPanel icecream) {
				mf.remove(main);
				main = icecream;
				mf.add(main);
				revalidate();

			}
		});
		
		butt[1].addActionListener(new ActionListener() {                        

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_icecream icecream = new Gui_icecream();
				changePanel(icecream.gui_icecream());
			}

			private void changePanel(JPanel icecream) {
				mf.remove(main);
				main = icecream;
				mf.add(main);
				revalidate();	
			}
		});
		
		butt[2].addActionListener(new ActionListener() {                        

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_icecream icecream = new Gui_icecream();
				changePanel(icecream.gui_icecream());
			}

			private void changePanel(JPanel icecream) {
				mf.remove(main);
				main = icecream;
				mf.add(main);
				revalidate();
			}
		});
		
		butt[4].addActionListener(new ActionListener() {                        

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_icecream icecream = new Gui_icecream();
				changePanel(icecream.gui_icecream());
			}

			private void changePanel(JPanel icecream) {
				mf.remove(main);
				main = icecream;
				mf.add(main);
				revalidate();
			}
		});
		
		butt[5].addActionListener(new ActionListener() {                        

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_icecream icecream = new Gui_icecream();
				changePanel(icecream.gui_icecream());
			}

			private void changePanel(JPanel icecream) {
				mf.remove(main);
				main = icecream;
				mf.add(main);
				revalidate();
			}
		});
		
		butt[3].addActionListener(new ActionListener() {                        

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_icecream icecream = new Gui_icecream();
				changePanel(icecream.gui_icecream());
			}

			private void changePanel(JPanel icecream) {
				mf.remove(main);
				main = icecream;
				mf.add(main);
				revalidate();
			}
		});
		
		/* 메뉴 카테고리 선택 시 각 카테고리 별 메뉴 선택으로 넘어감 */		
		butt3[0].addActionListener(new ActionListener() {                       

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_icecream icecream = new Gui_icecream();
				changePanel(icecream.gui_icecream());
			}

			private void changePanel(JPanel icecream) {
				mf.remove(main);
				main = icecream;
				mf.add(main);
				revalidate();
			}
		});

		butt3[1].addActionListener(new ActionListener() {                       

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_cake cake = new Gui_cake();
				changePanel(cake.gui_cake());
			}

			private void changePanel(JPanel cake) {
				mf.remove(main);
				main = cake;
				mf.add(main);
				revalidate();
			}
		});
		
		butt3[2].addActionListener(new ActionListener() {                       

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_desert desert = new Gui_desert();
				changePanel(desert.gui_desert());
			}

			private void changePanel(JPanel desert) {
				mf.remove(main);
				main = desert;
				mf.add(main);
				revalidate();
			}
		});
		
		butt3[3].addActionListener(new ActionListener() {                        

			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_drink drink = new Gui_drink();
				changePanel(drink.gui_drink());
			}

			private void changePanel(JPanel drink) {
				mf.remove(main);
				main = drink;
				mf.add(main);
				revalidate();
			}
		});
		

		mf.add(main);
		mf.add(categoryPanel);

	}}

