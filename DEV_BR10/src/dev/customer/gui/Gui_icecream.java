package dev.customer.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.manager.MainFrame;

public class Gui_icecream extends JPanel {
	private ImageKick kb = new ImageKick();

	public JPanel gui_icecream() {

		JPanel icecream = new JPanel();
		icecream.setLocation(150, 300);
		icecream.setSize(300, 400);
		icecream.setLayout(new GridLayout(4, 3));

		String[] size = { "바람과함께보여지다", "민트초코칩", "피스타아몽드", "제주녹차티", "아빠도외계인", "체리마루", "쿠키앤크림", "사과민트", "바나나꿀단지", "자모카모카",
				"이상한왕국의솜사탕", "베리베리빨간베리" };

		JButton[] butt = new JButton[size.length];

		for (int i = 0; i < butt.length; i++) {
			butt[i] = new JButton(size[i]);
		}

		for (int i = 0; i < butt.length; i++) {

			icecream.add(butt[i]);

		}
		
		int j = 25;
		for (int i = 0; i < butt.length; i++) {
			
			butt[i].setIcon(kb.ImageKickButton("BR10_images/gui_order/flavor_" + j + ".jpg", 100, 100));
			j++;
		}
		

		butt[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		butt[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		}); // 장바구니

		butt[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		}); // 장바구니
		
		return icecream;

	}
}