package dev.customer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dev.customer.model.service.CustomerService;
import dev.dto.OrderDTO;
import dev.dto.PayDTO;
import dev.dto.ProductDTO;
import dev.manager.controller.ManagerController;

public class Gui_basket extends JFrame {

	private JFrame mf = new JFrame("BR_10");
	private ImageKick kb = new ImageKick();

	public void Gui_basket() {
		mf.setTitle("mini_BR10");
		mf.setBounds(600, 10, 600, 1000);
		mf.setLayout(null);

		ImageKickPanel panel = new ImageKickPanel(
		new ImageIcon("BR10_images/gui_order/bg_06.jpg").getImage().getScaledInstance(600, 1000, 3));
		panel.setSize(600, 1000);
		panel.setBackground(Color.WHITE);

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

		JPanel controllPanel = new JPanel();
		controllPanel.setLayout(null);
		controllPanel.setLocation(0, 750);
		controllPanel.setSize(600, 50);
		controllPanel.setBackground(new Color(255, 0, 0, 0));

		String[] controll = { "이전", "결제" };

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
		butt4[1].setLocation(450, 0);
		butt4[1].setSize(100, 50);
		butt4[1].setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_09.jpg", 100, 50));
		butt4[1].setBorderPainted(false); // 버튼 테두리 설정해제

		butt4[0].addActionListener(new ActionListener() { // 액션 설정
			@Override
			public void actionPerformed(ActionEvent e) {
				new StartMain();
				mf.dispose(); // 창 꺼짐
			}
		});

		butt4[1].addActionListener(new ActionListener() { // 액션 설정
			@Override
			public void actionPerformed(ActionEvent e) {
				new Gui_md();
				mf.dispose(); // 창 꺼짐
			}
		});
		createTable(panel);

		panel.add(homePanel);
		panel.add(controllPanel);

		mf.add(panel);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
	
	public void createTable(JPanel panel) {
		String header[] = {"메뉴명", "갯수", "금액"};
		DefaultTableModel model = new DefaultTableModel(header, 0);
		JTable stockTable = new JTable(model);
		JScrollPane pane = new JScrollPane(stockTable);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
	    center.setHorizontalAlignment(JLabel.CENTER);
		
	    stockTable.getColumn("갯수").setCellRenderer(center);
	    
		pane.setLocation(100, 200);
		pane.setSize(400, 500);
		
		panel.add(pane);
	}
}
