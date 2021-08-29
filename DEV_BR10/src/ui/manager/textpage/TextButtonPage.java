package ui.manager.textpage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import dev.customer.gui.ImageKick;
import dev.customer.gui.StartMain;
import ui.manager.MainFrame;
import ui.manager.ManagerPanel;

public class TextButtonPage extends JPanel{
	private MainFrame mf;
	private ImageKick kb = new ImageKick();
	private LineBorder line = new LineBorder(Color.black,3);

	public TextButtonPage(MainFrame mf, int num) {
		this.mf = mf;
		this.setSize(600, 1000);
		this.setBackground(Color.white);
		
		if (num == 1) {
			label1();
		} else if (num == 2) {
			label2();
		}
		
		exitButton(num);
		
		mf.add(this);
	}

	public void label1() {
		Font font = new Font("맑은 고딕",Font.BOLD, 30);
		
		JLabel label = new JLabel("판매 모드로 돌아가시겠습니까?");
		label.setSize(540, 400);
		label.setLocation(25, 200);
		label.setFont(font);
		label.setBorder(line);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label);
	}
	
	public void label2() {
		
		// 폰트 설정
		Font font = new Font("맑은 고딕",Font.BOLD, 30);
		
		JLabel label = new JLabel("<html>키오스크가 종료됩니다.<br>정말 종료하시겠습니까?</html>");
		label.setSize(540, 400);
		label.setLocation(25, 200);
		label.setFont(font);
		label.setBorder(line);
		
		// 라벨의 글씨를 가운데로 정렬
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label);
	}
	
	public void exitButton(int num) {
		Font font = new Font("궁서 보통", Font.PLAIN, 20);
		JButton button1 = new JButton("예");
		button1.setFont(font);
		button1.setLocation(25, 600);
		button1.setSize(275, 100);
		if (num == 2) {
			button1.addActionListener(new ActionListener() {
			
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
			}
		});
		} else if (num == 1) {
			button1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new StartMain();
					mf.dispose();
				}
			});
		}
		JButton button2 = new JButton("아니요");
		button2.setFont(font);
		button2.setLocation(300, 600);
		button2.setSize(265, 100);
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerPanel managerPanel = new ManagerPanel(mf);
				changePanel(managerPanel);
			}
		});
		
		this.add(button1);
		this.add(button2);
	}
	
	public void changePanel(JPanel panel) {
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}
	
}
