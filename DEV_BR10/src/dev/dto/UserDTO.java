package dev.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6321173687825094498L;

	private String phoneNum;		// 핸드폰번호
	private Integer point;				// 포인트점수
	private String phoneCo;			// 통신사
	
	public UserDTO() {
	}

	public UserDTO(String phoneNum, int point, String phoneCo) {
		this.phoneNum = phoneNum;
		this.point = point;
		this.phoneCo = phoneCo;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getPhoneCo() {
		return phoneCo;
	}

	public void setPhoneCo(String phoneCo) {
		this.phoneCo = phoneCo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserDTO [phoneNum=" + phoneNum + ", point=" + point + ", phoneCo=" + phoneCo + "]";
	}
	
	
}
