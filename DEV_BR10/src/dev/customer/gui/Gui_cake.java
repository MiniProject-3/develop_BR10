package dev.customer.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.manager.MainFrame;
import ui.manager.ManagerPanel;
import ui.manager.page.StockPage;

public class Gui_cake extends JPanel {
   private JFrame mf = new JFrame("BR_10");
   private ImageKick kb = new ImageKick();

   public JPanel gui_cake() {

      JPanel cake = new JPanel();
      cake.setLocation(125, 250);
      cake.setSize(350, 450);
      cake.setLayout(new GridLayout(2, 2));

      String[] size = { "라인언일병파티", "별빛이내린다", "아이스후르츠와츄원NO.6", "해피해피뽀로로친구들" };

      JButton[] butt = new JButton[size.length];

      for (int i = 0; i < butt.length; i++) {
         butt[i] = new JButton(size[i]);
      }
      for (int i = 0; i < butt.length; i++) {
         cake.add(butt[i]);
      }
      
  	for (int i = 0; i < butt.length; i++) {
		butt[i].setText("");
		butt[i].setBackground(Color.WHITE);
	}
      /* 케이크 이미지 추가 */
      butt[0].setIcon(kb.ImageKickButton("BR10_images/gui_order/Cake_19.jpg", 200, 200));
      butt[1].setIcon(kb.ImageKickButton("BR10_images/gui_order/Cake_20.jpg", 200, 200));
      butt[2].setIcon(kb.ImageKickButton("BR10_images/gui_order/Cake_18.jpg", 200, 200));
      butt[3].setIcon(kb.ImageKickButton("BR10_images/gui_order/Cake_17.jpg", 200, 200));
      
      return cake;
   }
}