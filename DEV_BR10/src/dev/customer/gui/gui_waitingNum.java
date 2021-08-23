package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class gui_waitingNum {

	public JPanel waitingNum() {



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
				.getScaledInstance(waitingPanel.getWidth() - 4, 300, 4));
		waitingPanel1.setLocation(2, 2);
		waitingPanel1.setSize(waitingPanel.getWidth(), 500);
		waitingPanel1.setLayout(null);

		waitingPanel.add(waitingPanel1);

		JButton butt = new JButton("확인");
		butt.setLocation(125, 350);
		butt.setSize(100, 50);
		waitingPanel.add(butt);
		
		return waitingPanel;



	}
}