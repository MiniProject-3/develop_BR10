package dev.customer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StartMain extends JFrame  { 
	
	private ImageKick sm = new ImageKick();
	
	public StartMain() {
		this.setTitle("mini_BR10");
		this.setBounds(600, 10, 600, 1000);
		this.setLayout(null);
	
		ImageKickPanel SMpanel = new ImageKickPanel(
				new ImageIcon("BR10_images/OrderMain_pack.jpg").getImage().getScaledInstance(600, 1000, 3));
		SMpanel.setSize(600, 1000);
		
		String[] controll = {""};
		JButton[] butt1 = new JButton[controll.length];
		for (int i = 0; i < controll.length; i++) {
			butt1[i] = new JButton(controll[i]);
		}
		for (int i = 0; i < controll.length; i++) {
			SMpanel.add(butt1[i]);
		}
		butt1[0].setLocation(0,0); 
		butt1[0].setSize(600, 1000);
		butt1[0].setIcon(sm.ImageKickButton("BR10_images/OrderMain_pack.jpg", 620, 1030));
		butt1[0].setBorderPainted(false); // 버튼 테두리 설정해제
		
		butt1[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = new MainFrame();
				 changePanel(mainFrame);
				 dispose();
			}

			private void changePanel(MainFrame mainFrame) {
				
			}
		});

		add(SMpanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		revalidate();
		
	
	}	
}	

	

//	JFrame frame;
//	JPanel main_panel; 
//	JButton bt_img;
//	
//
//	public StartMain() {
//		setTitle("mini_BR10"); // 프레임 타이틀바 텍스트 지정
//		setSize(600,1000); // 프레임 크기 조정(픽셀)
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		main_panel = new JPanel(); // 패널 객체화 
//		main_panel.setBackground(Color.WHITE); // 패널 배경색 하얀색으로 설정
//		ImageIcon img = new ImageIcon("BR10_images/gui_order/OrderMain_pack.jpg");
//		bt_img = new JButton(img);
//		bt_img.setBorderPainted(false); // 버튼 테두리 설정해제
////		bt_img.setSize(600,1000);
//		bt_img.setPreferredSize(new Dimension(600, 1000)); // 버튼 크기 지정
//		
//		main_panel.add(bt_img); // 패널에 버튼을 붙이는 작업
//		add(main_panel); // 메인 프레임에 메인패널을 붙여주는 작업
//		setVisible(true); // 프레임 보이게 하기
//		bt_img.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				MainFrame mainFrame = new MainFrame(); //연결
//				frame.dispose();
//			}
//		});
//	}
//	public static void main(String[] args) {
//		new StartMain();	
//	}
//}