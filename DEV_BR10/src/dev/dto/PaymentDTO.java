package dev.dto;

import java.io.Serializable;

public class PaymentDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3937178039527883185L;

	private int paymentNum;		// 결제수단 구분번호
	private String paymentName;	// 수단명
	
	public PaymentDTO() {
	}
	
	public PaymentDTO(int paymentNum, String paymentName) {
		this.paymentNum = paymentNum;
		this.paymentName = paymentName;
	}
	
	public int getPaymentNum() {
		return paymentNum;
	}
	
	public void setPaymentNum(int paymentNum) {
		this.paymentNum = paymentNum;
	}
	
	public String getPaymentName() {
		return paymentName;
	}
	
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PaymentDTO [paymentNum=" + paymentNum + ", paymentName=" + paymentName + "]";
	}
}
