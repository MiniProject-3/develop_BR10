package ui.manager.page;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class insertMenuPage extends JPanel {
	private JTextField nameField;
	private JTextField priceField;
	private JTextField stockField;

	/**
	 * Create the panel.
	 */
	public insertMenuPage() {
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(115, 69, 110, 21);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC544\uC774\uC2A4\uD06C\uB9BC", "\uCF00\uC774\uD06C", "\uB514\uC800\uD2B8", "\uC74C\uB8CC"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		setLayout(null);
		
		JLabel Label = new JLabel("\uBA54\uB274 \uCD94\uAC00");
		Label.setBounds(74, 19, 107, 28);
		Label.setFont(new Font("돋움", Font.BOLD, 24));
		Label.setHorizontalAlignment(SwingConstants.CENTER);
		add(Label);
		
		JLabel labelCategory = new JLabel("\uCE74\uD14C\uACE0\uB9AC");
		labelCategory.setBounds(47, 72, 48, 15);
		add(labelCategory);
		add(comboBox);
		
		JLabel labelProductName = new JLabel("\uC81C\uD488\uBA85");
		labelProductName.setBounds(53, 110, 36, 15);
		add(labelProductName);
		
		nameField = new JTextField();
		nameField.setBounds(115, 107, 110, 21);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel labelPrice = new JLabel("\uAC00\uACA9");
		labelPrice.setBounds(59, 153, 24, 15);
		add(labelPrice);
		
		priceField = new JTextField();
		priceField.setBounds(115, 150, 110, 21);
		add(priceField);
		priceField.setColumns(10);
		
		JLabel labelStock = new JLabel("\uC218\uB7C9");
		labelStock.setBounds(59, 193, 24, 15);
		add(labelStock);
		
		stockField = new JTextField();
		stockField.setBounds(115, 190, 110, 21);
		add(stockField);
		stockField.setColumns(10);
		
		JButton storeBtn = new JButton("\uC800\uC7A5");
		storeBtn.setBounds(54, 255, 57, 23);
		add(storeBtn);
		
		JButton cancelBtn = new JButton("\uCDE8\uC18C");
		cancelBtn.setBounds(142, 255, 57, 23);
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(cancelBtn);

	}

}