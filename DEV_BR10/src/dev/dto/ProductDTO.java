package dev.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8996867095629917336L;

	private int productNum;			// 상품번호
	private String productName;		// 상품명
	private Integer productPrice;	// 상품가격
	private int categoryCode;		// 카테고리코드
	private Integer stock;			// 재고
	private Integer qty;
	private String payment;
	
	public ProductDTO() {
	}

	public ProductDTO(int productNum, String productName, Integer productPrice, int categoryCode, Integer stock) {
		this.productNum = productNum;
		this.productName = productName;
		this.productPrice = productPrice;
		this.categoryCode = categoryCode;
		this.stock = stock;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	
	public void setProductPrice() {
		this.productPrice = null;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "ProductDTO [productNum=" + productNum + ", productName=" + productName + ", productPrice="
				+ productPrice + ", categoryCode=" + categoryCode + ", stock=" + stock + "]";
	}
	
	

}
