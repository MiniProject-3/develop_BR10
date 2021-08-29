package dev.customer.model.service;

import static dev.common.JDBCTemplate.close;
import static dev.common.JDBCTemplate.commit;
import static dev.common.JDBCTemplate.getConnection;
import static dev.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dev.customer.menu.MenuOrderList;
import dev.customer.model.dao.CustomerDAO;
import dev.dto.GiftDTO;
import dev.dto.InoDTO;
import dev.dto.OrderDTO;
import dev.dto.UserDTO;

public class CustomerService {
	private CustomerDAO customerDAO = new CustomerDAO();
	
	/* insertOrder */
	
	/* insertPay */
	
	/* selectAllUsers */
	public List<UserDTO> selectAllUsers(){
		Connection con = getConnection();
		
		List<UserDTO> userList = customerDAO.selectAllUsers(con);
		
		close(con);
		
		return userList;
	}
	
	/* updateUsers */
	
	/* updateManagerKey */
	
	/* selectAllGifts */
	public List<GiftDTO> selectAllGifts(){
		Connection con = getConnection();
		
		List<GiftDTO> giftList = customerDAO.selectAllGifts(con);
		
		close(con);
		
		return giftList;
	}
	/* updateGift */
	
	/* selectAllInos */
	public List<InoDTO> selectAllInos(){
		Connection con = getConnection();
		
		List<InoDTO> inoList = customerDAO.selectAllInos(con);
		
		close(con);
		
		return inoList;
	}
	
	/* insertIno */
	
	/* order 조회 */
	public List<OrderDTO> selectOrder(){
		Connection con = getConnection();
		
		List<OrderDTO> orderList = customerDAO.selectOrder(con);
		
		return orderList;
	}	
	
	
	/* order 시퀀스 조회 */
	public int selectOrderSeq(){
		Connection con = getConnection();
		int seq = customerDAO.selectOrderSeq(con);
		
		return seq;
	}	
	
	
	public int insertOrder(OrderDTO orderlist){
		Connection con = getConnection();
		int insertResult = 0;

		insertResult = customerDAO.insertOrder(con, orderlist);
		
		if(insertResult > 0) 
			commit(con);
		else 
			rollback(con);

		close(con);

		return insertResult;
	}	
	
}