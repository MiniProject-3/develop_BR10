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

public class Gui_md extends JFrame {
	
	private ImageKick ab = new ImageKick();
	public Gui_md() {
		this.setTitle("mini_BR10");
		this.setBounds(600, 10, 600, 1000);
		this.setLayout(null);
	
		ImageKickPanel mdPanel = new ImageKickPanel(
		new ImageIcon("BR10_images/gui_order/bg_04.png").getImage().getScaledInstance(580, 970, 3));
		mdPanel.setSize(600, 1000);
	    
		JPanel mdGoods = new JPanel();
		mdGoods.setLocation(0, 100);
		mdGoods.setSize(600, 700);
		mdGoods.setBackground(Color.WHITE);

		JButton butt2 = new JButton("홈버튼");          //  홈버튼
		butt2.setPreferredSize(new Dimension(50, 50));
		mdGoods.add(butt2);
		butt2.setText("");
		butt2.setIcon(ab.ImageKickButton("BR10_images/gui_order/Buttons_14.jpg", 50, 50));
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
		
		String[] md_butt = { "핑크", "블루", "건너뛰기", "추가하기", "md상품 취소"};
		JButton[] butt = new JButton[md_butt.length];

		for (int i = 0; i < md_butt.length; i++) {
			butt[i] = new JButton(md_butt[i]);
		}

		for (int i = 0; i < md_butt.length; i++) {
			mdGoods.add(butt[i]);
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
		butt[2].setSize(125, 30);
		butt[2].setIcon(ab.ImageKickButton("BR10_images/gui_order/Buttons_17.jpg", butt[2].getWidth() , butt[2].getHeight()));
		butt[3].setLocation(325, 550);
		butt[3].setSize(125, 30);
		butt[3].setIcon(ab.ImageKickButton("BR10_images/gui_order/Buttons_18.jpg", butt[3].getWidth() , butt[3].getHeight()));
		butt[4].setLocation(490, 120);
		butt[4].setSize(25, 25);
		butt[4].setIcon(ab.ImageKickButton("BR10_images/gui_order/Buttons_15.png", 25, 25));
//		butt[4].setText("");
//		butt[4].setBackground(new Color(255, 0, 0, 0));
		
		/*다이얼로그 설정*/ 
		butt[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
//				dispose();
//				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		mdPanel.add(mdGoods);
		
		this.add(mdPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		revalidate();
	}
}