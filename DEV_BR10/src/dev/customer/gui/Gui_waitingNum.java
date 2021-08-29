package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Gui_waitingNum {
	   private JFrame mf = new JFrame("BR_10");
	   private ImageKick kb = new ImageKick();
	public void waitingNum() {
		mf.setTitle("mini_BR10");
		mf.setBounds(600, 10, 600, 1000);
		mf.setLayout(null);
		
		ImageKickPanel panel = new ImageKickPanel(
		new ImageIcon("BR10_images/gui_order/bg_06.jpg").getImage().getScaledInstance(600, 1000, 3));
		panel.setLocation(0, 0);
		panel.setSize(600, 1000);
		panel.setBackground(Color.WHITE);
		
		JPanel homePanel = new JPanel();
		homePanel.setLocation(50, 50);
		homePanel.setSize(70, 100);
		homePanel.setBackground(Color.WHITE);

		JButton butt2 = new JButton("홈버튼");
		butt2.setPreferredSize(new Dimension(50, 50));
		butt2.setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_14.jpg", 50, 50));
		homePanel.add(butt2);
		

		
		TitledBorder Tb1 = new TitledBorder(new LineBorder(Color.black, 2));

		JPanel waitingPanel = new JPanel();
		waitingPanel.setLocation(125, 250);
		waitingPanel.setSize(350, 450);
		waitingPanel.setLayout(null);
		waitingPanel.setBackground(Color.WHITE);
		waitingPanel.getBorder();
		waitingPanel.setBorder(Tb1);

		ImageKickPanel waitingPanel1 = new ImageKickPanel
				(new ImageIcon("BR10_images/waitingNum.jpg").getImage()
				.getScaledInstance(waitingPanel.getWidth() - 4, 300, 1));
		waitingPanel1.setLocation(2, 2);
		waitingPanel1.setSize(waitingPanel.getWidth()-4, 300);
		waitingPanel1.setLayout(null);
		waitingPanel.add(waitingPanel1);
		waitingPanel1.revalidate();
		
		
		
		waitingPanel.repaint();

		JButton butt = new JButton("확인");
		butt.setLocation(125, 350);
		butt.setSize(100, 50);
		butt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StartMain startMain = new StartMain();
				changePanel(startMain);
				mf.dispose();
			}
			private void changePanel(StartMain startMain) {
			}
		});
		
		waitingPanel.add(butt);
		
		panel.add(homePanel);
		panel.add(waitingPanel);

		mf.add(panel);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	
	}
}