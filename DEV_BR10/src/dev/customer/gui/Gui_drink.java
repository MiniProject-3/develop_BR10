package dev.customer.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.customer.menu.MenuOrderList;
import dev.dto.OrderDTO;

public class Gui_drink extends JFrame {
   private ImageKick kb = new ImageKick();

   public JPanel gui_drink() {
      
      JPanel drink = new JPanel();
      drink.setLocation(125, 250);
      drink.setSize(350, 450);
      drink.setLayout(new GridLayout(2, 2));

      String[] size = { "바닐라 라떼", "아메리카노", "아이스 바닐라 라떼", "아이스 아메리카노" };
      JButton[] butt = new JButton[size.length];

      for (int i = 0; i < butt.length; i++) {
         butt[i] = new JButton(size[i]);
      }
      for (int i = 0; i < butt.length; i++) {
         drink.add(butt[i]);
      }
		for (int i = 0; i < butt.length; i++) {
			butt[i].setText("");
			butt[i].setBackground(Color.WHITE);
		}
      /* 음료 이미지 추가 */
      butt[0].setIcon(kb.ImageKickButton("BR10_images/gui_order/beverage_03.jpg", 150, 150));
      butt[1].setIcon(kb.ImageKickButton("BR10_images/gui_order/beverage_01.jpg", 150, 150));
      butt[2].setIcon(kb.ImageKickButton("BR10_images/gui_order/beverage_04.jpg", 150, 150));
      butt[3].setIcon(kb.ImageKickButton("BR10_images/gui_order/beverage_02.jpg", 150, 150));
      
      butt[0].addActionListener(new ActionListener() {  //액션 설정
			@Override
			public void actionPerformed(ActionEvent e) {
			
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(21);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
      
      butt[1].addActionListener(new ActionListener() {  //액션 설정
			@Override
			public void actionPerformed(ActionEvent e) {
			
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(22);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
      
      butt[2].addActionListener(new ActionListener() {  //액션 설정
			@Override
			public void actionPerformed(ActionEvent e) {
			
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(23);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
      
      butt[3].addActionListener(new ActionListener() {  //액션 설정
			@Override
			public void actionPerformed(ActionEvent e) {
			
				OrderDTO order = new OrderDTO();
//				order.setOrderSeq();
				order.setProductNum(24);
//				order.setOrderNum();
				order.setQty(1);
				order.setPayment("N");
				MenuOrderList.orderList.add(order);
			}
		});
      
      return drink;
   }
}