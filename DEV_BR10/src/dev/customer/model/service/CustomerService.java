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
import dev.dto.PayDTO;
import dev.dto.ProductDTO;
import dev.dto.UserDTO;

public class CustomerService {
	
	/* 고객 서비스 시스템 */
	private CustomerDAO customerDAO = new CustomerDAO();
	
	/* 주문 추가 - insertOrder */
	public int insertOrder(OrderDTO order) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = customerDAO.insertOrder(con, order);
		
		if(result > 0) 
			commit(con);
		else 
			rollback(con);

		close(con);

		return result;
	}
	
	/* 주문 업데이트 updateOrder */
	public int updateOrder(int orderNum, String payMent) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = customerDAO.updateOrder(con, orderNum, payMent);
		
		if(result > 0) 
			commit(con);
		else 
			rollback(con);

		close(con);

		return result;
	}
	
	/* 주문 완료된 항목 값들 가져오기 selectOrderByOrderNum */
	public List<OrderDTO> selectOrderByOrderNum(int orderNum){
		
		Connection con = getConnection();
		List<OrderDTO> orderList = customerDAO.selectOrderByOrderNum(con, orderNum);
		
		close(con);
		
		return orderList;
	}
	
	/* 결제 추가 - insertPay */
	public int insertPay(PayDTO pay) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = customerDAO.insertPay(con, pay);
		
		if(result > 0) 
			commit(con);
		else 
			rollback(con);

		close(con);

		return result;
	}
	
	/* 회원 여부 조회 - 포인트 조회 selectAllUsers */
	/* 1. 결제할 때 통신사 조회
	 * 2. 적립할 때 핸드폰 번호 존재 여부 조회
	 * */
	public List<UserDTO> selectAllUsers(){
		Connection con = getConnection();
		
		List<UserDTO> userList = customerDAO.selectAllUsers(con);
		
		close(con);
		
		return userList;
	}
	
	/* 포인트 내역 업데이트 (사용, 적립) - updateUserPoint */
	public int updateUserPoint(int phoneNum, int point) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = customerDAO.updateUserPoint(con, phoneNum, point);
		
		if(result > 0) 
			commit(con);
		else 
			rollback(con);

		close(con);

		return result;
	}
	
	/* 기프티콘 내역 조회 - selectAllGifts */
	public List<GiftDTO> selectAllGifts(){
		Connection con = getConnection();
		
		List<GiftDTO> giftList = customerDAO.selectAllGifts(con);
		
		close(con);
		
		return giftList;
	}
	
	/* 기프티콘 내역 업데이트(사용) - updateGiftUse */
	public int updateGiftUse(String giftUse, int giftNum) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = customerDAO.updateGiftUse(con, giftUse, giftNum);
		
		if(result > 0) 
			commit(con);
		else 
			rollback(con);

		close(con);

		return result;
	}
	
	/* 입출고 내역 조회 selectAllInos */
	public List<InoDTO> selectAllInos(){
		Connection con = getConnection();
		
		List<InoDTO> inoList = customerDAO.selectAllInos(con);
		
		close(con);
		
		return inoList;
	}
	
	/*  입출고 내역 추가 - insertIno */
	public int insertIno(InoDTO ino) {
		
		Connection con = getConnection();
		int result = 0;
		
		result = customerDAO.insertIno(con, ino);
		
		if(result > 0) 
			commit(con);
		else 
			rollback(con);

		close(con);

		return result;
	}
	
	/* order 조회 */
	public List<OrderDTO> selectOrder(){
		Connection con = getConnection();
		
		List<OrderDTO> orderList = customerDAO.selectOrder(con);
		
		return orderList;
	}	
	
	
	/* order 시퀀스 조회 */
	public int selectOrderNum(){
		Connection con = getConnection();
		int orderNum = customerDAO.selectOrderNum(con);
		
		return orderNum;
	}	
	
	
	public int selectSeqNum(){
		Connection con = getConnection();
		int seq = customerDAO.selectSeqNum(con);
		
		return seq;
	}	
	
	
	public int insertOrder(List orderList){
		Connection con = getConnection();
		int insertResult = 0;
		OrderDTO order[] = new OrderDTO [MenuOrderList.orderList.size()];
		for (int i = 0 ; i < MenuOrderList.orderList.size() ; i++) {
			order[i] = (OrderDTO) MenuOrderList.orderList.get(i);
		
		System.out.println(order[i]);
		
		insertResult = customerDAO.insertOrder(con, order[i]);
		}
		if(insertResult > 0) 
			commit(con);
		else 
			rollback(con);

		close(con);

		return insertResult;
	}	
	
}