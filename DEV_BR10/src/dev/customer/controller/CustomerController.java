package dev.customer.controller;

import java.util.List;

import dev.customer.menu.MenuOrderList;
import dev.customer.model.service.CustomerService;
import dev.dto.OrderDTO;

public class CustomerController {
	private CustomerService customerService = new CustomerService();
	
	public int selectOrderNum() {
		
		int orderNum = customerService.selectOrderNum();
		
		if(orderNum > 0) {		// 값이 0보다 큰 경우.

			return orderNum;
		} else {							// 리스트가 비어있는 경우

			return 1;
		}
	}
	
	public int selectSeqNum() {
		
		int seq = customerService.selectOrderNum();
		
		if(seq > 0) {		// 값이 0보다 큰 경우.

			return seq;
		} else {							// 리스트가 비어있는 경우

			return 1;
		}
	}
	
	
	
	public int insertOrder() {
		
		return 0;

	}
	
	
	
	

}
