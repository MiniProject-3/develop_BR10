package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui_payment extends JPanel{
   private JFrame mf = new JFrame("BR_10");
   private ImageKick kb = new ImageKick();
   

   public Gui_payment() {
      mf.setTitle("mini_BR10");
      mf.setBounds(600, 10, 600, 1000);
      mf.setLayout(null);

      ImageKickPanel panel = new ImageKickPanel(
            new ImageIcon("BR10_images/gui_order/bg_06.jpg").getImage().getScaledInstance(600, 1000, 3));
      panel.setLocation(0, 0);
      panel.setSize(600, 1000);
      panel.setBackground(Color.WHITE);

      JPanel homePanel = new JPanel();
      homePanel.setLocation(50, 130);
      homePanel.setSize(50, 50);
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
      JPanel PaymentPanel = new JPanel();
      PaymentPanel.setLocation(125, 250);
      PaymentPanel.setSize(350, 450);
      PaymentPanel.setLayout(null);
      PaymentPanel.setBackground(Color.WHITE);

      String[] md_butt = { "기프티콘", "휴대폰 결제" };
      JButton[] butt = new JButton[md_butt.length];

      for (int i = 0; i < butt.length; i++) {
         butt[i] = new JButton(md_butt[i]);
      }

      for (int i = 0; i < butt.length; i++) {
         PaymentPanel.add(butt[i]);
      }
      butt[0].setLocation(50, 150);
      butt[0].setSize(250, 50);
      butt[1].setLocation(50, 250);
      butt[1].setSize(250, 50);

      mf.add(homePanel);
      mf.add(PaymentPanel);
      mf.add(panel);

      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mf.setVisible(true);
   }
}