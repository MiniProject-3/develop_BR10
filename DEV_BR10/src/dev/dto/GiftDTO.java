package dev.dto;

import java.io.Serializable;

public class GiftDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5668197487139869090L;

	private int giftNum;		// 기프티콘번호
	private String giftUse;		// 기프티콘 사용 여부
	
	public GiftDTO() {
	}
	
	public GiftDTO(int giftNum, String giftUse) {
		this.giftNum = giftNum;
		this.giftUse = giftUse;
	}

	public int getGiftNum() {
		return giftNum;
	}

	public void setGiftNum(int giftNum) {
		this.giftNum = giftNum;
	}

	public String getGiftUse() {
		return giftUse;
	}

	public void setGiftUse(String giftUse) {
		this.giftUse = giftUse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "GiftDTO [giftNum=" + giftNum + ", giftUse=" + giftUse + "]";
	}

	
	
}
