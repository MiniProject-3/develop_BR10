package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Gui_point extends JFrame {

	private JFrame mf = new JFrame("BR_10");
	private ImageKick kb = new ImageKick();
	private JPanel jpa = null;

	public void point() {
		mf.setTitle("mini_BR10");
		mf.setBounds(600, 10, 600, 1000);
		mf.setLayout(null);

		ImageKickPanel panel = new ImageKickPanel(
				new ImageIcon("BR10_images/gui_order/bg_06.jpg").getImage().getScaledInstance(600, 1000, 3));
		panel.setLocation(0, 0);
		panel.setSize(600, 1000);
		panel.setBackground(Color.WHITE);

		JPanel homePanel = new JPanel(); // 홈버튼 패널
		homePanel.setLocation(50, 50);
		homePanel.setSize(70, 100);
		homePanel.setBackground(Color.WHITE);

		JButton butt2 = new JButton("홈버튼");
		butt2.setPreferredSize(new Dimension(50, 50));
		butt2.setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_14.jpg", 50, 50));
		homePanel.add(butt2);

		TitledBorder Tb = new TitledBorder(new LineBorder(Color.black, 2));
		TitledBorder Tb2 = new TitledBorder(new LineBorder(Color.gray, 4));

		JPanel giftPanel = new JPanel(); // 기프티콘 패널
		giftPanel.setBorder(Tb);
		giftPanel.setLocation(150, 300);
		giftPanel.setSize(300, 400);
		giftPanel.setBackground(Color.WHITE);
		giftPanel.setLayout(null);

		JPanel repeat = new JPanel();
		repeat.setLocation(75, 75);
		repeat.setSize(300, 400);
		repeat.setBackground(Color.WHITE);
		repeat.setLayout(null);

		Font font = new Font("맑은 고딕", Font.PLAIN, 30);
		Font font2 = new Font("맑은 고딕", Font.PLAIN, 30);

		JLabel giftLabel = new JLabel("<html><pre>  포인트 번호를    <br>    입력하세요</pre> </html>");
		giftLabel.setBounds(2, 2, 290, 200);
		giftLabel.setFont(font);

		JPasswordField  giftNum = new JPasswordField (20); // 포인트 번호
		giftNum.setBounds(50, 200, 200, 50);
		giftNum.setBorder(Tb2);
		giftNum.setFont(font2);
		giftNum.setText(null);
		giftPanel.add(giftLabel);
		giftPanel.add(giftNum);

		JButton butt3 = new JButton("확인"); // 확인버튼
		butt3.setBounds(50, 300, 100, 50);
		butt3.setBorder(Tb);
		butt3.setFont(font);
		butt3.setBackground(Color.WHITE);

		JButton butt4 = new JButton("취소"); // 취소버튼
		butt4.setBounds(150, 300, 100, 50);
		butt4.setBorder(Tb);
		butt4.setFont(font);
		butt4.setBackground(Color.WHITE);
		giftPanel.add(butt3);
		giftPanel.add(butt4);

		butt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!giftNum.getText().equals("01092880100")) {
					JOptionPane.showMessageDialog(null, "미등록 번호입니다.");
					giftNum.setText("");
					giftNum.requestFocus();
				} else {
					
					JOptionPane.showMessageDialog(null, "100p 적립 예정입니다.");
					Gui_gifticon Gcon = new Gui_gifticon();
					Gcon.gift();
					mf.dispose();
				}
			}
		});

		butt4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Gui_gifticon Gcon = new Gui_gifticon();
				   Gcon.gift();
				   mf.dispose();
					}
				});

		panel.add(giftPanel);
		panel.add(homePanel);
		mf.add(panel);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
}
