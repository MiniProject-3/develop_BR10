package dev.customer.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.manager.MainFrame;
import ui.manager.ManagerPanel;
import ui.manager.page.StockPage;

public class gui_cake extends JPanel {
	private JFrame mf = new JFrame("BR_10");
	private ImageKick kb = new ImageKick();

	public void gui_cake(MainFrame mainFrame) {
		mf.setTitle("케이크");
		mf.setBounds(600, 10, 600, 1000);
		mf.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLocation(0, 100);
		panel.setSize(600, 750);
		panel.setBackground(Color.WHITE);

		JPanel cake = new JPanel();
		cake.setLocation(100, 200);
		cake.setSize(400, 500);
		cake.setLayout(new GridLayout(2, 2));

		String[] size = { "라인언일병파티", "별빛이내린다", "아이스후르츠와츄원NO.6", "해피해피뽀로로친구들" };

		JButton[] butt = new JButton[size.length];

		for (int i = 0; i < butt.length; i++) {
			butt[i] = new JButton(size[i]);
		}

		for (int i = 0; i < butt.length; i++) {

			cake.add(butt[i]);

		}

		mf.add(cake);

		mf.add(panel);

		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}

}
