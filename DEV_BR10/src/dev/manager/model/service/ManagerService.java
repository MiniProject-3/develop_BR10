package dev.manager.model.service;

import static dev.common.JDBCTemplate.getConnection;
import static dev.common.JDBCTemplate.close;
import static dev.common.JDBCTemplate.commit;
import static dev.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import dev.dto.PayDTO;
import dev.dto.ProductDTO;
import dev.manager.model.dao.ManagerDAO;

public class ManagerService {

	/* 관리자 서비스 시스템 */
	private ManagerDAO managerDAO = new ManagerDAO();
	
	/* 재고 조회 */
	public List<ProductDTO> selectAllProducts(){
		
		Connection con = getConnection();
		List<ProductDTO> productList = managerDAO.selectAllProducts(con);
		
		close(con);
		
		return productList;
	}
	
	/* 결재내역(저널) 조회 */
	public List<PayDTO> selectAllPays(){
		
		Connection con = getConnection();
		List<PayDTO> payList = managerDAO.selectAllPays(con);
		
		close(con);

		return payList;
	}
	
	/* 메뉴 추가 */
	public int insertProduct(ProductDTO product) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = managerDAO.insertProduct(con, product);
		
		if(result > 0) 
			commit(con);
		else 
			rollback(con);

		close(con);

		return result;
	}
	
	/* 메뉴 수정 - 가격 */
	public int updateProductPrice(int productNum, int productPrice) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = managerDAO.updateProductPrice(con, productNum, productPrice);
		
		if(result > 0) 
			commit(con);
		else 
			rollback(con);

		close(con);

		return result;
	}
	
	/* 메뉴 수정 - 수량 */
	public int updateProductStock(int productNum, int productStock) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = managerDAO.updateProductStock(con, productNum, productStock);
		
		if(result > 0) 
			commit(con);
		else 
			rollback(con);

		close(con);

		return result;
	}
	
	/* 메뉴 수정 - 이름 */
	public int updateProductName(int productNum, int productName) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = managerDAO.updateProductName(con, productNum, productName);
		
		if(result > 0) 
			commit(con);
		else 
			rollback(con);

		close(con);

		return result;
	}
	
	/* 메뉴 삭제 */
	public int deleteProduct(int productNum) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = managerDAO.deleteProduct(con, productNum);
		
		if(result > 0) 
			commit(con);
		else 
			rollback(con);

		close(con);

		return result;
	}
}
