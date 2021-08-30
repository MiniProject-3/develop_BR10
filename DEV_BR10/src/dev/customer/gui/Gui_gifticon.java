package dev.customer.gui;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import dev.customer.controller.CustomerController;
import dev.customer.menu.Gifticon;
import dev.dto.GiftDTO;
import dev.dto.OrderDTO;
import dev.dto.ProductDTO;
import dev.manager.controller.ManagerController;

public class Gui_gifticon extends JFrame {

   private JFrame mf = new JFrame("BR_10");
   private ImageKick kb = new ImageKick();
   private JPanel jpa = null;

   public void gift() {
      mf.setTitle("mini_BR10");
      mf.setBounds(600, 10, 600, 1000);
      mf.setLayout(null);

      ImageKickPanel panel = new ImageKickPanel(
      new ImageIcon("BR10_images/gui_order/bg_06.jpg").getImage().getScaledInstance(600, 1000, 3));
      panel.setLocation(0, 0);
      panel.setSize(600, 1000);
      panel.setBackground(Color.WHITE);

      JPanel homePanel = new JPanel(); // 홈버튼 패널
      homePanel.setLocation(50, 50);
      homePanel.setSize(70, 100);
      homePanel.setBackground(Color.WHITE);

      JButton butt2 = new JButton("홈버튼");
      butt2.setPreferredSize(new Dimension(50, 50));
      butt2.setIcon(kb.ImageKickButton("BR10_images/gui_order/Buttons_14.jpg", 50, 50));
      homePanel.add(butt2);

      TitledBorder Tb = new TitledBorder(new LineBorder(Color.black, 2));
      TitledBorder Tb2 = new TitledBorder(new LineBorder(Color.gray, 4));

      JPanel giftPanel = new JPanel(); // 기프티콘 패널
      giftPanel.setBorder(Tb);
      giftPanel.setLocation(150, 300);
      giftPanel.setSize(300, 400);
      giftPanel.setBackground(Color.WHITE);
      giftPanel.setLayout(null);

      JPanel repeat = new JPanel();
      repeat.setLocation(75, 75);
      repeat.setSize(300, 400);
      repeat.setBackground(Color.WHITE);
      repeat.setLayout(null);

      Font font = new Font("맑은 고딕", Font.PLAIN, 30);
      Font font2 = new Font("맑은 고딕", Font.PLAIN, 30);

      JLabel repeatLabel = new JLabel("dddhdhdh");

      JLabel giftLabel = new JLabel("<html><pre>  기프티콘 코드를    <br>    입력하세요</pre> </html>");
      giftLabel.setBounds(2, 2, 290, 200);
      giftLabel.setFont(font);

      JTextField giftNum = new JTextField(20); // 기프티콘 번호
      giftNum.setBounds(50, 200, 200, 50);
      giftNum.setBorder(Tb2);
      giftNum.setFont(font2);
      giftNum.setText(null);
      giftPanel.add(giftLabel);
      giftPanel.add(giftNum);

      JButton butt3 = new JButton("확인"); // 확인버튼
      butt3.setBounds(50, 300, 100, 50);
      butt3.setBorder(Tb);
      butt3.setFont(font);
      butt3.setBackground(Color.WHITE);

      JButton butt4 = new JButton("취소"); // 취소버튼
      butt4.setBounds(150, 300, 100, 50);
      butt4.setBorder(Tb);
      butt4.setFont(font);
      butt4.setBackground(Color.WHITE);
      giftPanel.add(butt3);
      giftPanel.add(butt4);

      butt3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

            if (!giftNum.getText().equals("1234")) {
               JOptionPane.showMessageDialog(null, "다시입력");
               giftNum.setText("");
               giftNum.requestFocus();
               
               GiftDTO gift = new GiftDTO();
               gift.setGiftNum(1);
               gift.setGiftUse("N");
               Gifticon.gift.add(gift);
            } else {
            	
            	/* insertPay */
            	 CustomerController customerController = new CustomerController();
 		    	ManagerController managerController = new ManagerController();
 		    	
 		    	String payMentNum = "2";											// 기프티콘 결제
 		    	int giftOrderNum = customerController.selectOrderNum() - 1;		// 주문번호 받아오기
 		    	
 		    	/* selectOrderByOrderNum == customerController.selectOrderNum() - 1 */
 		    	Map<String, String> ansMap = new HashMap<>();
 		    	
 		    	List<OrderDTO> orderList = new ArrayList<>();
 		    	orderList = customerController.selectOrderByOrderNum(giftOrderNum);
 		    	
 		    	SimpleDateFormat format1 = new SimpleDateFormat("yy/MM/dd");
 		    	
 		    	Date time = new Date();
 		    	String payTime = "00/00/00"; 
 		    	
 		    	int orderPayTotal = 0;

 		    	for(OrderDTO order :orderList) {
 		    		 String productNum = order.getProductNum() + "";		// 상품번호
 		    		 String phoneNum = order.getPhoneNum();					// 핸드폰번호
 		    		 String orderNum = order.getOrderNum() + "";			// 주문번호
 		    		 System.out.println(productNum);
 		    		 
 				     List<ProductDTO> productList = managerController.selectQtyNProductByProductNum(order.getProductNum());		// productNum으로 찾아낸 product
 			    		 for (ProductDTO product : productList) {
 			    			 int productQty = product.getQty();
 			    			 int price = product.getProductPrice();
 			    			 int productPayTotal = productQty * price;
 			    			 orderPayTotal += productPayTotal;
 			    		 }
 		    		 payTime = format1.format(time);
 		    		 
 		    		 /* insertPay */
 		    		 ansMap.put("payNum", orderNum);
 		    		 ansMap.put("payTime", payTime);
 		    		 ansMap.put("phoneNum", phoneNum);
 		    		 ansMap.put("paymentNum", payMentNum);
 		    	}
 		    	ansMap.put("payTotal", orderPayTotal + "");
 		    	
 		    	/* DB에 값 넣기 */
 		    	customerController.registNewPay(ansMap);
            	
            	/* 화면 전환 */
               Gui_waitingNum as = new Gui_waitingNum();
               as.waitingNum();
               mf.dispose();
               
            }
         }
      });

      butt4.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            new Gui_payment();
            mf.dispose();
         }
      });

      panel.add(giftPanel);
      panel.add(homePanel);
      mf.add(panel);
      mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mf.setVisible(true);
   }
}