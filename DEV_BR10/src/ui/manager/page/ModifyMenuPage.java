package ui.manager.page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dev.manager.controller.ManagerController;
import ui.manager.MainFrame;

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
      
      JLabel Label = new JLabel("메뉴수정");
      Label.setBackground(Color.LIGHT_GRAY);
      Label.setBounds(12, 206, 526, 57);
      Label.setFont(new Font("돋움", Font.BOLD, 30));
      Label.setHorizontalAlignment(SwingConstants.CENTER);
      this.add(Label);
      
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
      /* 아이스크림에 대한 메뉴 수정일 때 - 가격 수정 불가능 */
      if(selectedProduct.get(3).equals("1")) {
          priceField.enable(false);
          priceField.setBackground(Color.LIGHT_GRAY);
      } else {
    	  priceField.enable(true);
          priceField.setBackground(Color.white);
      }
      this.add(priceField);      
      priceField.setColumns(10);
      
      JLabel labelStock = new JLabel("재고");
      labelStock.setHorizontalAlignment(SwingConstants.CENTER);
      labelStock.setFont(new Font("돋움", Font.BOLD, 20));
      labelStock.setBounds(63, 589, 82, 50);
      this.add(labelStock);
      
      stockField = new JTextField();
      stockField.setBounds(201, 592, 337, 50);
      stockField.setFont(new Font("돋움", Font.BOLD, 20));
      this.add(stockField);
      stockField.setColumns(10);

      /* textField에 기본 값 설정하기 */
      nameField.setText(selectedProduct.get(1));		// 상품명
      priceField.setText(selectedProduct.get(2)+"");		// 가격
      stockField.setText(selectedProduct.get(4)+"");		// 재고
      
      /* 취소 버튼 */
      JButton cancelBtn = new JButton("취소");
      cancelBtn.setFont(new Font("돋움", Font.BOLD, 20));
      cancelBtn.setBounds(63, 702, 213, 57);
      cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	UpdateMenu updateMenu = new UpdateMenu(mf);
                changePanel(updateMenu);
            }
      });
      this.add(cancelBtn);
      
      /* 저장 버튼 */
      JButton storeBtn = new JButton("저장");
      storeBtn.setBounds(331, 702, 207, 57);
      storeBtn.setFont(new Font("돋움", Font.BOLD, 20));
      
      /*
      			selectedProduct.add(productNum);		// 상품번호 0
				selectedProduct.add(productName);		// 상품명 1
				selectedProduct.add(productPrice);		// 상품가격 2
				selectedProduct.add(categoryCode);		// 카테고리코드 3
				selectedProduct.add(stock);				// 재고 4
       */
      
      /* 저장 버튼 눌렀을 때 */
      /* PRODUCT TABLE에 값 update */
         storeBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         
            ManagerController managerController = new ManagerController();
            
            /* textField에 넣어진 값들 받아오기 */
            String newName = nameField.getText();
            Integer newPrice;
            Integer newStock;
            
            if (priceField.getText().equals("0")) {
            	newPrice = null;
            } else {
            	
            	newPrice = Integer.valueOf(priceField.getText());
            }
            if (stockField.getText().equals("0")) {
            	newStock = null;
            } else {
            	
            	newStock = Integer.valueOf(stockField.getText());
            }
            
            /* productNum 받아오기 */
      		int productNum = Integer.valueOf(selectedProduct.get(0));
           
      		/* console test */
      		System.out.println(newName + " " + newPrice + " " + newStock + " " + productNum);
      		
            /* DB에 값 넣기 */
            managerController.modifyProduct(productNum, newName, newPrice, newStock);
            
            /* 페이지 변경하기 */
            UpdateMenu updateMenu = new UpdateMenu(mf);
            changePanel(updateMenu);
         }
      });
      this.add(storeBtn);
      
      /* 메뉴 삭제 버튼 */
      JButton delBtn = new JButton("삭제");
      delBtn.setBounds(63, 815, 475, 50);

      delBtn.setFont(new Font("돋움", Font.BOLD, 20));

      delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                 ManagerController managerController = new ManagerController();
                 
                 /* 받아온 리스트의 productNum */
                 int selectedProductNum = Integer.valueOf(selectedProduct.get(0));
                 
                 /* DB에서 해당 메뉴 삭제 */
                 managerController.deleteProduct(selectedProductNum);

            	 UpdateMenu updateMenu = new UpdateMenu(mf);
                 changePanel(updateMenu);
            }
      });
      this.add(delBtn);
      mf.add(this);
   }
   
   public void changePanel(JPanel panel) {
      mf.repaint();
      mf.remove(this);
      mf.add(panel);
      revalidate();
   }

}