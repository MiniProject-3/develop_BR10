package ui.manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import ui.manager.page.ExitPage;
import ui.manager.page.JournalPage;
import ui.manager.page.StockPage;
import ui.manager.page.UpdateMenu;

public class ManagerPanel extends JPanel{
 
	private MainFrame mf;
	private Font font = new Font("궁서 보통", Font.BOLD, 20);
	
	public ManagerPanel(MainFrame  mainframe) {
		this.mf = mainframe;
		
		this.setLocation(0, 0);
		this.setSize(600, 1000);
		this.setLayout(null);
		this.setBackground 
		(Color.white);
		
		this.ManagerButton();
		
		mf.add(this);
	}
	
	// 매니저 화면 버튼
	public void ManagerButton() {
		JButton searchStock = new JButton("재고파악");
		searchStock.setFont(font);
		searchStock.setLocation(20, 100);
		searchStock.setSize(270, 400);
		searchStock.setOpaque(false);				// 버튼을 투명하게 만들기
		searchStock.setContentAreaFilled(false);	// 버튼 내용역역 채우지않음
		searchStock.setBorderPainted(true);			// 버튼 테두리 X
		searchStock.setBorder(new LineBorder(Color.black));
		
		// 재고화면으로 이동
		searchStock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StockPage stock = new StockPage(mf);
				changePanel(stock);
			}
		});
		
		JButton searchJournal = new JButton("저널조회");
		searchJournal.setFont(font);
		searchJournal.setLocation(290, 100);
		searchJournal.setSize(270, 400);
		searchJournal.setOpaque(false);
		searchJournal.setContentAreaFilled(false);
		searchJournal.setBorderPainted(true);
		searchJournal.setBorder(new LineBorder(Color.black));
		
		// 저널조회 화면 이동
		searchJournal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JournalPage journal = new JournalPage(mf);
				changePanel(journal);
			}
		});
		
		JButton updateMenu = new JButton("메뉴관리");
		updateMenu.setFont(font);
		updateMenu.setLocation(20, 500);
		updateMenu.setSize(270, 400);
		updateMenu.setOpaque(false);
		updateMenu.setContentAreaFilled(false);
		updateMenu.setBorderPainted(true);
		updateMenu.setBorder(new LineBorder(Color.black));
		
		updateMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateMenu updatemenu = new UpdateMenu(mf);
				changePanel(updatemenu);
			}
		});
		
		JButton exit = new JButton("종료");
		exit.setFont(font);
		exit.setLocation(290, 500);
		exit.setSize(270, 400);
		exit.setOpaque(false);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(true);
		exit.setBorder(new LineBorder(Color.black));

		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ExitPage exitpage = new ExitPage(mf);
				changePanel(exitpage);
			}
		});
		
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
