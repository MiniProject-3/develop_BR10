package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui_hereOrToGo extends JPanel {
   private JFrame mf = new JFrame("BR_10");
   private ImageKick kb = new ImageKick();

   public Gui_hereOrToGo() {
      mf.setTitle("mini_BR10");
      mf.setBounds(600, 10, 600, 1000);
      mf.setLayout(null);

      ImageKickPanel panel = new ImageKickPanel(
      new ImageIcon("BR10_images/gui_order/bg_06.jpg").getImage().getScaledInstance(600, 1000, 3));
      panel.setLocation(0, 0);
      panel.setSize(600, 1000);
      panel.setBackground(Color.WHITE);

      JPanel controllPanel = new JPanel();
      controllPanel.setLayout(null);
      controllPanel.setLocation(0, 750);
      controllPanel.setSize(600, 50);
      controllPanel.setBackground(new Color(255, 0, 0, 0));

      JPanel homePanel = new JPanel();
      homePanel.setLocation(50, 50);
      homePanel.setSize(70, 100);
      homePanel.setBackground(Color.WHITE);

      JButton butt2 = new JButton("홈버튼");
      butt2.setPreferredSize(new Dimension(50, 50));
      butt2.setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_14.jpg", 50, 50));
      homePanel.add(butt2);

      butt2.addActionListener(new ActionListener() { // 액션 설정
         @Override
         public void actionPerformed(ActionEvent e) {
            new StartMain();
            mf.dispose(); // 창 꺼짐
         }
      });

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
      butt4[0].setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_16.jpg", 100, 50));
      butt4[0].setBorderPainted(false); // 버튼 테두리 설정해제
      butt4[0].addActionListener(new ActionListener() { // 액션 설정
         @Override
         public void actionPerformed(ActionEvent e) {
            new Gui_md();
            mf.dispose(); // 창 꺼짐
         }
      });

      String[] hg = { "매장", "포장" };
      JButton[] butt = new JButton[hg.length];

      for (int i = 0; i < butt.length; i++) {
         butt[i] = new JButton(hg[i]);
      }
      for (int i = 0; i < butt.length; i++) {
         panel.add(butt[i]);
      }
      butt[0].setLocation(175, 400);
      butt[0].setSize(110, 100);
      butt[1].setLocation(325, 400);
      butt[1].setSize(110, 100);
      butt[0].setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_13.jpg", 110, 150));
      butt[1].setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_10.jpg", 110, 150));
      
      
      butt[0].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Take_In takein = new Take_In();
            changePanel(takein);
         }
      private void changePanel(Take_In takein) {
         // TODO Auto-generated method stub
      }
      });

      butt[1].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Take_Out takeout = new Take_Out();
            changePanel(takeout);
         }
         private void changePanel(Take_Out takeout) {
         }
      });

      butt[0].setText("");
      butt[1].setText("");
      panel.add(homePanel);
      panel.add(controllPanel);
      mf.add(panel);
      mf.setVisible(true);
      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}