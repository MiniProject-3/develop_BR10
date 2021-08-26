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

public class Take_Out{
   private JFrame mf = new JFrame("BR_10");
   private ImageKick kb = new ImageKick();
   private JPanel main = null;

   
   public void Take_Out() {
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

      JButton butt2 = new JButton("Ȩ��ư");          //  Ȩ��ư
      butt2.setPreferredSize(new Dimension(50, 50));
      homePanel.add(butt2);
      butt2.setText("");
      butt2.setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_14.jpg", 50, 50));
      butt2.setBorderPainted(false); // ��ư �׵θ� ��������
      
      butt2.addActionListener(new ActionListener() {  //�׼� ����
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
      
      JButton butt3 = new JButton("����");          //  ������ư
      butt3.setPreferredSize(new Dimension(100, 45));
      Back.add(butt3);
      butt3.setText("");
      butt3.setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_16.jpg", 100, 50));
      butt3.setBorderPainted(false); // ��ư �׵θ� ��������
      
//      butt3.addActionListener(new ActionListener() {  //�׼� ����
//         @Override
//         public void actionPerformed(ActionEvent e) {
//        	 Gui_md gui = new Gui_md();
//            changePanel(gui);
//         }
//         private void changePanel(StartMain startMain) {
//         }
//      });
      
      JPanel Pay = new JPanel();
      Pay.setLocation(200,750);
      Pay.setSize(600, 50);
      Pay.setBackground(new Color(255, 0, 0, 0));
      
      JButton butt4 = new JButton("����");          //  ������ư
      butt4.setPreferredSize(new Dimension(100, 45));
      Pay.add(butt4);
      butt4.setText("");
      butt4.setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_09.jpg", 100, 50));
      butt4.setBorderPainted(false); // ��ư �׵θ� ��������
      
      butt4.addActionListener(new ActionListener() {  //�׼� ����
         @Override
         public void actionPerformed(ActionEvent e) {
            Gui_payment payment = new Gui_payment();
            changePanel(payment);
         }
         private void changePanel(Gui_payment payment) {
            mf.remove(panel);
            main.add(payment);
         }
      });
               
      JLabel label1 = new JLabel("�ҿ�ð�");
      label1.setLocation(100, 350);
      label1.setSize(150, 50);
      label1.setOpaque(true); 
      label1.setHorizontalAlignment(JLabel.CENTER);
      label1.setBackground(Color.pink);
      
      JLabel label2 = new JLabel("������");
      label2.setLocation(100, 500);
      label2.setSize(150, 50);
      label2.setOpaque(true); 
      label2.setHorizontalAlignment(JLabel.CENTER);
      label2.setBackground(Color.pink);
      
      JLabel label3 = new JLabel("��");
      label3.setLocation(100, 650);
      label3.setSize(150, 50);
      label3.setOpaque(true); 
      label3.setHorizontalAlignment(JLabel.CENTER);
      label3.setBackground(Color.pink);
      
      JLabel label4 = new JLabel("����");
      label4.setLocation(100, 200);
      label4.setSize(50, 50);
      label4.setOpaque(true); 
      label4.setHorizontalAlignment(JLabel.CENTER);
      label4.setBackground(Color.pink);
      
      SpinnerNumberModel time = new SpinnerNumberModel(0, 0, 60, 10);
      
      JSpinner spinner1 = new JSpinner(time);
      spinner1.setLocation(330, 350);
      spinner1.setSize(150, 50);
      
      
      SpinnerNumberModel spoon = new SpinnerNumberModel(0, 0, 10, 1);
      
      JSpinner spinner2 = new JSpinner(spoon);
      spinner2.setLocation(330, 500);
      spinner2.setSize(150, 50);
      
      SpinnerNumberModel candle = new SpinnerNumberModel(0, 0, 10, 1);
      
      JSpinner spinner3 = new JSpinner(candle);
      spinner3.setLocation(330, 650);
      spinner3.setSize(150, 50);
            
      mf.add(Back);
      mf.add(Pay);
      mf.add(homePanel);
      mf.add(label1);
      mf.add(label2);
      mf.add(label3);
      mf.add(label4);
      mf.add(spinner1);
      mf.add(spinner2);
      mf.add(spinner3);
      mf.add(panel);
      
      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mf.setVisible(true);
      
   }

}