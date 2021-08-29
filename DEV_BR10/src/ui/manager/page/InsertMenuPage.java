package ui.manager.page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import dev.manager.controller.ManagerController;
import ui.manager.MainFrame;
import ui.manager.ManagerPanel;

public class InsertMenuPage extends JPanel {
   
   private MainFrame mf;
   private JTextField nameField;
   private JTextField priceField;
   private JTextField stockField;

   /**
    * Create the panel.
    */
   public InsertMenuPage(MainFrame  mainframe) {
      
      
      this.mf = mainframe;
      this.setBackground(Color.white);
      this.setSize(600, 1000);
      JComboBox comboBox = new JComboBox();
      comboBox.setBounds(201, 313, 337, 50);
      comboBox.setFont(new Font("돋움", Font.BOLD, 20));
      comboBox.setModel(new DefaultComboBoxModel(new String[] {"아이스크림", "케이크", "디저트", "음료","MD"}));
      comboBox.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      this.setLayout(null);
      
      JLabel Label = new JLabel("메뉴추가");
      Label.setBackground(Color.LIGHT_GRAY);
      Label.setBounds(12, 206, 526, 57);
      Label.setFont(new Font("돋움", Font.BOLD, 30));
      Label.setHorizontalAlignment(SwingConstants.CENTER);
      this.add(Label);
      
      JLabel labelCategory = new JLabel("카테고리");
      labelCategory.setHorizontalAlignment(SwingConstants.CENTER);
      labelCategory.setFont(new Font("돋움", Font.BOLD, 20));
      labelCategory.setBounds(63, 311, 93, 50);
      this.add(labelCategory);
      this.add(comboBox);
      
      JLabel labelProductName = new JLabel("제품명");
      labelProductName.setHorizontalAlignment(SwingConstants.CENTER);
      labelProductName.setFont(new Font("돋움", Font.BOLD, 20));
      labelProductName.setBounds(63, 406, 93, 50);
      this.add(labelProductName);
      
      nameField = new JTextField();
      nameField.setBounds(201, 409, 337, 50);
      nameField.setFont(new Font("돋움", Font.BOLD, 20));
      this.add(nameField);
      nameField.setColumns(10);
      
      JLabel labelPrice = new JLabel("가격");
      labelPrice.setHorizontalAlignment(SwingConstants.CENTER);
      labelPrice.setFont(new Font("돋움", Font.BOLD, 20));
      labelPrice.setBounds(63, 495, 82, 50);
      this.add(labelPrice);
      
      
      priceField = new JTextField();
      priceField.setBounds(201, 498, 337, 50);
      priceField.setFont(new Font("돋움", Font.BOLD, 20));
      this.add(priceField);      
      priceField.setColumns(10);
      /* 아이스크림의 경우 가격 입력 X - 콤보박스의 기본값 : 아이스크림 */
      priceField.enable(false);
      priceField.setBackground(Color.LIGHT_GRAY);
      
      comboBox.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

            /* 아이스크림이 아닌 다른 카테고리 선택 시 */ 
            if(comboBox.getSelectedIndex() != 0) {
               priceField.enable(true);
               priceField.setBackground(Color.white);
               } else {
                  priceField.enable(false);
                  priceField.setBackground(Color.LIGHT_GRAY);
               }
            }
      });

      JLabel labelStock = new JLabel("\uC218\uB7C9");
      labelStock.setHorizontalAlignment(SwingConstants.CENTER);
      labelStock.setFont(new Font("돋움", Font.BOLD, 20));
      labelStock.setBounds(63, 589, 82, 50);
      this.add(labelStock);
      
      stockField = new JTextField();
      stockField.setBounds(201, 592, 337, 50);
      stockField.setFont(new Font("돋움", Font.BOLD, 20));
      this.add(stockField);
      stockField.setColumns(10);
      
      JButton storeBtn = new JButton("저장");
      storeBtn.setBounds(331, 702, 207, 57);
      storeBtn.setFont(new Font("돋움", Font.BOLD, 20));

      
      /* 저장 버튼 눌렀을 때 */
      /* PRODUCT TABLE에 값 INSERT */

      storeBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         
            ManagerController managerController = new ManagerController();
            
            /* 값을 넣어 전달할 map 생성*/
            Map<String, String> ansMap = new HashMap<>();
            
            /* textField에 넣어진 값들 받아오기 */
            String newCategoryCode = comboBox.getSelectedIndex() + 1 +"";
            String newName = nameField.getText();
            String newPrice = priceField.getText();
            String newStock = stockField.getText();            
            
            /* 일련번호 만들기 */
            String newSeq = managerController.selectProductLastSeq() + "";
            
            /* map에 데이터 추가하기 */
            ansMap.put("num", newSeq);
            ansMap.put("name", newName);
            ansMap.put("price", newPrice);
            ansMap.put("categoryCode", newCategoryCode);
            ansMap.put("stock", newStock);
            
            /* DB에 값 넣기 */
            managerController.registNewProduct(ansMap);
            
            /* 페이지 변경하기 */
            UpdateMenu updateMenu = new UpdateMenu(mf);
            changePanel(updateMenu);
         }
      });
      this.add(storeBtn);
      
      JButton cancelBtn = new JButton("취소");
      cancelBtn.setBounds(63, 702, 213, 57);
      cancelBtn.setFont(new Font("돋움", Font.BOLD, 20));

      cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ManagerPanel managerPanel = new ManagerPanel(mf);
               changePanel(managerPanel);
            }
      });
      this.add(cancelBtn);
      mf.add(this);
   }
   
   public void changePanel(JPanel panel) {
      mf.repaint();
      mf.remove(this);
      mf.add(panel);
      revalidate();
   }

}