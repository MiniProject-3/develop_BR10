package dev.customer.controller;

import java.util.List;
import java.util.Map;

import dev.customer.model.service.CustomerService;
import dev.dto.GiftDTO;
import dev.dto.InoDTO;
import dev.dto.OrderDTO;
import dev.dto.PayDTO;
import dev.dto.ProductDTO;
import dev.dto.UserDTO;
import dev.customer.menu.MenuOrderList;
import dev.customer.model.service.CustomerService;
import dev.dto.OrderDTO;

public class CustomerController {
	private static CustomerService customerService = new CustomerService();
	
	public int selectOrderNum() {
		
		int orderNum = customerService.selectOrderNum();
		
		if(orderNum > 0) {		// 값이 0보다 큰 경우.
			return orderNum;
		} else {							// 비어있는 경우
			return 1;
		}
	}
	
	public static int selectSeqNum() {
		
		int seq = customerService.selectSeqNum();
		
		if(seq > 0) {		// 값이 0보다 큰 경우.
			return seq;
		} else {							// 비어있는 경우
			return 1;
		}
	}
	
	/* (생략) 주문 추가 insertOrder */
	public int insertOrder() {
		return 0;

	}
	
	/* 결제 추가 insertPay */
	public String registNewPay(Map<String, String> ansMap) {
		
		PayDTO payDTO = new PayDTO();
		
		payDTO.setPayNum(Integer.valueOf((String) ansMap.get("payNum")));
		payDTO.setPayTime((String) ansMap.get("payTime"));
		payDTO.setPhoneNum((String) ansMap.get("phoneNum"));
		payDTO.setPayTotal(Integer.valueOf((String) ansMap.get("payTotal")));
		payDTO.setPaymentNum(Integer.valueOf((String) ansMap.get("paymentNum")));
		
		int result = customerService.insertPay(payDTO);
		
		if (result > 0) {
			return "삽입 성공";
		}else {
			return "삽입 실패";
		}
	}
	
	/* 회원 여부 조회 - 포인트 조회 selectAllUsers */
	public List<UserDTO> selectAllUsers() {
		
		List<UserDTO> userList = customerService.selectAllUsers();
		
		if(!userList.isEmpty()) {		// 리스트가 비어있지 않은 경우 - 값이 존재하는 경우.
			return userList;
		} else {							// 리스트가 비어있는 경우
			return null;
		}
	}

	/* 포인트 내역 업데이트 (사용, 적립) - updateUserPoint */
	public String modifyUserPoint(int phoneNum, int point) {
		int result = customerService.updateUserPoint(phoneNum, point);
		
		if (result > 0) {
			return "수정 성공";
		}else {
			return "수정 실패";
		}
	}
	
	/* 기프티콘 내역 조회 - selectAllGifts */
	public List<GiftDTO> selectAllGifts() {
		
		List<GiftDTO> giftList = customerService.selectAllGifts();
		
		if(!giftList.isEmpty()) {		
			return giftList;
		} else {							
			return null;
		}
	}
	/* 기프티콘 내역 업데이트(사용) - updateGiftUse */
	public String modifyGiftUse(String giftUse, int giftNum) {
		int result = customerService.updateGiftUse(giftUse, giftNum);
		
		if (result > 0) {
			return "수정 성공";
		}else {
			return "수정 실패";
		}
	}
	
	/* 입출고 내역 조회 selectAllInos */
	public List<InoDTO> selectAllInos() {
		
		List<InoDTO> inoList = customerService.selectAllInos();
		
		if(!inoList.isEmpty()) {		
			return inoList;
		} else {							
			return null;
		}
	}
	
	/*  입출고 내역 추가 - insertIno */
	public String registNewIno(Map<String, String> ansMap) {
		
		InoDTO inoDTO = new InoDTO();
		
		inoDTO.setInoNum(Integer.valueOf((String) ansMap.get("inoNum")));
		inoDTO.setIno((String) ansMap.get("ino"));
		/* 수량 - null값 판단 */
		if ("".equals(ansMap.get("qty")) || ansMap.get("qty") == null) {
			inoDTO.setQty(null);
		} else {
			inoDTO.setQty(Integer.valueOf((String) ansMap.get("qty")));
		}
		inoDTO.setProductNum(Integer.valueOf((String) ansMap.get("productNum")));
		
		int result = customerService.insertIno(inoDTO);
		
		if (result > 0) {
			return "삽입 성공";
		}else {
			return "삽입 실패";
		}
	}
	/* order 조회 - selectOrder */
	public List<OrderDTO> selectOrder() {
		
		List<OrderDTO> orderList = customerService.selectOrder();
		
		if(!orderList.isEmpty()) {		
			return orderList;
		} else {							
			return null;
		}
	}

	
	
	
}
