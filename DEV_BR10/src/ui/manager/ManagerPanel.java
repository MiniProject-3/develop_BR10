package ui.manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ui.manager.page.JournalPage;
import ui.manager.page.StockPage;
import ui.manager.page.UpdateMenu;

public class ManagerPanel extends JPanel{

	private MainFrame mf;
	
	public ManagerPanel(MainFrame mainframe) {
		this.mf = mainframe;
		
		this.setLocation(0, 0);
		this.setSize(600, 1000);
		this.setLayout(null);
		this.setBackground(Color.white);
		
		this.ManagerButton();
		
		mf.add(this);
	}
	
	public void ManagerButton() {
		JButton searchStock = new JButton("재고파악");
		searchStock.setLocation(20, 100);
		searchStock.setSize(270, 400);
		searchStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StockPage stock = new StockPage(mf);
				changePanel(stock);
			}
		});
		
		JButton searchJournal = new JButton("저널조회");
		searchJournal.setLocation(290, 100);
		searchJournal.setSize(270, 400);
		searchJournal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JournalPage journal = new JournalPage(mf);
				changePanel(journal);
			}
		});
		
		JButton updateMenu = new JButton("메뉴관리");
		updateMenu.setLocation(20, 500);
		updateMenu.setSize(270, 400);
		updateMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateMenu updatemenu = new UpdateMenu(mf);
				changePanel(updatemenu);
			}
		});
		
		JButton exit = new JButton("종료");
		exit.setLocation(290, 500);
		exit.setSize(270, 400);
		
		this.add(searchStock);
		this.add(searchJournal);
		this.add(updateMenu);
		this.add(exit);
	}

	public void changePanel(JPanel panel) {
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}

	
	
}
