package dev.customer.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dev.customer.menu.MenuOrderList;
import dev.customer.model.service.CustomerService;
import dev.dto.OrderDTO;

public class Gui_desert {
   private ImageKick kb = new ImageKick();
	private CustomerService Cus = new CustomerService();
	private int cusorder = Cus.selectOrderNum();

   public JPanel gui_desert() {
      JPanel desert = new JPanel();
      desert.setLocation(125, 250);
      desert.setSize(350, 450);
      desert.setLayout(new GridLayout(2, 2));

      String[] size = { "아이스 롤 케이크 체리초코", "아이스 모찌 바나나킥", "아이스 모찌 초코 바닐라", "아이스크림 롤 바닐라" };
      JButton[] butt = new JButton[size.length];

      for (int i = 0; i < butt.length; i++) {
         butt[i] = new JButton(size[i]);
      }

      for (int i = 0; i < butt.length; i++) {
         desert.add(butt[i]);
      }
  	for (int i = 0; i < butt.length; i++) {
		butt[i].setText("");
		butt[i].setBackground(Color.WHITE);
	}
      /*디저트 이미지 추가 */
      butt[0].setIcon(kb.ImageKickButton("BR10_images/gui_order/Dessert_24.jpg", 150, 150));
      butt[1].setIcon(kb.ImageKickButton("BR10_images/gui_order/Dessert_21.jpg", 150, 150));
      butt[2].setIcon(kb.ImageKickButton("BR10_images/gui_order/Dessert_23.jpg", 150, 150));
      butt[3].setIcon(kb.ImageKickButton("BR10_images/gui_order/Dessert_22.jpg", 150, 150));
      butt[0].addActionListener(new ActionListener() { // 액션 설정
		@Override
		public void actionPerformed(ActionEvent e) {

			OrderDTO order = new OrderDTO();
			order.setOrderSeq(MenuOrderList.orderSeq++);
			order.setProductNum(20);
			order.setOrderNum(cusorder);
			order.setQty(1);
			order.setPayment("N");
			MenuOrderList.orderList.add(MenuOrderList.orderList.size(), order);
			System.out.println(order);
		
		}
	});

	butt[1].addActionListener(new ActionListener() { // 액션 설정
		@Override
		public void actionPerformed(ActionEvent e) {

			OrderDTO order = new OrderDTO();
			order.setOrderSeq(MenuOrderList.orderSeq++);
			order.setProductNum(17);
			order.setOrderNum(cusorder);
			order.setQty(1);
			order.setPayment("N");
			MenuOrderList.orderList.add(MenuOrderList.orderList.size(), order);
			System.out.println(order);

		}
	});

	butt[2].addActionListener(new ActionListener() { // 액션 설정
		@Override
		public void actionPerformed(ActionEvent e) {

			OrderDTO order = new OrderDTO();
			order.setOrderSeq(MenuOrderList.orderSeq++);
			order.setProductNum(19);
			order.setOrderNum(cusorder);
			order.setQty(1);
			order.setPayment("N");
			MenuOrderList.orderList.add(MenuOrderList.orderList.size(), order);
			System.out.println(order);
		}
	});

	butt[3].addActionListener(new ActionListener() { // 액션 설정
		@Override
		public void actionPerformed(ActionEvent e) {

			OrderDTO order = new OrderDTO();
			order.setOrderSeq(MenuOrderList.orderSeq++);
			order.setProductNum(18);
			order.setOrderNum(cusorder);
			order.setQty(1);
			order.setPayment("N");
			MenuOrderList.orderList.add(MenuOrderList.orderList.size(), order);
			System.out.println(order);

		}
	});
      return desert;
   }
}