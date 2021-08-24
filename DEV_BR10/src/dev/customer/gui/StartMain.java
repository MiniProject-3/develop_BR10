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

	