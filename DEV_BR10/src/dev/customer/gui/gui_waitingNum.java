package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class gui_waitingNum {
	private JFrame mf = new JFrame("BR_10");

	public void waitingNum() {
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

		TitledBorder Tb1 = new TitledBorder(new LineBorder(Color.black, 2)) ;
		
		JPanel waitingPanel = new JPanel();
		waitingPanel.setLocation(125, 250);
		waitingPanel.setSize(350, 450);
		waitingPanel.setLayout(null);
		waitingPanel.setBackground(Color.WHITE);
		waitingPanel.getBorder();
		waitingPanel.setBorder(Tb1);

		
		JButton butt = new JButton("확인");
		butt.setLocation( 125, 350);
		butt.setSize(100, 50);
		waitingPanel.add(butt);
		
		
		mf.add(homePanel);
		mf.add(waitingPanel);
		mf.add(panel);

		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
}