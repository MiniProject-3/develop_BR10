package ui.manager.page;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ui.manager.MainFrame;
import ui.manager.ManagerPanel;

public class JournalPage extends JPanel{
	private MainFrame mf;
	
	public JournalPage(MainFrame mainFrame) {
		this.mf = mainFrame;
		
		this.setSize(600,1000);
		this.setBackground(Color.white);
		
		BackButton();
		CategoryButton();
		viewPanel();
	}
	
	public void viewPanel() {
		JPanel viewPanel = new JPanel();
		viewPanel.setSize(490, 690);
		viewPanel.setLocation(5,5);
		viewPanel.setBackground(Color.white);
		
		JPanel viewPanel2 = new JPanel();
		viewPanel2.setSize(500, 700);
		viewPanel2.setLocation(40, 140);
		viewPanel2.setBackground(Color.black);
		
		this.add(viewPanel2);
		viewPanel2.add(viewPanel);
	}
	
	public void BackButton() {
		JButton back = new JButton();
		
		back.setLocation(40,850);
		back.setSize(100,50);
		
		this.add(back);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerPanel managerPanel = new ManagerPanel(mf);
				changePanel(managerPanel);
			}
		});
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