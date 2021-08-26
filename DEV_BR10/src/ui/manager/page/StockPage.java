package ui.manager.page;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
	}
	
	public void viewPanel() {
		JPanel viewPanel1 = new JPanel();
		viewPanel1.setSize(500, 700);
		viewPanel1.setLocation(40, 140);
		viewPanel1.setBorder(line);
		viewPanel1.setBackground(Color.white);
		
		this.add(viewPanel1);
	}
	
	public void namePanel() {
		
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
