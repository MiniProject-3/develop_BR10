package dev.dto;

import java.io.Serializable;

public class SalesProductDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6981490950672747756L;

	private String productName;
	private Integer oldStock;
	private Integer sale;
	private Integer newStock;
	
	public SalesProductDTO() {
	}

	public SalesProductDTO(String productName, Integer oldStock, Integer sale, Integer newStock) {
		this.productName = productName;
		this.oldStock = oldStock;
		this.sale = sale;
		this.newStock = oldStock - sale;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getOldStock() {
		return oldStock;
	}

	public void setOldStock(Integer oldStock) {
		this.oldStock = oldStock;
	}

	public Integer getSale() {
		return sale;
	}

	public void setSale(Integer sale) {
		this.sale = sale;
	}

	public Integer getNewStock() {
		return newStock;
	}

	public void setNewStock(Integer newStock) {
		this.newStock = newStock;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SalesProductDTO [productName=" + productName + ", oldStock=" + oldStock + ", sale=" + sale
				+ ", newStock=" + newStock + "]";
	}
	
	
	
	
}
