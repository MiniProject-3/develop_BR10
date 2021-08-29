package dev.dto;

import java.io.Serializable;

public class ManagerDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7602630580305883026L;

	private String managerKey;		// 관리자키

	public ManagerDTO() {
	}

	public ManagerDTO(String managerKey) {
		this.managerKey = managerKey;
	}

	public String getManagerKey() {
		return managerKey;
	}

	public void setManagerKey(String managerKey) {
		this.managerKey = managerKey;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ManagerDTO [managerKey=" + managerKey + "]";
	}
	
	
	
}
