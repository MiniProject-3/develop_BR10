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
		
		BackButton();
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
		
		JLabel label = new JLabel("키오스크가 종료됩니다." + "<br>정말 종료하시겠습니까?");
		label.setSize(540, 400);
		label.setLocation(25, 200);
		label.setFont(font);
		label.setBorder(line);
		
		// 라벨의 글씨를 가운데로 정렬
		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(label);
	}
	
	public void BackButton() {
		JButton back = new JButton();
		
		back.setLocation(40,850);
		back.setSize(100,50);
		back.setIcon(kb.ImageKickButton("BR10_images/Back.jpg", 100, 50));
		
		// 버튼의 외각선 제거
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
