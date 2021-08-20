package dev.dto;

import java.io.Serializable;

public class AccountDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3774301832837194351L;

	private String date;		// 날짜
	private int account;		// 정산금액
	
	public AccountDTO() {
	}

	public AccountDTO(String date, int account) {
		this.date = date;
		this.account = account;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AccountDTO [date=" + date + ", account=" + account + "]";
	}
	
	
}
