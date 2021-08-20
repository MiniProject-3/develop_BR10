package dev.dto;

import java.io.Serializable;

public class OrderDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1103733986471579372L;

	private int orderSeq;		// 주문_일련번호(PK)
	private int productNum;		// 상품번호
	private String phoneNum;	// 핸드폰번호
	private int orderNum;		// 주문번호
	private int qty;			// 수량
	private	char payment;		// 결제상태
	
	public OrderDTO() {
	}

	public OrderDTO(int orderSeq, int productNum, String phoneNum, int orderNum, int qty, char payment) {
		this.orderSeq = orderSeq;
		this.productNum = productNum;
		this.phoneNum = phoneNum;
		this.orderNum = orderNum;
		this.qty = qty;
		this.payment = payment;
	}

	public int getOrderSeq() {
		return orderSeq;
	}

	public void setOrderSeq(int orderSeq) {
		this.orderSeq = orderSeq;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public char getPayment() {
		return payment;
	}

	public void setPayment(char payment) {
		this.payment = payment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderSeq=" + orderSeq + ", productNum=" + productNum + ", phoneNum=" + phoneNum
				+ ", orderNum=" + orderNum + ", qty=" + qty + ", payment=" + payment + "]";
	}
	
	
}
