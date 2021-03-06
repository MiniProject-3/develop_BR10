package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dev.customer.menu.MenuOrderList;
import dev.customer.model.service.CustomerService;
import dev.dto.OrderDTO;

public class Gui_md extends JFrame {
	private int SelectedNum = 0;
	private ImageKick ab = new ImageKick();
	private CustomerService Cus = new CustomerService();
	private int cusorder = Cus.selectOrderNum();

	public Gui_md() {
		this.setTitle("mini_BR10");
		this.setBounds(600, 10, 600, 1000);
		this.setLayout(null);

		ImageKickPanel mdPanel = new ImageKickPanel(
				new ImageIcon("BR10_images/gui_order/bg_04.jpg").getImage().getScaledInstance(580, 970, 3));
		mdPanel.setSize(600, 1000);
		mdPanel.setLayout(null);

		JPanel homePanel = new JPanel();

		homePanel.setLocation(50, 50);
		homePanel.setSize(50, 50);
		homePanel.setBackground(Color.WHITE);

		JButton butt2 = new JButton("홈버튼"); // 홈버튼
		butt2.setPreferredSize(new Dimension(50, 50));

		butt2.setText("");
		butt2.setIcon(ab.ImageKickButton("BR10_images/gui_order/Buttons_14.jpg", 50, 50));
		butt2.setBorderPainted(false); // 버튼 테두리 설정해제

		butt2.addActionListener(new ActionListener() { // 액션 설정
			@Override
			public void actionPerformed(ActionEvent e) {
				StartMain startMain = new StartMain();
				changePanel(startMain);
				dispose(); // 창 꺼짐
			}
			private void changePanel(StartMain startMain) {
			}
		});

		JPanel controllPanel = new JPanel();
		controllPanel.setLayout(null);
		controllPanel.setLocation(0, 50);
		controllPanel.setSize(600, 1000);
		controllPanel.setBackground(new Color(0, 0, 0, 0));

		String[] md_butt = { "핑크", "블루", "건너뛰기", "추가하기", "md상품 취소" };
		JButton[] butt = new JButton[md_butt.length];

		for (int i = 0; i < md_butt.length; i++) {
			butt[i] = new JButton(md_butt[i]);
		}
		for (int i = 0; i < md_butt.length; i++) {
			controllPanel.add(butt[i]);
		}
		for (int i = 0; i < butt.length; i++) {
			butt[i].setText("");
		}

		butt[0].setLocation(175, 350);
		butt[0].setSize(100, 100);
		butt[0].setIcon(ab.ImageKickButton("BR10_images/gui_order/md2.jpg", 100, 100));
		butt[1].setLocation(325, 350);
		butt[1].setSize(100, 100);
		butt[1].setIcon(ab.ImageKickButton("BR10_images/gui_order/md1.jpg", 100, 100));
		butt[2].setLocation(150, 550);
		butt[2].setSize(125, 40);
		butt[2].setIcon(
				ab.ImageKickButton("BR10_images/gui_order/Buttons_17.jpg", butt[2].getWidth(), butt[2].getHeight()));
		butt[3].setLocation(325, 550);
		butt[3].setSize(125, 40);
		butt[3].setIcon(
				ab.ImageKickButton("BR10_images/gui_order/Buttons_18.jpg", butt[3].getWidth(), butt[3].getHeight()));
		butt[4].setLocation(490, 120);
		butt[4].setSize(25, 25);
		butt[4].setIcon(ab.ImageKickButton("BR10_images/gui_order/Buttons_15.png", 25, 25));

		butt[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				butt[0].setIcon(ab.ImageKickButton("BR10_images/gui_order/md2_Selected.jpg", 100, 100));
				butt[1].setIcon(ab.ImageKickButton("BR10_images/gui_order/md1.jpg", 100, 100));
				repaint();
				SelectedNum = 1;
			}
		});

		butt[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				butt[1].setIcon(ab.ImageKickButton("BR10_images/gui_order/md1_Selected.jpg", 100, 100));
				butt[0].setIcon(ab.ImageKickButton("BR10_images/gui_order/md2.jpg", 100, 100));
				repaint();
				SelectedNum = 2;
			}
		});

		/* 매장포장 페이지 넘기기 */
		butt[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Gui_hereOrToGo();
				dispose(); // 창 꺼짐
			}
		});

		/* 다이얼로그 설정 */
		butt[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (SelectedNum == 0) {                                  //  미선택
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
				} else if (SelectedNum == 1) {                           //  핑크 신발선택
					OrderDTO order = new OrderDTO();
					order.setOrderSeq(MenuOrderList.orderSeq++);
					order.setProductNum(25);
					order.setOrderNum(cusorder);
					order.setQty(1);
					order.setPayment("N");
					MenuOrderList.orderList.add(MenuOrderList.orderList.size(), order);
					System.out.println(order);
					new Gui_hereOrToGo();
					dispose(); 
				} else {                                                //  블루 신발선택
					OrderDTO order = new OrderDTO();
					order.setOrderSeq(MenuOrderList.orderSeq++);
					order.setProductNum(26);
					order.setOrderNum(cusorder);
					order.setQty(1);
					order.setPayment("N");
					MenuOrderList.orderList.add(MenuOrderList.orderList.size(), order);
					System.out.println(order);
					new Gui_hereOrToGo();
					dispose(); 
				}
			}
		});

		/* md상품 취소 -> 메뉴선택화면 전환 */
		butt[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				dispose();
			}
		});

		homePanel.add(butt2);
		this.add(homePanel);
		this.add(controllPanel);
		this.add(mdPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		revalidate();
	}
}