package ui.manager.page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import dev.customer.gui.ImageKick;
import ui.manager.MainFrame;
import ui.manager.ManagerPanel;
import ui.manager.textpage.TextButtonPage;

public class ExitPage extends JPanel{
	private MainFrame mf;
	private ImageKick kb = new ImageKick();
	private LineBorder line = new LineBorder(Color.black,3);
	
	public ExitPage(MainFrame mf) {
		this.mf = mf;
		
		this.setLocation(0, 0);
		this.setSize(600, 1000);
		this.setBackground(Color.white);
		
		BackButton();
		label();
		exitButton();
		
		mf.add(this);
	}

	public void label() {
		Font font = new Font("맑은 고딕",Font.BOLD, 30);
		
		JLabel label = new JLabel("종료할 모드를 선택하세요.");
		label.setSize(540, 400);
		label.setLocation(25, 200);
		label.setFont(font);
		label.setBorder(line);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label);
	}
	
	public void exitButton() {
		Font font = new Font("궁서 보통", Font.PLAIN, 20);
		JButton button1 = new JButton("관리자");
		button1.setFont(font);
		button1.setLocation(25, 600);
		button1.setSize(275, 100);
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 1;
				TextButtonPage textpage = new TextButtonPage(mf, num);
				changePanel(textpage);
			}
		});
		
		JButton button2 = new JButton("키오스크");
		button2.setFont(font);
		button2.setLocation(300, 600);
		button2.setSize(265, 100);
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 2;
				TextButtonPage textpage = new TextButtonPage(mf, num);
				changePanel(textpage);
			}
		});
		
		this.add(button1);
		this.add(button2);
	}
	
	public void BackButton() {
		JButton back = new JButton();
		
		back.setLocation(40,850);
		back.setSize(100,50);
		back.setIcon(kb.ImageKickButton("BR10_images/Back.jpg", 100, 50));
		back.setBorderPainted(false);
		
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
