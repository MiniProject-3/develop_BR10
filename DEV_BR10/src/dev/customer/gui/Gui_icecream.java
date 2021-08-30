package dev.customer.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dev.customer.menu.MenuOrderList;
import dev.customer.model.service.CustomerService;
import dev.dto.OrderDTO;

public class Gui_icecream extends JPanel {
	private CustomerService Cus = new CustomerService();
	private int cusorder = Cus.selectOrderNum();
	private ImageKick kb = new ImageKick();
	int iceSize = 0;
	int i = 0;

	public JPanel gui_icecream(int ice) {
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

		for (i = 0; i < butt.length; i++) {                                       //    아이스크림 선택 제한
			int ProductNumber = i + 1;
			butt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (ice > iceSize) {
						OrderDTO order = new OrderDTO();
						order.setOrderSeq(MenuOrderList.orderSeq++);
						order.setProductNum(ProductNumber);
						order.setOrderNum(cusorder);
						order.setQty(1);
						order.setPayment("N");
						MenuOrderList.orderList.add(MenuOrderList.orderList.size(), order);
						System.out.println(order);
						iceSize++;
						System.out.println(iceSize);
					} else {
						JOptionPane.showMessageDialog(null, "이미" + ice + "가지 맛 모두를 선택하셨습니다.", "경고",
								JOptionPane.WARNING_MESSAGE);
					}

				}
			});
		}

		return icecream;
	}
}