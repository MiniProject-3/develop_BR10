package ui.manager.page;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dev.customer.gui.ImageKick;
import dev.dto.PayDTO;
import dev.dto.ProductDTO;
import dev.manager.controller.ManagerController;
import ui.manager.MainFrame;
import ui.manager.ManagerPanel;

public class JournalPage extends JPanel{
	private MainFrame mf;
	private ImageKick kb = new ImageKick();
	private LineBorder line = new LineBorder(Color.black);
	
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
		String header[] = {"결제번호", "결제시간", "총결제금액", "결재수단"};
		DefaultTableModel model = new DefaultTableModel(header, 0);
		JTable stockTable = new JTable(model);
		JScrollPane pane = new JScrollPane(stockTable);
		
		ManagerController manage = new ManagerController();
		List<PayDTO> jounal = manage.selectAllPays();
		for (PayDTO pay : jounal) {
			String payNum = pay.getPayNum() + "";
			String payTime = pay.getPayTime();
			String payTotal = pay.getPayTotal() + "";
			String payMenu = pay.getPaymentNum() + "";
			
			String[] mix = {payNum, payTime, payTotal, payMenu};
			model.addRow(mix);
		}
		
		pane.setLocation(10, 10);
		pane.setSize(480, 680);
		
		panel.add(pane);
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