package dev.dto;

import java.io.Serializable;

public class IcePriceDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4951394949839899325L;

	private int sizeNum;		 	//사이즈번호
	private String sizeName;		// 사이즈명
	private int sizePrice;			// 가격
	
	public IcePriceDTO() {
	}

	public IcePriceDTO(int sizeNum, String sizeName, int sizePrice) {
		this.sizeNum = sizeNum;
		this.sizeName = sizeName;
		this.sizePrice = sizePrice;
	}

	public int getSizeNum() {
		return sizeNum;
	}

	public void setSizeNum(int sizeNum) {
		this.sizeNum = sizeNum;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public int getSizePrice() {
		return sizePrice;
	}

	public void setSizePrice(int sizePrice) {
		this.sizePrice = sizePrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "IcePriceDTO [sizeNum=" + sizeNum + ", sizeName=" + sizeName + ", sizePrice=" + sizePrice + "]";
	}
	
	
	
}
