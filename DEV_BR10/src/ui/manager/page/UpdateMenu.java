package ui.manager.page;

import java.awt.Color;

import javax.swing.JPanel;

import ui.manager.MainFrame;

public class UpdateMenu extends JPanel{
	private MainFrame mf;
	
	public UpdateMenu(MainFrame mainFrame) {

		this.mf = mainFrame;
		
		this.setSize(600,1000);
		this.setBackground(Color.white);
		
	}

}
