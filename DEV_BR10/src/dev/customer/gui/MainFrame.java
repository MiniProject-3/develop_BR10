package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private ImageKick kb = new ImageKick();
	public MainFrame() {
		this.setTitle("mini_BR10");
		this.setBounds(600, 10, 600, 1000);
		this.setLayout(null);


		ImageKickPanel panel = new ImageKickPanel(
		new ImageIcon("BR10_images/gui_order/bg_06.jpg").getImage().getScaledInstance(600, 1000, 3));
		panel.setSize(600, 1000);
		
		JPanel homePanel = new JPanel();
		homePanel.setLocation(50, 50);
		homePanel.setSize(70, 100);
		homePanel.setBackground(Color.WHITE);

		JButton butt2 = new JButton("홈버튼");          //  홈버튼
		butt2.setPreferredSize(new Dimension(50, 50));
		homePanel.add(butt2);
		butt2.setText("");
		butt2.setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_14.jpg", 50, 50));
		butt2.setBorderPainted(false); // 버튼 테두리 설정해제
		
		butt2.addActionListener(new ActionListener() {  //액션 설정
			@Override
			public void actionPerformed(ActionEvent e) {
				StartMain startMain = new StartMain();
				changePanel(startMain);
				dispose(); //창 꺼짐 
			}
			private void changePanel(StartMain startMain) {
			}
		});
		
		JPanel controllPanel = new JPanel();
		controllPanel.setLayout(null);
		controllPanel.setLocation(0, 750);
		controllPanel.setSize(600, 50);
		controllPanel.setBackground(new Color(255, 0, 0, 0));

		String[] controll = { "이전", "장바구니", "결제" };
		
		JButton[] butt4 = new JButton[controll.length];
		for (int i = 0; i < controll.length; i++) {
			butt4[i] = new JButton(controll[i]);
		}
		for (int i = 0; i < controll.length; i++) {
			controllPanel.add(butt4[i]);
		}
		for (int i = 0; i < butt4.length; i++) {
			butt4[i].setText("");
		}
		butt4[0].setLocation(50, 0);
		butt4[0].setSize(100, 50);
		butt4[0].setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_16.jpg", 100, 50));
		butt4[0].setBorderPainted(false); // 버튼 테두리 설정해제	
		butt4[1].setLocation(275, 0);
		butt4[1].setSize(50, 50);
		butt4[1].setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_19.jpg", 50, 50));
		butt4[1].setBorderPainted(false); // 버튼 테두리 설정해제	
		butt4[2].setLocation(450, 0);
		butt4[2].setSize(100, 50);
		butt4[2].setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_09.jpg", 100, 50));
		butt4[2].setBorderPainted(false); // 버튼 테두리 설정해제	
		
		/* 이전 버튼 연결 */
		butt4[0].addActionListener(new ActionListener() {  //액션 설정
			@Override
			public void actionPerformed(ActionEvent e) {
				StartMain startMain = new StartMain();
				changePanel(startMain);
				dispose();
			}
			private void changePanel(StartMain startMain) {
			}
		});
		
//		/* 장바구니에 연결 */
//		butt4[1].addActionListener(new ActionListener() {  
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				StartMain startMain = new StartMain();
//				changePanel(startMain);
//				dispose();
//			}
//			private void changePanel(StartMain startMain) {
//			}
//		});
		/* 결제버튼 연결 */ //md 페이지로 이동
		butt4[2].addActionListener(new ActionListener() {  
			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_md gui_md = new Gui_md();
				changePanel(gui_md);
//				dispose();
				
			}
			private void changePanel(Gui_md gui_md) {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(homePanel);
		panel.add(controllPanel);

		new Gui(this);
		this.add(panel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		revalidate();
	}

}
