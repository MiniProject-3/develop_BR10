package ui.manager.page;

import static dev.common.JDBCTemplate.close;
import static dev.common.JDBCTemplate.getConnection;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dev.customer.gui.ImageKick;
import dev.dto.ProductDTO;
import dev.manager.controller.ManagerController;
import dev.manager.model.dao.ManagerDAO;
import ui.manager.MainFrame;
import ui.manager.ManagerPanel;

public class UpdateMenu extends JPanel{
	private int row;					// 테이블의 행 조회
	private MainFrame mf;
	private ImageKick kb = new ImageKick();
	private LineBorder line = new LineBorder(Color.black);
	private ArrayList<String> selectedProduct;
	
	private ManagerController managercontroller = new ManagerController();
	private List<ProductDTO> curProduct = null;
	
	private List<ProductDTO> product1 = managercontroller.selectProductByCategoryCode(1);
	private List<ProductDTO> product2 = managercontroller.selectProductByCategoryCode(2);
	private List<ProductDTO> product3 = managercontroller.selectProductByCategoryCode(3);
	private List<ProductDTO> product4 = managercontroller.selectProductByCategoryCode(4);
	private List<ProductDTO> product5 = managercontroller.selectProductByCategoryCode(5);

	public UpdateMenu(MainFrame mainFrame) {
		JPanel pan = new JPanel();
		this.mf = mainFrame;
		
		this.setSize(600,1000);
		this.setBackground(Color.white);
		
		BackButton();
		CategoryButton();
		viewPanel(pan, 1);
		plusButton();
	}
	
	public UpdateMenu(MainFrame mf, int num) {
				
		JPanel pan = new JPanel();
		this.mf = mf;
		this.setSize(600,1000);
		this.setBackground(Color.white);
		BackButton();
		CategoryButton();
		viewPanel(pan, num);
		plusButton();
	}

	public void viewPanel(JPanel panel, int num ) {
		panel.setSize(500, 700);
		panel.setLocation(40, 140);
		panel.setBorder(line);
		panel.setBackground(Color.white);
		
		createTable(panel,num);
		
		this.add(panel);
	}
	
