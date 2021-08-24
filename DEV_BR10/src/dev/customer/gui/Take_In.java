package dev.customer.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Take_In extends JPanel{
	private JFrame mf = new JFrame("BR_10");
	JPanel panel = new JPanel();
	
	public Take_In(MainFrame mainFrame) {
		this.mf = mainFrame;
		mf.setTitle("mini_BR10");
		mf.setBounds(600, 10, 600, 1000);
		mf.setLayout(null);
		
		this.categoryPanel();
		
		mf.add(this);
		revalidate();
	}
	
	public void categoryPanel() {
//		JPanel categoryPanel = new JPanel();
//		categoryPanel.setLocation(0, 200);
//		categoryPanel.setSize(600, 60);
		
		JLabel label1 = new JLabel("숟가락");
		label1.setLocation(0, 200);
		label1.setSize(600, 60);
		
		JLabel label2 = new JLabel("초");
		label2.setLocation(0, 500);
		label2.setSize(600, 60);
		
		SpinnerNumberModel spoon = new SpinnerNumberModel(0, 0, 10, 1);
		
		JSpinner spinner1 = new JSpinner(spoon);
		panel.add(spinner1);
		spinner1.setLocation(300, 200);
		
		SpinnerNumberModel candle = new SpinnerNumberModel(0, 0, 10, 1);
		
		JSpinner spinner2 = new JSpinner(candle);
		panel.add(spinner2);
		spinner2.setLocation(300, 500);
		
		
		
	}

}
