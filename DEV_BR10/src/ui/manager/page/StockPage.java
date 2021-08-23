package ui.manager.page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dev.customer.gui.ImageKick;
import ui.manager.MainFrame;
import ui.manager.ManagerPanel;

public class StockPage extends JPanel{
	private MainFrame mf;
	private ImageKick kb = new ImageKick();
	private LineBorder line = new LineBorder(Color.black);
	
	public StockPage(MainFrame mainFrame) {
		this.mf = mainFrame;
		
		this.setSize(600,1000);
		this.setBackground(Color.white);
		
		BackButton();
		CategoryButton();
		viewPanel();
		viewMoney();
	}
	
	public void viewPanel() {
		JPanel viewPanel1 = new JPanel();
		viewPanel1.setSize(500, 700);
		viewPanel1.setLocation(40, 140);
		viewPanel1.setBorder(line);
		viewPanel1.setBackground(Color.white);
		
		createTable(viewPanel1);
		
		this.add(viewPanel1);
	}
	
	public void createTable(JPanel panel) {
		String header[] = {"메뉴명", "기존재고", "판매량", "잔량"};
		DefaultTableModel model = new DefaultTableModel(header, 0);
		JTable stockTable = new JTable(model);
		JScrollPane pane = new JScrollPane(stockTable);
		
		pane.setLocation(10, 10);
		pane.setSize(480, 680);
		
		panel.add(pane);
	}

	public void viewMoney() {
		Font font = new Font("맑은 고딕", Font.BOLD, 15);
		String money = "0"; // 정산 값 가져와야함
		
		JLabel moneyText = new JLabel("일일매출");
		JLabel moneyLabel = new JLabel("￦ " + money);
		
		moneyLabel.setLocation(450, 860);
		moneyLabel.setSize(100, 50);
		moneyLabel.setFont(font);
		moneyText.setSize(100, 50);
		moneyText.setLocation(450,835);
		moneyText.setFont(font);
		
		this.add(moneyText);
		this.add(moneyLabel);
	}
	
	public void BackButton() {
		JButton back = new JButton();
		back.setLocation(40,850);
		back.setSize(100,50);
		back.setBorderPainted(false);
		
		back.setIcon(kb.ImageKickButton("BR10_images/Back.jpg", 100, 50));
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerPanel managerPanel = new ManagerPanel(mf);
				changePanel(managerPanel);
			}
		});
		this.add(back);
	}
	
	public void CategoryButton() {
		JButton ice = new JButton("아이스크림");
		
		ice.setLocation(40,100);
		ice.setSize(100,40);
		
		JButton cake = new JButton("케이크");
		
		cake.setLocation(140,100);
		cake.setSize(100,40);
		
		JButton dessert = new JButton("디저트");
		
		dessert.setLocation(240,100);
		dessert.setSize(100,40);
		
		JButton drink = new JButton("음료");
		
		drink.setLocation(340,100);
		drink.setSize(100,40);
		
		JButton md = new JButton("MD");
		
		md.setLocation(440,100);
		md.setSize(100,40);
		
		this.add(ice);
		this.add(cake);
		this.add(dessert);
		this.add(drink);
		this.add(md);
		
	}
		
	public void changePanel(JPanel panel) {
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}
}
