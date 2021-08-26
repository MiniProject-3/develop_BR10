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

public class QR extends JFrame {
	private ImageKick qr = new ImageKick();
	public QR() {
		this.setTitle("mini_BR10");
		this.setBounds(600, 10, 600, 1000);
		this.setLayout(null);


		ImageKickPanel panel = new ImageKickPanel(
		new ImageIcon("BR10_images/QR.jpg").getImage().getScaledInstance(600, 1000, 3));
		panel.setSize(600, 1000);
		
		JPanel homePanel = new JPanel();
		homePanel.setLocation(50, 50);
		homePanel.setSize(70, 100);
		homePanel.setBackground(Color.WHITE);

		JButton butt2 = new JButton("홈버튼");          //  홈버튼
		butt2.setPreferredSize(new Dimension(50, 50));
		homePanel.add(butt2);
		butt2.setText("");
		butt2.setIcon(qr.ImageKickButton("BR10_images/gui_order/Buttons_14.jpg", 50, 50));
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
		JPanel homePanel2 = new JPanel();
		homePanel2.setLocation(140, 350);
		homePanel2.setSize(300, 300);
		homePanel2.setBackground(Color.WHITE);
		
		JButton butt3 = new JButton("QR");          //  QR버튼
		butt3.setPreferredSize(new Dimension(300, 300));
		homePanel2.add(butt3);
		butt3.setText("");
		butt3.setIcon(qr.ImageKickButton("BR10_images/QR_1.jpg", 300, 300));
		butt3.setBorderPainted(false); // 버튼 테두리 설정해제
		
		 /*다이얼로그 설정*/ 
	      butt3.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
//	            dispose();
//	            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         }
	      });
	      
	     /*다음으로 이동 버튼(포인트번호페이지)*/ 
		JPanel homePanel3 = new JPanel();
			   homePanel3.setLocation(210, 755);
			   homePanel3.setSize(350, 70);
			   homePanel3.setBackground(Color.white);
			   
			JButton butt7 = new JButton("공백");          //공백 버튼
			butt7.setPreferredSize(new Dimension(350, 70));
			homePanel3.add(butt7);
			butt7.setText("");
			butt7.setIcon(qr.ImageKickButton("BR10_images/White.jpg", 350, 70));
			butt7.setBorderPainted(false); // 버튼 테두리 설정해제
			
		/*다이얼로그 설정*/ 
		    butt7.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    JOptionPane.showMessageDialog(null, "ㅎㅎㅎㅎㅎ숨어 있지롱~~ :>");
//		     dispose();
//		     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		         }
		      });
		
		JPanel controllPanel = new JPanel();
		controllPanel.setLayout(null);
		controllPanel.setLocation(0, 750);
		controllPanel.setSize(600, 50);
		controllPanel.setBackground(new Color(255, 0, 0, 0));

		String[] controll = { "이전" };
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
		butt4[0].setIcon(qr.ImageKickButton("BR10_images/gui_order/Buttons_16.jpg", 100, 50));
		butt4[0].setBorderPainted(false); // 버튼 테두리 설정해제	
		
		/* 이전 버튼 연결(결제 수단선택) */
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

		panel.add(homePanel);
		panel.add(controllPanel);
		panel.add(homePanel2);
		panel.add(homePanel3);

		this.add(panel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		revalidate();
	}

}