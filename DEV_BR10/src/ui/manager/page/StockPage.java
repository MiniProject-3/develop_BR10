package ui.manager.page;

import static dev.common.JDBCTemplate.close;
import static dev.common.JDBCTemplate.getConnection;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dev.customer.gui.ImageKick;
import dev.dto.PayDTO;
import dev.dto.ProductDTO;
import dev.manager.model.dao.ManagerDAO;
import ui.manager.MainFrame;
import ui.manager.ManagerPanel;

public class StockPage extends JPanel{
	private MainFrame mf;
	private ImageKick kb = new ImageKick();
	private LineBorder line = new LineBorder(Color.black);
	private JTable stockTable;
	private JPanel viewPanel = new JPanel();
	
	// 첫 화면 생성자
	public StockPage(MainFrame mainFrame) {
		JPanel pan = new JPanel();
		this.mf = mainFrame;
		
		this.setSize(600,1000);
		this.setBackground(Color.white);
		
		viewPanel(pan, 1);
		BackButton();
		CategoryButton();
		
		viewMoney();
	}
	
	// 교체시 보여질 화면 생성자
	public StockPage(MainFrame mainFrame, int num) {
		JPanel pan = new JPanel();
		this.mf = mainFrame;
		
		this.setSize(600,1000);
		this.setBackground(Color.white);
		
		viewPanel(pan, num);
		BackButton();
		CategoryButton();
		
		viewMoney();
	}

	public void viewPanel(JPanel panel, int num) {
		panel.setSize(500, 700);
		panel.setLocation(40, 140);
		panel.setBorder(line);
		panel.setBackground(Color.white);
		
		createTable(panel,num);
		
		this.add(panel);
	}
	
	public void createTable(JPanel panel, int num) {
		String header[] = {"메뉴명", "기존재고", "판매량", "잔량"};
		DefaultTableModel model = new DefaultTableModel(header, 0);
		stockTable = new JTable(model);
		JScrollPane pane = new JScrollPane(stockTable);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);
		
		addTable(model, num);
		stockTable.getColumnModel().getColumn(0).setPreferredWidth(130);
		stockTable.getColumn("기존재고").setCellRenderer(center);
		stockTable.getColumn("판매량").setCellRenderer(center);
		stockTable.getColumn("잔량").setCellRenderer(center);
		
		pane.setLocation(10, 10);
		pane.setSize(480, 680);
		
		panel.add(pane);
	}

	
	public void CategoryButton() {
		JButton ice = new JButton("아이스크림");
		
		ice.setLocation(40,100);
		ice.setSize(100,40);
		ice.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 1;
				StockPage md = new StockPage(mf, num);
				changePanel(md);
			}
		});
		
		JButton cake = new JButton("케이크");
		
		cake.setLocation(140,100);
		cake.setSize(100,40);
		cake.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 2;
				StockPage md = new StockPage(mf, num);
				changePanel(md);
			}
		});
		
		JButton dessert = new JButton("디저트");
		
		dessert.setLocation(240,100);
		dessert.setSize(100,40);
		dessert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 3;
				StockPage md = new StockPage(mf, num);
				changePanel(md);
				
			}
		});
		
		JButton drink = new JButton("음료");
		
		drink.setLocation(340,100);
		drink.setSize(100,40);
		drink.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 4;
				StockPage md = new StockPage(mf, num);
				changePanel(md);				
			}
		});
		
		JButton md = new JButton("MD");
		
		md.setLocation(440,100);
		md.setSize(100,40);
		md.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 5;
				StockPage md = new StockPage(mf, num);
				changePanel(md);
			}
		});
		
		this.add(ice);
		this.add(cake);
		this.add(dessert);
		this.add(drink);
		this.add(md);
		
	}
	
	public void addTable(DefaultTableModel model, int num) {
		
		ManagerDAO managerDAO = new ManagerDAO();
		Connection con = getConnection();
		List<ProductDTO> productList = managerDAO.selectAllProducts(con);
		
		for (ProductDTO product : productList) {
			if (num == 1 && product.getCategoryCode() == 1) {
				String name = product.getProductName();
				String preStock = product.getStock() + "";
				String sellnum = null;
				String stocknum = null;
				if (!("".equals(product.getPayment())) || !(product.getPayment() == null)) {
					sellnum = product.getQty() + "";
					stocknum = (product.getStock() - product.getQty()) + "";
				}
				String[] mix = {name, preStock, sellnum, stocknum};
				model.addRow(mix);
			} else if (num == 2 && product.getCategoryCode() == 2) {
				String name = product.getProductName();
				String preStock = product.getStock() + "";
				String sellnum = null;
				String stocknum = null;
				if (!("".equals(product.getPayment())) || !(product.getPayment() == null)) {
					sellnum = product.getQty() + "";
					stocknum = (product.getStock() - product.getQty()) + "";
				}
				String[] mix = {name, preStock, sellnum, stocknum};
				model.addRow(mix);
			} else if (num == 3 && product.getCategoryCode() == 3) {
				String name = product.getProductName();
				String preStock = product.getStock() + "";
				String sellnum = null;
				String stocknum = null;
				if (!("".equals(product.getPayment())) || !(product.getPayment() == null)) {
					sellnum = product.getQty() + "";
					stocknum = (product.getStock() - product.getQty()) + "";
				}
				String[] mix = {name, preStock, sellnum, stocknum};
				model.addRow(mix);
			} else if (num == 4 && product.getCategoryCode() == 4) {
				String name = product.getProductName();
				String preStock = product.getStock() + "";
				String sellnum = null;
				String stocknum = null;
				if (!("".equals(product.getPayment())) || !(product.getPayment() == null)) {
					sellnum = product.getQty() + "";
					stocknum = (product.getStock() - product.getQty()) + "";
				}
				String[] mix = {name, preStock, sellnum, stocknum};
				model.addRow(mix);
			} else if (num == 5 && product.getCategoryCode() == 5) {
				String name = product.getProductName();
				String preStock = product.getStock() + "";
				String sellnum = null;
				String stocknum = null;
				if (!("".equals(product.getPayment())) || !(product.getPayment() == null)) {
					sellnum = product.getQty() + "";
					stocknum = (product.getStock() - product.getQty()) + "";
				}
				String[] mix = {name, preStock, sellnum, stocknum};
				model.addRow(mix);
			}
		}
		close(con);
	}
	
	public void viewMoney() {
		Font font = new Font("맑은 고딕", Font.BOLD, 15);
		int money = 0; 
		Date today = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yy/MM/dd");
		String formay = sim.format(today);
		
		ManagerDAO managerDAO = new ManagerDAO();
		Connection con = getConnection();
		List<PayDTO> payList = managerDAO.selectAllPays(con);
		for (PayDTO payDTO : payList) {
			// 일일 매출을 위한 조건문 (당일 매출만 표시)
			if (payDTO.getPayTime().equals(formay)) {
			money += payDTO.getPayTotal();
			}
		}
		
		close(con);
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
		back.setSize(100,70);
		back.setBorderPainted(false);
		
		back.setIcon(kb.ImageKickButton("BR10_images/Back.jpg", 100, 70));
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerPanel managerPanel = new ManagerPanel(mf);
				changePanel(managerPanel);
			}
		});
		this.add(back);
	}
		
	public void changePanel(JPanel panel) {
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}
	
}
