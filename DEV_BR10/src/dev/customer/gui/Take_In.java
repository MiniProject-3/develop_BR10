package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Take_In{
	private JFrame mf = new JFrame("BR_10");
	private ImageKick kb = new ImageKick();
	
	public void Take_In() {
		mf.setTitle("mini_BR10");
		mf.setBounds(600, 10, 600, 1000);
		mf.setLayout(null);
		
		ImageKickPanel panel = new ImageKickPanel(
				new ImageIcon("BR10_images/gui_order/bg_06.jpg").getImage().getScaledInstance(600, 1000, 3));
		panel.setLocation(0, 0);
		panel.setSize(600, 1000);
		panel.setBackground(Color.WHITE);
		
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
				
			}
			private void changePanel(StartMain startMain) {
			}
		});
		
		JPanel Back = new JPanel();
		Back.setLocation(-200,750);
		Back.setSize(600, 50);
		Back.setBackground(new Color(255, 0, 0, 0));
		
		JButton butt3 = new JButton("이전");          //  이전버튼
		butt3.setPreferredSize(new Dimension(100, 45));
		Back.add(butt3);
		butt3.setText("");
		butt3.setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_16.jpg", 100, 50));
		butt3.setBorderPainted(false); // 버튼 테두리 설정해제
		     
		JLabel label1 = new JLabel("숟가락");
		label1.setLocation(100, 400);
		label1.setSize(150, 50);
		label1.setOpaque(true); 
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setBackground(Color.pink);
		
		JLabel label2 = new JLabel("초");
		label2.setLocation(100, 550);
		label2.setSize(150, 50);
		label2.setOpaque(true); 
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setBackground(Color.pink);
		
		JLabel label3 = new JLabel("매장");
		label3.setLocation(100, 200);
		label3.setSize(50, 50);
		label3.setOpaque(true); 
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setBackground(Color.pink);
		
		SpinnerNumberModel spoon = new SpinnerNumberModel(0, 0, 10, 1);
		
		JSpinner spinner1 = new JSpinner(spoon);
		spinner1.setLocation(330, 400);
		spinner1.setSize(150, 50);
		
		
		SpinnerNumberModel candle = new SpinnerNumberModel(0, 0, 10, 1);
		
		JSpinner spinner2 = new JSpinner(candle);
		spinner2.setLocation(330, 550);
		spinner2.setSize(150, 50);
				
		mf.add(Back);
		mf.add(homePanel);
		mf.add(label1);
		mf.add(label2);
		mf.add(label3);
		mf.add(spinner1);
		mf.add(spinner2);
		mf.add(panel);
		
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
		
	}

}