	public void createTable(JPanel panel, int num ) {
		String header[] = {"메뉴명", "가격", "수량"};
		DefaultTableModel model = new DefaultTableModel(header, 0);
		JTable stockTable = new JTable(model);
		JScrollPane pane = new JScrollPane(stockTable);
		DefaultTableCellRenderer right = new DefaultTableCellRenderer();
		right.setHorizontalAlignment(JLabel.RIGHT);
		
		stockTable.getColumn("가격").setCellRenderer(right);
		stockTable.getColumn("수량").setCellRenderer(right);
		
		addTable(model, num);
		pane.setLocation(10, 10);
		pane.setSize(480, 680);
		
		panel.add(pane);
		
		/* 해당되는 메뉴 선택하여 값 수정 */
		stockTable.addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {
				row = stockTable.getSelectedRow() + 1;
				
				ManagerController mc = new ManagerController();
				
				ArrayList<String> selectedProduct = new ArrayList<String>();
				
				switch(num){
					case 1 :
						/* 선택된 행의 값을 리스트에 삽입 */
						selectedProduct.add(product1.get(row).getProductNum()+"");		// 0_상품번호
						selectedProduct.add(product1.get(row).getProductName()+"");		// 1_상품명
						selectedProduct.add(product1.get(row).getProductPrice()+"");	// 2_상품가격
						selectedProduct.add(product1.get(row).getCategoryCode()+"");	// 3_카테고리코드
						selectedProduct.add(product1.get(row).getStock()+"");   		// 4_재고
						break;
					case 2 :
						/* 선택된 행의 값을 리스트에 삽입 */
						selectedProduct.add(product2.get(row).getProductNum()+"");		// 0_상품번호
						selectedProduct.add(product2.get(row).getProductName()+"");		// 1_상품명
						selectedProduct.add(product2.get(row).getProductPrice()+"");	// 2_상품가격
						selectedProduct.add(product2.get(row).getCategoryCode()+"");	// 3_카테고리코드
						selectedProduct.add(product2.get(row).getStock()+"");   		// 4_재고
						break;
					case 3 :
						/* 선택된 행의 값을 리스트에 삽입 */
						selectedProduct.add(product3.get(row).getProductNum()+"");		// 0_상품번호
						selectedProduct.add(product3.get(row).getProductName()+"");		// 1_상품명
						selectedProduct.add(product3.get(row).getProductPrice()+"");	// 2_상품가격
						selectedProduct.add(product3.get(row).getCategoryCode()+"");	// 3_카테고리코드
						selectedProduct.add(product3.get(row).getStock()+"");   		// 4_재고
						break;
					case 4 :
						/* 선택된 행의 값을 리스트에 삽입 */
						selectedProduct.add(product4.get(row).getProductNum()+"");		// 0_상품번호
						selectedProduct.add(product4.get(row).getProductName()+"");		// 1_상품명
						selectedProduct.add(product4.get(row).getProductPrice()+"");	// 2_상품가격
						selectedProduct.add(product4.get(row).getCategoryCode()+"");	// 3_카테고리코드
						selectedProduct.add(product4.get(row).getStock()+"");   		// 4_재고
						break;
					case 5 :
						/* 선택된 행의 값을 리스트에 삽입 */
						selectedProduct.add(product5.get(row).getProductNum()+"");		// 0_상품번호
						selectedProduct.add(product5.get(row).getProductName()+"");		// 1_상품명
						selectedProduct.add(product5.get(row).getProductPrice()+"");	// 2_상품가격
						selectedProduct.add(product5.get(row).getCategoryCode()+"");	// 3_카테고리코드
						selectedProduct.add(product5.get(row).getStock()+"");   		// 4_재고
						break;
					default :
						selectedProduct = null;
						break;
				}
				
				/* 메뉴 수정 창으로 이동 */
				ModifyMenuPage modifyMenuPage = new ModifyMenuPage(mf, selectedProduct);
				changePanel(modifyMenuPage);					
			}
		});
	}
	
