package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		this.setTitle("mini_BR10");
		this.setBounds(600, 10, 600, 1000);
		this.setLayout(null);
		
		
		ImageKickPanel panel = new ImageKickPanel(
				new ImageIcon("BR10_images/gui_order/bg_06.jpg").getImage().getScaledInstance(600, 1000, 3));
		panel.setSize(600, 1000);
		
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
		
		panel.add(homePanel);
		panel.add(controllPanel);
		this.add(panel);
		
		new gui(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
