package dev.customer.model.dao;

import static dev.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import dev.dto.OrderDTO;
import dev.dto.PayDTO;

public class CustomerDAO {
	
	private Properties prop = new Properties();
	
	public CustomerDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/BR10-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* 주문 추가 insertOrder*/
	public int insertOrder(Connection con, OrderDTO order) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertOrder");
	      
		try {
	          pstmt = con.prepareStatement(query);
	          pstmt.setInt(1, order.getOrderSeq());
	          pstmt.setInt(2, order.getProductNum());
	          pstmt.setString(3, order.getPhoneNum());
	          pstmt.setInt(4, order.getOrderNum());
	          pstmt.setInt(5, order.getQty());
	          pstmt.setString(6, order.getPayment());

	          result = pstmt.executeUpdate();
	       } catch (SQLException e) {
	          e.printStackTrace();
	       } finally {
	          close(pstmt);
	       }
		
		return result;
	}

	/* 결제 추가 insertPay */
	public int insertPay(Connection con, PayDTO pay) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPay");
	      
		try {
	          pstmt = con.prepareStatement(query);
	          pstmt.setInt(1, pay.getPayNum());
	          pstmt.setString(2, pay.getPayTime());
	          pstmt.setString(3, pay.getPhoneNum());
	          pstmt.setInt(4, pay.getPayTotal());
	          pstmt.setInt(5, pay.getPaymentNum());

	          result = pstmt.executeUpdate();
	       } catch (SQLException e) {
	          e.printStackTrace();
	       } finally {
	          close(pstmt);
	       }
		
		return result;
	}
	
	/* 회원 여부 조회 - 포인트 조회 */
	
	/* 포인트 내역 업데이트 (사용, 적립) */
	
	/*  */

}
