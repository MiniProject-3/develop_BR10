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

		TitledBorder Tb1 = new TitledBorder(new LineBorder(Color.black, 2));

		JPanel waitingPanel = new JPanel();
		waitingPanel.setLocation(125, 250);
		waitingPanel.setSize(350, 450);
		waitingPanel.setLayout(null);
		waitingPanel.setBackground(Color.WHITE);
		waitingPanel.getBorder();
		waitingPanel.setBorder(Tb1);

		ImageKickPanel waitingPanel1 = new ImageKickPanel(new ImageIcon("BR10_images/waitingNum.jpg").getImage()
				.getScaledInstance(waitingPanel.getWidth() - 4, 300, 4));
		waitingPanel1.setLocation(2, 2);
		waitingPanel1.setSize(waitingPanel.getWidth(), 500);
		waitingPanel1.setLayout(null);

		waitingPanel.add(waitingPanel1);

		JButton butt = new JButton("확인");
		butt.setLocation(125, 350);
		butt.setSize(100, 50);
		waitingPanel.add(butt);

		mf.add(homePanel);
		mf.add(waitingPanel);
		mf.add(panel);

		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
}

class ImageKickPanel extends JPanel {

	private Image img;

	public ImageKickPanel(Image img) {

		this.img = img;
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
