package dev.customer.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dev.customer.menu.MenuOrderList;
import dev.dto.OrderDTO;
import ui.manager.MainFrame;

public class Gui_icecream extends JPanel {
	private ImageKick kb = new ImageKick();
	int ice = 0;
	public JPanel gui_icecream(int ice) {
		this.ice = ice;
		JPanel icecream = new JPanel();
		icecream.setLocation(125, 250);
		icecream.setSize(350, 450);
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
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(1);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("Y");
				MenuOrderList.orderList.add(order);
			}
		});

		butt[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(2);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		}); 
		butt[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(3);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
		butt[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(4);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
		butt[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(5);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
		butt[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(6);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
		butt[6].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(7);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
		butt[7].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(8);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
		butt[8].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(9);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
		butt[9].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(10);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
		butt[10].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(11);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
		butt[11].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(12);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
		return icecream;
	}
}