package dev.customer.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gui_desert {

	public JPanel desert() {
		JPanel desert = new JPanel();
		desert.setLocation(100, 200);
		desert.setSize(400, 500);
		desert.setLayout(new GridLayout(2, 2));

		String[] size = { "아이스 롤 케이크 체리초코", "아이스 모찌 바나나킥", "아이스 모찌 초코 바닐라", "아이스크림 롤 바닐라" };

		JButton[] butt = new JButton[size.length];

		for (int i = 0; i < butt.length; i++) {
			butt[i] = new JButton(size[i]);
		}

		for (int i = 0; i < butt.length; i++) {

			desert.add(butt[i]);

		}
		return desert;

	}
}