public void addTable(DefaultTableModel model, int num) {
		
		ManagerDAO managerDAO = new ManagerDAO();
		Connection con = getConnection();
		List<ProductDTO> productList = managerDAO.selectAllProducts(con);
		
		for (ProductDTO product : productList) {
			if (num == 1 && product.getCategoryCode() == 1) {
				/* 테이블에 값 넣기 */
				String name = product.getProductName();
				String price = product.getProductPrice() + "";
				String preStock = product.getStock() + "";
				String[] mix = {name, price, preStock};
				model.addRow(mix);
				
				/* 테이블에 입력된 순서대로 리스트에 넣기 */
				ProductDTO productByCategory = new ProductDTO();
				
				productByCategory.setProductNum(product.getProductNum());
				productByCategory.setCategoryCode(product.getCategoryCode());
				productByCategory.setProductName(product.getProductName());
				productByCategory.setProductPrice(product.getProductPrice());
				productByCategory.setStock(product.getStock());
				
				product1.add(productByCategory);

			} else if (num == 2 && product.getCategoryCode() == 2) {
				String name = product.getProductName();
				String price = product.getProductPrice() + "";
				String preStock = product.getStock() + "";
				String[] mix = {name, price, preStock};
				model.addRow(mix);
				
				ProductDTO productByCategory = new ProductDTO();
				
				productByCategory.setProductNum(product.getProductNum());
				productByCategory.setCategoryCode(product.getCategoryCode());
				productByCategory.setProductName(product.getProductName());
				productByCategory.setProductPrice(product.getProductPrice());
				productByCategory.setStock(product.getStock());
				
				product2.add(productByCategory);
			} else if (num == 3 && product.getCategoryCode() == 3) {
				String name = product.getProductName();
				String price = product.getProductPrice() + "";
				String preStock = product.getStock() + "";
				String[] mix = {name, price, preStock};
				model.addRow(mix);
				
				ProductDTO productByCategory = new ProductDTO();

				productByCategory.setProductNum(product.getProductNum());
				productByCategory.setCategoryCode(product.getCategoryCode());
				productByCategory.setProductName(product.getProductName());
				productByCategory.setProductPrice(product.getProductPrice());
				productByCategory.setStock(product.getStock());
				
				product3.add(productByCategory);
			} else if (num == 4 && product.getCategoryCode() == 4) {
				String name = product.getProductName();
				String price = product.getProductPrice() + "";
				String preStock = product.getStock() + "";
				String[] mix = {name, price, preStock};
				model.addRow(mix);
				
				ProductDTO productByCategory = new ProductDTO();

				productByCategory.setProductNum(product.getProductNum());
				productByCategory.setCategoryCode(product.getCategoryCode());
				productByCategory.setProductName(product.getProductName());
				productByCategory.setProductPrice(product.getProductPrice());
				productByCategory.setStock(product.getStock());
				
				product4.add(productByCategory);
			} else if (num == 5 && product.getCategoryCode() == 5) {
				String name = product.getProductName();
				String price = product.getProductPrice() + "";
				String preStock = product.getStock() + "";
				String[] mix = {name, price, preStock};
				model.addRow(mix);
				
				ProductDTO productByCategory = new ProductDTO();

				productByCategory.setProductNum(product.getProductNum());
				productByCategory.setCategoryCode(product.getCategoryCode());
				productByCategory.setProductName(product.getProductName());
				productByCategory.setProductPrice(product.getProductPrice());
				productByCategory.setStock(product.getStock());
				
				product5.add(productByCategory);
			}
		}
		close(con);
	}
	
	public void plusButton() {
		JButton plusbutton = new JButton();
		
		plusbutton.setLocation(265,850);
		plusbutton.setSize(65,65);
		plusbutton.setBorderPainted(false);
		plusbutton.setIcon(kb.ImageKickButton("BR10_images/Plus.jpg", 65, 65));
		
		/* 메뉴 추가 화면 띄우기 */
		plusbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InsertMenuPage insertMenuPage = new InsertMenuPage(mf);
				changePanel(insertMenuPage);	
			}
			
		});
		this.add(plusbutton);
	}
	
	public void BackButton() {
		JButton back = new JButton();
		
		back.setLocation(40,850);
		back.setSize(100,70);
		back.setBorderPainted(false);
		
		back.setIcon(kb.ImageKickButton("BR10_images/Back.jpg", 100, 70));
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ManagerPanel managerPanel = new ManagerPanel(mf);
				changePanel(managerPanel);
			}
		});
		this.add(back);
	}

	public void CategoryButton() {
		JButton ice = new JButton("아이스크림");
		
		ice.setLocation(40,100);
		ice.setSize(100,40);
		ice.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 1;
				UpdateMenu md = new UpdateMenu(mf, num);
				changePanel(md);
			}
		});
		
		JButton cake = new JButton("케이크");
		
		cake.setLocation(140,100);
		cake.setSize(100,40);
		cake.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 2;
				UpdateMenu md = new UpdateMenu(mf, num);
				changePanel(md);
			}
		});
		
		JButton dessert = new JButton("디저트");
		
		dessert.setLocation(240,100);
		dessert.setSize(100,40);
		dessert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 3;
				UpdateMenu md = new UpdateMenu(mf, num);
				changePanel(md);
				
			}
		});
		
		JButton drink = new JButton("음료");
		
		drink.setLocation(340,100);
		drink.setSize(100,40);
		drink.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 4;
				UpdateMenu md = new UpdateMenu(mf, num);
				changePanel(md);				
			}
		});
		
		JButton md = new JButton("MD");
		
		md.setLocation(440,100);
		md.setSize(100,40);
		md.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 5;
				UpdateMenu md = new UpdateMenu(mf, num);
				changePanel(md);
			}
		});
		
		this.add(ice);
		this.add(cake);
		this.add(dessert);
		this.add(drink);
		this.add(md);
	}
	
	public void changePanel(JPanel panel) {
		mf.remove(this);
		mf.add(panel);
		mf.repaint();
	}

}