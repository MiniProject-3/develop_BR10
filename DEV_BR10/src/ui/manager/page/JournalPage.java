package ui.manager.page;

import java.awt.Color;

import javax.swing.JPanel;

import ui.manager.MainFrame;

public class JournalPage extends JPanel{
	private MainFrame mf;
	
	public JournalPage(MainFrame mainFrame) {
		this.mf = mainFrame;
		
		this.setSize(600,1000);
		this.setBackground(Color.blue);
	}

}
