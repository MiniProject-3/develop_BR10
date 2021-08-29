package ui.manager.page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import dev.manager.controller.ManagerController;
import ui.manager.MainFrame;
import ui.manager.ManagerPanel;

public class ModifyMenuPage  extends JPanel {
   
   private MainFrame mf;
   private JTextField nameField;
   private JTextField priceField;
   private JTextField stockField;

   /**
    * Create the panel.
    */
   public ModifyMenuPage(MainFrame  mainframe , ArrayList<String> selectedProduct) {
      
      
      this.mf = mainframe;
      this.setBackground(Color.white);
      this.setSize(600, 1000);
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
//      priceField.enable(false);
//      priceField.setBackground(Color.LIGHT_GRAY);
      
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
            String newName = nameField.getText();
            String newPrice = priceField.getText();
            String newStock = stockField.getText();            
            
            /* map에 데이터 추가하기 */
            ansMap.put("name", newName);
            ansMap.put("price", newPrice);
            ansMap.put("stock", newStock);
            
            /* DB에 값 넣기 */
            managerController.registNewProduct(ansMap);
            
            /* 페이지 변경하기 */
            UpdateMenu updateMenu = new UpdateMenu(mf);
            changePanel(updateMenu);
         }
      });
      
      
      /*
      			selectedProduct.add(productNum);		// 상품번호 0
				selectedProduct.add(productName);		// 상품명 1
				selectedProduct.add(productPrice);		// 상품가격 2
				selectedProduct.add(categoryCode);		// 카테고리코드 3
				selectedProduct.add(stock);				// 재고 4
       */
      
      /* textField에 기본 값 설정하기 */
      nameField.setText(selectedProduct.get(1));		// 상품명
      priceField.setText(selectedProduct.get(2));		// 가격
      stockField.setText(selectedProduct.get(4));		// 재고
         
      /* 저장 버튼 눌렀을 때 */
      /* PRODUCT TABLE에 값 update */
         storeBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         
            ManagerController managerController = new ManagerController();
            
            /* 값을 넣어 전달할 map 생성*/
            Map<String, String> ansMap = new HashMap<>();
            
            /* textField에 넣어진 값들 받아오기 */
            String newName = nameField.getText();
            Integer newPrice = Integer.valueOf(priceField.getText());
            Integer newStock = Integer.valueOf(stockField.getText()); 
            
            /* productNum 받아오기 */
      		int productNum = Integer.valueOf(selectedProduct.get(0));
           
            /* DB에 값 넣기 */
            managerController.modifyProduct(productNum, newName, newPrice, newStock);
            
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