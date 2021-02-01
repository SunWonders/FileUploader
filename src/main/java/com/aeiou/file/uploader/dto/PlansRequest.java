package com.aeiou.file.uploader.dto;

public class PlansRequest {
	private String name;
	private String type;
	private String validityType;
	private Integer vailidity;
	private Boolean isActive;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValidityType() {
		return validityType;
	}
	public void setValidityType(String validityType) {
		this.validityType = validityType;
	}
	public Integer getVailidity() {
		return vailidity;
	}
	public void setVailidity(Integer vailidity) {
		this.vailidity = vailidity;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
