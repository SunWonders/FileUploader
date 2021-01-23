package com.aeiou.file.uploader.dto;

public class StatusUpdateRequest {

	private String id;
	/** The is active. */
	private Boolean isActive;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
