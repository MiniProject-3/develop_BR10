package dev.dto;

import java.io.Serializable;

public class ManagerDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7602630580305883026L;

	private int managerKey;		// 관리자키

	public ManagerDTO() {
	}

	public ManagerDTO(int managerKey) {
		this.managerKey = managerKey;
	}

	public int getManagerKey() {
		return managerKey;
	}

	public void setManagerKey(int managerKey) {
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
