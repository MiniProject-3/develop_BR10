package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui_hereOrToGo {
	public JPanel hotg() {

		JPanel hgPanel = new JPanel();
		hgPanel.setLocation(125, 250);
		hgPanel.setSize(350, 450);
		hgPanel.setLayout(null);

		String[] hg = { "매장", "포장" };
		JButton[] butt = new JButton[hg.length];

		for (int i = 0; i < butt.length; i++) {
			butt[i] = new JButton(hg[i]);
		}

		for (int i = 0; i < butt.length; i++) {
			hgPanel.add(butt[i]);
		}
		
		butt[0].setLocation(60, 150);
		butt[0].setSize(100, 100);
		butt[1].setLocation(190, 150);
		butt[1].setSize(100, 100);
		
		return hgPanel;

	}
}