package ui.manager.page;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dev.customer.gui.ImageKick;
import dev.customer.model.dao.CustomerDAO;
import dev.customer.model.service.CustomerService;
import dev.dto.OrderDTO;
import dev.dto.PayDTO;
import dev.dto.ProductDTO;
import dev.manager.controller.ManagerController;
import ui.manager.MainFrame;
import ui.manager.ManagerPanel;

public class JournalPage extends JPanel{
	private MainFrame mf;
	private ImageKick kb = new ImageKick();
	private LineBorder line = new LineBorder(Color.black);
	private int row;
	public JournalPage() {}
	public JournalPage(MainFrame mainFrame) {
		this.mf = mainFrame;
		
		this.setSize(600,1000);
		this.setBackground(Color.white);
		
		BackButton();
		viewPanel();
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
		String header[] = {"결제번호", "결제시간", "총결제금액", "결제수단"};
		DefaultTableModel model = new DefaultTableModel(header, 0);
		JTable stockTable = new JTable(model);
		JScrollPane pane = new JScrollPane(stockTable);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
	    center.setHorizontalAlignment(JLabel.CENTER);
		
	    stockTable.getColumn("결제번호").setCellRenderer(center);
	    stockTable.getColumn("총결제금액").setCellRenderer(center);
	    stockTable.getColumn("결제수단").setCellRenderer(center);
	    
	    addTable(model, stockTable);
	    
		pane.setLocation(10, 10);
		pane.setSize(480, 680);
		
		panel.add(pane);
	}
	
	// 테이블 내부 값 넣기
	public void addTable(DefaultTableModel model,JTable stockTable) {
		ManagerController manage = new ManagerController();
		CustomerService cus = new CustomerService();
		
		List<PayDTO> jounal = manage.selectAllPays();
		List<OrderDTO> order = cus.selectOrder();
		List<ProductDTO> productList = manage.selectAllProducts();
		
		for (PayDTO pay : jounal) {
			String payNum = pay.getPayNum() + "";
			String payTime = pay.getPayTime();
			String payTotal = pay.getPayTotal() + "";
			String payMenu = null;
			if (pay.getPaymentNum() == 1) {
				payMenu = "QR 결제";
			} else {
				payMenu = "기프티콘 결제";
			}
			String[] mix = {payNum, payTime, payTotal, payMenu};
			model.addRow(mix);
		}
		
		// 주문한 상품을 조회하기위한 ArrayList
		ArrayList<String> ar = new ArrayList<String>();
		
		// 테이블 클릭시 판매된 상품조회 기능
		stockTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// 테이블안의 행을 클릭시 해당 행의 값을 읽어옴
				row = stockTable.getSelectedRow();
				for (OrderDTO orderDTO : order) {
					if (orderDTO.getOrderNum() == jounal.get(row).getPayNum()) {
						for (ProductDTO product : productList) {
							if (product.getProductNum() == orderDTO.getProductNum()) {
								String menu = product.getProductName();
								ar.add(menu);
								break;
							}
						}
					}
				}
				JOptionPane.showMessageDialog(stockTable,ar);
				ar.clear();
			}
		});
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