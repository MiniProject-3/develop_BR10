package dev.customer.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gui_drink extends JFrame {

	public JPanel drink() {
		
		JPanel drink = new JPanel();
		drink.setLocation(100, 200);
		drink.setSize(400, 500);
		drink.setLayout(new GridLayout(2, 2));

		String[] size = { "바닐라 라떼", "아메리카노", "아이스 바닐라 라떼", "아이스 아메리카노" };

		JButton[] butt = new JButton[size.length];

		for (int i = 0; i < butt.length; i++) {
			butt[i] = new JButton(size[i]);
		}

		for (int i = 0; i < butt.length; i++) {

			drink.add(butt[i]);

		}
		return drink;
	}
}