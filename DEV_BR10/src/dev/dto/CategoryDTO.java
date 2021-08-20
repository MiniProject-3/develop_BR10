package dev.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 204509418139167694L;

	private int categoryCode;		// 카테고리코드
	private String categoryName;	// 카테고리 이름
	
	public CategoryDTO() {
	}

	public CategoryDTO(int categoryCode, String categoryName) {
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryCode=" + categoryCode + ", categoryName=" + categoryName + "]";
	}
	
	
}
