package dev.dto;

import java.io.Serializable;

public class PayDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2436880389223701955L;

	private int payNum; 		// 결제번호
	private String payTime;		// 결제시간
	private String phoneNum;	// 핸드폰번호
	private int payTotal;		// 총결제금액
	private int paymentNum;		// 결제수단구분번호
	
	public PayDTO() {
	}

	public PayDTO(int payNum, String payTime, String phoneNum, int payTotal, int paymentNum) {
		this.payNum = payNum;
		this.payTime = payTime;
		this.phoneNum = phoneNum;
		this.payTotal = payTotal;
		this.paymentNum = paymentNum;
	}

	public int getPayNum() {
		return payNum;
	}

	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getPayTotal() {
		return payTotal;
	}

	public void setPayTotal(int payTotal) {
		this.payTotal = payTotal;
	}

	public int getPaymentNum() {
		return paymentNum;
	}

	public void setPaymentNum(int paymentNum) {
		this.paymentNum = paymentNum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PayDTO [payNum=" + payNum + ", payTime=" + payTime + ", phoneNum=" + phoneNum + ", payTotal=" + payTotal
				+ ", paymentNum=" + paymentNum + "]";
	}
	
	
}
