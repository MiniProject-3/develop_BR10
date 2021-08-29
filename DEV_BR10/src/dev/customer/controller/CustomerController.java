package dev.customer.controller;

import java.util.List;

import dev.customer.model.service.CustomerService;
import dev.dto.OrderDTO;

public class CustomerController {
	private CustomerService customerService = new CustomerService();
	
	public int selectOrderSeq() {
		
		int seq = customerService.selectOrderSeq();
		
		if(seq > 0) {		// 값이 0보다 큰 경우.

			return seq;
		} else {							// 리스트가 비어있는 경우

			return 0;
		}
	}
	
	public String insertOrder() {
		
		OrderDTO orderDTO = new OrderDTO();
		
		orderDTO.setOrderSeq(insertResult);
		orderDTO.setProductNum(insertResult);
		orderDTO.setPhoneNum(null);
		orderDTO.setQty(insertResult);
		orderDTO.setOrderNum(insertResult);
		orderDTO.setPayment(null);
		
		return insertResult;
		
		
		
	}
	
	
	
	

}
