package com.aeiou.file.uploader.dto;

import java.util.List;

import com.aeiou.file.uploader.entity.UrlShortner;

public class RetrieverResponse {
	List<UrlShortner> data;
	private Integer status;

	/** The message. */
	private String message;

	public List<UrlShortner> getData() {
		return data;
	}

	public void setData(List<UrlShortner> data) {
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
